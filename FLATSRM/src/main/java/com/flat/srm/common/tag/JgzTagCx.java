package com.flat.srm.common.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

public class JgzTagCx extends BodyTagSupport {
	private int conent = 3;

	public void setConent(int conent) {
		this.conent = conent;
	}

	@Override
	public int doAfterBody() throws JspException {
		if (conent > 1) {
			try {
				// 获取标签体中的内容
				String string = this.getBodyContent().getString();
				// 定义输出流
				JspWriter out = this.getPreviousOut();
				// 输出到页面中
				out.println(string.toUpperCase());
				System.out.println(string.toUpperCase());
				conent--;
				// 清除标签缓存
				bodyContent.clearBuffer();
			} catch (IOException e) {

				e.printStackTrace();
			}
			return EVAL_BODY_AGAIN;
		} else {
			return SKIP_BODY;
		}

	}

	@Override
	public void release() {

		super.release();
	}

}
