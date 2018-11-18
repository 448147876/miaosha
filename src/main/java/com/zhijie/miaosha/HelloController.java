package com.zhijie.miaosha;


import com.zhijie.miaosha.cacheutils.service.HelloServiceImpl;
import com.zhijie.miaosha.common.ResponseData;
import com.zhijie.miaosha.entity.Goods;
import com.zhijie.miaosha.entity.User;
import com.zhijie.miaosha.mapper.GoodsMapper;
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

    //    @Autowired
//    UserDao userDao;
//
    @Autowired
    GoodsMapper goodsMapper;
//
//    @Autowired
//    CacheService cacheService;

    @Autowired
    HelloServiceImpl helloService;


//    @RequestMapping("/hello")
//    @ResponseBody
//    private ResponseData index() {
//        Goods goods = goodsMapper.selectByPrimaryKey((long)1);
//        logger.info(goods.toString());
//        return ResponseData.successByData(goods);
//    }
//
//
//    @RequestMapping("/get")
//    @ResponseBody
//    private ResponseData getRedis(Long goodsId) {
//        Goods goods = cacheService.get(GoodsKey.goodsInfo,String.valueOf(goodsId),Goods.class);
//        if(goods == null){
//            goods = goodsMapper.selectByPrimaryKey(goodsId);
//            cacheService.set(GoodsKey.goodsInfo,String.valueOf(goodsId),goods,Goods.class);
//        }
//        logger.info(goods.toString());
//        return ResponseData.successByData(goods);
//    }
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

//    @RequestMapping("/get2")
//    @ResponseBody
//    private ResponseData getRedis2(Long goodsId) {
//        Goods goods = helloService.getGoodsById(goodsId);
//        return ResponseData.successByData(goods);
//    }
//
//    @RequestMapping("/get3")
//    @ResponseBody
//    private ResponseData getRedis3(Integer userId) {
//        User user = cacheService.getByPK(UserKey.selectByPK,userId,User.class);
//        return ResponseData.successByData(user);
//    }
//
//    @RequestMapping("/get4")
//    @ResponseBody
//    private ResponseData getRedis4(Integer userId) {
//
//        User user = new User();
//        user.setId(userId);
//        user.setName("老王");
////        User user = cacheService.getByPK(UserKey.selectByPK,userId,User.class);
//        boolean bb = cacheService.insertByPK(UserKey.selectByPK,userId,user,User.class);
//        return ResponseData.successByData(user);
//    }
//
//    @RequestMapping("/get5")
//    @ResponseBody
//    private ResponseData getRedis5(Integer userId) {
//
//        User user = new User();
//        user.setId(userId);
//        user.setName("老王1");
////        User user = cacheService.getByPK(UserKey.selectByPK,userId,User.class);
//        boolean bb = cacheService.updataByPK(UserKey.selectByPK,userId,user,User.class);
//        return ResponseData.successByData(user);
//    }
//
//    @RequestMapping("/get6")
//    @ResponseBody
//    private ResponseData getRedis6(Integer userId) {
//
//        User user = new User();
//        user.setId(userId);
//        user.setName("老王1");
////        User user = cacheService.getByPK(UserKey.selectByPK,userId,User.class);
//        boolean bb = cacheService.deleteByPK(UserKey.selectByPK,userId);
//        return ResponseData.successByData(user);
//    }

    @RequestMapping("/get7")
    @ResponseBody
    public ResponseData getRedis7(Long userId) {

        Goods user = goodsMapper.selectByPrimaryKey(userId);
        return ResponseData.successByData(user);
    }

    @RequestMapping("/get8")
    @ResponseBody
    public ResponseData getRedis8(Long userId) {

        Goods user = helloService.selectByPrimaryKey(userId);
        return ResponseData.successByData(user);
    }


}
