package com.flat.srm.system.service.permissions;

import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.system.bean.Permissions;

import java.util.List;

public interface IPermissionsService {

	/**
	 * 查询 com.jgz.service.permissions 方法名：findPermissionss 时间：[date]
	 * 
	 * @param params
	 * @return 返回类型：List<Permissions>
	 * @exception
	 * @since 1.0.0
	 */
	public List<Permissions> finds(TzParams params);

	/**
	 * 
	 * com.jgz.service.permissions 方法名：findPermissions
	 * 
	 * @param params
	 * @return 返回类型：Permissions
	 * @exception
	 * @since 1.0.0
	 */
	public Permissions find(TzParams params);

	/**
	 * 保存 com.jgz.service.permissions 方法名：save
	 * 
	 * @param permissions
	 * @return 返回类型：int
	 * @exception
	 * @since 1.0.0
	 */
	public String saveAll(Permissions permissions,String name) throws Exception;

	/**
	 * 更新 com.jgz.service.permissions 方法名：update
	 * 
	 * @param permissions
	 * @return 返回类型：int
	 * @exception
	 * @since 1.0.0
	 */
	public int update(Permissions permissions);

	/**
	 * 删除 com.jgz.service.permissions 方法名：delete
	 * 
	 * @param params
	 * @return 返回类型：int
	 * @exception
	 * @since 1.0.0
	 */
	public int delete(Long id);

	/**
	 * 
	 * 根据用户名分页查询对应上级节点名称<br/>
	 * com.jgz.service.permissions <br/>
	 * 方法名：findRoles<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年3月20日-上午9:35:25 <br/>
	 * 
	 * @param params
	 * @return 返回类型List<Permissions><br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public List<Permissions> findPermissionss(TzParams params);
}
