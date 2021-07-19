package mall_mybatis.demo.mbg.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * @author zzy
 * @description:
 * @date 2021/7/16 9:42
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UmsAdminLoginDTO {
    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty(message = "密码不能为空")
    private String password;


}
