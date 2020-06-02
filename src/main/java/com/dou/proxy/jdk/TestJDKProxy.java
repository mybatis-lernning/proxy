package com.dou.proxy.jdk;

import com.dou.proxy.service.UserService;
import com.dou.proxy.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

// 测试jdk动态代理
@Slf4j
public class TestJDKProxy {

  public static void main(String[] args) {

    // 目标对象
    UserServiceImpl userServiceImpl = new UserServiceImpl();

    // 代理类
    JDKProxyHandler<UserService> userServiceJDKProxyHandler =
        new JDKProxyHandler<UserService>(userServiceImpl);

    // 代理对象
    UserService proxy = userServiceJDKProxyHandler.getProxy();

    // 代理类调用方法，执行代理类的invoke方法
    proxy.eat();
  }
}
