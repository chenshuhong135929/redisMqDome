package com.redisMq;

/**
 * @Auther ChenShuHong
 * @Date 2021-06-07 10:04
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RedisMqApplication {
  public static void main(String[] args) {
    System.setProperty("spring.devtools.restart.enabled", "false");
    SpringApplication.run(RedisMqApplication.class, args);
  }
}
