package com.angeljava.springboot.form.app.interceptors;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("ElapsedTimeInterceptor")
public class ElapsedTimeInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(ElapsedTimeInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		if (request.getMethod().equalsIgnoreCase("post")) {
			return true;
		}

		if (handler instanceof HandlerMethod) {
			HandlerMethod method = (HandlerMethod) handler;
			logger.info("This is a controller method: " + method.getMethod().getName());
		}
		logger.info("ElapsedTimeInterceptor: preHandle() entrando...");
		logger.info("Intercepting: " + handler);
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);

		Random random = new Random();
		Integer milliseconds = random.nextInt(500);
		Thread.sleep(milliseconds);

		//response.sendRedirect(request.getContextPath().concat("/login"));
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (request.getMethod().equalsIgnoreCase("post")) {
			return;
		}
		long endTime = System.currentTimeMillis();
		long startTime = (Long) request.getAttribute("startTime");
		long elapsedTime = endTime - startTime;
		if (handler instanceof HandlerMethod && modelAndView != null) {
			modelAndView.addObject("elapsedTime", elapsedTime);
		}
		logger.info("Elapsed time: " + elapsedTime + " milliseconds.");
		logger.info("ElapsedTimeInterceptor: postHandle saliendo...");
	}

}
