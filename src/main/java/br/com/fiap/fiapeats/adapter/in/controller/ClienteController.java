package br.com.fiap.fiapeats.adapter.in.controller;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.CriarClienteRequest;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.CriarClienteResponse;
import br.com.fiap.fiapeats.core.domain.Cliente;
import br.com.fiap.fiapeats.core.ports.in.CriarClienteUseCasePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

  Logger logger = LoggerFactory.getLogger(ClienteController.class);

  @Autowired private CriarClienteUseCasePort useCase;

  @PostMapping
  public ResponseEntity<Object> cadastrarCliente(
      @RequestBody CriarClienteRequest criarClienteRequest) {
    logger.info("Requisição para criar cliente recebida");

    Cliente cliente =
        new Cliente(
            criarClienteRequest.getNome(),
            criarClienteRequest.getEmail(),
            criarClienteRequest.getDocumento());

    useCase.criar(cliente);

    return ResponseEntity.status(201)
        .body(
            new CriarClienteResponse(
                cliente.getNome(), cliente.getEmail(), cliente.getDocumento()));
  }
}
