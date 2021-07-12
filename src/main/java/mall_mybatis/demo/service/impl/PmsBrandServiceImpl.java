package mall_mybatis.demo.service.impl;

import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import mall_mybatis.demo.mbg.mapper.PmsBrandMapper;
import mall_mybatis.demo.mbg.model.PmsBrand;
import mall_mybatis.demo.mbg.model.PmsBrandExample;
import mall_mybatis.demo.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zzy
 * @description: PmsBrandServiceImpl
 * @date 2021/7/12 15:00
 */

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PmsBrandServiceImpl implements PmsBrandService {

    private final PmsBrandMapper pmsBrandMapper;


    @Override
    public List<PmsBrand> listAllBrand() {
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand brand) {
        return pmsBrandMapper.insert(brand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return pmsBrandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int deleteBrand(Long id) {
        return pmsBrandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return pmsBrandMapper.selectByPrimaryKey(id);
    }
}
