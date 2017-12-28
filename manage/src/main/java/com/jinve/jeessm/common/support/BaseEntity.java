package com.jinve.jeessm.common.support;

import org.apache.poi.ss.formula.functions.T;

import java.io.Serializable;

/**
 * @author jinven
 * @create 2017-12-14 14:33
 **/
public abstract class BaseEntity<T> implements Serializable {
    /**
     * 当前实体分页对象
     */
    protected Page<T> page;

    /**
     * 唯一标识id
     */
    protected String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
