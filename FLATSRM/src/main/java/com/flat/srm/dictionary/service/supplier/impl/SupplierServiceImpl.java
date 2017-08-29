package com.flat.srm.dictionary.service.supplier.impl;

import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.dictionary.bean.Supplier;
import com.flat.srm.dictionary.dao.supplier.ISupplierMapper;
import com.flat.srm.dictionary.service.supplier.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SupplierServiceImpl implements ISupplierService {

	@Autowired
	private ISupplierMapper supplierMapper;
	
	/**
	 * 供应商注册保存<br/>
	 */
	@Override
	public Long save(Supplier supplier) {

		Long id=supplierMapper.save(supplier);
		return id;
	}
 
	@Override
	public Map<String,Object> find(TzParams params) {
	 	/**
	 	 *SupplierServiceImpl方法find的功能描述
		 * 供应商信息分页查询
	 	 * @paam [params]
	 	 * @return java.util.Map<java.lang.String,java.lang.Object>
	 	 * @throws
	 	 * @sice v1.0
	 	 * @author jingu qq 274492196
	 	 * 2017/8/24
	 	*/
		Integer page = params.getPage();// 页数
		Integer rows = params.getRows();// 每页显示行数
		if (page == 1) {// 判断是否是第一页
			page = page - 1;
		}
		if (page > 1) {// 判断是否翻页
			page = rows * (page - 1);
		}
		params.setPageNo(page);// 赋值
		params.setPageSize(rows);// 赋值

		Map<String,Object> map=new HashMap<String,Object>();
		List<Supplier> listSuppliers=supplierMapper.find(params);
		Integer records = supplierMapper.findTotal(params);// 查询总数据
		Double total = ((double) records / (double) rows);
		// 返回jqgrid 分页的数据格式
		map.put("rows", listSuppliers);// 表格数据
		map.put("page", params.getPage());// 当前页数
		map.put("total", Math.ceil(total));// 总页数
		map.put("records", records);// 总条数
		return map;
	}
}
