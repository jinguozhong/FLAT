package com.flat.srm.system.service.user.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.common.util.TmStringUtils;
import com.flat.srm.system.bean.Role;
import com.flat.srm.system.bean.User;
import com.flat.srm.system.dao.user.IUserMapper;
import com.flat.srm.system.service.user.IUserService;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserMapper userMapper;
	@Autowired
	private SessionDAO sessionDAO;

	/**
	 * 登入查询方法
	 */
	/*
	 * @Override public User getLogin(TzParams params) {
	 * 
	 * return userMapper.getLogin(params); }
	 */
	@Override
	public User getLogin(String username) {
		return userMapper.getLogin(username);
	}

 
	 

	@Override
	public int update(User user) {

		return userMapper.update(user);
	}

	@Override
	public List<User> findUsers(TzParams params) {
		return userMapper.findUsers(params);
	}

	@Override
	public int deleteAll(Long id) throws Exception {
		Integer i = userMapper.delete(id); 
		userMapper.u_rDelete(id); 
		return i;
	}

	@Override
	public List<HashMap<String, Object>> userRoles(Long id) {

		return userMapper.userRoles(id);
	}

	@Override
	public Integer pNodeUpdate(String isParent, Long pId) {

		return userMapper.pNodeUpdate(isParent, pId);
	}

	 
	@Override
	public Integer u_rDelete(Long uId) {

		return userMapper.u_rDelete(uId);
	}

	@Override
	public int save(User user) {
		return userMapper.save(user);
	}

	 

	@Override
	public Integer updeletePass(User user) {
		if(TmStringUtils.isEmpty(user.getPassword())){
			user.setPassword("sb" + TmStringUtils.md5Base64("holle123")); 
		}
		return userMapper.updeletePass(user);
	}

	 
	@Override
	public Boolean kickedOutUser(String sessionId) {
		Session session = sessionDAO.readSession(sessionId);
		// session.setTimeout(0);
		// session.stop();
		sessionDAO.delete(session);
		return true;
	}

	@Override
	public Map<String, Object> findRegisteredUsers(TzParams params) {
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
		Map<String, Object> map = new HashMap<String, Object>();
		List<User> users = userMapper.findRegisteredUsers(params);// 查询数据
		double records = userMapper.findRegisteredUserTotal(params);// 查询总数据
		Double total = ((double) records / (double) rows);
		// 返回jqgrid 分页的数据格式
		map.put("rows", users);// 表格数据
		map.put("page", params.getPage());// 当前页数
		map.put("total", Math.ceil(total));// 总页数
		map.put("records", records);// 总条数
		return map;
	}

	@Override
	public String saveToAuditUser(User user) {

		String results = "";
		Integer integer = userMapper.update(user);
		if (integer > 0) {
			results = "success";
		} else {
			results = "file";
		}
		return results;
	}

	@Override
	public String saveAll(String datas, String name) throws Exception {
		JSONObject jsonObject = JSON.parseObject(datas);
		String results = "userNull";
		if (TmStringUtils.isNotEmpty(datas) && jsonObject != null) {
			// 获取用户信息
			User user = JSON.parseObject(jsonObject.getString("basicFrom"), User.class);
			// 获取用户对应的角色信息列表
			JSONArray roleDatas = JSONArray.parseArray(jsonObject.getString("roleDatas"));

			List<Role> roles = null;
			if (user != null && user.getId() != null) {// 修改还保存进入
				if (user.getpId() == null) {
					user.setpId((long) -1);
				}
				user.setUpdateBy(name);
				user.setUpdateTime(new Date());
				int flat = userMapper.pNodeUpdate("true", user.getpId());
				int updateI = userMapper.update(user);
				roles = JSON.parseArray(roleDatas.toJSONString(), Role.class);
				userMapper.u_rDelete(user.getId());// 删将用户对应的角色表的数据清空再执行插入操作 
				if (roles.size() != 0) {
					userMapper.u_rSave(user.getId(), roles);
				}
				if (flat != 0 || updateI != 0) {
					results = "modifySuccess";
				} else {
					results = "modifyFail";
				}
			} else if (user.getId() == null) {// 新增保存进入
				if (user != null) {
					user.setNewBy(name);
					int uSave = userMapper.save(user);
					TzParams params = new TzParams();
					params.setCode(user.getCode());
					if (roleDatas != null && roleDatas.size() > 0) {
						roles = JSON.parseArray(roleDatas.toJSONString(), Role.class);
						int saveI = userMapper.u_rSave(user.getId(), roles);
						results = (uSave != 0 && saveI != 0) ? "SaveSuccess?" + user.getId() : "userNull";
					}
					results = (uSave != 0) ? "SaveSuccess?" + user.getId() : "userNull";
				}
			}

		}
		return results;
	}
 
	@Override
	public User findUser(TzParams params) {
		 
		return userMapper.findUser(params);
	}
 
	@Override
	public List<User> findUserDictionary(TzParams params) { 
		return userMapper.getUsers(params);
	}
 
}
