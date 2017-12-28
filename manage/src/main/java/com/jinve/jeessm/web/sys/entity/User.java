package com.jinve.jeessm.web.sys.entity;

import com.jinve.jeessm.common.support.DataEntity;
import lombok.Data;

import java.util.Date;

/**
 * Created by tanjingwen on 2017/12/6.
 */
@Data
public class User extends DataEntity{

    private static final long serialVersionUID = 1L;
    private String id;
    private String loginName;// 登录名
    private String password;// 密码
    private String no;		// 工号
    private String name;	// 姓名
    private String email;	// 邮箱
    private String phone;	// 电话
    private String mobile;	// 手机
    private String userType;// 用户类型
    private String loginIp;	// 最后登陆IP
    private Date loginDate;	// 最后登陆日期
    private String loginFlag;	// 是否允许登陆
    private String photo;	// 头像
    private String delFlag; // 删除标记
    private String remarks; //备注信息
}
