package com.project.projectcomm;

import com.project.projectcomm.interceptor.LoginCheckInterceptor;
import com.project.projectcomm.interceptor.MsgRemoveInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    public InterceptorConfig(LoginCheckInterceptor loginCheckInterceptor, MsgRemoveInterceptor msgRemoveInterceptor) {
        this.loginCheckInterceptor = loginCheckInterceptor;
        this.msgRemoveInterceptor = msgRemoveInterceptor;
    }

    LoginCheckInterceptor loginCheckInterceptor;
    MsgRemoveInterceptor msgRemoveInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginCheckInterceptor).order(1)
                .addPathPatterns("/user/*.do")
                .excludePathPatterns("/user/findPw.do")
                .excludePathPatterns("/user/resetPw.do")
                .excludePathPatterns("/user/login.do")
                .excludePathPatterns("/user/signup.do")
                .addPathPatterns("/comm/*.do")
                .addPathPatterns("/comm/*/*.do")
                .excludePathPatterns("/comm/reply/list.do")
                .excludePathPatterns("/comm/user/list.do")
                .excludePathPatterns("/comm/user/cate_list.do")
                .excludePathPatterns("/comm/user/detail.do");
        registry.addInterceptor(msgRemoveInterceptor).order(2)
                .addPathPatterns("/")
                .addPathPatterns("/**/*.do");
    }
}
