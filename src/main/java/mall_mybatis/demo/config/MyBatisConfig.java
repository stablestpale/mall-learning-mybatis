package mall_mybatis.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zzy
 * @description: TODO
 * @date 2021/7/12 10:35
 */



@Configuration
@MapperScan("mall_mybatis.demo.mbg.mapper")
public class MyBatisConfig {
}
