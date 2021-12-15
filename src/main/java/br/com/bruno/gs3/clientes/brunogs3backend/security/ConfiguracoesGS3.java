package br.com.bruno.gs3.clientes.brunogs3backend.security;

import br.com.bruno.gs3.clientes.brunogs3backend.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class ConfiguracoesGS3 implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    @Bean
    public HandlerInterceptor getClienteInterceptor(){
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(getClienteInterceptor());
    }
}