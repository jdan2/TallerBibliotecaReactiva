package com.sofka.biblioteca.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.config.WebFluxConfigurerComposite;

public class WebFluxConfig implements WebFluxConfigurer {
    @Bean
    public WebFluxConfigurer corsConfigure(){
        return  new WebFluxConfigurerComposite() {
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/**").allowedOrigins("*")
                    .allowedMethods("*");
            }
        };
    }

}
