package com.dixn.dxboot.Swagger;

import org.springframework.beans.factory.annotation.Value;
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
 * @Description：swagger config
 * @projectName：dxboot
 * @packageName： com.dixn.dxboot.Swagger
 * @ClassName：SwaggerConfig
 * @author：zhaoxu
 * @createTime：2018/11/19 18:15
 * @upate：zhaoxu
 * @updateDate：2018/11/19 18:15
 * @remark：
 * @version v1.0
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Value(value = "${swagger.enabled}")
    Boolean swaggerEnabled;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                // 是否开启
                .enable(swaggerEnabled).select()
                // 扫描的路径包
                .apis(RequestHandlerSelectors.basePackage("com.dixn.dxboot.controller"))
                // 指定路径处理PathSelectors.any()代表所有的路径
                .paths(PathSelectors.any()).build().pathMapping("/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot-Swagger2集成和使用")
                .description("Swagger2集成和使用")
                // 作者信息
                .contact(new Contact("zx", "http://www.dixn.com.cn/", ""))
                .version("1.0.0")
                .build();
    }
}