package com.challenge.pokemon.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpServletConnection;

public class InterceptorService implements EndpointInterceptor {

    @Override
    public boolean handleRequest(MessageContext messageContext, Object endpoint) throws Exception {
        TransportContext transportContext = TransportContextHolder.getTransportContext();
        HttpServletConnection connection = (HttpServletConnection) transportContext.getConnection();
        HttpServletRequest servletRequest = connection.getHttpServletRequest();

        if (servletRequest != null) {
            String clientIp = servletRequest.getRemoteAddr();
            messageContext.setProperty("clientIp", clientIp);
        }
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex) throws Exception {
    }
}
