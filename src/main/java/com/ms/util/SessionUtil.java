package com.ms.util;

import com.ms.dto.DiscountDTO;
import com.ms.dto.UserDTO;
import java.io.File;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SessionUtil {
	HttpSession session;
	private static final String usrDTO = "userDTO";
	private static final String msg = "validationmessage";
	private static final String page = "";
	private static final String pageUrl = "url";
	private static String deploymentPath = null;
	private static Byte currentSchoolSesseion;
	private static Map<Integer, DiscountDTO> discountMap;

	public static HttpSession getSession() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		attr.getRequest().getServletPath();
		if (deploymentPath == null) {
			setDeploymentPath(getServerDeploymentPath(attr.getRequest()));
		}

		return attr.getRequest().getSession(true);
	}

	public static String getServerDeploymentPath(HttpServletRequest httpServletRequest) {
		File fl = new File(httpServletRequest.getRealPath(File.separator));
		return fl.getParent();
	}

	public static void setUser(UserDTO userDTO) {
		getSession().setAttribute("userDTO", userDTO);
	}

	public static UserDTO getUser() {
		return (UserDTO) getSession().getAttribute("userDTO");
	}

	public static void setMessage(String message) {
		getSession().setAttribute("validationmessage", message);
	}

	public static void removeMessage() {
		getSession().removeAttribute("validationmessage");
	}

	public static String getMessage() {
		return (String) getSession().getAttribute("validationmessage");
	}

	public static void setUrl(String url) {
		getSession().setAttribute("url", url);
	}

	public static String getUrl() {
		return (String) getSession().getAttribute("url");
	}

	public static String getDeploymentPath() {
		return deploymentPath;
	}

	public static void setDeploymentPath(String deploymentPath) {
		SessionUtil.deploymentPath = deploymentPath;
	}

	public static void setUserDataMap(String userId, Map<String, Object> userDataMap) {
		getSession().setAttribute(userId, userDataMap);
	}

	public static Map<String, Object> getUserDataMap(String userId) {
		return (Map) getSession().getAttribute(userId);
	}

	public static void setClientMap(String userId, Map<Integer, String> clientMap) {
		getSession().setAttribute(userId + "_clientMap", clientMap);
	}

	public static Map<Integer, String> getClientMap(String userId) {
		return (Map) getSession().getAttribute(userId + "_clientMap");
	}

	public static void setPage(String page) {
		getSession().setAttribute("page", page);
	}

	public static String getPage() {
		return (String) getSession().getAttribute("");
	}

	private static ServletContext getServletContext() {
		return getSession().getServletContext();
	}

	public static Byte getCurrentSchoolSesseion() {
		return (Byte) getServletContext().getAttribute("cs");
	}

	public static void setCurrentSchoolSesseion(Byte currentSchoolSesseion) {
		getServletContext().setAttribute("cs", currentSchoolSesseion);
	}

	public static Map<Integer, DiscountDTO> getDiscountMap() {
		return (Map) getServletContext().getAttribute("dmap");
	}

	public static void setDiscountMap(Map<Integer, DiscountDTO> discountMap) {
		getServletContext().setAttribute("dmap", discountMap);
	}
}