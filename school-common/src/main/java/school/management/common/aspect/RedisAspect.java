package school.management.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import school.management.common.config.RedisSwitchConfig;
import school.management.common.exception.RRException;

/**
 * Redis切面处理类
 */
@Aspect
@Component
public class RedisAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //是否开启redis缓存  true开启   false关闭
    @Autowired
    RedisSwitchConfig redisSwitchConfig;

    @Around("execution(* school.management.common.utils.RedisUtils.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        if(redisSwitchConfig.isGlobalOpen()){
            try{
                result = point.proceed();
            }catch (Exception e){
                logger.error("redis error", e);
                throw new RRException("Redis服务异常");
            }
        }
        return result;
    }

}
