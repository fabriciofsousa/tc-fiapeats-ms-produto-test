package br.com.fiap.fiapeats.external.api.mapper;

import br.com.fiap.fiapeats.external.api.contracts.request.CriarProdutoRequest;
import br.com.fiap.fiapeats.external.api.contracts.request.EditarProdutoRequest;
import br.com.fiap.fiapeats.usecases.dtos.CriarProdutoDTO;
import br.com.fiap.fiapeats.usecases.dtos.EditarProdutoDTO;

import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    CriarProdutoDTO toCriarProdutoDTO(CriarProdutoRequest criarProdutoRequest);

    @Mapping(target = "id", source = "id")
    EditarProdutoDTO toEditarProdutoDTO(UUID id, EditarProdutoRequest editarProdutoRequest);
}
