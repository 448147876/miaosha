package com.zhijie.miaosha.service;

import com.zhijie.miaosha.common.BaseServiceImpl;
import com.zhijie.miaosha.entity.User;
import com.zhijie.miaosha.mapper.UserDao;
import com.zhijie.miaosha.service.impl.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao, User> implements IUserService {



}
