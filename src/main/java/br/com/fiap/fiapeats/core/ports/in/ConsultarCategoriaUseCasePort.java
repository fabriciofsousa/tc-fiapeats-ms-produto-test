package br.com.fiap.fiapeats.core.ports.in;

import br.com.fiap.fiapeats.core.domain.Categoria;
import br.com.fiap.fiapeats.core.domain.Produto;

public interface ConsultarCategoriaUseCasePort {
  Categoria consultar(Categoria categoria);

}
