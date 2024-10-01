package br.com.fiap.fiapeats.usecases.dtos;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class CriarPedidoDTO {

    private List<UUID> idProdutos;

    private String cliCpf;

    private BigDecimal valor;

    public CriarPedidoDTO(List<UUID> idProdutos, String cliCpf, BigDecimal valor) {
        this.idProdutos = idProdutos;
        this.cliCpf = cliCpf;
        this.valor = valor;
    }

    public List<UUID> getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(List<UUID> idProdutos) {
        this.idProdutos = idProdutos;
    }

    public String getCliCpf() {
        return cliCpf;
    }

    public void setCliCpf(String cliCpf) {
        this.cliCpf = cliCpf;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
