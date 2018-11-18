package com.zhijie.miaosha.cacheutils.base;

import com.zhijie.miaosha.cacheutils.comm.BasePrefix;
import com.zhijie.miaosha.cacheutils.comm.KeyPrefix;

public class GoodsKey extends BasePrefix {

	private GoodsKey(int expireSeconds, String prefix) {
		super(expireSeconds, prefix);
	}
	public static GoodsKey goodsInfo = new GoodsKey(60*2, "goodsInfo");

}
