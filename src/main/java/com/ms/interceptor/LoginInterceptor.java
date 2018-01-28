package com.ms.interceptor;

import com.ms.dto.UserDTO;
import com.ms.util.SessionUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", Long.valueOf(startTime));
		UserDTO userDTO = SessionUtil.getUser();
		if (userDTO == null) {
			logger.info("Session expired. Redirecting to login page");
			response.sendRedirect("login.do");
			return false;
		} else {
			return true;
		}
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String pageName = SessionUtil.getPage();
		if (pageName != null) {
			modelAndView.getModel().put("page", pageName);
			SessionUtil.getSession().removeAttribute("page");
		}

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}