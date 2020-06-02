package com.dou.proxy.jdk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// jdk代理
@Slf4j
public class JDKProxyHandler<T> implements InvocationHandler {

  // 目标
  private T target;

  // 构造方法
  public JDKProxyHandler(T target) {
    this.target = target;
  }

  /**
   * @param proxy
   * @param method 方法
   * @param args 参数
   * @return
   * @throws Throwable
   */
  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

    log.info("之前执行。。。。");
    Object invoke = method.invoke(target, args);
    log.info("之后执行。。。。");
    return null;
  }

  /**
   * 获取代理类
   *
   * @return
   */
  public T getProxy() {

    // 第一个参数：类加载器  ，第二个参数：目标类的接口，第三个参数：InvocationHandler
    return (T)
        Proxy.newProxyInstance(
            Thread.currentThread().getContextClassLoader(),
            target.getClass().getInterfaces(),
            this::invoke);
  }
}
