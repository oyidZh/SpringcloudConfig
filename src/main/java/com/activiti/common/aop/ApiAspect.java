package com.activiti.common.aop;

import com.activiti.pojo.restApiDto.RestApiResponse;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 接口统一出参注解
 * Created by 12490 on 2017/8/19.
 */
@Aspect
@Component
public class ApiAspect {
    private static final Logger logger = LoggerFactory.getLogger(ApiAspect.class);

    @Pointcut("@annotation(com.activiti.common.aop.ApiAnnotation)")
    public void allMethod() {
    }

    //用来计算消耗时间
    private ThreadLocal<Long> time = new ThreadLocal<Long>();

    /**
     * 在所有标注@ParamCheck的地方切入
     *
     * @param joinPoint 切点
     */
    @Before("allMethod()")
    public void beforeExec(JoinPoint joinPoint) {
        time.set(System.currentTimeMillis());
    }

    @Around("allMethod()")
    public Object aroundExec(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result;
        try {
            result = joinPoint.proceed();
            return new RestApiResponse(true, result);
        } catch (Exception e) {
            ExceptionUtils.getStackTrace(e);
            throw e;
        }
    }

    /**
     * 在所有标注@ParamCheck的地方切入  后置通知
     *
     * @param joinPoint 切点
     */
    @After("allMethod()")
    public void afterExec(JoinPoint joinPoint) {
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method method = ms.getMethod();
        String ClassName = method.getDeclaringClass().getName();
        Long callTime = System.currentTimeMillis() - time.get();
        logger.info("类" + ClassName + "的方法" + method.getName() + "运行消耗" + callTime + "ms");
    }
}
