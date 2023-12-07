package com.example.demo;

import io.micrometer.common.KeyValue;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.ServerHttpObservationFilter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class TenantInterceptor implements HandlerInterceptor {

    private final HttpHeaderTenantResolver httpHeaderTenantResolver;

    private static final Logger log = LoggerFactory.getLogger(TenantInterceptor.class);

    public TenantInterceptor(HttpHeaderTenantResolver httpHeaderTenantResolver) {
        this.httpHeaderTenantResolver = httpHeaderTenantResolver;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String tenantId = httpHeaderTenantResolver.resolveTenantId(request);
        log.info("preHandle tenantId: {}", tenantId);
        TenantContext.setTenantId(tenantId);
        configureLogs(tenantId);
        configureTraces(tenantId, request);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        clear();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        clear();
    }

    private void configureLogs(String tenantId) {
        MDC.put("tenantId", tenantId);
    }

    private void configureTraces(String tenantId, HttpServletRequest request) {
        ServerHttpObservationFilter.findObservationContext(request).ifPresent(context ->
                context.addHighCardinalityKeyValue(KeyValue.of("tenantId", tenantId)));
    }

    private void clear() {
        MDC.remove("tenantId");
        TenantContext.clear();
    }
}
