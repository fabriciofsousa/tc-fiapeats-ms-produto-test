package br.com.fiap.fiapeats.domain.entities;

/**
 * Represents a category entity with an ID and description.
 */
public class Categoria {
    private final Long id;
    private final String descricao;

    /**
     * Constructs a Categoria instance.
     *
     * @param id        the ID of the category
     * @param descricao the description of the category
     * @throws IllegalArgumentException if the description is null
     */
    public Categoria(Long id, String descricao) {
        if (descricao == null) {
            throw new IllegalArgumentException("Descricao não pode ser nula");
        }
        this.id = id;
        this.descricao = descricao.substring(0, 1).toUpperCase().concat(descricao.substring(1).toLowerCase());
    }

    /**
     * Creates a new Categoria instance with the given description.
     *
     * @param descricao the description of the category
     * @return a new Categoria instance
     * @throws IllegalArgumentException if the description is null
     */
    public static Categoria adicionarDescricao(String descricao) {
        if (descricao == null) {
            throw new IllegalArgumentException("Descricao não pode ser nula");
        }
        return new Categoria(null, descricao.substring(0, 1).toUpperCase().concat(descricao.substring(1).toLowerCase()));
    }

    /**
     * Gets the ID of the category.
     *
     * @return the ID of the category
     */
    public Long getId() {
        return id;
    }

    /**
     * Gets the description of the category.
     *
     * @return the description of the category
     */
    public String getDescricao() {
        return descricao;
    }
}