package br.com.fiap.fiapeats.adapter.controller.mapper;

import br.com.fiap.fiapeats.adapter.controller.contracts.request.CriarProdutoRequest;
import br.com.fiap.fiapeats.adapter.controller.contracts.request.EditarProdutoRequest;
import br.com.fiap.fiapeats.adapter.controller.contracts.response.CriarProdutoResponse;
import br.com.fiap.fiapeats.adapter.controller.contracts.response.EditarProdutoResponse;
import br.com.fiap.fiapeats.entities.Categoria;
import br.com.fiap.fiapeats.entities.Produto;
import java.util.UUID;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

  default Produto criarProdutoRequestToProduto(CriarProdutoRequest criarProdutoRequest) {
    return new Produto(
        criarProdutoRequest.getNome(),
        criarProdutoRequest.getDescricao(),
        criarProdutoRequest.getValor(),
        Categoria.adicionarDescricao(criarProdutoRequest.getCategoria()),
        criarProdutoRequest.getImagemUrl());
  }

  default Produto editarProdutoRequestToProduto(
      UUID id, EditarProdutoRequest editarProdutoRequest) {
    return new Produto(
        id,
        editarProdutoRequest.getNome(),
        editarProdutoRequest.getDescricao(),
        editarProdutoRequest.getValor(),
        Categoria.adicionarDescricao(editarProdutoRequest.getCategoria()),
        editarProdutoRequest.getImagemUrl());
  }

  default CriarProdutoResponse toCriarProdutoResponse(Produto produto) {
    return new CriarProdutoResponse(
        produto.getId(),
        produto.getNome(),
        produto.getDescricao(),
        produto.getValor(),
        produto.getCategoria().getDescricao(),
        produto.getImagemUrl());
  }

  default EditarProdutoResponse toEditarProdutoResponse(Produto produto) {
    return new EditarProdutoResponse(
        produto.getId(),
        produto.getNome(),
        produto.getDescricao(),
        produto.getValor(),
        produto.getCategoria().getDescricao(),
        produto.getImagemUrl());
  }
}
