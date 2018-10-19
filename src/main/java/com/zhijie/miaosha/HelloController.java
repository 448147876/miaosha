package com.zhijie.miaosha;


import com.zhijie.miaosha.common.ResponseData;
import com.zhijie.miaosha.entity.Goods;
import com.zhijie.miaosha.mapper.GoodsMapper;
import com.zhijie.miaosha.mapper.UserMapper;
import com.zhijie.miaosha.utils.HelloService;
import com.zhijie.miaosha.utils.base.GoodsKey;
import com.zhijie.miaosha.utils.service.CacheService;
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

    @Autowired
    CacheService cacheService;

    @Autowired
    HelloService helloService;

    @RequestMapping("/hello")
    @ResponseBody
    private ResponseData index() {
        Goods goods = goodsMapper.selectByPrimaryKey((long)1);
        logger.info(goods.toString());
        return ResponseData.successByData(goods);
    }


    @RequestMapping("/get")
    @ResponseBody
    private ResponseData getRedis(Long goodsId) {
        Goods goods = cacheService.get(GoodsKey.goodsInfo,String.valueOf(goodsId),Goods.class);
        if(goods == null){
            goods = goodsMapper.selectByPrimaryKey(goodsId);
            cacheService.set(GoodsKey.goodsInfo,String.valueOf(goodsId),goods,Goods.class);
        }
        logger.info(goods.toString());
        return ResponseData.successByData(goods);
    }
//
//    @RequestMapping("/set")
//    @ResponseBody
//    private ResponseData gsetRedis() {
//        Goods goods = new Goods();
//        goods.setId((long)10);
//        goods.setGoodsName("手机");
//        goods.setGoodsPrice(new BigDecimal(30));
////        goodsMapper.insert(goods);
//
//        boolean b = CacheUtils.set(GoodsKey.goodsInfo,String.valueOf(10),goods,Goods.class);
//        if(b){
//            return ResponseData.successByData(goods);
//        }else{
//            return ResponseData.error();
//        }
//
//    }

    @RequestMapping("/get2")
    @ResponseBody
    private ResponseData getRedis2(Long goodsId) {
        Goods goods = helloService.getGoodsById(goodsId);
        return ResponseData.successByData(goods);
    }


}
