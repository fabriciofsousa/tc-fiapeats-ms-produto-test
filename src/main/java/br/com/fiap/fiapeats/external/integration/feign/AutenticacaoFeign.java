package br.com.fiap.fiapeats.external.integration.feign;

import br.com.fiap.fiapeats.external.integration.feign.request.CriarAutenticacaoRequest;
import br.com.fiap.fiapeats.external.integration.feign.response.CriarAutenticacaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "api-gerarToken", url = "https://api.mercadopago.com/oauth/token")
public interface AutenticacaoFeign {

  @RequestMapping(method = RequestMethod.POST, produces = "application/json")
  CriarAutenticacaoResponse obterToken(
      @RequestBody CriarAutenticacaoRequest criarAutenticacaoRequest);
}
