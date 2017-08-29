package com.flat.srm.system.service.role;

import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.system.bean.Role;

import java.util.HashMap;
import java.util.List;

public interface IRoleService {

	/**
	 * 查询 com.jgz.service.role 方法名：findRoles 时间：[date]
	 * 
	 * @param params
	 * @return 返回类型：List<Role>
	 * @exception
	 * @since 1.0.0
	 */
	public List<Role> finds(TzParams params);

	/**
	 * 
	 * com.jgz.service.role 方法名：findRole
	 * 
	 * @param params
	 * @return 返回类型：Role
	 * @exception
	 * @since 1.0.0
	 */
	public Role find(TzParams params);

	/**
	 * 保存 com.jgz.service.role 方法名：save
	 * 
	 * @param role
	 * @return 返回类型：int
	 * @exception
	 * @since 1.0.0
	 */
	public int save(Role role);

	/**
	 * 更新 com.jgz.service.role 方法名：update
	 * 
	 * @param role
	 * @return 返回类型：int
	 * @exception
	 * @since 1.0.0
	 */
	public int update(Role role);

	/**
	 * 
	 * 根据用户名分页查询对应上级节点名称<br/>
	 * com.jgz.dao.role <br/>
	 * 方法名：findRoles<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年2月28日-下午5:08:15 <br/>
	 * 
	 * @param name
	 * @param pageNo
	 * @param pageSize
	 * @return 返回类型List<User><br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public List<Role> findRoles(TzParams params);

	/**
	 * 
	 * 根据角色查询用户信息<br/>
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
	public List<HashMap<String, Object>> findRoleUsers(Long integer);

	/**
	 * 
	 * 保存数据<br/>
	 * com.jgz.service.role <br/>
	 * 方法名：saveAll<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年3月8日-上午10:35:13 <br/>
	 * 
	 * @param datas
	 * @param name
	 * @return
	 * @throws Exception
	 *             返回类型String<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public String saveAll(String datas, String name) throws Exception;

	/**
	 * 
	 * 删除数据<br/>
	 * com.jgz.service.role <br/>
	 * 方法名：deleteAll<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年3月9日-下午1:17:40 <br/>
	 * 
	 * @param i
	 * @return
	 * @throws Exception
	 *             返回类型String<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public int deleteAll(Long i) throws Exception;

	/**
	 * 
	 * 登入时，根据登入名查询对应的角色<br/>
	 * com.jgz.service.role <br/>
	 * 方法名：findLodinRoles<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年3月14日-上午10:44:18 <br/>
	 * 
	 * @param params
	 * @return 返回类型List<Role><br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public List<Role> findLodinRoles(TzParams params);
}
