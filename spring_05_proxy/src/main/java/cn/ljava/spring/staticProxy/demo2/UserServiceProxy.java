package cn.ljava.spring.staticProxy.demo2;

/**
 * @Description: 代理增强UserService
 * @Author: Liuys
 * @CreateDate: 2021/7/7 10:10
 * @Version: 1.0
 */
public class UserServiceProxy implements UserService {

    private UserServiceImpl userService;
    public void setUserService(UserServiceImpl userService){
        this.userService = userService;
    }
    @Override
    public void add() {
        log("add");
        userService.add();
    }

    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }

    @Override
    public void update() {
        log("update");
        userService.update();
    }

    @Override
    public void query() {
        log("query");
        userService.query();
    }
    public void log(String msg){
        System.out.println("[Debug]使用了"+ msg+ "方法");
    }
}
