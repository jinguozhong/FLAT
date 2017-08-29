package com.flat.srm.common.tag;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

/**
 * 
 * 
 * TextTag标签测试类<br/>
 * 创建人:JGZ<br/>
 * 时间：2016年9月30日-下午2:06:19 <br/>
 * 
 * @version 1.0.0<br/>
 *
 */
public class TextTag extends BodyTagSupport {
	private String var;

	@Override
	public int doStartTag() throws JspException {
		System.out.println("=================进入了doStartTag");
		ServletContext servletContext = this.pageContext.getServletContext();

		System.out.println("++++++++++servletContext" + servletContext);
		JspWriter jspWriter = this.pageContext.getOut();
		try {
			jspWriter.print("=======-----");
			pageContext.setAttribute("aa", var);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_BODY_BUFFERED;
	}

	@Override
	public int doAfterBody() throws JspException {
		System.out.println("=================进入了doAfterBody");
		String neirString = getBodyContent().getString();
		System.out.println("==========" + neirString);
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		System.out.println("=================进入了doEndTag");
		return EVAL_PAGE;
	}

	public void setVar(String var) {
		this.var = var;
	}

}
