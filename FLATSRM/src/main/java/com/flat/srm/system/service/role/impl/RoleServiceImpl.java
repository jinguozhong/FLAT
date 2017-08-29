package com.flat.srm.system.service.role.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.common.util.TmStringUtils;
import com.flat.srm.system.bean.Role;
import com.flat.srm.system.bean.User;
import com.flat.srm.system.dao.authorization.IAuthorizationMapper;
import com.flat.srm.system.dao.role.IRoleMapper;
import com.flat.srm.system.service.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleMapper roleMapper;
	@Autowired
	private IAuthorizationMapper authorizationMapper;

	@Override
	public List<Role> finds(TzParams params) {

		return roleMapper.finds(params);
	}

	@Override
	public Role find(TzParams params) {
		return roleMapper.find(params);
	}

	@Override
	public int save(Role role) {
		return roleMapper.save(role);
	}

	@Override
	public int update(Role role) {
		return roleMapper.update(role);
	}

	@Override
	public List<Role> findRoles(TzParams params) {

		return roleMapper.findRoles(params);
	}

	@Override
	public List<HashMap<String, Object>> findRoleUsers(Long integer) {

		return roleMapper.findRoleUsers(integer);
	}

	@Override
	public String saveAll(String datas, String name) throws Exception {
		JSONObject jsonObject = JSON.parseObject(datas);
		String results = "Null";
		if (TmStringUtils.isNotEmpty(datas) && jsonObject != null) {
			// 获取用户信息
			Role role = JSON.parseObject(jsonObject.getString("basicFrom"), Role.class);

			// 获取用户对应的角色信息列表
			JSONArray roleDatas = JSONArray.parseArray(jsonObject.getString("userDatas"));

			List<User> users = null;
			if (role != null && role.getId() != null) {// 修改还保存进入
				if (role.getpId() == null) {
					role.setpId((long) -1);
				}
				role.setUpdateBy(name);
				role.setUpdateTime(new Date());
				int flat = roleMapper.pNodeUpdate("true", role.getpId());
				int updateI = roleMapper.update(role);
				users = JSON.parseArray(roleDatas.toJSONString(), User.class);
				roleMapper.formDelete(role.getId());// 删将用户对应的角色表的数据清空再执行插入操作
				if(users.size()!=0){ 
					roleMapper.formSave(role.getId(), users);
				}
				if (flat != 0 || updateI != 0) {
					results = "modifySuccess";
				} else {
					results = "modifyFail";
				}
			} else if (role.getId() == null) {// 新增保存进入
				if (role != null) {
					role.setNewBy(name);
					int saveI = roleMapper.save(role);
					TzParams params = new TzParams();
					params.setCode(role.getCode());
					if (roleDatas != null && roleDatas.size() > 0) {
						users = JSON.parseArray(roleDatas.toJSONString(), User.class);
						int saveII = roleMapper.formSave(role.getId(), users);
						results = (saveI != 0 && saveII != 0) ? "SaveSuccess?" + role.getId() : "Null";
					}

					results = (saveI != 0) ? "SaveSuccess?" + role.getId() : "Null";
				}
			}

		}
		return results;

	}

	@Override
	public int deleteAll(Long rid) throws Exception {
		Integer i = roleMapper.delete(rid);
		roleMapper.formDelete(rid);
		authorizationMapper.delete(rid);// 删除角色对应的授权内容
		return i;
	}

	@Override
	public List<Role> findLodinRoles(TzParams params) {

		return roleMapper.findLodinRoles(params);
	}
}
