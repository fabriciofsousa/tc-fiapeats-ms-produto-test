package br.com.fiap.fiapeats.external.integration.feign.response;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarPagamentoPedidoResponse {

    @JsonProperty("in_store_order_id")
    private String idPedido;

    @JsonProperty("qr_data")
    private String codigoQr;

    public CriarPagamentoPedidoResponse(String idPedido, String codigoQr) {
        this.idPedido = idPedido;
        this.codigoQr = codigoQr;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public String getCodigoQr() {
        return codigoQr;
    }
}
