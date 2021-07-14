package mall_mybatis.demo.dao;

import mall_mybatis.demo.mbg.model.UmsPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zzy
 * @description:
 * @date 2021/7/13 15:58
 */


@Repository
public interface UmsAdminRoleRelationDAO {

    /*
     * @description: 获取用户所有权限
     * @param: [adminId]
     * @return: List<UmsPermission>
     * @date: 16:13 2021/7/13
     */
    List<UmsPermission> getPermissionList(@Param("adminId") Long adminId);
}
