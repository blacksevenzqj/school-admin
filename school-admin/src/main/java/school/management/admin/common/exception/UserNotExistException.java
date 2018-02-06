package school.management.admin.common.exception;

import school.management.admin.common.exception.base.BusinessException;

/**
 * 用户未存在
 */
public class UserNotExistException extends BusinessException {

    public UserNotExistException(String message) {
        super(message);
    }

}
