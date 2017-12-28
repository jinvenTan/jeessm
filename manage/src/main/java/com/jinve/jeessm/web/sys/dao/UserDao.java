package com.jinve.jeessm.web.sys.dao;


import com.jinve.jeessm.common.support.CrudDao;
import com.jinve.jeessm.common.support.annotation.MyBatisDao;
import com.jinve.jeessm.web.sys.entity.User;

/**
 * 用户接口
 * @author jinven
 */
@MyBatisDao
public interface UserDao extends CrudDao<User> {
    /**
     * 用户登录
     * @param user
     * @return
     */
    int login(User user);

    /**
     * 根据登录名称查找用户
     * @param loginname
     * @return
     */
    User getUserByLoginName(String loginname);
}