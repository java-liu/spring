package cn.ljava.spring.Dao.impl;

import cn.ljava.spring.Dao.UserDao;

/**
 * @Description: java类作用描述
 * @Author: Liuys
 * @CreateDate: 2021/7/1 17:34
 * @Version: 1.0
 */
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("UserDaoImpl---add()");
    }
}
