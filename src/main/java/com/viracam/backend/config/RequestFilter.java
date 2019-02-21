package com.viracam.backend.config;

import org.apache.log4j.Logger;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mohammad on 1/15/2018.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestFilter implements Filter {
    private static Logger logger  = Logger.getLogger(RequestFilter.class);
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        logger.info("request is " + servletRequest.getRequestURI());

        servletResponse.setHeader("Access-Control-Allow-Origin", "*");
        servletResponse.setHeader("Access-Control-Allow-Methods", "POST,PUT,GET,OPTIONS,DELETE");
//        servletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with, x-auth-token");
        servletResponse.setHeader("Access-Control-Allow-Headers", "*");
//        servletResponse.setHeader("Access-Control-Max-Age", "3600");
//        servletResponse.setHeader("Access-Control-Allow-Credentials", "true");

        try {
            chain.doFilter(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
/*
        if (!servletRequest.getMethod().equalsIgnoreCase("OPTIONS")) {
            try {
                chain.doFilter(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Pre-fight");
            servletResponse.setHeader("Access-Control-Allowed-Mehods","POST, GET, DELETE");
//            servletResponse.setHeader("Access-Control-Max-Age", "3600");
//            servletResponse.setHeader("Access-Control-Allow-Headers", "*");
            try {
                chain.doFilter(request, response);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }

        }
*/
    }

    @Override
    public void destroy() {

    }

    public void init(FilterConfig filterConfig){

    }

}
