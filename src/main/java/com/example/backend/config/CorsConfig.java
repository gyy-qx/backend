package com.example.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域配置
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(1800)
                .allowedOrigins("http://localhost:3000");//前端服务器IP和端口号
    }
//    导致图片回显不能立刻加载，需要idea重新加载的原理是服务器的保护措施导致的，服务器不能对外部暴露真实的资源路径，需要配置虚拟路径映射访问
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
//                String path = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\coverImg\\";
    //static/upload/**是对应resource下工程目录
//        registry.addResourceHandler("/coverImg/**").addResourceLocations("file:"+path);

    registry.addResourceHandler("/coverImg/**")
            .addResourceLocations("file:E:/Download/workspace/backend/src/main/resources/static/coverImg/");
    registry.addResourceHandler("/headImg/**")
            .addResourceLocations("file:E:/Download/workspace/backend/src/main/resources/static/headImg/");
}

}
