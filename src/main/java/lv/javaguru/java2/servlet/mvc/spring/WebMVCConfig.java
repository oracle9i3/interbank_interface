package lv.javaguru.java2.servlet.mvc.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by Svetlana Titova on 27.08.2016.
 */
    @Configuration
    @EnableWebMvc
    @ComponentScan(basePackages = {"lv.javaguru.java2"})

    public class WebMVCConfig   extends WebMvcConfigurerAdapter {

        @Bean
        public ViewResolver viewResolver() {
            InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
            viewResolver.setPrefix("/");
            viewResolver.setSuffix(".jsp");
            return viewResolver;
        }


        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/styles/**").addResourceLocations("/styles/");
            registry.addResourceHandler("/images/**").addResourceLocations("/images/");
        }
    }

