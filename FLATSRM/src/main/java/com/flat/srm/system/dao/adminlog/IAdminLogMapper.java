package com.flat.srm.system.dao.adminlog;

import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.system.bean.AdminLog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
@Repository
public interface IAdminLogMapper {

	/**
	 * 查询 com.jgz.dao.adminlog 方法名：findAdminLogs
	 * 
	 * @param params
	 * @return 返回类型：List<AdminLog>
	 * @exception
	 * @since 1.0.0
	 */
	public List<AdminLog> finds(TzParams params);

	/**
	 * 获取对象 com.jgz.dao.adminlog 方法名：getAdminLog
	 * 
	 * @param id
	 * @return 返回类型：AdminLog
	 * @exception
	 * @since 1.0.0
	 */
	public AdminLog get(Integer id);

	/**
	 * 添加 com.jgz.dao.adminlog 方法名：save
	 * 
	 * @param adminlog
	 * @return 返回类型：int
	 * @exception
	 * @since 1.0.0
	 */
	public Integer save(AdminLog adminlog);

	/**
	 * 修改 com.jgz.dao.adminlog 方法名：update
	 * 
	 * @param adminlog
	 * @return 返回类型：int
	 * @exception
	 * @since 1.0.0
	 */
	public int update(AdminLog adminlog);

	/**
	 * 删除 com.jgz.dao.adminlog 方法名：delete
	 * 
	 * @param params
	 * @return 返回类型：int
	 * @exception
	 * @since 1.0.0
	 */
	public int delete(TzParams params);

	/**
	 * 
	 * 查询总数<br/>
	 * com.jgz.dao.adminlog <br/>
	 * 方法名：count<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2016年6月24日-下午12:59:09 <br/>
	 * 
	 * @param params
	 * @return 返回类型Integer<br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public int count(TzParams params);

	/**
	 * 
	 * 查询br/> com.jgz.dao.adminlog <br/>
	 * 方法名：findMaps<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2016年6月27日-下午3:40:21 <br/>
	 * 
	 * @param params
	 * @return 返回类型List<HashMap<String,Object>><br/>
	 * @exception <br/>
	 * @since 1.0.0<br/>
	 */
	public List<HashMap<String, Object>> findMaps(TzParams params);

}
