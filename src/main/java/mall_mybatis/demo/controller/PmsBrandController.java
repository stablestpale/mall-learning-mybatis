package mall_mybatis.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Tag;
import lombok.RequiredArgsConstructor;
import mall_mybatis.demo.config.Swagger2Config;
import mall_mybatis.demo.mbg.api.BasePageResult;
import mall_mybatis.demo.mbg.api.BaseResult;
import mall_mybatis.demo.mbg.model.PmsBrand;
import mall_mybatis.demo.service.PmsBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static mall_mybatis.demo.utils.ConstUtil.*;

/**
 * @author zzy
 * @description: PmsBrandController
 * @date 2021/7/12 15:16
 */

@Api(tags = {PMS_BRAND_CONTROLLER})
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(PMS_BRAND)
public class PmsBrandController {

    private final PmsBrandService brandService;

    public static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandService.class);

    @ApiOperation("获取所有品牌列表")
    @GetMapping(PMS_BRAND_GET_BRAND_LIST)
    @ResponseBody
    public BaseResult<List<PmsBrand>> getBrandList(){
        return BaseResult.success(brandService.listAllBrand());
    }

    /*
     * @description: 添加品牌
     * @param: [pmsBrand]
     * @return: BaseResult
     * @date: 15:59 2021/7/12
     */
    @ApiOperation("添加品牌")
    @PostMapping(PMS_BRAND_CREATE_BRAND)
    @ResponseBody
    public BaseResult createBrand(@RequestBody PmsBrand pmsBrand){
        BaseResult baseResult;
        int count = brandService.createBrand(pmsBrand);
        if(count == 1){
            baseResult = BaseResult.success(pmsBrand);
            LOGGER.debug("createBrand success:{}", pmsBrand);
        } else{
            baseResult = BaseResult.failed(OPERATION_FAILED);
            LOGGER.debug("createBrand failed:{}", pmsBrand);
        }
        return baseResult;
    }

    /*
     * @description: 更新品牌信息
     * @param: [id, pmsBrand, result]
     * @return: BaseResult
     * @date: 16:00 2021/7/12
     */
    @ApiOperation("更新品牌信息")
    @PostMapping(PMS_BRAND_UPDATE_BRAND)
    @ResponseBody
    public BaseResult updateBrand(@PathVariable(ID) Long id, @RequestBody PmsBrand pmsBrand, BindingResult result){
        BaseResult baseResult;
        int count = brandService.updateBrand(id, pmsBrand);
        if(count == 1){
            baseResult = BaseResult.success(pmsBrand);
            LOGGER.debug("updateBrand success:{}", pmsBrand);
        } else{
            baseResult = BaseResult.failed(OPERATION_FAILED);
            LOGGER.debug("updateBrand failed:{}", pmsBrand);
        }
        return baseResult;
    }

    /*
     * @description: 删除品牌
     * @param: [id]
     * @return: BaseResult
     * @date: 16:00 2021/7/12
     */
    @ApiOperation("删除品牌")
    @GetMapping(PMS_BRAND_DELETE_BRAND)
    @ResponseBody
    public BaseResult deleteBrand(@PathVariable(ID) Long id){
        int count  = brandService.deleteBrand(id);
        if(count == 1){
            LOGGER.debug("deleteBrand success :id={}", id);
            return BaseResult.success(null);
        } else{
            LOGGER.debug("deleteBrand failed :id={}", id);
            return BaseResult.failed(OPERATION_FAILED);
        }
    }

    /*
     * @description: 分页查询品牌列表
     * @param: [pageNum, pageSize]
     * @return: BaseResult<BasePageResult<PmsBrand>>
     * @date: 16:00 2021/7/12
     */
    @ApiOperation("分页查询品牌列表")
    @GetMapping(PMS_BRAND_LIST_BRAND)
    @ResponseBody
    public BaseResult<BasePageResult<PmsBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") @ApiParam("页码") Integer pageNum,
                                                          @RequestParam(value = "pageSize", defaultValue = "3") @ApiParam("每页数量") Integer pageSize){
        List<PmsBrand> brandList = brandService.listBrand(pageNum, pageSize);
        return BaseResult.success(BasePageResult.restPage(brandList));
    }

    /*
     * @description: 获取品牌详细信息
     * @param: [id]
     * @return: BaseResult<PmsBrand>
     * @date: 16:00 2021/7/12
     */
    @ApiOperation("获取品牌详细信息")
    @GetMapping(PMS_BRAND_GET_BRAND_DETAIL)
    @ResponseBody
    public BaseResult<PmsBrand> getBrandDetail(@PathVariable(ID) Long id){
        return BaseResult.success(brandService.getBrand(id));
    }


}
