# API desenvolvida para o desafio de contracão SeaTech

* O Banco de dados utilizado foi o H2, um banco em memoria, geralmente utilizado para realizacão de teste. Quando a aplicão
  é reiniciada os dados cadastrados são perdidos.

* Para baixar a depêndencias do projeto e gerar classes e bibliotecas basta executar o comando "mvn clean install compile". 

* A API conta com três endpoints (As chamadas via postman com authenticacao simples estão disponiveis no zip do projeto)

* "/client/cadastrarCliente": Permite cadastras um novo cliente, autorizado apenas para o usuario (admin/123qwe!@#)
* "/client/obterClientPorCpf/{cpf}": Obtem o cliente cadastrado pelo cpf, autorizado para os dois usuarios da aplicacão(admin/123qwe!@# & user/123qwe123)
* "/client/obterCep/{cep}": Recupera o cep com integracão com o servico https://viacep.com.br/, autorizado para os dois usuarios da aplicacão

