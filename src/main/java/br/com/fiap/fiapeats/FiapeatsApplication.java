package br.com.fiap.fiapeats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication(scanBasePackages = "br.com.fiap.fiapeats")
public class FiapeatsApplication {

  public static void main(String[] args) {
    SpringApplication.run(FiapeatsApplication.class, args);
  }
}
