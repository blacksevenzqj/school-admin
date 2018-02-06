package school.management.admin.common.exception;

import school.management.admin.common.exception.base.BusinessException;

/**
 * 用户已存在
 */
public class UserExistException extends BusinessException {

    public UserExistException(String message) {
        super(message);
    }

}
