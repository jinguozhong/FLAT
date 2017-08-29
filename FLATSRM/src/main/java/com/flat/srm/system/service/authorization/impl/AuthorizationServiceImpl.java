package com.flat.srm.system.service.authorization.impl;

import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.system.bean.Authorization;
import com.flat.srm.system.dao.authorization.IAuthorizationMapper;
import com.flat.srm.system.service.authorization.IAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthorizationServiceImpl implements IAuthorizationService {

	@Autowired
	private IAuthorizationMapper authorizationMapper;

	@Override
	public List<Authorization> findAll(TzParams params) {

		return authorizationMapper.findAll(params);
	}

	@Override
	public Authorization find(Long id) {
		return authorizationMapper.find(id);
	}

	@Override
	public String save(TzParams params) throws Exception {
		String ret = "";
		if (params.getId() == null || params.getListString().size() <= 0) {
			ret = "null";
		} else {
			// 删除选中角色对应所有的权限内容
			authorizationMapper.delete(params.getId());
			// 查询插入权限数据
			int saveI = authorizationMapper.save(params);
			if (saveI != 0) {
				ret = "ok";
			}
		}
		;
		return ret;
	}

	@Override
	public int update(Authorization authorization) {
		return authorizationMapper.update(authorization);
	}

	@Override
	public int delete(Long id) {
		return authorizationMapper.delete(id);
	}

	@Override
	public Map<String, Object> findMap(Long id) {
		// 定义map对象
		Map<String, Object> hashMap = new HashMap<String, Object>();
		// 定义参数对象
		TzParams params = new TzParams();
		// 查询所有的权限数据
		List<Authorization> listAll = authorizationMapper.findAll(params);
		// 将所有的权限数据放进map中
		hashMap.put("lisauthorizationAll", listAll);
		// 给id赋值
		params.setId(id);
		// 查询选中角色的权限数据
		List<Authorization> lists = authorizationMapper.finds(params);
		// 放进map中
		hashMap.put("lisauthorization", lists);
		// 返回
		return hashMap;
	}

	@Override
	public List<Authorization> finds(TzParams params) {

		return authorizationMapper.finds(params);
	}
}
