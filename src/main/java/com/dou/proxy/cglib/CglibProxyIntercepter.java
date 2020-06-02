package com.dou.proxy.cglib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class CglibProxyIntercepter<T> implements MethodInterceptor {

  private T target;

  public CglibProxyIntercepter(T target) {
    this.target = target;
  }

  @Override
  public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
      throws Throwable {

    log.info("cglib之前执行。。。。");

    // 第一个参数：目标对象  ，第二个参数：方法参数
    Object invoke = methodProxy.invoke(target, objects);

    log.info("cglib之后执行。。。。");

    return invoke;
  }

  public T getCglibProxy() {

    Enhancer eh = new Enhancer();
    eh.setSuperclass(this.target.getClass());
    eh.setCallback(this);

    return (T) eh.create();
  }
}
