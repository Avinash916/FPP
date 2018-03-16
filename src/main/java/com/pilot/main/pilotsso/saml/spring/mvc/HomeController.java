package com.pilot.main.pilotsso.saml.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.pilot.main.pilotsso.saml.spring.security.SAMLUserDetails;

@Controller
public class HomeController {

	@RequestMapping("/home1")
	public ModelAndView home(@SAMLUser SAMLUserDetails user) {
		ModelAndView homeView = new ModelAndView("home");
		homeView.addObject("userId", user.getUsername());
		homeView.addObject("samlAttributes", user.getAttributes());
		return homeView;

	}

	@RequestMapping("/home")
	public RedirectView pfjOverview(@SAMLUser SAMLUserDetails user) {
		RedirectView redirectView = new RedirectView("http://fuel-pricing-platform-dev.herokuapp.com/");
		// redirectView.addObject("userId", user.getUsername());
		// redirectView.addObject("samlAttributes", user.getAttributes());
		return redirectView;
	}
}