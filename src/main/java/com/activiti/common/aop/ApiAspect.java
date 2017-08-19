package com.activiti.common.aop;

import com.activiti.pojo.restApiDto.RestApiResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
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
    ThreadLocal<Long> time = new ThreadLocal<Long>();

    /**
     * 在所有标注@ParamCheck的地方切入
     *
     * @param joinPoint
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
            RestApiResponse restApiResponse = new RestApiResponse(true, result);
            return restApiResponse;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 在所有标注@ParamCheck的地方切入  后置通知
     *
     * @param joinPoint
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
