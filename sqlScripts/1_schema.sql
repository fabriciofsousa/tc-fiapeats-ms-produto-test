CREATE TABLE IF NOT EXISTS cliente
(
    documento character varying(255) COLLATE pg_catalog."default" NOT NULL,
    email character varying(255) COLLATE pg_catalog."default",
    nome character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT cliente_pkey PRIMARY KEY (documento)
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS cliente OWNER to sa;

CREATE TABLE IF NOT EXISTS categoria
(
    id bigint NOT NULL,
    descricao character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT categoria_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS categoria OWNER to sa;


CREATE TABLE IF NOT EXISTS pedido
(
    tempo_espera integer NOT NULL,
    valor_total numeric(38,2) NOT NULL,
    data_hora_criacao timestamp(6) without time zone NOT NULL,
    id_status bigint NOT NULL,
    id_pedido uuid NOT NULL,
    cliente_documento character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT pedido_pkey PRIMARY KEY (id_pedido)
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS pedido OWNER to sa;

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


CREATE TABLE IF NOT EXISTS pedido_produtos
(
    pedido_entity_id_pedido uuid NOT NULL,
    produtos_id uuid NOT NULL,
    CONSTRAINT pedido_produtos_pkey PRIMARY KEY (pedido_entity_id_pedido, produtos_id),
    CONSTRAINT pedido_pkey FOREIGN KEY (pedido_entity_id_pedido)
        REFERENCES pedido (id_pedido) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkjbeb9e1fpew7efynuggyfyk28 FOREIGN KEY (produtos_id)
        REFERENCES produto (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;
ALTER TABLE IF EXISTS pedido_produtos OWNER to sa;