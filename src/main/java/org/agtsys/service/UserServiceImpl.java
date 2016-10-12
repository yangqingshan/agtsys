package org.agtsys.service;

import java.util.List;

import org.agtsys.dao.AccountMapper;
import org.agtsys.dao.UserMapper;
import org.agtsys.domain.Account;
import org.agtsys.domain.User;
import org.agtsys.util.MySqlPageTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private AccountMapper accountMapper;
	
	public User getUserByUser(User user) {
		return userMapper.getUserByUser(user);
	}

	public int updateUser(User user) throws Exception {
		return userMapper.updateUser(user);
	}

	public int getCount(User user) throws Exception {
		return userMapper.getCount(user);
	}

	public List<User> getPageUserByUser(User user, MySqlPageTool pt)
			throws Exception {
		return userMapper.getPageUserByUser(user, pt);
	}

	public int tx_addUser(User user) throws Exception {
		userMapper.insertUser(user);
		Account account =new Account();
		account.setMoney(0.0);
		account.setMoneybak(0.0);
		account.setUserid(user.getId());
		return accountMapper.insertAccount(account);
	}

	public int insertUser(User user) throws Exception {
		return userMapper.insertUser(user);
	}
}
