package kr.co.meerkat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
public class MainController extends MultiActionController{

	public ModelAndView main(HttpServletRequest request,HttpServletResponse response){
		return new ModelAndView("View/main");
	}

}
