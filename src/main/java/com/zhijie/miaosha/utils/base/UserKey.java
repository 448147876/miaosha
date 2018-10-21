package com.zhijie.miaosha.utils.base;

public class UserKey extends BasePrefix{

	private UserKey(int expireSeconds, String prefix) {
		super(expireSeconds, prefix);
	}
	public static UserKey selectByPK = new UserKey(60*2, "PK");

}
