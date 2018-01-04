package com.wqp.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import com.opensymphony.xwork2.ActionInvocation;

import cn.dsna.util.images.ValidateCode;

public class CAPTCHAResult extends StrutsResultSupport {

	// 通过配置文件，调整生成图片的大小
	private int width = 1000;
	private int height = 200;
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}

	// Servlet的中原来怎么写，现在还怎么写
	protected void doExecute(String finalLocation, ActionInvocation invocation) throws Exception {
		/*
		 * 使用第三方生成验证码的jar包 1.拷贝ValidateCode.jar到工程lib目录 2.创建ValidateCode的对象
		 * 3.获取响应对象输出流 4.输出到浏览器
		 */
		// 创建ValidateCode的对象
		// 参数详解：1:图像宽度 2.图像高度 3.数字的格式 4.干扰线条数
		ValidateCode code = new ValidateCode(width, height, 4, 10);
		// 获取响应对象
		HttpServletResponse response = ServletActionContext.getResponse();
		// 输出到浏览器
		code.write(response.getOutputStream());
	}
}
