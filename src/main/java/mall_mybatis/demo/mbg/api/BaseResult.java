package mall_mybatis.demo.mbg.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zzy
 * @description: BaseResult
 * @date 2021/7/12 15:30
 */



@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResult<T> {
    private Long code;
    private String message;
    private T data;

    /*
     * @description: 返回成功结果
     * @param: [data]
     * @return: BaseResult<T>
     * @date: 15:42 2021/7/12
     */
    public static <T> BaseResult<T> success(T data){
        return new BaseResult<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    /*
     * @description: 返回成功结果
     * @param: [data, message]
     * @return: BaseResult<T>
     * @date: 15:42 2021/7/12
     */
    public static <T> BaseResult<T> success(T data, String message){
        return new BaseResult<>(ResultCode.SUCCESS.getCode(), message, data);
    }


    /*
     * @description: 返回失败结果
     * @param: [errorCode]
     * @return: BaseResult<T>
     * @date: 15:42 2021/7/12
     */
    public static <T> BaseResult<T> failed(IErrorCode errorCode){
        return new BaseResult<>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /*
     * @description: 返回失败结果
     * @param: [message]
     * @return: BaseResult<T>
     * @date: 15:42 2021/7/12
     */
    public static <T> BaseResult<T> failed(String message){
        return new BaseResult<>(ResultCode.FAILED.getCode(), message, null);
    }

    /*
     * @description: 返回失败结果
     * @param: []
     * @return: BaseResult<T>
     * @date: 15:43 2021/7/12
     */
    public static <T> BaseResult<T> failed(){
        return failed(ResultCode.FAILED);
    }

    /*
     * @description: 返回验证失败结果
     * @param: []
     * @return: BaseResult<T>
     * @date: 15:43 2021/7/12
     */
    public static <T> BaseResult<T> validateFailed(){
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /*
     * @description: 返回验证失败结果
     * @param: [message]
     * @return: BaseResult<T>
     * @date: 15:43 2021/7/12
     */
    public static <T> BaseResult<T> validateFailed(String message){
        return new BaseResult<>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /*
     * @description: 返回未登录结果
     * @param: [data]
     * @return: BaseResult<T>
     * @date: 15:43 2021/7/12
     */
    public static <T> BaseResult<T> unauthorized(T data){
        return new BaseResult<>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /*
     * @description: 返回未授权结果
     * @param: [data]
     * @return: BaseResult<T>
     * @date: 15:43 2021/7/12
     */
    public static <T> BaseResult<T> forbidden(T data){
        return new BaseResult<>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }


}
