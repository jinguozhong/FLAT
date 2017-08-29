package com.flat.srm.dictionary.service.supplier;

import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.dictionary.bean.Supplier;

import java.util.List;
import java.util.Map;

public interface ISupplierService {

	/**
	 * 
	 * 供应商注册保存<br/>
	 * com.flat.srm.dictionary.service.supplier <br/>
	 * 方法名：save<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年7月21日-下午4:21:14 <br/>
	 * @param supplier
	 * @return 
	 * 返回类型Long<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public Long save(Supplier supplier);


	/**
	 *ISupplierMapper方法的功能描述
	 * 供应商查询
	 * @paam  params
	 * @return
	 * @throws
	 * @sice v1.0
	 * @author jingu qq 274492196
	 * 2017/8/21
	 */
	public Map<String,Object> find(TzParams params);


}
