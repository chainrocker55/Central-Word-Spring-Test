package org.example.configuration;

import org.example.adapters.ProductJpaAdapter;
import org.example.adapters.ProductPostmanAdapter;
import org.example.controller.LoggableDispatcherServlet;
import org.example.ports.api.ProductPostmanServicePort;
import org.example.ports.api.ProductServicePort;
import org.example.ports.spi.ProductPersistencePort;
import org.example.ports.spi.ProductPostmanPersistencePort;
import org.example.service.ProductPostmanServiceImpl;
import org.example.service.ProductServiceImpl;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class ProductConfig {

    @Bean
    public ProductPersistencePort productPersistence(){
        return new ProductJpaAdapter();
    }

    @Bean
    public ProductServicePort productService(){
        return new ProductServiceImpl(productPersistence());
    }

    @Bean
    public ProductPostmanPersistencePort productPostmanPersistence(){
        return new ProductPostmanAdapter();
    }

    @Bean
    public ProductPostmanServicePort productPostmanService(){
        return new ProductPostmanServiceImpl(productPostmanPersistence());
    }

    @Bean
    public ServletRegistrationBean dispatcherRegistration() {
        return new ServletRegistrationBean(dispatcherServlet());
    }

    @Bean(name = DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME)
    public DispatcherServlet dispatcherServlet() {
        return new LoggableDispatcherServlet();
    }

}