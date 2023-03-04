package sn.groupeisi.findjob.config.logging;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import sn.groupeisi.findjob.service.ILoggingService;


/**
 * @Author : DAOUDA BORY Yacouba Software Engineer
 * @Project : object-model
 * @Package : sn.finapps.guce.logging
 * @Date : 11/06/2020
 * @Time : 14:23
 */
@ControllerAdvice
@AllArgsConstructor
public class CustomResponseBodyAdviceAdapter implements ResponseBodyAdvice<Object> {

    private ILoggingService loggingService;

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        if (serverHttpRequest instanceof ServletServerHttpRequest && serverHttpResponse instanceof ServletServerHttpResponse) {
            loggingService.logResponse(((ServletServerHttpRequest) serverHttpRequest).getServletRequest(), ((ServletServerHttpResponse) serverHttpResponse).getServletResponse(), o);
        }

        return o;
    }
}
