package school.management.admin.common.exception;

import school.management.admin.common.exception.base.BusinessException;

/**
 * 短信发送太频繁
 */
public class SmsTooMuchException extends BusinessException {

    public SmsTooMuchException(String message) {
        super(message);
    }

}
