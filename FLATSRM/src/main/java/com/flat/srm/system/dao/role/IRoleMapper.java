package com.flat.srm.system.dao.role;

import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.system.bean.Role;
import com.flat.srm.system.bean.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
@Repository
public interface IRoleMapper {

	/**
	 * 查询 com.jgz.dao.role 方法名：findRoles
	 * 
	 * @param params
	 * @return 返回类型：List<Role>
	 * @exception
	 * @since 1.0.0
	 */
	public List<Role> finds(TzParams params);

	/**
	 * 
	 * 根据用户名分页查询对应上级节点名称<br/>
	 * com.jgz.dao.role <br/>
	 * 方法名：findRoles<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年2月28日-下午5:08:15 <br/>
	 *
	 * @return 返回类型List<User><br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public List<Role> findRoles(TzParams params);

	/**
	 * 
	 * 登入时，根据登入名查询对应的角色<br/>
	 * com.jgz.dao.role <br/>
	 * 方法名：findLodinRoles<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年3月14日-上午10:23:45 <br/>
	 * 
	 * @param params
	 * @return 返回类型List<Role><br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public List<Role> findLodinRoles(TzParams params);

	/**
	 * 获取对象 com.jgz.dao.role 方法名：getRole
	 *
	 * @return 返回类型：Role
	 * @exception
	 * @since 1.0.0
	 */
	public Role find(TzParams params);

	/**
	 * 添加 com.jgz.dao.role 方法名：save
	 * 
	 * @param role
	 * @return 返回类型：int
	 * @exception
	 * @since 1.0.0
	 */
	public int save(Role role);

	/**
	 * 
	 * 表格保存<br/>
	 * com.jgz.dao.role <br/>
	 * 方法名：formSave<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年3月8日-上午10:52:41 <br/>
	 * 
	 * @param rid
	 * @param users
	 * @return 返回类型int<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public int formSave(Long rid, List<User> users);

	/**
	 * 修改 com.jgz.dao.role 方法名：update
	 * 
	 * @param role
	 * @return 返回类型：int
	 * @exception
	 * @since 1.0.0
	 */
	public int update(Role role);

	/**
	 * 删除 com.jgz.dao.role 方法名：delete
	 * 

	 *            rid
	 * @return 返回类型：int
	 * @exception
	 * @since 1.0.0
	 */
	public int delete(Long rid);

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
	 * 修改付对应父节点的节点类型<br/>
	 * com.jgz.dao.role <br/>
	 * 方法名：pNodeUpdate<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年3月8日-下午10:22:26 <br/>
	 * 
	 * @param isParent
	 * @param pId
	 * @return 返回类型Integer<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public Integer pNodeUpdate(String isParent, Long pId);

	/**
	 * 
	 * 用户表格删除<br/>
	 * com.jgz.dao.role <br/>
	 * 方法名：formDelete<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年3月8日-下午10:26:31 <br/>
	 * 
	 * @param uId
	 * @return 返回类型Integer<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public Integer formDelete(Long uId);

}
