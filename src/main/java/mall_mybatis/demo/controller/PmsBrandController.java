package mall_mybatis.demo.controller;

import lombok.RequiredArgsConstructor;
import mall_mybatis.demo.service.PmsBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static mall_mybatis.demo.utils.ConstUtil.PMS_BRAND;

/**
 * @author zzy
 * @description: PmsBrandController
 * @date 2021/7/12 15:16
 */


@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(PMS_BRAND)
public class PmsBrandController {

    private final PmsBrandService pmsBrandService;

    public static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandService.class);



}
