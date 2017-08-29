/**
 
 */
package com.flat.srm.system.dao.user;

import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.system.bean.Role;
import com.flat.srm.system.bean.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

 

/**
 * 
 * IUserMapper 创建人:金国忠 时间：2015年11月24日-上午12:40:28
 * 
 * @version 1.0.0
 * 
 */
@Repository
public interface IUserMapper {
	/**
	 * 
	 * 用户信息新增<br/>
	 * com.flat.srm.system.dao.user <br/>
	 * 方法名：save<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年6月15日-下午4:25:46 <br/>
	 * @param user
	 * @return 
	 * 返回类型int<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public int save(User user);

	/**
	 * 
	 * 用户信息修改<br/>
	 * com.flat.srm.system.dao.user <br/>
	 * 方法名：update<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年6月15日-下午4:26:10 <br/>
	 * @param user
	 * @return 
	 * 返回类型int<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public int update(User user);

	/**
	 * 
	 * 用户删除<br/>
	 * com.flat.srm.system.dao.user <br/>
	 * 方法名：delete<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年6月15日-下午4:26:22 <br/>
	 * @param id
	 * @return 
	 * 返回类型int<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public int delete(Long id);

	/**
	 * 
	 * 根据账号和密码实现登陆<br/>
	 * com.flat.srm.system.dao.user <br/>
	 * 方法名：getLogin<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年6月15日-下午4:26:37 <br/>
	 * @param username
	 * @return 
	 * 返回类型User<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	// public User getLogin(TzParams params);
	public User getLogin(String username);

	/**
	 * 
	 * 查询用户明细信息<br/>
	 * com.flat.srm.system.dao.user <br/>
	 * 方法名：getUser<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年6月15日-下午4:26:48 <br/>
	 * @param params
	 * @return 
	 * 返回类型User<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public User findUser(TzParams params);

	/**
	 * 
	 * 查询用户列表<br/>
	 * com.flat.srm.system.dao.user <br/>
	 * 方法名：findUsers<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年6月15日-下午4:27:01 <br/>
	 * @param params
	 * @return 
	 * 返回类型List<User><br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public List<User> findUsers(TzParams params);

	/**
	 * 根据用户查询角色信息
	 *  <br/>
	 * com.flat.srm.system.dao.user <br/>
	 * 方法名：userRoles<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年6月15日-下午4:27:10 <br/>
	 * @return 
	 * 返回类型List<HashMap<String,Object>><br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public List<HashMap<String, Object>> userRoles(Long id);

	/**
	 * 根据用户名查询对应上级节点名称
	 * (这里用一句话描述这个方法的作用)<br/>
	 * com.flat.srm.system.dao.user <br/>
	 * 方法名：getUsers<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年6月15日-下午4:27:26 <br/>
	 * @param prParams
	 * @return 
	 * 返回类型List<User><br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	// public List<User> getUsers(String name, Integer pageNo, Integer
	// pageSize);
	public List<User> getUsers(TzParams prParams);

	/**
	 * 修改付对应父节点的节点类型
	 * (这里用一句话描述这个方法的作用)<br/>
	 * com.flat.srm.system.dao.user <br/>
	 * 方法名：pNodeUpdate<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年6月15日-下午4:27:33 <br/>
	 * @param isParent
	 * @param pId
	 * @return 
	 * 返回类型Integer<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public Integer pNodeUpdate(String isParent, Long pId);
 

	/**
	 * 删除用户管理中角色表中的数据
	 * (这里用一句话描述这个方法的作用)<br/>
	 * com.flat.srm.system.dao.user <br/>
	 * 方法名：u_rDelete<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年6月15日-下午4:27:41 <br/>
	 * @param uId
	 * @return 
	 * 返回类型Integer<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public Integer u_rDelete(Long uId);

	/**
	 * 用户密码修改
	 * (这里用一句话描述这个方法的作用)<br/>
	 * com.flat.srm.system.dao.user <br/>
	 * 方法名：updeletePass<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年6月15日-下午4:27:54 <br/>
	 * @param user
	 * @return 
	 * 返回类型Integer<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public Integer updeletePass(User user);

	/**
	 * 查询注册待审核的用户
	 * (这里用一句话描述这个方法的作用)<br/>
	 * com.flat.srm.system.dao.user <br/>
	 * 方法名：findRegisteredUsers<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年6月15日-下午4:28:01 <br/>
	 * @param params
	 * @return 
	 * 返回类型List<User><br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public List<User> findRegisteredUsers(TzParams params);

	/**
	 * 查询注册待审核的用户的总数
	 * (这里用一句话描述这个方法的作用)<br/>
	 * com.flat.srm.system.dao.user <br/>
	 * 方法名：findRegisteredUserTotal<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年6月15日-下午4:28:13 <br/>
	 * @param params
	 * @return 
	 * 返回类型Integer<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public Integer findRegisteredUserTotal(TzParams params);
	
	
	/**
	 * 保存用户管理中角色表中的数据 <br/>
	 * com.flat.srm.system.dao.user <br/>
	 * 方法名：u_rSave<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年6月29日-下午4:58:05 <br/>
	 * @param uid
	 * @param roles
	 * @return 
	 * 返回类型Integer<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public Integer u_rSave(Long uid, List<Role> roles);

}
