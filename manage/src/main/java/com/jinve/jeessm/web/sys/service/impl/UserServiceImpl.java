package com.jinve.jeessm.web.sys.service.impl;

import com.jinve.jeessm.web.sys.dao.UserDao;
import com.jinve.jeessm.web.sys.entity.User;
import com.jinve.jeessm.web.sys.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tanjingwen on 2017/12/7.
 * @author jinwen
 */
@Service("userService")
@Transactional(readOnly = true,rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true,rollbackFor = Exception.class)
    @Cacheable(value = "userCache",key = "#id")
    public User get(String id) {
        return this.userDao.get(id);
    }

    @Override
    @Transactional(readOnly = true,rollbackFor = Exception.class)
    public User getUserByUserName(String loginname) {
        return this.userDao.getUserByLoginName(loginname);
    }

    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    @CacheEvict(value = "userCache",key = "#user.id")
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    @Transactional(readOnly = true,rollbackFor = Exception.class)
    @Cacheable(value = "userCache")
    public int login(User user) {
        int result = userDao.login(user);
        return result;
    }

    @Override
    @Transactional(readOnly = true,rollbackFor = Exception.class)
    public List<User> findList() {
        return userDao.findList();
    }

    @Override
    @Transactional(readOnly = false,rollbackFor = Exception.class)
    public int creatUser(User user) {
        return userDao.insert(user);
    }

    @Override
    public List<User> findPage(String page,String rows){
        return userDao.findPage(page,rows);
    }
}
