package com.spring3.common.aop;

import com.spring3.common.annotation.CheckLogin;
import com.spring3.common.api.Result;
import com.spring3.common.api.ResultCode;
import com.spring3.common.context.UserContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Optional;

@Aspect
@Component
public class CheckLoginAspect {

    @Pointcut("@within(com.spring3.common.annotation.CheckLogin) || @annotation(com.spring3.common.annotation.CheckLogin)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        CheckLogin annotation = Optional.ofNullable(method.getAnnotation(CheckLogin.class)).orElse(method.getDeclaringClass().getAnnotation(CheckLogin.class));
        if (Objects.isNull(annotation) || !annotation.enabled()) {
            return joinPoint.proceed();
        }

        if (checkLogin()) {
            return joinPoint.proceed();
        } else {
            // 防止记录太多日志，这里禁止抛异常
            return Result.fail(ResultCode.UNAUTHORIZED);
        }
    }

    private boolean checkLogin() {
        return !ObjectUtils.isEmpty(UserContextHolder.getUserId());
    }

}
