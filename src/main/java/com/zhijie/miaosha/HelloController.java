package com.zhijie.miaosha;


import com.zhijie.miaosha.common.ResponseData;
import com.zhijie.miaosha.entity.Goods;
import com.zhijie.miaosha.entity.User;
import com.zhijie.miaosha.mapper.GoodsMapper;
import com.zhijie.miaosha.mapper.UserMapper;
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
    UserMapper userMapper;

    @Autowired
    GoodsMapper goodsMapper;

    @RequestMapping("/hello")
    @ResponseBody
    private ResponseData index() {
        Goods goods = goodsMapper.selectByPrimaryKey((long)1);
        logger.info(goods.toString());
        return ResponseData.successByData(goods);
    }


}
