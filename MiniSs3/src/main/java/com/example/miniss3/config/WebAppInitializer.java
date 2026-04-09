package com.example.miniss3.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null; // Không dùng root context riêng
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class}; // Dùng config MVC hiện có
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; // Map toàn bộ request cho DispatcherServlet
    }
}
