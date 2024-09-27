package br.com.fiap.fiapeats.domain.dtos;

import br.com.fiap.fiapeats.external.api.contracts.response.ProdutoResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ListarPedidosResponse {
    private String id;
    private String cliCpf;
    private Long idStatus;
    private BigDecimal valor;
    private int tempoEspera;
    private LocalDateTime dataHoraCriacao;
    private List<ProdutoResponse> produtos;

    public ListarPedidosResponse(String id, String cliCpf, Long idStatus, BigDecimal valor, int tempoEspera, LocalDateTime dataHoraCriacao, List<ProdutoResponse> produtos) {
        this.id = id;
        this.cliCpf = cliCpf;
        this.idStatus = idStatus;
        this.valor = valor;
        this.tempoEspera = tempoEspera;
        this.dataHoraCriacao = dataHoraCriacao;
        this.produtos = produtos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCliCpf() {
        return cliCpf;
    }

    public void setCliCpf(String cliCpf) {
        this.cliCpf = cliCpf;
    }

    public Long getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Long idStatus) {
        this.idStatus = idStatus;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getTempoEspera() {
        return tempoEspera;
    }

    public void setTempoEspera(int tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public List<ProdutoResponse> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoResponse> produtos) {
        this.produtos = produtos;
    }
}
