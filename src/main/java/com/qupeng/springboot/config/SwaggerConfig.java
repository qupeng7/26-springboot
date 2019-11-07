/**
 * @项目名：zjsProject
 * @创建人： qupeng
 * @创建时间： 2019-11-06
 * @公司： www.bjpowernode.com
 * @描述：TODO
 */

package com.qupeng.springboot.config;

import io.swagger.annotations.ApiOperation;
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
 * <p>NAME: SwaggerConfig</p>
 * @author qupeng
 * @date 2019-11-06 21:30:32
 * @version 1.0
 */

@EnableSwagger2 //开启Swagger2的支持
@Configuration
public class SwaggerConfig {

    /**
     * 在spring容器配置一个bean对象
     *
     * @Bean等价于 <bean id="createRestApi" class="xxxx.Docket">
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))//扫描有ApiOperation注解的方法
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 创建api的基本信息
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("集成Swagger2构建RESTful APIs")
                .description("集成Swagger2构建RESTful APIs")
                .termsOfServiceUrl("https://github.com/qupeng7")
                .contact(new Contact("sevenqu","https://github.com/qupeng7","qupeng7@126.com"))
                .license("采用 Apache 2.0 开源许可证")
                .licenseUrl("https://github.com/qupeng7")
                .version("1.0.0")
                .build();
    }
}
