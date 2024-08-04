CREATE TABLE IF NOT EXISTS public.cliente
(
    documento character varying(255) COLLATE pg_catalog."default" NOT NULL,
    email character varying(255) COLLATE pg_catalog."default",
    nome character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT cliente_pkey1 PRIMARY KEY (documento)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.cliente
    OWNER to sa;

CREATE TABLE IF NOT EXISTS public.pedido
(
    id_pedido uuid NOT NULL,
    cliente_documento character varying(255) COLLATE pg_catalog."default",
    data_hora_criacao timestamp(6) without time zone NOT NULL,
    id_status bigint NOT NULL,
    tempo_espera integer NOT NULL,
    valor_total numeric(38,2) NOT NULL,
    CONSTRAINT pedido_pkey PRIMARY KEY (id_pedido)
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.pedido
    OWNER to sa;

CREATE TABLE IF NOT EXISTS public.pedido_produto
(
    id_produto uuid NOT NULL,
    id_pedido uuid NOT NULL,
    CONSTRAINT pedido_produto_pkey PRIMARY KEY (id_pedido, id_produto),
    CONSTRAINT fk1sojgctn8vt21b1tbuaou288m FOREIGN KEY (id_pedido)
    REFERENCES public.pedido (id_pedido) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.pedido_produto
    OWNER to sa;