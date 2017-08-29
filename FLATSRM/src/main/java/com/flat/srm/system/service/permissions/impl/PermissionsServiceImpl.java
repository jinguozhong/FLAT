package com.flat.srm.system.service.permissions.impl;

import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.system.bean.Permissions;
import com.flat.srm.system.dao.permissions.IPermissionsMapper;
import com.flat.srm.system.service.permissions.IPermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PermissionsServiceImpl implements IPermissionsService {

	@Autowired
	private IPermissionsMapper permissionsMapper;

	@Override
	public List<Permissions> finds(TzParams params) {
		return permissionsMapper.finds(params);
	}

	@Override
	public Permissions find(TzParams params) {
		return permissionsMapper.find(params);
	}

	@Override
	public String saveAll(Permissions permissions,String name) throws Exception {
		String results = null;
		if (permissions.getId() != null) {// 修改保存
			permissions.setUpdateBy(name);
			permissions.setUpdateTime(new Date());
			Integer integer = permissionsMapper.update(permissions);
			permissionsMapper.pNodeUpdate(permissions);
			results = integer != 0 ? "modifySuccess" : "Null";
		} else {
			permissions.setNewBy(name);
			Integer keyId = permissionsMapper.save(permissions);
			permissionsMapper.pNodeUpdate(permissions);
			results = keyId != 0 ? "SaveSuccess?" + permissions.getId()
					: "Null";
		}

		return results;
	}

	@Override
	public int update(Permissions permissions) {
		return permissionsMapper.update(permissions);
	}

	@Override
	public int delete(Long id) {
		return permissionsMapper.delete(id);
	}

	@Override
	public List<Permissions> findPermissionss(TzParams params) {

		return permissionsMapper.findPermissionss(params);
	}
}
