# TC-FiapEats
Projeto inicial para entrega do Tech Challenge



## Executando o projeto via docker

Foi criado o arquivo na raiz docker-compose.yaml que contempla os 3 itens necessários para compor o ambiente completo de nosso sistema, sendo eles:
- Postgress: imagem do banco de dados usado no projeto
- PgAdmin: interface para manipularmos dados, verificar mudanças e administrar o banco
- Spring: app criada

### Executar em tempo de desenvolvimento

Enquanto estiver desenvolvendo, utilize o comando abaixo para que o docker suba apenas o ambiente de banco de dados:

```bash
docker compose --profile database up -d
```
desta maneira, a aplicação pode ser executada localmente e ela se conectará ao banco exposto pelo docker

### Executar todo o ambiente para homologação

Uma vez que o desenvolvimento seja concluído, para avaliar uma entrega de outro desenvolvedor o correto é executar todo o ambiente pelo docker, avaliando se a aplicação demonstra um comportamento diferente quando está dockerizada. 

Execute o seguinte comando:
```bash
docker compose --profile fullenv up -d
```
