package com.jinve.jeessm.common.support;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jinve.jeessm.common.utils.IdGen;
import com.jinve.jeessm.web.sys.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * @author jinven
 * @create 2017-12-13 11:23
 **/
public abstract class DataEntity<T> extends BaseEntity<T>{
    private static final long serialVersionUID = 1L;
    /**
     *  创建日期
     */
    protected Date createDate;
    /**
     * 更新日期
     */
    protected Date updateDate;

    /**
     * 插入之前执行方法，需要手动调用
     */
    public void preInsert(){
        setId(IdGen.uuid());
        this.updateDate = new Date();
        this.createDate = this.updateDate;
    }

    /**
     * 更新之前执行方法，需要手动调用
     */
    public void preUpdate(){
        this.updateDate = new Date();
    }


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

}
