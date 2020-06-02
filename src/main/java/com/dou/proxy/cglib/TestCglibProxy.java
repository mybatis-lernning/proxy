package com.dou.proxy.cglib;

import com.dou.proxy.service.UserService;
import com.dou.proxy.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

// 测试cglib动态代理
@Slf4j
public class TestCglibProxy {

  public static void main(String[] args) {

    // 目标对象
    UserServiceImpl userServiceImpl = new UserServiceImpl();

    // 代理类
    CglibProxyIntercepter<UserService> userServiceCglibProxyIntercepter =
        new CglibProxyIntercepter<>(userServiceImpl);

    // 获取代理对象
    UserService cglibProxy = userServiceCglibProxyIntercepter.getCglibProxy();

    // 执行目标方法
    cglibProxy.eat();
  }
}
