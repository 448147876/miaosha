package com.zhijie.miaosha.utils.base;


import java.lang.annotation.*;

/**
 * 自定义注解,结合cache对方法进行缓存
 *
 * @author 童志杰
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@Documented
public @interface Cacheable {

    /**
     * 可以根据key自定义key值
     * key
     *
     * @return
     */
    String keyName();

    /**
     * 存活时间   存入数据后多少时间后数据无效
     *
     * @return
     */
    int time() default 0;



}
