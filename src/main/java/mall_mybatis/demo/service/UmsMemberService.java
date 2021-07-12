package mall_mybatis.demo.service;

import mall_mybatis.demo.mbg.api.BasePageResult;
import mall_mybatis.demo.mbg.api.BaseResult;

public interface UmsMemberService {
    /**
     * 生成验证码
     */
    BaseResult generateAuthCode(String phoneNum);

    /**
     * 判断验证码和手机号码是否匹配
     */
    BaseResult verifyAuthCode(String phoneNum, String authCode);
}
