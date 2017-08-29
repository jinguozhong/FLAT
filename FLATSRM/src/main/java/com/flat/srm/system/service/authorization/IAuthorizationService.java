package com.flat.srm.system.service.authorization;

import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.system.bean.Authorization;

import java.util.List;
import java.util.Map;

public interface IAuthorizationService {
	/**
	 * 
	 * 加载所有树和对应角色已有的树<br/>
	 * com.jgz.service.authorization <br/>
	 * 方法名：findAll<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年3月16日-下午1:00:25 <br/>
	 * 
	 * @param id
	 * @return 返回类型List<Authorization><br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public Map<String, Object> findMap(Long id);

	/**
	 * 查询 com.jgz.service.permissions 方法名：findPermissionss 时间：[date]
	 * 
	 * @param params
	 * @return 返回类型：List<Permissions>
	 * @exception
	 * @since 1.0.0
	 */
	public List<Authorization> findAll(TzParams params);

	/**
	 * 
	 * 查询选中角色所对应的权限<br/>
	 * com.jgz.service.authorization <br/>
	 * 方法名：finds<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年3月16日-下午1:25:12 <br/>
	 * 
	 * @param params
	 * @return 返回类型List<Authorization><br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public List<Authorization> finds(TzParams params);

	/**
	 * 
	 * com.jgz.service.permissions 方法名：findPermissions
	 * 
	 * @param params
	 * @return 返回类型：Permissions
	 * @exception
	 * @since 1.0.0
	 */
	public Authorization find(Long id);

	/**
	 * 保存 com.jgz.service.permissions 方法名：save
	 * 
	 * @param permissions
	 * @return 返回类型：int
	 * @exception
	 * @since 1.0.0
	 */
	public String save(TzParams params) throws Exception;

	/**
	 * 更新 com.jgz.service.permissions 方法名：update
	 * 
	 * @param permissions
	 * @return 返回类型：int
	 * @exception
	 * @since 1.0.0
	 */
	public int update(Authorization permissions);

	/**
	 * 删除 com.jgz.service.permissions 方法名：delete
	 * 
	 * @param params
	 * @return 返回类型：int
	 * @exception
	 * @since 1.0.0
	 */
	public int delete(Long id);
}
