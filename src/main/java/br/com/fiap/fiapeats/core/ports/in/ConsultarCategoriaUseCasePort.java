package br.com.fiap.fiapeats.core.ports.in;

import br.com.fiap.fiapeats.core.domain.Categoria;

public interface ConsultarCategoriaUseCasePort {
  Categoria consultar(Categoria categoria);
}
