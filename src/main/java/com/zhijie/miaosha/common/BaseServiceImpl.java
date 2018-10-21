package com.zhijie.miaosha.common;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @Description:service基础类=接口
 * @author: 童志杰
 * @Date:2018/10/21
 */
public class BaseServiceImpl<M extends BaseDao<T>, T> implements  BaseService<T>   {

    private static final Log logger = LogFactory.getLog(BaseServiceImpl.class);

    @Autowired
    protected M baseDao;


    @Override
    public boolean deleteByPrimaryKey(Serializable id) {
        Integer count = baseDao.deleteByPrimaryKey(id);
        if(count>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean insert(T entity) {
        Integer count = baseDao.insert(entity);
        if(count>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean insertSelective(T entity) {
        Integer count = baseDao.insertSelective(entity);
        if(count>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public T selectByPrimaryKey(Serializable id) {
        T t = baseDao.selectByPrimaryKey(id);
        return t;
    }

    @Override
    public boolean updateByPrimaryKeySelective(T entity) {
        Integer count = baseDao.updateByPrimaryKeySelective(entity);
        if(count>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean updateByPrimaryKey(T entity) {
        Integer count = baseDao.updateByPrimaryKey(entity);
        if(count>0){
            return true;
        }else{
            return false;
        }
    }
}
