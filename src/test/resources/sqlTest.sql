DELETE FROM PRODUTO;
DELETE FROM CATEGORIA;

INSERT INTO CATEGORIA(id, descricao)
VALUES (1, 'Fast Food'),
       (2, 'Side Dish'),
       (3, 'Drink'),
       (4, 'Dessert');

INSERT INTO PRODUTO(valor, categoria_id, id, descricao, nome, imagem_url)
VALUES (12.50, 1, 'a1b2c3d4-e5f6-7890-abcd-ef1234567890', 'burger, cheese, lettuce, tomato', 'Cheeseburger', 'https://example.com/images/cheeseburger.jpg'),
       (2.50, 3, 'b2c3d4e5-f6a7-8901-bcde-f23456789012', '500ml bottle of soda', 'Coca-Cola 500ml', 'https://example.com/images/coca-cola-500ml.jpg');
