package br.com.fiap.fiapeats.external.integration.feign;

import br.com.fiap.fiapeats.external.integration.feign.request.CriarPagamentoPedidoRequest;
import br.com.fiap.fiapeats.external.integration.feign.response.CriarPagamentoPedidoResponse;
import feign.Headers;
import io.swagger.v3.oas.annotations.headers.Header;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "api-criarPedido", url = "https://api.mercadopago.com/instore/orders/qr/seller/collectors/2000983121/pos/FIAPEATSPOS001/qrs")
public interface PedidoFeign {

    @RequestMapping(method = RequestMethod.POST)
    CriarPagamentoPedidoResponse criarPedido(@RequestHeader("Authorization") String token,
                                             @RequestBody CriarPagamentoPedidoRequest criarPedidoRequest);

}

