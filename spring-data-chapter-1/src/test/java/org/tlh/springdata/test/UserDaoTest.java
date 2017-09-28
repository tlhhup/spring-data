package org.tlh.springdata.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tlh.springdata.App;
import org.tlh.springdata.dao.UserDao;
import org.tlh.springdata.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=App.class)
public class UserDaoTest {
	
	@Resource
	private UserDao userDao;

	@Test
	public void save(){
		User user=new User();
		user.setAddress("成都");
		user.setPassword("admin");
		user.setUserName("admin");
		
		userDao.save(user);
	}
	
	@Test
	public void query(){
		Page<User> users = userDao.findAll(new PageRequest(1, 1));
		
		System.out.println(users.getSize());
	}
	
	@Test
	public void merge(){
		User user=new User();
		user.setAddress("成都");
		user.setPassword("admin");
		user.setUserName("admin");
		user.setId(1);
		userDao.updateUserInfo(user);
	}
	
	@Test
	public void delete(){
		userDao.deleteUserById(1);
	}
	
}
