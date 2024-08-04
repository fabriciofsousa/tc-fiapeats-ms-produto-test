package br.com.fiap.fiapeats.adapter.configuration;

import br.com.fiap.fiapeats.adapter.out.persistence.entities.CategoriaEntity;
import br.com.fiap.fiapeats.adapter.out.persistence.repository.CategoriaRepositoryJPA;
import br.com.fiap.fiapeats.core.domain.Categoria;
import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader implements CommandLineRunner {

  private CategoriaRepositoryJPA categoriaRepositoryJPA;

  public DataLoader(CategoriaRepositoryJPA categoriaRepositoryJPA) {
    this.categoriaRepositoryJPA = categoriaRepositoryJPA;
  }

  @Override
  public void run(String... args) throws Exception {
    Arrays.stream(Categoria.Enum.values())
        .forEach(
            categoria ->
                categoriaRepositoryJPA.save(
                    new CategoriaEntity(categoria.getId(), categoria.getDescricao())));
  }
}
