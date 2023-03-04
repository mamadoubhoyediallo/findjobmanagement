package sn.groupeisi.findjob.config.logging;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.DispatcherType;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import sn.groupeisi.findjob.service.ILoggingService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@AllArgsConstructor
public class LogInterceptor extends HandlerInterceptorAdapter {

    private ILoggingService ILoggingService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        if (DispatcherType.REQUEST.name().equals(request.getDispatcherType().name())
                && request.getMethod().equals(HttpMethod.GET.name())) {
            ILoggingService.logRequest(request, null);
        }

        return true;
    }
}
