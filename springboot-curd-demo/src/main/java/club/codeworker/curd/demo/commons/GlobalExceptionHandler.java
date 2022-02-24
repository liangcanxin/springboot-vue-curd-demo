package club.codeworker.curd.demo.commons;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.stream.Collectors;


/**
 * 全局异常类
 *
 * @author code-worker
 * @since 2022/02/21 14:17
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    /**
     * 参数校验异常捕获
     * @author code-worker
     * @since 2022/2/21 14:29
	 * @param e 异常
	 * @return club.codeworker.curd.demo.commons.BaseResponse
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return BaseResponse.failure(
                e.getBindingResult().getFieldErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.joining(",")));
    }
    /**
     * 参数校验异常捕获
     * @author code-worker
     * @since 2022/2/21 14:20
	 * @param ex 异常
	 * @return club.codeworker.curd.demo.commons.BaseResponse
     */
    @ExceptionHandler(BindException.class)
    public BaseResponse bindExceptionHandler(BindException ex) {
        return BaseResponse.failure(
                ex.getBindingResult().getFieldErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.joining(",")));
    }

    /**
     * 未知异常捕获
     * @author code-worker
     * @since 2022/2/21 14:21
	 * @param ex 异常
	 * @return club.codeworker.curd.demo.commons.BaseResponse
     */
    @ExceptionHandler(Exception.class)
    public BaseResponse exceptionHandler(Exception ex) {
        return BaseResponse.failure(ex.getMessage());
    }
}
