package cn.ljava.spring.controller;

import cn.ljava.spring.diy.LogAnnotation;
import org.junit.Test;

public class TestController {
    @Test
    @LogAnnotation(value = "bbbbb")
    public void testAop(){
        System.out.println("aaaa");
    }
}
