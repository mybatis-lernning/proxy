package com.dou.proxy.service.impl;

import com.dou.proxy.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserServiceImpl implements UserService {
  @Override
  public void eat() {

    log.info("吃。。。。。");
  }
}
