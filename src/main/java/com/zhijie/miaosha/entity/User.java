package com.zhijie.miaosha.entity;

import com.zhijie.miaosha.cacheutils.base.BaseEntity;

public class User extends BaseEntity {
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}