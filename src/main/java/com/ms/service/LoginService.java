package com.ms.service;

import com.ms.bean.Login;
import com.ms.dao.UserDao;
import com.ms.entity.User;
import com.ms.util.EncryptionUtil;
import com.ms.util.MSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	@Autowired
	private UserDao userDao;

	public User authenticate(Login login) throws MSException {
		return this.userDao.findByEmailAndPassword(login.getEmail(), EncryptionUtil.md5Encrypt(login.getPassword()));
	}
}