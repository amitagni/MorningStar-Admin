package com.ms.controller;

import com.ms.bean.FeeFormBean;
import com.ms.bean.PaymentFormBean;
import com.ms.dto.DiscountDTO;
import com.ms.dto.FeeDTO;
import com.ms.dto.FeeMonthsDTO;
import com.ms.dto.FeeSummaryDTO;
import com.ms.entity.Discount;
import com.ms.entity.FeeSlip;
import com.ms.entity.FeeStructure;
import com.ms.entity.PaidFeeSummary;
import com.ms.entity.Payment;
import com.ms.entity.StudentInfo;
import com.ms.enums.FeeFreqType;
import com.ms.enums.FeeType;
import com.ms.enums.Month;
import com.ms.enums.PaymentType;
import com.ms.enums.Section;
import com.ms.enums.StudentClass;
import com.ms.service.AdmissionService;
import com.ms.service.FeeService;
import com.ms.service.PaymentService;
import com.ms.util.DateUtils;
import com.ms.util.MSException;
import com.ms.util.MSUtil;
import com.ms.util.SessionUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("request")
public class FeeController {
	@Autowired
	private FeeService feeService;
	@Autowired
	private AdmissionService admissionService;
	@Autowired
	private PaymentService paymentService;

	@RequestMapping(value = {"/fee"}, method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView fee(@ModelAttribute("feeFormBean") FeeFormBean feeFormBean, BindingResult bindingResult,
			Model model, HttpServletRequest request, HttpServletResponse response) {
		SessionUtil.setPage("Fee");
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			String e1 = request.getParameter("id");
			this.populateFeeFormBean(feeFormBean, e1);
			if (SessionUtil.getMessage() != null) {
				model.addAttribute("message", SessionUtil.getMessage());
				SessionUtil.removeMessage();
			}

			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", 0L);
			return new ModelAndView("fee", "feeFormBean", feeFormBean);
		} else {
			try {
				Integer e = SessionUtil.getUser().getId();
				FeeSummaryDTO feeSummaryDTO = this.saveFeeFormBean(feeFormBean, e);
				StringBuilder ids = new StringBuilder();
				Iterator arg9 = feeSummaryDTO.getFeeSlipList().iterator();

				while (arg9.hasNext()) {
					FeeSlip feeSlip = (FeeSlip) arg9.next();
					ids.append(feeSlip.getId()).append(",");
				}

				return new ModelAndView("redirect:/fee-payment.do?ids=" + ids + "&id=" + feeFormBean.getStudentId()
						+ "&s=" + feeFormBean.getFeeSummaryId() + "&m=" + feeSummaryDTO.getMonthIds() + "&q="
						+ feeSummaryDTO.getQuarterlyIds() + "&h=" + feeSummaryDTO.getHalsyrlyIds() + "&a="
						+ feeSummaryDTO.getAnuallyIds() + "&amt=" + feeFormBean.getTotalPaidAmt() + "&damt="
						+ feeFormBean.getTotalDiscAmt());
			} catch (Exception arg10) {
				arg10.printStackTrace();
				this.populateFeeFormBean(feeFormBean, String.valueOf(feeFormBean.getStudentId()));
				return new ModelAndView("fee", "feeFormBean", feeFormBean);
			}
		}
	}

	@RequestMapping(value = {"/fee-payment"}, method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView feePayment(@ModelAttribute("paymentFormBean") PaymentFormBean paymentFormBean,
			BindingResult bindingResult, Model model, HttpServletRequest request, HttpServletResponse response) {
		SessionUtil.setPage("Fee");
		Integer e;
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			e = Integer.valueOf(Integer.parseInt(request.getParameter("id")));
			String userId1 = request.getParameter("ids");
			paymentFormBean.setFeeSlipIds(userId1);
			paymentFormBean.setStudentId(e);
			if (request.getParameter("s") != null && !request.getParameter("s").equals("null")) {
				paymentFormBean.setFeeSummaryId(Integer.valueOf(Integer.parseInt(request.getParameter("s"))));
			} else {
				paymentFormBean.setFeeSummaryId(Integer.valueOf(-1));
			}

			paymentFormBean.setMonthIds(request.getParameter("m"));
			paymentFormBean.setIsAddDiscount(Boolean.valueOf(true));
			paymentFormBean.setQuarterlyIds(request.getParameter("q"));
			paymentFormBean.setHalsyrlyIds(request.getParameter("h"));
			paymentFormBean.setAnuallyIds(request.getParameter("a"));
			paymentFormBean.setAmount(request.getParameter("amt"));
			paymentFormBean.setDisAmount(request.getParameter("damt"));
			this.populatePaymentFormBean(paymentFormBean);
			paymentFormBean.setAddtionalDiscountTypeList(this.populateAdditionDiscountList());
			paymentFormBean.setPaymentType(PaymentType.CASH.getCode());
			response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", 0L);
			return new ModelAndView("fee-payment", "paymentFormBean", paymentFormBean);
		} else {
			try {
				e = this.saveFeePaymentFormBean(paymentFormBean);
				Integer userId = SessionUtil.getUser().getId();
				List commonMonthList = this.updateFeeSummary(paymentFormBean, userId);
				if (commonMonthList != null && commonMonthList.size() != 0) {
					String months = "";

					String month;
					for (Iterator arg10 = commonMonthList.iterator(); arg10.hasNext(); months = months
							+ Month.findNameByCode(Byte.valueOf(Byte.parseByte(month))) + ",") {
						month = (String) arg10.next();
					}

					SessionUtil.setMessage(
							months.substring(0, months.length() - 1) + " Fees Already Paid, Please try again.");
					return new ModelAndView("redirect:/fee.do?id=" + paymentFormBean.getStudentId());
				} else {
					this.updateFeeSlipWithPayment(e, paymentFormBean.getFeeSlipIds());
					return new ModelAndView("redirect:/fee-reciept.do?id=" + e);
				}
			} catch (Exception arg11) {
				arg11.printStackTrace();
				return new ModelAndView("fee-payment", "paymentFormBean", paymentFormBean);
			}
		}
	}

	private List<DiscountDTO> populateAdditionDiscountList() {
		ArrayList addDiscountList = new ArrayList();
		List discountList = this.admissionService.findAllDiscountsByMagmt();
		Iterator arg3 = discountList.iterator();

		while (arg3.hasNext()) {
			Discount discount = (Discount) arg3.next();
			DiscountDTO discountDTO = new DiscountDTO();
			discountDTO.setId(discount.getId());
			discountDTO.setAbbriviation(discount.getAbbriviation());
			discountDTO.setValue(discount.getValue());
			addDiscountList.add(discountDTO);
		}

		return addDiscountList;
	}

	private List<String> updateFeeSummary(PaymentFormBean paymentFormBean, Integer userId) {
		PaidFeeSummary paidFeeSummary = null;
		List commonMonthList = null;
		if (paymentFormBean.getFeeSummaryId() != null) {
			try {
				paidFeeSummary = this.feeService.findByStudentId(paymentFormBean.getStudentId());
			} catch (MSException arg5) {
				arg5.printStackTrace();
			}
		}

		if (paidFeeSummary == null) {
			paidFeeSummary = new PaidFeeSummary();
			paidFeeSummary.setMonthlyFreq(paymentFormBean.getMonthIds());
			paidFeeSummary.setQuaterlyFreq(paymentFormBean.getQuarterlyIds());
			paidFeeSummary.setHalfyearlyFreq(paymentFormBean.getHalsyrlyIds());
			paidFeeSummary.setAnnuallyFreq(paymentFormBean.getAnuallyIds());
		} else {
			commonMonthList = this.validateMonthsAlreadyPaid(paidFeeSummary.getMonthlyFreq(),
					paymentFormBean.getMonthIds());
			if (commonMonthList.size() != 0) {
				return commonMonthList;
			}

			paidFeeSummary.setMonthlyFreq(paidFeeSummary.getMonthlyFreq() + paymentFormBean.getMonthIds());
			paidFeeSummary.setQuaterlyFreq(paidFeeSummary.getQuaterlyFreq() + paymentFormBean.getQuarterlyIds());
			paidFeeSummary.setHalfyearlyFreq(paidFeeSummary.getHalfyearlyFreq() + paymentFormBean.getHalsyrlyIds());
			paidFeeSummary.setAnnuallyFreq(paidFeeSummary.getAnnuallyFreq() + paymentFormBean.getAnuallyIds());
		}

		paidFeeSummary.setSessionName(SessionUtil.getCurrentSchoolSesseion());
		paidFeeSummary.setStudentId(paymentFormBean.getStudentId());
		paidFeeSummary.setUpdatedBy(userId);
		this.feeService.save(paidFeeSummary);
		return commonMonthList;
	}

	private List<String> validateMonthsAlreadyPaid(String monthsPaid, String goingToPaid) {
		ArrayList commonMonthList = new ArrayList();
		String[] arr1 = monthsPaid.split(",");
		String[] arr2 = goingToPaid.split(",");
		LinkedHashSet set = new LinkedHashSet();
		set.addAll(Arrays.asList(arr1));

		for (int i = 0; i < arr2.length; ++i) {
			String string = arr2[i];
			if (!set.add(string)) {
				commonMonthList.add(string);
			}
		}

		return commonMonthList;
	}

	@RequestMapping({"/fee-reciept"})
	public ModelAndView regReceipt(@ModelAttribute("feeFormBean") FeeFormBean feeFormBean, BindingResult bindingResult,
			Model model, HttpServletRequest request) {
		SessionUtil.setPage("Fee");
		ArrayList monthlyFeeList = new ArrayList();
		ArrayList quarterlyFeeList = new ArrayList();
		ArrayList halfyearlyFeeList = new ArrayList();
		ArrayList anualFeeList = new ArrayList();
		TreeMap map = new TreeMap();
		HashSet monthSet = new HashSet();
		float totalAmount = 0.0F;
		float totalDiscount = 0.0F;
		float totalPaidAmt = 0.0F;
		String additionalDiscount = null;

		try {
			String e = request.getParameter("id");
			List list = this.feeService.generateFeeSlipData(e);
			Integer studentId = null;
			Iterator selMonths = list.iterator();

			while (selMonths.hasNext()) {
				Object studentInfo = selMonths.next();
				Object[] months = (Object[]) studentInfo;
				if (months != null) {
					byte feeFreq = ((Byte) months[2]).byteValue();
					FeeDTO feeDTO = new FeeDTO();
					feeDTO.setName((String) months[3]);
					feeDTO.setPaidAmount((String) months[0]);
					feeDTO.setDiscount((String) months[1]);
					feeDTO.setAmount(String
							.valueOf(Float.parseFloat((String) months[0]) + Float.parseFloat((String) months[1])));
					studentId = (Integer) months[5];
					additionalDiscount = (String) months[6];
					if (months[4] != null) {
						monthSet.add((Byte) months[4]);
					}

					totalDiscount += Float.parseFloat(feeDTO.getDiscount());
					totalPaidAmt += Float.parseFloat(feeDTO.getPaidAmount());
					if (feeFreq == FeeFreqType.MONTHLY.getCode().byteValue()) {
						System.out.println("MONTHLY");
						FeeDTO existingFeeDto = (FeeDTO) map.get(feeDTO.getName());
						if (existingFeeDto != null) {
							existingFeeDto.setAmount(String.valueOf(Float.parseFloat(existingFeeDto.getAmount())
									+ Float.parseFloat(feeDTO.getAmount())));
							existingFeeDto.setDiscount(String.valueOf(Float.parseFloat(existingFeeDto.getDiscount())
									+ Float.parseFloat(feeDTO.getDiscount())));
							existingFeeDto.setPaidAmount(String.valueOf(Float.parseFloat(existingFeeDto.getPaidAmount())
									+ Float.parseFloat(feeDTO.getPaidAmount())));
						} else {
							map.put(feeDTO.getName(), feeDTO);
						}
					} else if (feeFreq == FeeFreqType.QUARTERLY.getCode().byteValue()) {
						quarterlyFeeList.add(feeDTO);
						System.out.println("QUARTERLY");
					} else if (feeFreq == FeeFreqType.HALFYEARLY.getCode().byteValue()) {
						halfyearlyFeeList.add(feeDTO);
						System.out.println("HALFYEARLY");
					} else if (feeFreq == FeeFreqType.ANUALLY.getCode().byteValue()) {
						anualFeeList.add(feeDTO);
						System.out.println("ANUALLY");
					}
				}
			}

			selMonths = map.entrySet().iterator();

			while (selMonths.hasNext()) {
				Entry studentInfo1 = (Entry) selMonths.next();
				monthlyFeeList.add((FeeDTO) studentInfo1.getValue());
			}

			StudentInfo studentInfo2 = this.admissionService.findStudentById(studentId);
			feeFormBean.setStudentMSId("MS-1-" + studentInfo2.getId());
			feeFormBean.setStudentName(studentInfo2.getFirstName() + " " + studentInfo2.getLastName());
			feeFormBean.setStudentClass(StudentClass.findNameByCode(studentInfo2.getCurrentClass()) + " "
					+ Section.findNameByCode(studentInfo2.getSection()));
			String selMonths1 = "";

			Byte months1;
			for (Iterator feeFreq1 = monthSet.iterator(); feeFreq1
					.hasNext(); selMonths1 = selMonths1 + Month.findNameByCode(months1) + ",") {
				months1 = (Byte) feeFreq1.next();
			}

			feeFormBean.setMonths(selMonths1);
			feeFormBean.setMonthlyFeeList(monthlyFeeList);
			feeFormBean.setQuarterlyFeeList(quarterlyFeeList);
			feeFormBean.setHalfyearlyFeeList(halfyearlyFeeList);
			feeFormBean.setAnualFeeList(anualFeeList);
			Byte[] months2 = new Byte[monthSet.size()];
			feeFormBean.setSelMonth((Byte[]) monthSet.toArray(months2));
			if (additionalDiscount != null && !additionalDiscount.isEmpty()) {
				totalDiscount += Float.parseFloat(additionalDiscount);
				totalPaidAmt -= Float.parseFloat(additionalDiscount);
			}

			feeFormBean.setTotalAmt(MSUtil.formatValue(totalPaidAmt + totalDiscount));
			feeFormBean.setTotalDiscAmt(MSUtil.formatValue(totalDiscount));
			feeFormBean.setTotalPaidAmt(MSUtil.formatValue(totalPaidAmt));
			feeFormBean.setRecieptDate(DateUtils.convertToStringObject(DateUtils.getCurrentDateTime(), "dd/MM/yyyy"));
		} catch (MSException arg23) {
			arg23.printStackTrace();
		}

		return new ModelAndView("fee-reciept");
	}

	public void populateFeeFormBean(FeeFormBean feeFormBean, String id) {
		ArrayList monthlyFeeList = new ArrayList();
		ArrayList quarterlyFeeList = new ArrayList();
		ArrayList halfyearlyFeeList = new ArrayList();
		ArrayList anualFeeList = new ArrayList();
		Object monthlyPaidFeeList = new ArrayList();
		Object quarterlyPaidFeeList = new ArrayList();
		Object halfYearlyPaidFeeList = new ArrayList();
		Object anuallyPaidFeeList = new ArrayList();
		Map discountMap = SessionUtil.getDiscountMap();
		if (discountMap == null) {
			discountMap = this.populateDiscountMap();
		}

		Integer studentId = Integer.valueOf(Integer.parseInt(id));
		feeFormBean.setStudentId(studentId);
		StudentInfo studentInfo = this.admissionService.findStudentById(studentId);
		feeFormBean.setStudentName(studentInfo.getFirstName() + " " + studentInfo.getLastName());
		feeFormBean.setStudentClass(StudentClass.findNameByCode(studentInfo.getCurrentClass()) + " "
				+ Section.findNameByCode(studentInfo.getSection()));

		try {
			PaidFeeSummary feeStructureList = this.feeService.findByStudentId(studentId);
			if (feeStructureList != null) {
				feeFormBean.setFeeSummaryId(feeStructureList.getId());
				monthlyPaidFeeList = this.tokenizeList(feeStructureList.getMonthlyFreq());
				quarterlyPaidFeeList = this.tokenizeList(feeStructureList.getQuaterlyFreq());
				halfYearlyPaidFeeList = this.tokenizeList(feeStructureList.getHalfyearlyFreq());
				anuallyPaidFeeList = this.tokenizeList(feeStructureList.getAnnuallyFreq());
			}
		} catch (MSException arg18) {
			arg18.printStackTrace();
		}

		if (studentInfo != null) {
			List feeStructureList1 = this.feeService.findFeeForClassAndSession(studentInfo.getCurrentClass(),
					Byte.valueOf((byte) 1));
			if (feeStructureList1 != null) {
				Iterator month = feeStructureList1.iterator();

				while (month.hasNext()) {
					FeeStructure monthList = (FeeStructure) month.next();
					FeeDTO feeDTO = new FeeDTO();
					feeDTO.setId(monthList.getId());
					feeDTO.setName(monthList.getAbbrName());
					feeDTO.setAmount(monthList.getAmount());
					if (monthList.getFeeFreqType().byteValue() == FeeFreqType.MONTHLY.getCode().byteValue()) {
						if (studentInfo.getDiscountId() != null && monthList.getIsTutionFee().byteValue() == 1) {
							DiscountDTO feeMonthsDTO = (DiscountDTO) discountMap.get(studentInfo.getDiscountId());
							if (feeMonthsDTO != null) {
								feeDTO.setDiscount(feeMonthsDTO.getValue());
							}
						}

						monthlyFeeList.add(feeDTO);
					} else if (monthList.getFeeFreqType().byteValue() == FeeFreqType.QUARTERLY.getCode().byteValue()) {
						if (((List) quarterlyPaidFeeList).contains(feeDTO.getId().toString())) {
							feeDTO.setPaid(true);
						}

						quarterlyFeeList.add(feeDTO);
					} else if (monthList.getFeeFreqType().byteValue() == FeeFreqType.HALFYEARLY.getCode().byteValue()) {
						if (((List) halfYearlyPaidFeeList).contains(feeDTO.getId().toString())) {
							feeDTO.setPaid(true);
						}

						halfyearlyFeeList.add(feeDTO);
					} else if (monthList.getFeeFreqType().byteValue() == FeeFreqType.ANUALLY.getCode().byteValue()) {
						if (((List) anuallyPaidFeeList).contains(feeDTO.getId().toString())) {
							feeDTO.setPaid(true);
						}

						anualFeeList.add(feeDTO);
					}
				}
			}

			feeFormBean.setMonthlyFeeList(monthlyFeeList);
			feeFormBean.setQuarterlyFeeList(quarterlyFeeList);
			feeFormBean.setHalfyearlyFeeList(halfyearlyFeeList);
			feeFormBean.setAnualFeeList(anualFeeList);
			ArrayList monthList1 = new ArrayList();

			FeeMonthsDTO feeMonthsDTO1;
			for (Iterator feeDTO1 = MSUtil.populateMonthList().iterator(); feeDTO1.hasNext(); monthList1
					.add(feeMonthsDTO1)) {
				Month month1 = (Month) feeDTO1.next();
				feeMonthsDTO1 = new FeeMonthsDTO();
				feeMonthsDTO1.setCode(month1.getCode());
				feeMonthsDTO1.setName(month1.getName());
				if (((List) monthlyPaidFeeList).contains(month1.getCode().toString())) {
					feeMonthsDTO1.setPaid(true);
					feeMonthsDTO1.setName(month1.getName() + "  --  PAID");
				}
			}

			feeFormBean.setMonthList(monthList1);
		}

	}

	private Map<Integer, DiscountDTO> populateDiscountMap() {
		HashMap discountMap = new HashMap();
		List discountList = this.admissionService.findAllDiscountsByPredefinedType();
		Iterator arg3 = discountList.iterator();

		while (arg3.hasNext()) {
			Discount discount = (Discount) arg3.next();
			DiscountDTO discountDTO = new DiscountDTO();
			discountDTO.setId(discount.getId());
			discountDTO.setAbbriviation(discount.getAbbriviation());
			discountDTO.setValue(discount.getValue());
			discountMap.put(discount.getId(), discountDTO);
			SessionUtil.setDiscountMap(discountMap);
		}

		return discountMap;
	}

	private List<String> tokenizeList(String str) {
		ArrayList retList = new ArrayList();
		StringTokenizer stringTokenizer = new StringTokenizer(str, ",");

		while (stringTokenizer.hasMoreElements()) {
			retList.add((String) stringTokenizer.nextElement());
		}

		return retList;
	}

	public FeeSummaryDTO saveFeeFormBean(FeeFormBean feeFormBean, Integer userId) {
		FeeSummaryDTO feeSummaryDTO = new FeeSummaryDTO();
		ArrayList feeSlipList = new ArrayList();
		StringBuilder monthIds = new StringBuilder();
		StringBuilder quarterlyIds = new StringBuilder();
		StringBuilder halsyrlyIds = new StringBuilder();
		StringBuilder anuallyIds = new StringBuilder();
		float feeSlip1;
		FeeDTO arg17;
		Iterator arg18;
		float arg20;
		String arg21;
		if (feeFormBean.getMonthlyFeeList() != null) {
			Byte[] discountAmt;
			int totalDiscount = (discountAmt = feeFormBean.getSelMonth()).length;

			for (int arg9 = 0; arg9 < totalDiscount; ++arg9) {
				Byte feeSlip = discountAmt[arg9];
				monthIds.append(feeSlip);
				monthIds.append(",");
			}

			arg18 = feeFormBean.getMonthlyFeeList().iterator();

			label95 : while (true) {
				do {
					if (!arg18.hasNext()) {
						break label95;
					}

					arg17 = (FeeDTO) arg18.next();
				} while (MSUtil.isEmpty(arg17.getPaidAmount()));

				arg20 = 0.0F;
				arg21 = arg17.getDiscount().trim();
				if (arg21.indexOf("%") != -1) {
					feeSlip1 = Float.parseFloat(arg17.getPaidAmount()) * 100.0F
							/ (100.0F - Float.parseFloat(arg21.substring(0, arg21.length() - 1)));
					arg20 = feeSlip1 - Float.parseFloat(arg17.getPaidAmount());
				} else {
					arg20 = Float.parseFloat(arg17.getDiscount());
				}

				Byte[] arg15;
				int arg14 = (arg15 = feeFormBean.getSelMonth()).length;

				for (int arg13 = 0; arg13 < arg14; ++arg13) {
					Byte arg22 = arg15[arg13];
					FeeSlip feeSlip2 = new FeeSlip();
					feeSlip2.setStudentId(feeFormBean.getStudentId());
					feeSlip2.setFeeStructureId(arg17.getId());
					feeSlip2.setMonth(arg22);
					feeSlip2.setAmount(String.valueOf(
							Float.parseFloat(arg17.getPaidAmount()) / (float) feeFormBean.getSelMonth().length));
					feeSlip2.setDiscount(String.valueOf(arg20 / (float) feeFormBean.getSelMonth().length));
					feeSlip2.setCreatedBy(userId);
					feeSlipList.add(feeSlip2);
				}
			}
		}

		FeeSlip arg23;
		if (feeFormBean.getQuarterlyFeeList() != null) {
			arg18 = feeFormBean.getQuarterlyFeeList().iterator();

			while (arg18.hasNext()) {
				arg17 = (FeeDTO) arg18.next();
				if (!MSUtil.isEmpty(arg17.getPaidAmount())) {
					arg20 = 0.0F;
					arg21 = arg17.getDiscount().trim();
					if (arg21.indexOf("%") != -1) {
						feeSlip1 = Float.parseFloat(arg17.getPaidAmount()) * 100.0F
								/ (100.0F - Float.parseFloat(arg21.substring(0, arg21.length() - 1)));
						arg20 = feeSlip1 - Float.parseFloat(arg17.getPaidAmount());
					} else {
						arg20 = Float.parseFloat(arg17.getDiscount());
					}

					arg23 = new FeeSlip();
					arg23.setStudentId(feeFormBean.getStudentId());
					arg23.setFeeStructureId(arg17.getId());
					arg23.setAmount(arg17.getPaidAmount());
					arg23.setDiscount(String.valueOf(arg20));
					arg23.setCreatedBy(userId);
					feeSlipList.add(arg23);
					quarterlyIds.append(arg17.getId());
					quarterlyIds.append(",");
				}
			}
		}

		if (feeFormBean.getHalfyearlyFeeList() != null) {
			arg18 = feeFormBean.getHalfyearlyFeeList().iterator();

			while (arg18.hasNext()) {
				arg17 = (FeeDTO) arg18.next();
				if (!MSUtil.isEmpty(arg17.getPaidAmount())) {
					arg20 = 0.0F;
					arg21 = arg17.getDiscount().trim();
					if (arg21.indexOf("%") != -1) {
						feeSlip1 = Float.parseFloat(arg17.getPaidAmount()) * 100.0F
								/ (100.0F - Float.parseFloat(arg21.substring(0, arg21.length() - 1)));
						arg20 = feeSlip1 - Float.parseFloat(arg17.getPaidAmount());
					} else {
						arg20 = Float.parseFloat(arg17.getDiscount());
					}

					arg23 = new FeeSlip();
					arg23.setStudentId(feeFormBean.getStudentId());
					arg23.setFeeStructureId(arg17.getId());
					arg23.setAmount(arg17.getPaidAmount());
					arg23.setDiscount(String.valueOf(arg20));
					arg23.setCreatedBy(userId);
					feeSlipList.add(arg23);
					halsyrlyIds.append(arg17.getId());
					halsyrlyIds.append(",");
				}
			}
		}

		if (feeFormBean.getAnualFeeList() != null) {
			arg18 = feeFormBean.getAnualFeeList().iterator();

			while (arg18.hasNext()) {
				arg17 = (FeeDTO) arg18.next();
				if (!MSUtil.isEmpty(arg17.getPaidAmount())) {
					arg20 = 0.0F;
					arg21 = arg17.getDiscount().trim();
					if (arg21.indexOf("%") != -1) {
						feeSlip1 = Float.parseFloat(arg17.getPaidAmount()) * 100.0F
								/ (100.0F - Float.parseFloat(arg21.substring(0, arg21.length() - 1)));
						arg20 = feeSlip1 - Float.parseFloat(arg17.getPaidAmount());
					} else {
						arg20 = Float.parseFloat(arg17.getDiscount());
					}

					arg23 = new FeeSlip();
					arg23.setStudentId(feeFormBean.getStudentId());
					arg23.setFeeStructureId(arg17.getId());
					arg23.setAmount(arg17.getPaidAmount());
					arg23.setDiscount(String.valueOf(arg20));
					arg23.setCreatedBy(userId);
					feeSlipList.add(arg23);
					anuallyIds.append(arg17.getId());
					anuallyIds.append(",");
				}
			}
		}

		arg18 = feeSlipList.iterator();

		while (arg18.hasNext()) {
			FeeSlip arg19 = (FeeSlip) arg18.next();
			this.feeService.save(arg19);
		}

		feeSummaryDTO.setFeeSlipList(feeSlipList);
		feeSummaryDTO.setMonthIds(monthIds.toString());
		feeSummaryDTO.setQuarterlyIds(quarterlyIds.toString());
		feeSummaryDTO.setHalsyrlyIds(halsyrlyIds.toString());
		feeSummaryDTO.setAnuallyIds(anuallyIds.toString());
		return feeSummaryDTO;
	}

	public void populatePaymentFormBean(PaymentFormBean paymentFormBean) {
	}

	private Integer saveFeePaymentFormBean(PaymentFormBean paymentFormBean) {
		Payment payment = new Payment();
		payment.setStudentId(paymentFormBean.getStudentId());
		payment.setAmount(paymentFormBean.getAmount());
		payment.setFeeType(FeeType.REGULARFEES.getCode());
		payment.setComment(paymentFormBean.getComment());
		payment.setPaymentType(paymentFormBean.getPaymentType());
		payment.setDiscountAmt(paymentFormBean.getDisAmount());
		payment.setCreatedBy(SessionUtil.getUser().getId());
		payment.setAddDiscountAmt(paymentFormBean.getAddDiscountAmt());
		payment.setAddDiscountId(paymentFormBean.getAddDiscountId());
		this.paymentService.save(payment);
		return payment.getId();
	}

	private void updateFeeSlipWithPayment(Integer paymentId, String ids) {
		try {
			if (!MSUtil.isEmpty(ids) && ids.length() > 1) {
				ids = ids.substring(0, ids.length() - 1);
			}

			List e = this.feeService.findFeeSlips(ids);
			Iterator arg4 = e.iterator();

			while (arg4.hasNext()) {
				FeeSlip feeSlip = (FeeSlip) arg4.next();
				feeSlip.setPaymentId(paymentId);
				this.feeService.save(feeSlip);
			}
		} catch (MSException arg5) {
			arg5.printStackTrace();
		}

	}
}