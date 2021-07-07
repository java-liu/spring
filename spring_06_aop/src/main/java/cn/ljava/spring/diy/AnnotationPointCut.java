package cn.ljava.spring.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;

/***
 * 方式三：使用注解方式实现AOP
 */
@Aspect //标注这是一个切面
public class AnnotationPointCut {

   /* @Pointcut(value="execution(* cn.ljava.spring.service.impl.UserServiceImpl.*(..))")
    public void PointCut(){
    } */
    @Pointcut("@annotation(cn.ljava.spring.diy.LogAnnotation)")
    public void PointCut(){
    }

    @Before("PointCut()")
    public void before(){
        System.out.println("========注解方式@Before==========");
    }

    @After("PointCut()")
    public void after(){
        System.out.println("========注解方式@After==========");
    }
    @AfterReturning("PointCut()")
    public void afterReturning(){
        System.out.println("========注解方式@afterReturning==========");
    }

    /***
     * 在环绕增强中，我们可以给定一个参数，代表我们要获取处理切入的点
     */
    @Around("PointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable{
        System.out.println("========注解方式@Around前==========");
        Signature signature = jp.getSignature();//获得签名
        System.out.println(signature);
        //执行方法
        Object proceed = jp.proceed();
        System.out.println("========注解方式@Around后==========");
        System.out.println(proceed);
    }
}
