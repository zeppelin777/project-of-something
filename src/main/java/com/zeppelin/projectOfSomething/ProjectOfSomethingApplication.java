package com.zeppelin.projectOfSomething;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * The type Project of something application.
 *
 * @author eddie
 */
@SpringBootApplication
@EnableCaching
public class ProjectOfSomethingApplication {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(ProjectOfSomethingApplication.class, args);
  }
}
