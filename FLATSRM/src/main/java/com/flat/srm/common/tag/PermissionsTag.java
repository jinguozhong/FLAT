package com.flat.srm.common.tag;

import com.flat.srm.common.util.JgzConstant;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class PermissionsTag extends BodyTagSupport {
	private String keyId;
	private List<HashMap<String, Object>> listDate;

	@Override
	public void doInitBody() throws JspException {
		System.out.println("PermissionsTag类中的=============doInitBody方法");
		listDate = (List<HashMap<String, Object>>) this.pageContext
				.getSession().getAttribute(JgzConstant.SESSION_USER_ROLES);
	}

	@Override
	public int doAfterBody() throws JspException {
		try {
			String string = this.getBodyContent().getString();// 获取标签体的内容
			JspWriter jspWriter = this.getPreviousOut();
			if (getPermissions()) {
				jspWriter.print(string);// 前天页面输出

			} else {
				jspWriter.print("");
			}
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {

		return EVAL_PAGE;
	}

	@Override
	public void release() {

		super.release();
	}

	/**
	 * 判断是否有权限
	 */
	public boolean getPermissions() {
		boolean mark = false;
		if (listDate != null && listDate.size() > 0) {
			for (HashMap<String, Object> hashMap : listDate) {
				String key = String.valueOf(hashMap.get("keyId"));
				if (key.equalsIgnoreCase(keyId)) {
					mark = true;
					break;
				}
			}

		}
		return mark;

	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

}
