package com.example.session7.Bai4;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;

@Override
protected void customizeRegistration(ServletRegistration.Dynamic registration) {

    MultipartConfigElement multipartConfig = new MultipartConfigElement(
            "C:/RikkeiFood_Temp/",
            2 * 1024 * 1024, // max file size = 2MB
            2 * 1024 * 1024, // max request size = 2MB
            0
    );

    registration.setMultipartConfig(multipartConfig);
}
