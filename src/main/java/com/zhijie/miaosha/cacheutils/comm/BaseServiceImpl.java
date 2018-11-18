package com.zhijie.miaosha.cacheutils.comm;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:service基础类=接口
 * @author: 童志杰
 * @Date:2018/10/21
 */
public class BaseServiceImpl<M extends BaseDao<T,V>,T extends BaseEntity,V extends BaseExample> implements BaseService<T,V>{


    @Autowired
    protected M baseDao;




    @Override
    public int countByExample(V example) {
        return 0;
    }

    @Override
    public int deleteByExample(V example) {
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Serializable id) {
        return 0;
    }

    @Override
    public int insert(T entity) {
        return 0;
    }

    @Override
    public int insertSelective(T entity) {
        return 0;
    }

    @Override
    public List<T> selectByExample(V example) {
        return null;
    }

    @Override
    public T selectByPrimaryKey(Serializable id) {
        return baseDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(T entity, V example) {
        return 0;
    }

    @Override
    public int updateByExample(T entity, V example) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(T entity) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(T entity) {
        return 0;
    }
}
