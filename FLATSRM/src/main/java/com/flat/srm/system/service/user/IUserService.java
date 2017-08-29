package com.flat.srm.system.service.user;

import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.system.bean.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IUserService {
	/**
	 * 
	 * 用户信息新增<br/>
	 * com.jgz.dao.user <br/>
	 * 方法名：save<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年2月20日-下午1:37:55 <br/>
	 * 
	 * @param user
	 * @return 返回类型int<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public int save(User user);

	/**
	 * 
	 * 用户字典保存<br/>
	 * com.jgz.service.user <br/>
	 * 方法名：saveAll<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年2月24日-上午9:30:50 <br/>
	 * 
	 * @return 返回类型String<br/>
	 * @throws Exception
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public String saveAll(String datas, String name) throws Exception;

	/**
	 * 
	 * 用户信息修改<br/>
	 * com.jgz.dao.user <br/>
	 * 方法名：update<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2016年10月27日-下午9:04:37 <br/>
	 * 
	 * @param user
	 * @return 返回类型Integer<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public int update(User user);

	/**
	 * 
	 * 用户删除<br/>
	 * com.jgz.dao.user <br/>
	 * 方法名：delete<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2016年12月6日-下午10:25:44 <br/>
	 * 
	 * @param id
	 * @return 返回类型int<br/>
	 * @throws Exception
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public int deleteAll(Long id) throws Exception;

	/**
	 * 
	 * 根据用户查询角色信息<br/>
	 * com.jgz.dao.user <br/>
	 * 方法名：userRole<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2016年12月22日-下午3:46:34 <br/>
	 * 
	 * @param integer
	 * @return 返回类型List<HashMap<String,Object>><br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public List<HashMap<String, Object>> userRoles(Long id);

	/**
	 * 
	 * 根据账户和密码登入<br/>
	 * com.jgz.service.user <br/>
	 * 方法名：getLogin<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2016年6月5日-下午1:15:10 <br/>
	 * 
	 * @param params
	 * @return 返回类型User<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	// public User getLogin(TzParams params);
	public User getLogin(String username);

	/**
	 * 
	 * 查询用户明细信息<br/>
	 * com.jgz.dao.user <br/>
	 * 方法名：getUser<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2016年9月29日-下午2:43:44 <br/>
	 * 
	 * @param params
	 * @return 返回类型User<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public User findUser(TzParams params);

	/**
	 * 
	 * 查询用户列表<br/>
	 * com.jgz.dao.user <br/>
	 * 方法名：findUser<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2016年6月15日-下午12:54:24 <br/>
	 * 
	 * @param params
	 * @return 返回类型List<User><br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public List<User> findUsers(TzParams params);

 

	/**
	 * 
	 * 修改付对应父节点的节点类型<br/>
	 * com.jgz.dao.user <br/>
	 * 方法名：pNodeUpdate<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年1月9日-下午1:52:40 <br/>
	 * 
	 * @param isParent
	 * @return 返回类型Integer<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public Integer pNodeUpdate(String isParent, Long pId);

	 

	/**
	 * 
	 * 删除用户管理中角色表中的数据<br/>
	 * com.jgz.dao.user <br/>
	 * 方法名：u_rDelete<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年2月3日-上午10:30:59 <br/>
	 * 
	 * @param uId
	 * @return 返回类型Integer<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public Integer u_rDelete(Long uId);

	/**
	 * 
	 * 用户密码修改<br/>
	 * com.jgz.dao.user <br/>
	 * 方法名：updeletePass<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年3月21日-下午3:24:57 <br/>
	 * 
	 * @param uId
	 * @return 返回类型Integer<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public Integer updeletePass(User user);

	 
	/**
	 * 
	 * 踢出用户<br/>
	 * com.jgz.service.user <br/>
	 * 方法名：kickedOutUser<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年3月31日-上午11:06:14 <br/>
	 * 
	 * @return 返回类型Boolean<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public Boolean kickedOutUser(String sessionId);

	/**
	 * 
	 * 分页查询注册待审核用户信息<br/>
	 * com.jgz.service.user <br/>
	 * 方法名：findRegisteredUsers<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年4月17日-下午10:02:35 <br/>
	 * 
	 * @param params
	 * @return 返回类型Map<String,Object><br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public Map<String, Object> findRegisteredUsers(TzParams params);

	/**
	 * 
	 * 审核通过保存方法<br/>
	 * com.jgz.web.system <br/>
	 * 方法名：toAuditUserSave<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年4月21日-上午10:07:10 <br/>
	 * 
	 * @param user
	 * @return 返回类型String<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public String saveToAuditUser(User user);
	 /**
	  * 
	  * 查询在字典字段中的模糊查询<br/>
	  * com.flat.srm.system.service.user <br/>
	  * 方法名：findUserDictionary<br/>
	  * 创建人：JGZ <br/>
	  * 时间：2017年6月27日-下午1:42:11 <br/>
	  * @param params
	  * @return 
	  * 返回类型List<User><br/>
	  * @exception <br/>
	  * @since  1.0.0<br/>
	  */
	public List<User> findUserDictionary(TzParams params);
}
