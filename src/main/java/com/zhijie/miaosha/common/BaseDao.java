package com.zhijie.miaosha.common;


import java.io.Serializable;

/**
 * @Description:基础dao接口
 * @author: 童志杰
 * @Date:2018/10/21
 */
public interface BaseDao<T> {


    
    int deleteByPrimaryKey(Serializable id);

    int insert(T entity);

    int insertSelective(T entity);

    T selectByPrimaryKey(Serializable id);

    int updateByPrimaryKeySelective(T entity);

    int updateByPrimaryKey(T entity);


}
