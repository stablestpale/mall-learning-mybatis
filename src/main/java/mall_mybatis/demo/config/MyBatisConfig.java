package mall_mybatis.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zzy
 * @description: MyBatisConfig
 * @date 2021/7/12 10:35
 */



@Configuration
@MapperScan({"mall_mybatis.demo.mbg.mapper", "mall_mybatis.demo.dao"})
public class MyBatisConfig {
}
