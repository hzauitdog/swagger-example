package com.hzau.swaggerdemo.config;

import com.hzau.swaggerdemo.vo.ResultState;
import io.swagger.models.auth.In;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName SwaggerConfig
 * @Description TODO
 * @Author yueyiming
 * @Date 2023/3/22 16:01
 * @Version 1.0
 * https://blog.csdn.net/hzau_itdog
 **/
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        //Docket: 摘要对象，通过对象配置 描述文件的信息
        Docket docket = new Docket(DocumentationType.OAS_30);
        docket.apiInfo(apiInfo())
                //select()：返回ApiSelectorBuilder对象，通过对象调用build()可以创建Docket对象
                .select()

                .apis(RequestHandlerSelectors.basePackage("com.hzau.swaggerdemo"))
                // 路径过滤：该Docket-UI展示时，只展示指定路径下的接口文档(any表示都展示)
                .paths(PathSelectors.any())
                .build();
        //所有状态码
        docket = this.globalMessage(docket);
        docket = this.addSecurity(docket, "BASE_TOKEN", In.HEADER);
        return docket;
    }


    private Docket addSecurity(Docket docket, String paramName, In authType) {
        return docket.securitySchemes(securitySchemes(paramName, authType)).securityContexts(securityContexts(paramName));
    }

    /**
     * 设置授权信息
     */
    private List<SecurityScheme> securitySchemes(String paramName, In authType) {
        ApiKey apiKey = new ApiKey(paramName, "", authType.toValue());
        return Collections.singletonList(apiKey);
    }

    /**
     * 授权信息全局应用
     */
    private List<SecurityContext> securityContexts(String paramName) {
        return Collections.singletonList(
                SecurityContext.builder()
                        .securityReferences(Collections.singletonList(new SecurityReference(paramName, new AuthorizationScope[]{new AuthorizationScope("global", "")})))
                        .build()
        );
    }

    /**
     * 所有状态码
     *
     * @param docket
     * @return
     */
    private Docket globalMessage(Docket docket) {
        List<Response> list = new ArrayList<>();
        Arrays.stream(ResultState.values()).forEach(state ->
                list.add(new ResponseBuilder().code(state.getCode().toString()).description(state.getMessage()).build())
        );
        docket.globalResponses(HttpMethod.POST, list);
        docket.globalResponses(HttpMethod.GET, list);
        docket.globalResponses(HttpMethod.DELETE, list);
        docket.globalResponses(HttpMethod.PUT, list);
        return docket;
    }

    /**
     * 接口文档的概要信息，返回ApiInfo对象
     *
     * @return
     */
    private ApiInfo apiInfo() {
        //标题
        String title = "hzau-itdog 测试接口文档";
        //简单描述
        String description = "文档面描述";
        //版本
        String version = "V1.0.0";
        // url接口路径前缀
        String termsOfServiceUrl = "/";
        //作者信息
        Contact contact = new Contact("hzau", "", "yueyiming0513@qq.com");
        //协议
        String license = "";
        //协议url
        String licenseUrl = "";

        ApiInfo apiInfo = new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(version)
                .termsOfServiceUrl(termsOfServiceUrl)
                .contact(contact)
                .license(license)
                .licenseUrl(licenseUrl)
                .build();
        return apiInfo;
    }


}
