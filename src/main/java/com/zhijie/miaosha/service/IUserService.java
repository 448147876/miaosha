package com.zhijie.miaosha.service;


import com.zhijie.miaosha.cacheutils.comm.BaseService;
import com.zhijie.miaosha.cacheutils.comm.Cacheable;
import com.zhijie.miaosha.entity.User;

public interface IUserService extends BaseService {

    User getByID(Integer userId);
}
