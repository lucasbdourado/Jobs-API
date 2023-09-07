# Jobs-API

**Author:** Lucas Barbosa Dourado - @lucasbdourado

## Descrição
Microsserviço desenvolvido em Java EE 8 para anúncios de vagas de emprego e gerenciamento de candidaturas. Este microsserviço irá compor um projeto desenhado e arquitetado por mim. Este microsserviço tem o objetivo de realizar todas as operações necessárias para genrencimento de funçoes e informações relacionadas a anuncio de vagas de emprego. Esta API será consumida por diversos dispositivos para realização do projeto LukeJobs.

## Estrutura do Código
- **Resource:** Camada responsável pelo mapeamento dos Endpoits que serão utilizados pela aplicação assim como gerenciamento de respostas e conteúdos da requisição HTTP.
- **DAO:** Camada responsável pela comunicação direta com o banco de dados, realizando todas operações necessárias. A conexão realizada utiliza-se de um Padrão de Projeto Singleton com conexão JDBC.
- **Service:** Camada responsável por intermediar as camadas **Resource** e **DAO** contendo a lógica para tratamento das informações recebidas pela requisição HTTP e repassando para serem armazenadas no banco de dados.
- **Domain:** Gerenciamento de Modelos utilizados para guardar e gerenciar a informações de forma mais clara.


