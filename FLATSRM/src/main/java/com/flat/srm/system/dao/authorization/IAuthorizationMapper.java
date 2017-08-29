package com.flat.srm.system.dao.authorization;

import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.system.bean.Authorization;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IAuthorizationMapper {

	/**
	 * 查询 com.jgz.dao.authorization 方法名：findPermissionss
	 * 
	 * @param params
	 * @return 返回类型：List<Permissions>
	 * @exception
	 * @since 1.0.0
	 */
	public List<Authorization> findAll(TzParams params);

	/**
	 * 查询 com.jgz.dao.authorization 方法名：findPermissionss
	 * 
	 * @param params
	 * @return 返回类型：List<Permissions>
	 * @exception
	 * @since 1.0.0
	 */
	public List<Authorization> finds(TzParams params);

	/**
	 * 获取对象 com.jgz.dao.authorization 方法名：getPermissions
	 * 
	 * @param id
	 * @return 返回类型：Permissions
	 * @exception
	 * @since 1.0.0
	 */
	public Authorization find(Long id);

	/**
	 * 添加 com.jgz.dao.authorization 方法名：save
	 * 
	 * @param permissions
	 * @return 返回类型：int
	 * @exception
	 * @since 1.0.0
	 */
	public Integer save(TzParams params);

	/**
	 * 修改 com.jgz.dao.authorization 方法名：update
	 * 
	 * @param permissions
	 * @return 返回类型：int
	 * @exception
	 * @since 1.0.0
	 */
	public int update(Authorization authorization);

	/**
	 * 删除 com.jgz.dao.authorization 方法名：delete
	 * 
	 * @param params
	 * @return 返回类型：int
	 * @exception
	 * @since 1.0.0
	 */
	public int delete(Long id);

}
