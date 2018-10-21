package com.zhijie.miaosha.common;

import java.io.Serializable;

/**
 * @Description:service基础类=接口
 * @author: 童志杰
 * @Date:2018/10/21
 */
public interface BaseService<T> {


    boolean deleteByPrimaryKey(Serializable id);

    boolean insert(T entity);

    boolean insertSelective(T entity);

    T selectByPrimaryKey(Serializable id);

    boolean updateByPrimaryKeySelective(T entity);

    boolean updateByPrimaryKey(T entity);


}
