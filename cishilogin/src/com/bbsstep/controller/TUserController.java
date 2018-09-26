package com.bbsstep.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bbsstep.po.TUser;
import com.bbsstep.service.TUserService;
import com.google.code.kaptcha.Constants;

@Controller
@RequestMapping(value="/tusercontroller")
public class TUserController {
	@Autowired
	private TUserService service;
	
	
	// 有一个登陆校验的方法：如果验证通过，将跳转至到系统首页，如果验证不通过，跳转到登陆页面
	
	@RequestMapping(method=RequestMethod.POST,value="/checklogin" )
	public ModelAndView checkLogin(String username,String password,String imageContent,HttpSession session) {
		TUser user = null;
		ModelAndView mv= new ModelAndView();
		String msg=null;
		//A、比对验证码是否正确
		//得到原始的验证码
		String origContent =(String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		//B 验证码正确的情况下 去比对用户名和密码
		if(origContent.equalsIgnoreCase(imageContent)) {
			try {
				user=service.checkUser(password, username);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(null ==user) {//用户名或密码不对
				
				mv.setViewName("redirect:/login.jsp?msg=1");
				
			}else {//用户名或密码正确
				
				session.setAttribute("loginUser", user);
				mv.setViewName("redirect:/pages/home/index.jsp");
			}
		}else {
			//验证码不正确
			mv.setViewName("redirect:/login.jsp?msg=0");
		}
		return mv;
	}
	
	

}
