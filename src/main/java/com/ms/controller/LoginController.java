package com.ms.controller;

import com.ms.bean.Login;
import com.ms.dto.UserDTO;
import com.ms.entity.User;
import com.ms.service.LoginService;
import com.ms.util.MSException;
import com.ms.util.SessionUtil;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Scope("request")
public class LoginController {
	@Autowired
	private LoginService loginService;

	@RequestMapping(value = {"/login"}, method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loginPage(@ModelAttribute("login") @Validated Login login, BindingResult bindingResult,
			Model model, HttpServletRequest request) {
		if (request.getMethod().equalsIgnoreCase(RequestMethod.GET.name())) {
			login = new Login();
			System.out.println();
			return new ModelAndView("login", "login", login);
		} else {
			try {
				User e = this.loginService.authenticate(login);
				if (e != null) {
					UserDTO userDTO = new UserDTO(e);
					SessionUtil.setUser(userDTO);
					SessionUtil.setCurrentSchoolSesseion(Byte.valueOf((byte) 1));
					return new ModelAndView("redirect:/dashboard.do");
				}

				model.addAttribute("message", "Incorrect Email/Password");
			} catch (MSException arg6) {
				arg6.printStackTrace();
				model.addAttribute("message", "Error Occured");
			}

			return new ModelAndView("login", "login", login);
		}
	}

	@RequestMapping(value = {"/dashboard"}, method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView dashboardPage(@ModelAttribute("login") @Validated Login login, BindingResult bindingResult,
			Model model, HttpServletRequest request) {
		SessionUtil.setPage("Dashboard");
		return new ModelAndView("dashboard");
	}

	@RequestMapping(value = {"/logout"}, method = {RequestMethod.GET})
	public ModelAndView logout(HttpServletRequest request, RedirectAttributes attributes) throws Exception {
		request.getSession().invalidate();
		attributes.addFlashAttribute("message", "You have logged out!");
		return new ModelAndView("redirect:/login.do");
	}
}