package com.zhijie.miaosha;


import com.zhijie.miaosha.cacheutils.base.UserKey;
import com.zhijie.miaosha.cacheutils.service.CacheService;
import com.zhijie.miaosha.common.ResponseData;
import com.zhijie.miaosha.entity.User;
import com.zhijie.miaosha.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    Logger logger = LoggerFactory.getLogger(HelloController.class);


    @Autowired
    IUserService iUserService;

    @Autowired
    CacheService cacheService;


    @RequestMapping("/user")
    @ResponseBody
    private ResponseData user() {
        User user = iUserService.selectByPrimaryKey(100);
        return ResponseData.successByData(user);
    }

    @RequestMapping("/redis")
    @ResponseBody
    private ResponseData redis() {

        User user = iUserService.selectByPrimaryKey(1);
        cacheService.set(UserKey.selectByPK, "1", user, User.class);
        user = cacheService.get(UserKey.selectByPK, "1", User.class);
        return ResponseData.successByData(user);
    }


}
