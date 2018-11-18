package com.zhijie.miaosha.cacheutils.comm;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * ecache缓存aop切面处理，拦截所有注解方法
 * 如果缓存中有，则返回，如果没有，则拦截方法的返回值，存入缓存后再返回
 */
@Aspect
@Component
public class EcacheAspect {

    @Around("@annotation(com.zhijie.miaosha.cacheutils.comm.Cacheable)")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //结果
        Object result = null;
        //注解key
        String keyName = "";


        //存活期
        int timeToLiveSeconds;
        //闲置时间
        int timeToIdleSeconds;
        //前置通知
        //获取注解参数
        Signature signature = proceedingJoinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        Cacheable annotation = targetMethod.getAnnotation(Cacheable.class);
        //如果注解没有写key，则使用包名+类名+方法名+参数类型+参数值
        keyName = annotation.keyName();

        Class testCase = annotation.testCase();
        if (Objects.equals("", keyName)) {
            keyName = targetMethod.toGenericString();
            Object[] args = proceedingJoinPoint.getArgs();
            for (Object object : args) {
                keyName += object.toString();
            }
        }
        //获取缓存
//        result = EcacheUtils.getCacheByKey(keyName);
//        if (result != null) {
//            return result;
//        } else {
//            result = proceedingJoinPoint.proceed();
//            timeToLiveSeconds = annotation.timeToLiveSeconds();
//            timeToIdleSeconds = annotation.timeToIdleSeconds();
//            EcacheUtils.putCacheByLiveIdle(keyName, result, timeToLiveSeconds, timeToIdleSeconds);
//            return result;
//        }
        return  null;
    }

}
