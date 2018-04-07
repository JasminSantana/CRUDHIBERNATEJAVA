package com.santana.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author JASMIN-SOMA
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.santana")
public class Configuracion extends WebMvcConfigurerAdapter {

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver vistaAceptada = new InternalResourceViewResolver();
        
        vistaAceptada.setViewClass(JstlView.class);
       
        vistaAceptada.setPrefix("/WEB-INF/vistas/");
        
        vistaAceptada.setSuffix(".jsp");
        
        registry.viewResolver(vistaAceptada);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registro) {
        registro.addResourceHandler("/static/**").addResourceLocations("/static/");
    }
    
    @Override
    public void configurePathMatch(PathMatchConfigurer matcher) {
        matcher.setUseRegisteredSuffixPatternMatch(true);
    }
}
