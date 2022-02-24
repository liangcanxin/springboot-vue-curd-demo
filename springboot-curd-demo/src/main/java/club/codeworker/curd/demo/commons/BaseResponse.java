package club.codeworker.curd.demo.commons;

/**
 * 响应体封装
 *
 * @author code-worker
 * @since 2022/02/17 20:56
 */
public class BaseResponse<T> {
    /**
     * 响应数据
     */
    private T data;
    /**
     * 响应状态码
     */
    private Integer code;
    /**
     * 响应补充信息
     */
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    private BaseResponse(Integer code, String message, T data) {
        this.data = data;
        this.code = code;
        this.message = message;
    }

    /**
     * 状态码枚举类
     */
    public enum ResponseCode {
        /**
         * 成功状态码
         */
        SUCCESS("请求成功", 1),
        /**
         * 失败状态码
         */
        FAILURE("请求失败", -1)
        ;
        /**
         * 状态码信息
         */
        private String message;
        /**
         * 状态码
         */
        private Integer code;

        ResponseCode(String message, Integer code) {
            this.message = message;
            this.code = code;
        }
    }

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(ResponseCode.SUCCESS.code, ResponseCode.SUCCESS.message, data);
    }

    public static BaseResponse success() {
        return BaseResponse.success(null);
    }

    public static BaseResponse failure(String message) {
        return new BaseResponse<>(ResponseCode.FAILURE.code, message, null);
    }

    public static BaseResponse failure() {
        return BaseResponse.failure(ResponseCode.FAILURE.message);
    }
}
