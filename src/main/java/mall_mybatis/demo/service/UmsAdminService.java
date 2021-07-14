package mall_mybatis.demo.service;

import mall_mybatis.demo.mbg.model.UmsAdmin;
import mall_mybatis.demo.mbg.model.UmsPermission;

import java.util.List;

/**
 * @author zzy
 * @description:
 * @date 2021/7/13 15:11
 */

public interface UmsAdminService {

    /*
     * @description: 根据用户名获取后台管理员
     * @param: [username]
     * @return: UmsAdmin
     * @date: 15:40 2021/7/13
     */
    UmsAdmin getAdminByUsername(String username);

    /*
     * @description: 注册
     * @param: [umsAdmin]
     * @return: UmsAdmin
     * @date: 15:40 2021/7/13
     */
    UmsAdmin register(UmsAdmin umsAdmin);

    /*
     * @description: 登录
     * @param: [username, password]
     * @return: String
     * @date: 15:41 2021/7/13
     */
    String login(String username, String password);

    /*
     * @description: 获取用户所有权限（包括角色权限和增删权限）
     * @param: [adminId]
     * @return: List<UmsPermission>
     * @date: 15:41 2021/7/13
     */
    List<UmsPermission> getPermissionList(Long adminId);
}
