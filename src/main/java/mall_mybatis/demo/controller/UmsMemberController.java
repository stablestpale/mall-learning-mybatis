package mall_mybatis.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import mall_mybatis.demo.mbg.api.BaseResult;
import mall_mybatis.demo.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static mall_mybatis.demo.utils.ConstUtil.*;

/**
 * @author zzy
 * @description:
 * @date 2021/7/12 22:30
 */

@Controller
@Api(tags = UMS_MEMBER_CONTROLLER)
@RequestMapping(UMS_MEMBER)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UmsMemberController {
    private final UmsMemberService umsMemberService;

    /*
     * @description: 获取验证码
     * @param: [phoneNum]
     * @return: BaseResult
     * @date: 22:36 2021/7/12
     */
    @ApiOperation("获取验证码")
    @GetMapping(UMS_MEMBER_GET_AUTH_CODE)
    @ResponseBody
    public BaseResult getAuthCode(@RequestParam String phoneNum){
        return umsMemberService.generateAuthCode(phoneNum);
    }


    /*
     * @description:验证验证码
     * @param: [phoneNum, authCode]
     * @return: BaseResult
     * @date: 22:37 2021/7/12
     */
    @ApiOperation("验证验证码")
    @PostMapping(UMS_MEMBER_VERIFY_AUTH_CODE)
    @ResponseBody
    public BaseResult verifyAuthCode(@RequestParam String phoneNum, @RequestParam String authCode){
        return umsMemberService.verifyAuthCode(phoneNum, authCode);
    }
}
