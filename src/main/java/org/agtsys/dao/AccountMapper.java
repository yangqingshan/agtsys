package org.agtsys.dao;

import org.agtsys.domain.Account;

public interface AccountMapper {
	int insertAccount(Account account)throws Exception;
}