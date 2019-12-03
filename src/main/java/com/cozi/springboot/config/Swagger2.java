package com.cozi.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author xiaosai
 * @Date 2019-12-2 11:10
 * @Version 1.0
 */

@Configuration
@EnableSwagger2
public class Swagger2 {

    //swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等

    @Bean
    public Docket DemoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("通用Api")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cozi.springboot.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("Cms_API")
                //创建人
                .contact(new Contact("eoner", "http://www.eoner.com", "webmaster@eoner.com"))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }
}
