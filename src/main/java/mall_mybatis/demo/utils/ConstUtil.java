package mall_mybatis.demo.utils;

/**
 * @author zzy
 * @description: ConstUtil
 * @date 2021/7/12 15:16
 */


public class ConstUtil {
    //Message
    public static final String OPERATION_FAILED = "操作失败";

    //swagger-ui tags
    public static final String PMS_BRAND_CONTROLLER = "PmsBrandController";
    public static final String UMS_MEMBER_CONTROLLER = "UmsMemberController";

    //controller
    public static final String ID = "id";
    //pms-brand-controller
    public static final String PMS_BRAND = "/brand";
    public static final String PMS_BRAND_GET_BRAND_LIST= "getBrandList";
    public static final String PMS_BRAND_CREATE_BRAND = "createBrand";
    public static final String PMS_BRAND_UPDATE_BRAND = "updateBrand";
    public static final String PMS_BRAND_DELETE_BRAND = "deleteBrand";
    public static final String PMS_BRAND_LIST_BRAND = "listBrand";
    public static final String PMS_BRAND_GET_BRAND_DETAIL = "getBrandDetail";
    //ums-member-controller
    public static final String UMS_MEMBER = "/sso";
    public static final String UMS_MEMBER_GET_AUTH_CODE = "getAuthCode";
    public static final String UMS_MEMBER_VERIFY_AUTH_CODE = "verifyAuthCode";
}
