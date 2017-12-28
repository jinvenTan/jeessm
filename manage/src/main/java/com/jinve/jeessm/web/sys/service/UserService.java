package com.jinve.jeessm.web.sys.service;

import com.jinve.jeessm.web.sys.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jinven
 * Created by tanjingwen on 2017/12/7.
 */
public interface UserService {
    /**
     * 根据id获取用户
     * @param d
     * @return
     */
    User get(String d);

    /**
     * 更新
     * @param user
     * @return
     */
    int update(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    int login(@Param("user") User user);

    /**
     * 查找用户
     * @return
     */
    List<User> findList();

    /**
     * 创建用户
     * @param user
     * @return
     */
    int creatUser(User user);

    /**
     * 根据用户名获取用户
     * @param id
     * @return
     */
    User getUserByUserName(String id);

    /**
     * 分页查找
     * @param page
     * @param rows
     * @return
     */
    List<User> findPage(String page,String rows);
}
