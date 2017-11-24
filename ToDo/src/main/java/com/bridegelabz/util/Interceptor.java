package com.bridegelabz.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.bridgelabz.model.User;

public class Interceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("Interceptor called");
		
		String jwtToken = request.getHeader("token");
	
		int userId = VerifyJwt.verify(jwtToken);
	
		System.out.println("User id="+userId);
		
		if(userId == 0)
			return false;
		
		User user = new User();
		user.setId(userId);
		request.setAttribute("loggedInUser", user);
		return true;

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	
	}

}
