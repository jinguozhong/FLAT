package com.flat.srm.dictionary.dao.supplier;

import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.dictionary.bean.Supplier;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ISupplierMapper {
	/**
	 * 
	 * 供应商注册保持<br/>
	 * com.flat.srm.dictionary.dao.supplier <br/>
	 * 方法名：save<br/>
	 * 创建人：JGZ <br/>
	 * 时间：2017年7月21日-下午3:16:09 <br/>
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
	 * @return  List<Supplier>
	 * @throws 
	 * @sice v1.0
	 * @author jingu qq 274492196
	 * 2017/8/21
	*/
	public List<Supplier> find(TzParams params);
 	/**
 	 *ISupplierMapper方法的功能描述
	 *
 	 * @paam params
 	 * @return Integer
 	 * @throws
 	 * @sice v1.0
 	 * @author jingu qq 274492196
 	 * 2017/8/24
 	*/
	public  Integer findTotal(TzParams params);
}
