package com.fengjf.demo.resp;

/**
 * 错误码
 * <p>
 * 定义规范：
 * <p>
 * 服务端口号_错误码
 *
 * @author xiaoz
 */

public enum BaseResult implements IRet {
    //公共错误
    SUCCESS("200", "操作成功!"),
    ERROR("400", "操作失败"),
    PARAMETER_ERROR("400", "参数错误"),
    NOT_FOUND("404", "内容不存在"),
    SERVER_ERROE("500", "系统内部异常"),

    SAVE_SUCCESS("200", "保存成功!"),
    SAVE_FAIL("500", "保存失败"),

    UPDATE_SUCCESS("200", "更新成功!"),
    UPDATE_FAIL("500", "更新失败!"),

    DELETE_SUCCESS("200", "删除成功!"),
    DELETE_FAIL("500", "删除失败!"),

    LOCK_SUCCESS("200", "锁定成功!"),

    UNKNOWN_FAIL("500", "未知错误!"),
    FEIGN_ERROR("503", "Feign调用异常"),

    //用户权限相关错误
    NOT_LOGIN("10016_100", "未登录"),
    USER_NOT_FOUNT("10016_101", "用户不存在"),
    USER_NOT_ENABLE("10016_102", "该账号已停用"),
    ERROR_PASSWORD("10016_103", "密码错误"),
    ROLE_IN_USE("10016_104", "该角色在使用，不能删除"),
    ROLE_NOT_FOUNT("10016_105", "角色不存在"),
    USER_IN_USE("10016_106", "账号已存在, 请勿重复添加"),
    USER_NOT_FOUND("10016_107", "账号不存在"),
    USER_NO_PRIVILEGES("10016_108", "权限不足"),

    //商户系统相关错误码
    COMPANY_NOT_FOUNT("10071_101", "渠道不存在"),
    COMMIT_REPEAT("10071_102", "渠道企业信息已存在, 请勿重复添加"),
    MANGERACCOUNT_BINDER("10071_103", "管家账号已绑定其他门店, 不能重复使用"),


    // 商品异常
    GOODS_BARCODES_IS_NULL("10071_103", "条形码为空!"),


    /**
     * 策略异常
     */
    // 策略
    VMSTRATEGY_ID_IS_EMPTY("10086_101", "策略id为空"),
    VMSTRATEGY_NAME_IS_EMPTY("10086_102", "策略名称为空"),
    VMSTRATEGY_NAME_EXIST("10086_103", "策略名称已存在"),
    VMSTRATEGY_OBJECT_NOT_FOUNT("10086_104", "策略对象不存在!"),
    VMSTRATEGY_UPDATE_OBJECT_NOT_FOUNT("10086_105", "更新的策略对象不存在!"),
    VMSTRATEGY_PARAMETER_IS_EMPTY("10086_106", "策略请求参数为空"),
    VMSTRATEGY_CURRENT_USER_HAS_NO_POLICY("10086_107", "当前用户没有策略!"),

    // 渠道
    VMSTRATEGY_CHANNELID_NOT_FOUNT("10086_201", "渠道id为空"),
    VMSTRATEGY_CHANNELNAME_NOT_FOUNT("10086_202", "渠道名称为空"),
    VMSTRATEGY_UNACQUIRED_CHANNEL_ID("10086_203", "通过渠道id没有获取到对象"),

    // 分类
    VMSTRATEGY_CATEGORY_IS_EMPTY("10086_301", "分类id为空"),

    // 策略商品单商品
    VMSTRATEGY_PRODUCT_GROUP_ID_IS_EMPTY("10086_401", "策略商品组合id为空"),
    VMSTRATEGY_PRODUCT_GROUP_OBJECT_IS_EMPTY("10086_402", "策略商品组合为空"),
    VMSTRATEGY_PRODUCT_GROUP_REPETITION("10086_403", "策略商品组合已存在"),
    VMSTRATEGY_WRONG_LOCK_STATUS("10086_405", "错误的锁定状态"),
    VMSTRATEGY_GROUP_PRODUCT_DOES_NOT_FOUNT("10086_406", "该渠道下的策略没有查找的商品"),

    // 套餐组合商品
    VMSTRATEGY_GROUP_ID_IS_EMPTY("10086_501", "套餐组合id为空"),
    VMSTRATEGY_GROUP_NAME_IS_EMPTY("10086_502", "套餐组合名称为空"),
    VMSTRATEGY_GROUP_OBJECT_IS_EMPTY("10086_503", "套餐组合对象为空"),
    VMSTRATEGY_TOTALPRICE_ID_IS_EMPTY("10086_504", "套餐组合销售价格为空"),
    VMSTRATEGY_IMAGEURL_IS_EMPTY("10086_505", "套餐组合图片为空"),
    VMSTRATEGY_CHANGE_OBJECT_DOES_NOT_FOUNT("10086_506", "套餐组增加修改的对象为空"),
    VMSTRATEGY_GROUP_DOES_NOT_FOUNT("10086_507", "当前策略组合没有此商品"),


    VMSTRATEGY_GROUP_OBJECT_EXIST("10086_508", "套餐组合已存在"),
    VMSTRATEGY_GROUP_PRODUCT_OBJECT_REPETITION("10086_509", "套餐组合包含的商品重复!"),
    VMSTRATEGY_GROUP_OBJECT_EXCEPTION("10086_510", "套餐组合异常"),
    VMSTRATEGY_COMBINATION_CAN_NOT_BE_ADDED_MORE_THAN_3("10086_511", "组合商品不能超过三个"),


    // feign
    VMSTRATEGY_INVENTORY_PRICE_UPDATE_ERROR("10086_601", "调用erp接口更新错误"),
    ;

    private final String code;
    private final String message;

    BaseResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
