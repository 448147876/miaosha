package com.zhijie.miaosha.cacheutils.base;

import com.zhijie.miaosha.cacheutils.comm.BasePrefix;
import com.zhijie.miaosha.cacheutils.comm.KeyPrefix;

public class UserKey extends BasePrefix {


	private UserKey(int expireSeconds, String prefix) {
		super(expireSeconds, prefix);
	}
	public static UserKey selectByPK = new UserKey(60*2, "PK");

}
