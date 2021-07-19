package mall_mybatis.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import mall_mybatis.demo.mbg.api.BaseResult;
import mall_mybatis.demo.mbg.dto.UmsAdminLoginDTO;
import mall_mybatis.demo.mbg.model.UmsAdmin;
import mall_mybatis.demo.mbg.model.UmsPermission;
import mall_mybatis.demo.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static mall_mybatis.demo.utils.ConstUtil.*;

/**
 * @author zzy
 * @description:
 * @date 2021/7/15 21:47
 */


@Controller
@RequestMapping(UMS_ADMIN)
@Api(tags = {UMS_ADMIN_CONTROLLER})
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UmsAdminController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    private final UmsAdminService umsAdminService;

    /*
     * @description: 注册
     * @param: [umsAdmin]
     * @return: BaseResult<UmsAdmin>
     * @date: 22:12 2021/7/15
     */
    @ApiOperation(value = "注册")
    @PostMapping(UMS_ADMIN_REGISTER)
    @ResponseBody
    public BaseResult<UmsAdmin> register(@RequestBody UmsAdmin umsAdmin){
        UmsAdmin result = umsAdminService.register(umsAdmin);
        if(result == null){
            BaseResult.failed();
        }
        return BaseResult.success(result);
    }

    /*
     * @description: 登录以后返回token
     * @param: [loginDTO]
     * @return: BaseResult
     * @date: 16:07 2021/7/19
     */
    @ApiOperation(value = "登录以后返回token")
    @PostMapping(value = UMS_ADMIN_LOGIN)
    @ResponseBody
    public BaseResult login(@RequestBody UmsAdminLoginDTO loginDTO){
        String token = umsAdminService.login(loginDTO.getUsername(), loginDTO.getPassword());
        if(token == null){
            return BaseResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return BaseResult.success(tokenMap);
    }

    /*
     * @description: 获取用户所有权限
     * @param: [adminId]
     * @return: BaseResult<List<UmsPermission>>
     * @date: 16:10 2021/7/19
     */
    @ApiOperation(value = "获取用户所有权限")
    @GetMapping(UMS_ADMIN_PERMISSION)
    @ResponseBody
    public BaseResult<List<UmsPermission>> getPermissionList(@PathVariable Long adminId){
        List<UmsPermission> permissionList = umsAdminService.getPermissionList(adminId);
        return BaseResult.success(permissionList);
    }
}
