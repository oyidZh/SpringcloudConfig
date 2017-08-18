package com.activiti.common.aop;

import com.activiti.pojo.restApiDto.RestApiResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by 12490 on 2017/8/19.
 */
@Aspect
@Component
public class ApiAspect {

    @Pointcut("@annotation(com.activiti.common.aop.ApiAnnotation)")
    public void allMethod() {
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
}
