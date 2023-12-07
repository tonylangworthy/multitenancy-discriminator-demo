package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class HttpHeaderTenantResolver implements TenantResolver<HttpServletRequest> {

    private static final Logger log = LoggerFactory.getLogger(HttpHeaderTenantResolver.class);

    private final TenantHttpProperties tenantHttpProperties;

    public HttpHeaderTenantResolver(TenantHttpProperties tenantHttpProperties) {
        this.tenantHttpProperties = tenantHttpProperties;
    }

    @Override
    public String resolveTenantId(@NonNull HttpServletRequest request) {
        log.info("Resolving tenantId from properties: {}", tenantHttpProperties.headerName());
        String headerValue = request.getHeader(tenantHttpProperties.headerName());
        log.info("Header value: {}", headerValue);
        return headerValue;
    }
}
