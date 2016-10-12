package org.agtsys.test.service;

import static org.junit.Assert.*;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;

import org.agtsys.dao.UserMapper;
import org.agtsys.domain.User;
import org.agtsys.service.UserService;
import org.agtsys.service.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
public class UserServiceTest {
	@Tested
	UserService userService;
	@Injectable
	UserMapper userMapper;
	
	
	@Before
	public void setUp() throws Exception {
		userService=new UserServiceImpl();
	}

	@Test
	public void testUserService() {
		//录制
		new Expectations(){
			{
				userMapper.getUserByUser(withInstanceOf(User.class));
				times=1;
			}
		};
		//回放
		userService.getUserByUser(new User());
		//验证
		new Verifications(){
			{
				userMapper.getUserByUser(withInstanceOf(User.class));
				times=1;
			}
		};
	}

}
