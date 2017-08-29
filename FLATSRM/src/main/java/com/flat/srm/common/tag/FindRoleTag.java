package com.flat.srm.common.tag;

import com.flat.srm.common.publicBean.TzParams;
import com.flat.srm.system.bean.Role;
import com.flat.srm.system.service.role.IRoleService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

public class FindRoleTag extends BodyTagSupport{
	
	
	private Long roleId;   
	
	@Override
	public int doAfterBody() throws JspException {
		// 获取应用上下文
		ServletContext context = this.pageContext.getServletContext();
		// 获取sprignweb容器的应用上下文，因为在web容器启动的时候，容器会将spring的applicationContext注入到一个叫application的上下文中
		WebApplicationContext ctx = WebApplicationContextUtils
				.getRequiredWebApplicationContext(context);
		// 从webapplicationContext获取对应的对象 
		IRoleService roleService = (IRoleService) ctx .getBean("roleServiceImpl");
		TzParams params=new TzParams();
		params.setId(roleId);
		Role role=roleService.find(params);
		JspWriter jspWriter = this.getPreviousOut();
		try {
			jspWriter.print(role.getName());
		} catch (IOException e) { 
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	

	@Override
	public void release() { 
		super.release();
	}


	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	
	
}
