package br.com.fiap.fiapeats.domain.enums;

public enum StatusPedido {
    PENDENTE(1, "Pendente"),
    RECEBIDO(2, "Recebido"),
    EM_PREPARACAO(3, "Em Preparação"),
    PRONTO(4, "Pronto"),
    FINALIZADO(5, "Finalizado"),
    CANCELADO(6, "Cancelado"),
    DESCONHECIDO(0, "Desconhecido");

    private final int codigo;
    private final String descricao;

    StatusPedido(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static String obterDescricaoPorCodigo(Long codigoStatus) {
        if (codigoStatus == null) {
            return "Código de status inválido";
        }

        for (StatusPedido status : StatusPedido.values()) {
            if (status.getCodigo() == codigoStatus.intValue()) {
                return status.getDescricao();
            }
        }
        return DESCONHECIDO.getDescricao();
    }

}
