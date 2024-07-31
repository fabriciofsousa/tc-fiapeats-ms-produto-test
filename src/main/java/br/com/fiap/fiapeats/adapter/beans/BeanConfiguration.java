package br.com.fiap.fiapeats.adapter.beans;

import br.com.fiap.fiapeats.core.usecases.PedidoUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
  @Bean
  public PedidoUseCaseImpl pedidoUseCasePort() {
    return new PedidoUseCaseImpl();
  }
}
