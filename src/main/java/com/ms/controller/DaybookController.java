package com.ms.controller;

import com.ms.bean.AccountBean;
import com.ms.bean.DayBookBean;
import com.ms.bean.LedgerBean;
import com.ms.dto.AccountDTO;
import com.ms.dto.DayBookDTO;
import com.ms.dto.SearchResultDTO;
import com.ms.entity.Account;
import com.ms.entity.DayBook;
import com.ms.enums.PaymentType;
import com.ms.enums.TransactionType;
import com.ms.service.DayBookService;
import com.ms.util.DateUtils;
import com.ms.util.MSException;
import com.ms.util.SessionUtil;
import java.sql.Date;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("request")
public class DaybookController {
	@Autowired
	private DayBookService dayBookService;

	@RequestMapping(value = {"/daybook"}, method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView daybook(@ModelAttribute("dayBookBean") DayBookBean dayBookBean, BindingResult bindingResult,
			Model model, HttpServletRequest request) {
		SessionUtil.setPage("DayBook");
		String daybookDate = request.getParameter("dt");
		if (daybookDate == null) {
			daybookDate = DateUtils.convertToStringObject(DateUtils.getCurrentDateTime(), "dd MMMM, yyyy");
		}

		dayBookBean.setDayBookDate(daybookDate);
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			dayBookBean.setAccountList(this.populateAccoountList());
			dayBookBean.setUserAction("2");
			dayBookBean.setDayBookDTOList(this.populateCurrentDateDaybook(daybookDate));
			String e2 = request.getParameter("err");
			if (e2 != null && e2.equals("1")) {
				model.addAttribute("message", "Account with this name already exit");
				System.out.println("Account with this name already exits");
			}

			return new ModelAndView("daybook", "dayBookBean", dayBookBean);
		} else {
			try {
				if (dayBookBean.getUserAction().indexOf("1") != -1) {
					String[] e = dayBookBean.getUserAction().split(":");
					String action = e[1];
					if (action.equals("1")) {
						if (dayBookBean.getAccountBean().getId() == null) {
							if (this.checkAccountIfExists(dayBookBean.getAccountBean().getName())) {
								return new ModelAndView("redirect:/daybook.do?err=1");
							}

							this.saveAccount(dayBookBean.getAccountBean());
						}
					} else if (action.equals("2")) {
						this.editAccount(dayBookBean.getAccountBean(), Byte.valueOf((byte) 1));
					} else if (action.equals("3")) {
						this.editAccount(dayBookBean.getAccountBean(), Byte.valueOf((byte) 0));
					}
				} else if (dayBookBean.getUserAction().equals("2")) {
					Account e1 = this.dayBookService.findAccountById(dayBookBean.getAccountBean().getId());
					dayBookBean.getAccountBean().setName(e1.getAccountName());
					this.saveDayBook(dayBookBean);
					return new ModelAndView("redirect:/daybook.do");
				}

				return new ModelAndView("redirect:/daybook.do");
			} catch (Exception arg7) {
				arg7.printStackTrace();
				return new ModelAndView("daybook", "dayBookBean", dayBookBean);
			}
		}
	}

	private boolean checkAccountIfExists(String name) {
		return this.dayBookService.findAccountByName(name) != null;
	}

	@RequestMapping(value = {"/ledger"}, method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView ledger(@ModelAttribute("ledgerBean") LedgerBean ledgerBean, BindingResult bindingResult,
			Model model, HttpServletRequest request) {
		SessionUtil.setPage("Ledger");
		ledgerBean.setAccountList(this.populateAccoountList());
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			ledgerBean.setTransactionType(TransactionType.ALL.getCode());
			return new ModelAndView("ledger", "ledgerBean", ledgerBean);
		} else {
			Date startDate = new Date(
					DateUtils.convertToDateObject(ledgerBean.getStartDate(), "DD MMMM, yyyy").getTime());
			Date endDate = new Date(DateUtils.convertToDateObject(ledgerBean.getEndDate(), "dd MMMM, yyyy").getTime());
			List dayBookList = this.dayBookService.findDayBookEntryByDateAndAccountId(ledgerBean.getId(),
					ledgerBean.getTransactionType(), startDate, endDate);
			if (dayBookList != null) {
				ArrayList dayBookDTOs = new ArrayList();
				Iterator arg9 = dayBookList.iterator();

				while (arg9.hasNext()) {
					DayBook dayBook = (DayBook) arg9.next();
					DayBookDTO dayBookDTO = new DayBookDTO();
					dayBookDTO.setAmount(dayBook.getAmount());
					dayBookDTO.setTransactionType(TransactionType.findNameByCode(dayBook.getTransactionType()));
					dayBookDTO.setComment(dayBook.getComments());
					dayBookDTOs.add(dayBookDTO);
				}

				ledgerBean.setDayBookDTOList(dayBookDTOs);
			}

			return new ModelAndView("ledger", "ledgerBean", ledgerBean);
		}
	}

	private List<AccountDTO> populateAccoountList() {
		List accounts = this.dayBookService.findAllAccounts();
		ArrayList accountDTOList = new ArrayList();
		if (accounts != null) {
			Iterator arg3 = accounts.iterator();

			while (arg3.hasNext()) {
				Account account = (Account) arg3.next();
				AccountDTO accountDTO = new AccountDTO();
				accountDTO.setId(account.getId().intValue());
				accountDTO.setAccountName(account.getAccountName());
				accountDTOList.add(accountDTO);
			}
		}

		return accountDTOList;
	}

	@RequestMapping({"/fetch-accountlist"})
	@ResponseBody
	public List<SearchResultDTO> getAccountList(HttpServletRequest request) {
		String accountName = request.getParameter("accountName");
		ArrayList accountnfoList = new ArrayList();
		List accontinfoList = this.dayBookService.findAccountsByName(accountName);
		if (accontinfoList != null) {
			Iterator arg5 = accontinfoList.iterator();

			while (arg5.hasNext()) {
				Account account = (Account) arg5.next();
				SearchResultDTO searchResultDTO = new SearchResultDTO();
				searchResultDTO.setLabel(account.getAccountName());
				searchResultDTO.setDescValue(account.getId() + ":" + account.getDescription());
				accountnfoList.add(searchResultDTO);
			}
		}

		return accountnfoList;
	}

	@RequestMapping({"/delete-dBookEntry"})
	@ResponseBody
	public boolean deleteDayBookEntry(HttpServletRequest request) {
		String id = request.getParameter("daybookId");
		return this.dayBookService.deletDayBookEntry(Integer.valueOf(Integer.parseInt(id)));
	}

	private List<DayBookDTO> populateCurrentDateDaybook(String daybookDate) {
		Date date = new Date(DateUtils.convertToDateObject(daybookDate, "dd MMMM, yyyy").getTime());
		List dayBookEntries = this.dayBookService.findDayBookEntryByDate(date);
		ArrayList dtoList = new ArrayList();
		if (dayBookEntries != null) {
			Iterator arg5 = dayBookEntries.iterator();

			while (arg5.hasNext()) {
				DayBook dayBook = (DayBook) arg5.next();
				DayBookDTO dayBookDTO = new DayBookDTO();
				dayBookDTO.setId(dayBook.getId().toString());
				dayBookDTO.setAccountName(dayBook.getAccountName());
				dayBookDTO.setTransactionType(TransactionType.findNameByCode(dayBook.getTransactionType()));
				dayBookDTO.setPaymentType(PaymentType.findNameByCode(dayBook.getPaymentType()));
				dayBookDTO.setAmount(dayBook.getAmount());
				dayBookDTO.setComment(dayBook.getComments());
				dtoList.add(dayBookDTO);
			}
		}

		return dtoList;
	}

	public void populateRegistrationFormBean(DayBookBean dayBookBean) {
	}

	private Integer saveDayBook(DayBookBean dayBookBean) throws MSException {
		DayBook dayBook = this.populateDayBookInfo(dayBookBean);
		this.dayBookService.save(dayBook);
		return dayBook.getId();
	}

	private Integer saveAccount(AccountBean accountBean) throws MSException {
		Account account = new Account();
		account.setAccountName(accountBean.getName());
		account.setDescription(accountBean.getDescription());
		account.setActive(Byte.valueOf((byte) 1));
		this.dayBookService.save(account);
		return account.getId();
	}

	private void editAccount(AccountBean accountBean, Byte type) throws MSException {
		Account account = new Account();
		account.setId(accountBean.getId());
		account.setAccountName(accountBean.getName());
		account.setDescription(accountBean.getDescription());
		account.setActive(type);
		this.dayBookService.save(account);
	}

	public DayBook populateDayBookInfo(DayBookBean dayBookBean) {
		DayBook dayBookEntity = new DayBook();
		dayBookEntity.setTransactionType(dayBookBean.getTransactionType());
		dayBookEntity.setAccountId(dayBookBean.getAccountBean().getId());
		dayBookEntity.setAccountName(dayBookBean.getAccountBean().getName());
		dayBookEntity.setPaymentType(dayBookBean.getPaymentType());
		dayBookEntity.setChequeEpayNo(dayBookBean.getChequeEpayNo());
		dayBookEntity.setAmount(dayBookBean.getAmount());
		dayBookEntity.setComments(dayBookBean.getComments());
		dayBookEntity.setActive(Byte.valueOf((byte) 1));
		return dayBookEntity;
	}
}