package com.ouou.sooljari.user;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter, WebMvcConfigurer {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        //여기에 내가 허용하고자 하는 클라이언트의 url을 입력해 줍니다.
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");  //이렇게 해서 모든 요청에 대해서 허용할 수도 있습니다.
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods","*");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers",
                "Access-Control-Allow-Origin, Origin, X-Requested-With, Content-Type, Accept, Authorization, X-AUTH-TOKEN");

        if("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        }else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {

    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("http//localhost:3000")
//                .allowedMethods("*")
//                .allowedHeaders("Access-Control-Allow-Origin", "X-AUTH-TOKEN", "Authorization", "Access-Control-Allow-Credentials", "Access-Control-Allow-Headers")
//                .exposedHeaders("Content-Disposition", "X-AUTH-TOKEN", "Authorization", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Access-Control-Allow-Headers")
//                .allowCredentials(true);
//    }
}