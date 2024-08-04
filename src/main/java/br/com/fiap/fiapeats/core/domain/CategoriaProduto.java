package br.com.fiap.fiapeats.core.domain;

public enum CategoriaProduto {

    LANCHE(1, "Lanche"),
    ACOMPANHAMENTO(2, "Acompanhamento"),
    BEBIDA(3, "Bebida"),
    SOBREMESA(4, "Sobremesa");

    private int codigo;
    private String descricao;

    private CategoriaProduto(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    private String getDescricao(){
        return descricao;
    }

    private int getCodigo(){
        return codigo;
    }

    public static Object getCategoria(String descricao){
        for(CategoriaProduto value : CategoriaProduto.values()){
            if(value.getDescricao().equals(descricao)) {
                return value.getCodigo();
            }
        }
        return null;
    }

}
