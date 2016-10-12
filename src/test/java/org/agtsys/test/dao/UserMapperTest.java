package org.agtsys.test.dao;


import org.agtsys.dao.UserMapper;
import org.agtsys.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMapperTest {
	private UserMapper userMapper;
	@Before
	public void setUp() throws Exception{
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mybatis.xml");
		userMapper=(UserMapper) ac.getBean("userMapper");
	}
	@Test
	public void testUserMapper() {
		User user=new User();
		user.setUsercode("CW_1");
		user.setUserpassword("123456");
		User u=userMapper.getUserByUser(user);
		System.out.println(u);
		Assert.assertNotNull(userMapper.getUserByUser(user));
	}

}
