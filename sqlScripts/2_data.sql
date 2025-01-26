
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


INSERT INTO CATEGORIA(id, descricao)
VALUES (1, 'Lanche');
INSERT INTO CATEGORIA(id, descricao)
VALUES (2, 'Acompanhamento');
INSERT INTO CATEGORIA(id, descricao)
VALUES (3, 'Bebida');
INSERT INTO CATEGORIA(id, descricao)
VALUES (4, 'Sobremesa');

INSERT INTO PRODUTO(valor, categoria_id, id, descricao, nome, imagem_url)
VALUES (9.90, 1, 'fc7c7f37-32ea-465c-ac4b-490685e5a55f', 'pao, salsicha, molho e ketchup', 'Cachorro quente', 'https://s2-receitas.glbimg.com/nhTnuFJn8-LKjqVgIn0tRvfyI3Y=/0x0:620x500/984x0/smart/filters:strip_icc()/s.glbimg.com/po/rc/media/2012/11/16/08_37_34_881_Cachorro_Quente_com_Leite_em_P_M_rcia_Cadore_Borin_620.jpg');
INSERT INTO PRODUTO(valor, categoria_id, id, descricao, nome, imagem_url)
VALUES (6, 3, 'fa0f9dde-b305-407b-869c-71045853dea8', 'Refrigerante 600ml de garrafa', 'Pepsi 600ml', 'https://io.convertiez.com.br/m/trimais/shop/products/images/846/medium/refrigerante-pepsi-600-ml_842.jpg');