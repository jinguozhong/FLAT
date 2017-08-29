package com.flat.srm.system;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.system.bean.User;
import com.flat.srm.system.dao.user.IUserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/applicationContext.xml",
		"classpath:spring/applicationContext-shiro.xml" })
public class UserTest { 
	
	@Autowired
	private IUserMapper userMapper; 
	
	/**
	 *
	 * 查询用户列表<br/>
	 * com.flat.srm.system <br/>
	 * 方法名：findUsersTest<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年6月15日-下午4:58:47 <br/> 
	 * 返回类型void<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@Test
	public void findUsersTest(){
		TzParams params=new TzParams();
		params.setIsParent("true");
		List<User> users=userMapper.findUsers(params);
		for (User user : users) {
			System.out.println(user.getName());
		}
	}
	/**
	 * 
	 * 用户表保存<br/>
	 * com.flat.srm.system <br/>
	 * 方法名：saveUser<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年6月17日-上午10:28:31 <br/> 
	 * 返回类型void<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@Test
	public void saveUser(){
		
		String mail="7";
		User user=new User();
		user.setName("text1");
		user.setpId(  (long) 1);
		for (int i = 0; i < 5000; i++) {
			mail="7"+i;
			user.setMail(mail);
			userMapper.save(user);
		}
	}
	/**
	 * 
	 * 查询用户明细<br/>
	 * com.flat.srm.system <br/>
	 * 方法名：findUser<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年6月22日-上午8:49:51 <br/> 
	 * 返回类型void<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@Test
	public void findUser(){
		TzParams params=new TzParams();
		params.setId((long)66);
		User user=userMapper.findUser(params);
		System.out.println(user.getMail()+"==="+user.getName());
	}
	/**
	 * 
	 * 根据用户id查询角色<br/>
	 * com.flat.srm.system <br/>
	 * 方法名：userRole<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年6月22日-下午1:15:06 <br/> 
	 * 返回类型void<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@Test
	public void userRole(){
		
		List<HashMap<String, Object>> lists=userMapper.userRoles(Long.parseLong("66"));
		for (HashMap<String, Object> hashMap : lists) {
			System.out.println(hashMap.get("userid")+"==="+hashMap.get("name"));
		}
	}
}
