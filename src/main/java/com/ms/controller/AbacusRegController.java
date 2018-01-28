package com.ms.controller;

import com.ms.bean.AbacusRegBean;
import com.ms.bean.AbacusSearchBean;
import com.ms.dto.AbacusReceiptDTO;
import com.ms.dto.FeeMonthsDTO;
import com.ms.entity.AbacusFee;
import com.ms.entity.AbacusRegEntity;
import com.ms.enums.Month;
import com.ms.service.AbacusRegService;
import com.ms.util.DateUtils;
import com.ms.util.MSException;
import com.ms.util.MSUtil;
import com.ms.util.SessionUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
public class AbacusRegController {
	@Autowired
	AbacusRegService abacusRegService;

	@RequestMapping(value = {"/abacusreg"}, method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView abacusreg(@ModelAttribute("abacusRegBean") AbacusRegBean abacusRegBean,
			BindingResult bindingResult, Model model, HttpServletRequest request) {
		SessionUtil.setPage("Registration Brain &lsquo;N&rsquo; Abacus");
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			this.populateAbacusRegFormBean(abacusRegBean);
			return new ModelAndView("abacusreg", "abacusRegBean", abacusRegBean);
		} else {
			try {
				Integer e = this.saveAbacusRegBean(abacusRegBean);
				return new ModelAndView("redirect:/abacus-search.do?id=" + e);
			} catch (Exception arg5) {
				arg5.printStackTrace();
				return new ModelAndView("abacusreg", "abacusRegBean", abacusRegBean);
			}
		}
	}

	@RequestMapping(value = {"/abacus-search"}, method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView abacussearch(@ModelAttribute("abacusSearchBean") AbacusSearchBean abacusSearchBean,
			BindingResult bindingResult, Model model, HttpServletRequest request) {
		String id = request.getParameter("id");
		ArrayList monthlyPaidFeeList = new ArrayList();

		try {
			if (id != null) {
				AbacusRegEntity e = this.abacusRegService.findId(Integer.valueOf(Integer.parseInt(id)));
				List month = this.abacusRegService.findByStudentId(Integer.valueOf(Integer.parseInt(id)));
				if (e != null) {
					abacusSearchBean.setName(e.getFirstName() + " " + e.getLastName());
					abacusSearchBean.setId(e.getId().intValue());
					abacusSearchBean.setFatherName(e.getFatherName());
				}

				if (month != null && month.size() > 0) {
					abacusSearchBean.setRegFee((byte) 0);
					abacusSearchBean.setRegAmt(Integer.valueOf(0));
					Iterator feeMonthsDTO = month.iterator();

					while (feeMonthsDTO.hasNext()) {
						AbacusFee abacusFee = (AbacusFee) feeMonthsDTO.next();
						monthlyPaidFeeList.addAll(MSUtil.tokenizeList(abacusFee.getMonths()));
					}
				} else {
					abacusSearchBean.setRegAmt(Integer.valueOf(1000));
					abacusSearchBean.setRegFee((byte) 1);
				}
			}

			ArrayList e1 = new ArrayList();

			FeeMonthsDTO feeMonthsDTO1;
			for (Iterator abacusFee1 = MSUtil.populateMonthList().iterator(); abacusFee1.hasNext(); e1
					.add(feeMonthsDTO1)) {
				Month month1 = (Month) abacusFee1.next();
				feeMonthsDTO1 = new FeeMonthsDTO();
				feeMonthsDTO1.setCode(month1.getCode());
				feeMonthsDTO1.setName(month1.getName());
				if (monthlyPaidFeeList.contains(month1.getCode().toString())) {
					feeMonthsDTO1.setPaid(true);
					feeMonthsDTO1.setName(month1.getName() + "  --  PAID");
				}
			}

			abacusSearchBean.setMonthList(e1);
			return new ModelAndView("abacus-search", "abacusSearchBean", abacusSearchBean);
		} catch (NumberFormatException arg10) {
			arg10.printStackTrace();
		} catch (MSException arg11) {
			arg11.printStackTrace();
		}

		return new ModelAndView("abacus-search");
	}

	@RequestMapping(value = {"/abacus-fee.do"}, method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView abacusFee(@ModelAttribute("abacusSearchBean") AbacusSearchBean abacusSearchBean,
			BindingResult bindingResult, Model model, HttpServletRequest request) {
		SessionUtil.setPage("Registration Brain &lsquo;N&rsquo; Abacus");
		Integer id = null;

		try {
			id = this.saveAbacusFee(abacusSearchBean);
			return new ModelAndView("redirect:/abacus-reciept.do?id=" + id + "&studentId=" + abacusSearchBean.getId());
		} catch (Exception arg6) {
			arg6.printStackTrace();
			return new ModelAndView("redirect:/abacus-reciept.do?id=" + id + "&studentId=" + abacusSearchBean.getId());
		}
	}

	@RequestMapping(value = {"/abacus-reciept.do"}, method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView abacusReceipt(@ModelAttribute("AbacusReceiptDTO") AbacusReceiptDTO abacusReceiptDTO,
			BindingResult bindingResult, Model model, HttpServletRequest request) {
		SessionUtil.setPage("Registration Brain &lsquo;N&rsquo; Abacus");

		try {
			String e = request.getParameter("id");
			String studentId = request.getParameter("studentId");
			this.fetchRecieptData(e, studentId, abacusReceiptDTO);
			return new ModelAndView("abacus-reciept", "abacusReceiptDTO", abacusReceiptDTO);
		} catch (Exception arg6) {
			arg6.printStackTrace();
			return new ModelAndView("abacus-reciept", "abacusReceiptDTO", abacusReceiptDTO);
		}
	}

	private AbacusReceiptDTO fetchRecieptData(String id, String studentId, AbacusReceiptDTO abacusReceiptDTO) {
		try {
			AbacusFee e = this.abacusRegService.findFeeById(Integer.valueOf(Integer.parseInt(id)));
			AbacusRegEntity abacusRegEntity = this.abacusRegService
					.findId(Integer.valueOf(Integer.parseInt(studentId)));
			abacusReceiptDTO.setRecieptId("" + e.getId());
			abacusReceiptDTO.setName(abacusRegEntity.getFirstName() + " " + abacusRegEntity.getLastName());
			abacusReceiptDTO.setFatherName(abacusRegEntity.getFatherName());
			abacusReceiptDTO.setDate(DateUtils.convertToStringObject(e.getCreatedAt(), "dd/MM/yyyy"));
			List monthList = MSUtil.tokenizeList(e.getMonths());
			StringBuilder months = new StringBuilder();
			Iterator arg8 = monthList.iterator();

			while (arg8.hasNext()) {
				String regAmount = (String) arg8.next();
				months.append(Month.findNameByCode(Byte.valueOf(Byte.parseByte(regAmount))));
				months.append(',');
			}

			abacusReceiptDTO.setMonths(months.substring(0, months.length() - 1));
			int regAmount1 = 0;
			if (e.getRegfee() != null && !e.getRegfee().equals("null")) {
				regAmount1 = Integer.parseInt(e.getRegfee());
				abacusReceiptDTO.setRegAmount(e.getRegfee());
			}

			abacusReceiptDTO.setAmount(e.getAmount());
			abacusReceiptDTO.setTotalAmount(String.valueOf(Integer.parseInt(e.getAmount()) + regAmount1));
		} catch (MSException arg9) {
			arg9.printStackTrace();
		}

		return abacusReceiptDTO;
	}

	private Integer saveAbacusFee(AbacusSearchBean abacusSearchBean) {
		AbacusFee abacusFee = new AbacusFee();
		abacusFee.setStudentId(Integer.valueOf(abacusSearchBean.getId()));
		abacusFee.setAmount(String.valueOf(abacusSearchBean.getMonthlyAmt()));
		abacusFee.setMonths(abacusSearchBean.getSelMonth());
		abacusFee.setStatus((byte) 1);
		abacusFee.setRegfee(String.valueOf(abacusSearchBean.getRegAmt()));

		try {
			this.abacusRegService.saveAbacusFee(abacusFee);
		} catch (MSException arg3) {
			arg3.printStackTrace();
		}

		return abacusFee.getId();
	}

	private Integer saveAbacusRegBean(AbacusRegBean abacusRegBean) {
		AbacusRegEntity abacusRegEntity = new AbacusRegEntity();
		abacusRegEntity.setFirstName(abacusRegBean.getFirstName());
		abacusRegEntity.setLastName(abacusRegBean.getLastName());
		abacusRegEntity.setNickName(abacusRegBean.getNickName());
		abacusRegEntity.setDateOfBirth(abacusRegBean.getDateOfBirth());
		abacusRegEntity.setFatherName(abacusRegBean.getFatherName());
		abacusRegEntity.setMotherName(abacusRegBean.getMotherName());
		abacusRegEntity.setSchoolName(abacusRegBean.getSchoolname());
		abacusRegEntity.setGender(abacusRegBean.getGender());
		abacusRegEntity.setAddress1(abacusRegBean.getAddress1());
		abacusRegEntity.setAddress2(abacusRegBean.getAddress2());
		abacusRegEntity.setArea(abacusRegBean.getArea());
		abacusRegEntity.setCity(abacusRegBean.getCity());
		abacusRegEntity.setState(abacusRegBean.getState());
		abacusRegEntity.setMobile(abacusRegBean.getMobile());
		abacusRegEntity.setPhone(abacusRegBean.getPhone());
		abacusRegEntity.setEmail(abacusRegBean.getEmail());
		abacusRegEntity.setStuentClass(Byte.valueOf(Byte.parseByte(abacusRegBean.getSchoolclass())));

		try {
			this.abacusRegService.saveAbacusRegBean(abacusRegEntity);
			return abacusRegEntity.getId();
		} catch (MSException arg3) {
			arg3.printStackTrace();
			return null;
		}
	}

	public void populateAbacusRegFormBean(AbacusRegBean abacusRegBean) {
		abacusRegBean.setStateList(MSUtil.populateStateList());
		abacusRegBean.setStudentClassList(MSUtil.populateClassList());
	}
}