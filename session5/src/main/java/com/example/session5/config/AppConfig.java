package com.example.session5.config;
// package chứa class cấu hình (config) cho toàn bộ Spring

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
// thư viện hỗ trợ layout (giống kiểu dùng template cha - con trong Thymeleaf)

import org.springframework.context.annotation.Bean;
// dùng để đánh dấu method trả về object sẽ được Spring quản lý (bean)

import org.springframework.context.annotation.ComponentScan;
// cho Spring tự động quét các class (@Controller, @Service, @Repository...)

import org.springframework.context.annotation.Configuration;
// đánh dấu đây là class cấu hình (giống file xml nhưng viết bằng Java)

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
// bật các chức năng của Spring MVC (DispatcherServlet, mapping,...)

import org.thymeleaf.spring6.SpringTemplateEngine;
// engine xử lý template Thymeleaf

import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
// class giúp Spring biết đọc file HTML ở đâu

import org.thymeleaf.spring6.view.ThymeleafViewResolver;
// class giúp trả view (HTML) về cho browser

import org.thymeleaf.templatemode.TemplateMode;
// định dạng template (HTML, TEXT,...)

@Configuration
// đánh dấu class này là config của Spring
@EnableWebMvc
// bật toàn bộ cơ chế Spring MVC
@ComponentScan("com.example.session5")
// Spring sẽ quét toàn bộ package này để tìm Controller, Service, Repository

public class AppConfig {

    // 1. Bean TemplateResolver
    // nhiệm vụ: xác định vị trí file HTML (view)
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();

        templateResolver.setPrefix("/WEB-INF/views/");
        // đường dẫn tới thư mục chứa file HTML

        templateResolver.setSuffix(".html");
        // đuôi file (ví dụ: home → home.html)

        templateResolver.setTemplateMode(TemplateMode.HTML);
        // xác định kiểu template là HTML

        templateResolver.setCharacterEncoding("UTF-8");
        // hỗ trợ tiếng Việt

        return templateResolver;
        // trả về bean để Spring quản lý
    }

    // 2. Bean TemplateEngine
    // nhiệm vụ: xử lý logic Thymeleaf (th:text, th:if, th:each,...)
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();

        engine.setTemplateResolver(templateResolver());
        // gắn resolver vào engine để biết đọc file ở đâu

        engine.addDialect(new LayoutDialect());
        // thêm hỗ trợ layout (giống include header/footer)

        return engine;
    }

    // 3. Bean ViewResolver
    // nhiệm vụ: kết nối Controller với View (HTML)
    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();

        resolver.setTemplateEngine(templateEngine());
        // gắn engine để xử lý Thymeleaf

        resolver.setCharacterEncoding("UTF-8");
        // hiển thị tiếng Việt đúng

        return resolver;
    }

}