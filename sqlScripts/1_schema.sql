
CREATE TABLE IF NOT EXISTS categoria
(
    id bigint NOT NULL,
    descricao character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT categoria_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS categoria OWNER to sa;

CREATE TABLE IF NOT EXISTS produto
(
    valor numeric(38,2) NOT NULL,
    categoria_id bigint,
    id uuid NOT NULL,
    descricao character varying(255) COLLATE pg_catalog."default" NOT NULL,
    imagem_url character varying(255) COLLATE pg_catalog."default",
    nome character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT produto_pkey PRIMARY KEY (id),
    CONSTRAINT categoria_pkey FOREIGN KEY (categoria_id)
        REFERENCES categoria (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS produto OWNER to sa;
