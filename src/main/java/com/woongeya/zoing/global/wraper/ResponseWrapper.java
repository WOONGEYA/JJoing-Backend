package com.woongeya.zoing.global.wraper;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.woongeya.zoing.global.exception.ErrorResponse;
import com.woongeya.zoing.global.wraper.response.CommonResponse;

@RestControllerAdvice
public class ResponseWrapper implements ResponseBodyAdvice<Object> {

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body,
		MethodParameter returnType,
		MediaType selectedContentType,
		Class<? extends HttpMessageConverter<?>> selectedConverterType,
		ServerHttpRequest request,
		ServerHttpResponse response
	) {
		if (body instanceof ErrorResponse errorResponse) {
			response.setStatusCode(errorResponse.status());
			return CommonResponse.error(errorResponse.status(), errorResponse.message());
		}

		return CommonResponse.success(HttpStatus.OK, body);
	}
}
