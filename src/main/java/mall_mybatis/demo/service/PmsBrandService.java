package mall_mybatis.demo.service;

import mall_mybatis.demo.mbg.model.PmsBrand;

import java.util.List;

/**
 * @author zzy
 * @description: PmsBrandService
 * @date 2021/7/12 10:37
 */

public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
