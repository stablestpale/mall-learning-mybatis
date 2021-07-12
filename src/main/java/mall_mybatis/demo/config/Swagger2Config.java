package mall_mybatis.demo.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static mall_mybatis.demo.utils.ConstUtil.PMS_BRAND_CONTROLLER;

/**
 * @author zzy
 * @description:
 * @date 2021/7/12 16:17
 */


@Configuration
@EnableSwagger2
public class Swagger2Config {



    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .tags(new Tag(PMS_BRAND_CONTROLLER, "商品品牌管理"))
                .select()
                //为当前包下controller生成API文档
                .apis(RequestHandlerSelectors.basePackage("com.test.mall.demo.controller"))
                /*//为有@Api注解的controller生成API文档
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                //为有@ApiOperation注解的方法生成API文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                */
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Swagger-Ui测试")
                .description("mall-learning")
                .version("1.0.0")
                .build();
    }
}

