package com.zhijie.miaosha.service.impl;

import com.zhijie.miaosha.cacheutils.base.BaseServiceImpl;
import com.zhijie.miaosha.entity.User;
import com.zhijie.miaosha.entity.UserExample;
import com.zhijie.miaosha.mapper.UserMapper;
import com.zhijie.miaosha.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User, UserExample> implements IUserService {


}
