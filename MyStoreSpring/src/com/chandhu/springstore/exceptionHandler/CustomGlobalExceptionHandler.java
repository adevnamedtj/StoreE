package com.chandhu.springstore.exceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
//@Component
public class CustomGlobalExceptionHandler implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) {
		

		ModelAndView x=new ModelAndView();
		x.addObject("exception", exception);
		x.addObject("url", request.getRequestURI());
		x.setViewName("error");
		return x;
	}

}
