# language: pt
Funcionalidade: Gerenciamento de Produtos

  Cenário: Criar um novo produto com sucesso
    Dado que eu tenho os dados de um novo produto
    Quando eu envio uma solicitação para criar o produto
    Então o produto deve ser criado com sucesso

  Cenário: Não deve criar produto com categoria inválida
    Dado que eu tenho os dados de um novo produto com categoria inválida
    Quando eu envio uma solicitação para criar o produto
    Então a criação do produto deve falhar com uma mensagem de categoria inválida

  Cenário: Criar produto com erro de validação
    Dado que eu tenho os dados de um novo produto com erro de validação
    Quando eu envio uma solicitação para criar o produto
    Então a criação do produto deve falhar com um erro de validação

  Cenário: Editar um produto existente com sucesso
    Dado que eu tenho os dados atualizados de um produto existente
    Quando eu envio uma solicitação para editar o produto
    Então o produto deve ser editado com sucesso

  Cenário: Editar um produto não encontrado
    Dado que eu tenho os dados atualizados de um produto inexistente
    Quando eu envio uma solicitação para editar o produto
    Então a edição do produto deve falhar com uma mensagem de produto não encontrado

  Cenário: Remover um produto com sucesso
    Dado que eu tenho o ID de um produto existente
    Quando eu envio uma solicitação para remover o produto
    Então o produto deve ser removido com sucesso

  Cenário: Remover um produto não encontrado
    Dado que eu tenho o ID de um produto inexistente
    Quando eu envio uma solicitação para remover o produto
    Então a remoção do produto deve falhar com uma mensagem de produto não encontrado

  Cenário: Listar todos os produtos com sucesso
    Quando eu envio uma solicitação para listar todos os produtos
    Então a listagem de produtos deve ser bem-sucedida

  Cenário: Listar produtos por categoria com sucesso
    Dado que eu tenho uma categoria de produto existente
    Quando eu envio uma solicitação para listar produtos por categoria
    Então a listagem de produtos por categoria deve ser bem-sucedida
