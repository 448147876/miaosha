package com.zhijie.miaosha.controller;


import com.zhijie.miaosha.common.ResponseData;
import com.zhijie.miaosha.entity.Goods;
import com.zhijie.miaosha.entity.User;
import com.zhijie.miaosha.mapper.GoodsMapper;
import com.zhijie.miaosha.mapper.UserDao;
import com.zhijie.miaosha.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloController {

    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    UserDao userDao;

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/hello")
    @ResponseBody
    private ResponseData index() {
        Goods goods = goodsMapper.selectByPrimaryKey((long)1);
        logger.info(goods.toString());
        return ResponseData.successByData(goods);
    }

    @RequestMapping("/user")
    @ResponseBody
    private ResponseData user() {
        User user = userDao.selectByPrimaryKey(1);
        return ResponseData.successByData(user);
    }

    @RequestMapping("/user2")
    @ResponseBody
    private ResponseData user2() {
        User user = userService.selectByPrimaryKey(1);
        return ResponseData.successByData(user);
    }


}
