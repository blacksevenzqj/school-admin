package school.management.admin.common.exception;

import school.management.admin.common.exception.base.BusinessException;

/**
 * 无效验证码
 */
public class InvalidCaptchaException extends BusinessException {

    public InvalidCaptchaException(String message) {
        super(message);
    }

}
