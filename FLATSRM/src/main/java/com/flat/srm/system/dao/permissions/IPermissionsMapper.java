package com.flat.srm.system.dao.permissions;

import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.system.bean.Permissions;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IPermissionsMapper {

	/**
	 * 查询 com.jgz.dao.permissions 方法名：findPermissionss
	 * 
	 * @param params
	 * @return 返回类型：List<Permissions>
	 * @exception
	 * @since 1.0.0
	 */
	public List<Permissions> finds(TzParams params);

	/**
	 * 获取对象 com.jgz.dao.permissions 方法名：getPermissions
	 * 
	 * @param
	 * @return 返回类型：Permissions
	 * @exception
	 * @since 1.0.0
	 */
	public Permissions find(TzParams params);

	/**
	 * 添加 com.jgz.dao.permissions 方法名：save
	 * 
	 * @param permissions
	 * @return 返回类型：int
	 * @exception
	 * @since 1.0.0
	 */
	public int save(Permissions permissions);

	/**
	 * 修改 com.jgz.dao.permissions 方法名：update
	 * 
	 * @param permissions
	 * @return 返回类型：int
	 * @exception
	 * @since 1.0.0
	 */
	public int update(Permissions permissions);

	/**
	 * 删除 com.jgz.dao.permissions 方法名：delete
	 * 
	 * @param
	 * @return 返回类型：int
	 * @exception
	 * @since 1.0.0
	 */
	public int delete(Long id);

	/**
	 * 
	 * 保存时将对应的父节点的状态进行修改<br/>
	 * com.jgz.dao.permissions <br/>
	 * 方法名：pNodeUpdate<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年3月18日-上午10:50:41 <br/>
	 * 
	 *
	 * @return 返回类型Integer<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public Integer pNodeUpdate(Permissions permissions);

	/**
	 * 
	 * * 根据用户名分页查询对应上级节点名称<br/>
	 * 
	 * com.jgz.dao.permissions <br/>
	 * 方法名：findPermissionss<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年3月20日-上午9:33:05 <br/>
	 * 
	 * @param params
	 * @return 返回类型List<Permissions><br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public List<Permissions> findPermissionss(TzParams params);

}
