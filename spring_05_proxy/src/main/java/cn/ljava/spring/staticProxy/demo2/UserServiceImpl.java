package cn.ljava.spring.staticProxy.demo2;

/**
 * @Description: java类作用描述
 * @Author: Liuys
 * @CreateDate: 2021/7/7 10:05
 * @Version: 1.0
 */
public class UserServiceImpl implements UserService {
    @Override
    public void add() {
        System.out.println("增加了一个用户");
    }

    @Override
    public void delete() {
        System.out.println("删除了一个用户");
    }

    @Override
    public void update() {
        System.out.println("修改了一个用户");
    }

    @Override
    public void query() {
        System.out.println("查询了一个用户");
    }
}
