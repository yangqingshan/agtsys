package org.agtsys.service;

import org.agtsys.dao.AccountdetailMapper;
import org.agtsys.domain.AccountDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AccountdetailServiceImpl implements AccountdetailService {
	@Autowired
	private AccountdetailMapper accountdetailMapper;
	
	public int insertAccountDetail(AccountDetail accountdetail)
			throws Exception {
		return accountdetailMapper.insertAccountDetail(accountdetail);
	}

}
