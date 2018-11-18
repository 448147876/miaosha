package com.zhijie.miaosha.cacheutils.comm;


import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:基础dao接口
 * @author: 童志杰
 * @Date:2018/10/21
 */
public interface BaseDao<T extends BaseEntity,V extends BaseExample>{


    int countByExample(V example);

    int deleteByExample(V example);

    int deleteByPrimaryKey(Serializable id);

    int insert(T entity);

    int insertSelective(T entity);

    List<T> selectByExample(V example);

    T selectByPrimaryKey(Serializable id);

    int updateByExampleSelective(@Param("record") T entity, @Param("example") V example);

    int updateByExample(@Param("record") T entity, @Param("example") V example);

    int updateByPrimaryKeySelective(T entity);

    int updateByPrimaryKey(T entity);


}
