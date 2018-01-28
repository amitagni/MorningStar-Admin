package com.ms.service;

import com.ms.dao.AccountDao;
import com.ms.dao.DayBookDao;
import com.ms.entity.Account;
import com.ms.entity.DayBook;
import com.ms.util.MSException;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DayBookService {
	@Autowired
	private DayBookDao dayBookDao;
	@Autowired
	private AccountDao accountDao;

	@Transactional(rollbackFor = {Exception.class})
	public DayBook save(DayBook dayBookEntity) throws MSException {
		if (dayBookEntity.getId() != null && dayBookEntity.getId().intValue() > 0) {
			dayBookEntity = (DayBook) this.dayBookDao.merge(dayBookEntity);
		} else {
			this.dayBookDao.persist(dayBookEntity);
		}

		return dayBookEntity;
	}

	@Transactional(rollbackFor = {Exception.class})
	public Account save(Account account) throws MSException {
		if (account.getId() != null && account.getId().intValue() > 0) {
			account = (Account) this.accountDao.merge(account);
		} else {
			this.accountDao.persist(account);
		}

		return account;
	}

	@Transactional(rollbackFor = {Exception.class})
	public boolean deletDayBookEntry(Integer id) {
		DayBook dayBook = (DayBook) this.dayBookDao.findById(id, DayBook.class);
		dayBook.setActive(Byte.valueOf((byte) 0));
		this.dayBookDao.merge(dayBook);
		return true;
	}

	public List<Account> findAccountsByName(String accountName) {
		return this.accountDao.findAccountsByName(accountName);
	}

	public Account findAccountByName(String accountName) {
		return this.accountDao.findAccountByName(accountName);
	}

	public List<DayBook> findDayBookEntryByDate(Date date) {
		return this.dayBookDao.findDayBookEntryByDate(date);
	}

	public List<DayBook> findDayBookEntryByDateAndAccountId(Integer id, Byte trType, Date startDate, Date endDate) {
		return this.dayBookDao.findDayBookEntryByDateAndAccountId(id, trType, startDate, endDate);
	}

	public List<Account> findAllAccounts() {
		try {
			return this.accountDao.findAll(Account.class);
		} catch (MSException arg1) {
			arg1.printStackTrace();
			return null;
		}
	}

	public Account findAccountById(Integer id) {
		return (Account) this.accountDao.findById(id, Account.class);
	}
}