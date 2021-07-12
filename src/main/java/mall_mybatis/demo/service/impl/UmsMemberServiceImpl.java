package mall_mybatis.demo.service.impl;

import lombok.RequiredArgsConstructor;
import mall_mybatis.demo.mbg.api.BaseResult;
import mall_mybatis.demo.service.RedisService;
import mall_mybatis.demo.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * @author zzy
 * @description:
 * @date 2021/7/12 22:23
 */

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UmsMemberServiceImpl implements UmsMemberService {
    private final RedisService redisService;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    /*
     * @description: 生成验证码
     * @param: [telephone]
     * @return: BaseResult
     * @date: 22:26 2021/7/12
     */
    @Override
    public BaseResult generateAuthCode(String phoneNum) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        //验证码绑定手机号并存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + phoneNum, sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + phoneNum, AUTH_CODE_EXPIRE_SECONDS);
        return BaseResult.success(sb.toString(), "获取验证码成功");
    }

    /*
     * @description: 对输入的验证码进行校验
     * @param: [telephone, authCode]
     * @return: BaseResult
     * @date: 22:26 2021/7/12
     */
    @Override
    public BaseResult verifyAuthCode(String phoneNum, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return BaseResult.failed("请输入验证码");
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + phoneNum);
        boolean result = authCode.equals(realAuthCode);
        if (result) {
            return BaseResult.success(null, "验证码校验成功");
        } else {
            return BaseResult.failed("验证码不正确");
        }
    }
}
