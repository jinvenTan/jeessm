package com.jinve.jeessm.common.support;

import com.jinve.jeessm.common.support.BaseDao;

import java.util.List;

/**
 * @author jinven
 * @create 2017-12-13 10:08
 **/
public interface CrudDao<T> extends BaseDao {

    /**
     * 获取单条数据
     * @param id
     * @return
     */
    T get(String id);

    /**
     * 获取单条数据
     * @param entity
     * @return
     */
    T get(T entity);

    /**
     * 查询所有数据，如有分页则设置分页
     * @param entity
     * @return
     */
    public List<T> findList(T entity);

    /**
     * 查询所有数据
     * @return
     */
    public List<T> findList();

    /**
     * 插入数据
     * @param entity
     * @return
     */
    public int insert(T entity);

    /**
     * 更新数据
     * @param entity
     * @return
     */
    public int update(T entity);

    /**
     * 删除数据
     * @param entity
     * @return
     */
    public int delete(T entity);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    public int delete(String id);

    /**
     * 分页查找
     * @param page
     * @param rows
     * @return
     */
    public List<T> findPage(String page,String rows);
}
