package br.com.fiap.fiapeats.usecases.categoria;

import br.com.fiap.fiapeats.entities.Categoria;
import br.com.fiap.fiapeats.interfaces.in.categoria.ConsultarCategoriaUseCaseInterface;
import br.com.fiap.fiapeats.interfaces.out.CategoriaRepositoryInterface;

public class ConsultarCategoriaUseCaseImpl implements ConsultarCategoriaUseCaseInterface {

  private final CategoriaRepositoryInterface categoriaRepositoryInterface;

  public ConsultarCategoriaUseCaseImpl(CategoriaRepositoryInterface categoriaRepositoryInterface) {
    this.categoriaRepositoryInterface = categoriaRepositoryInterface;
  }

  @Override
  public Categoria consultar(Categoria categoria) {
    return categoriaRepositoryInterface.consultar(categoria);
  }
}
