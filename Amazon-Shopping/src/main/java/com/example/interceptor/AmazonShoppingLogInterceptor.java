package com.example.interceptor;

import java.util.UUID;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AmazonShoppingLogInterceptor implements HandlerInterceptor {


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		UUID transactionId = UUID.randomUUID();
		MDC.put("transactionId",transactionId.toString());
		request.setAttribute("transactionId", transactionId.toString());
		response.setHeader("transactionId", transactionId.toString());
		log.info("Setting transactionId in MDC: {}",transactionId);
		return true;
	}
}
