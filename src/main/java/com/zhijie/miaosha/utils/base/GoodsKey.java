package com.zhijie.miaosha.utils.base;

public class GoodsKey extends BasePrefix{

	private GoodsKey(int expireSeconds, String prefix) {
		super(expireSeconds, prefix);
	}
	public static GoodsKey goodsInfo = new GoodsKey(60*2, "goodsInfo");

}
