# 🧁 Gerenciador Doceria 🧁

![JavaFX](https://img.shields.io/badge/javafx-%23FF0000.svg?style=for-the-badge&logo=javafx&logoColor=white) ![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white) ![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)

O **Gerenciador de Doceria** é uma aplicação desktop desenvolvida para o gerenciamento de docerias. Utilizando JavaFX, possui uma interface intuitiva e interativa, alem de geração de PDFs e tabelas no Excel.

## Descrição
Além da utilização de JavaFX para a interface gráfica, a aplicação também conta com uso de Hibernate para persistencia dos dados e gerenciamento de consultas e alterações no banco de dados e MySQL como gerenciador de banco de dados.
Visando facilitação e interatividade do usuário, a aplicação conta com sub-menus para separar as janelas e oque cada uma gerencia diretamente. Sendo assim, possui listado os seguintes sub-menus e algumas de suas funcionalidades:

- **INICIO** Possui informações simples como:
	- Pedidos pendentes
	- Vendas realizadas
	- Pedidos cancelados
	- Gráfico de lucro mensal
	- Gráfico de lucro anual
- **CADASTROS**  possui duas abas, sendo elas **Clientes** e **Fornecedores** além de:
	- Barra de pesquisa
	- Botão para adição de cadastro
	- Tabela
	- Opção de edição/exclusão de cadastro
	- Filtragem de dados
- **ESTOQUE** Janela para controle de estoque de itens, possuindo:
	- Informações claras sobre dados do estoque
	- Barra de pesquisa
	- Botão para adição de itens
	- Tabela
	- Filtragem de dados
	- Opção de edição/exclusão de itens
- **PRODUTOS** Design simples, com informações de total de produtos cadastrados alem de:
	- Botão para adição de produto
	- Barra de pesquisa
	- Filtragem de dados
	- Detalhes sobre o produto(itens,quantidade,peso,valor e imagem(opcional))
- **PEDIDOS** Design simples, com informações de pedidos pendentes e tambem:
	- Botão para adição de pedido
	- Barra de pesquisa
	- Filtragem de dados
	- Detalhes sobre o pedido(produtos,quantidade,cliente,valor e status dos itens)
	- Botão para gerar Orçamento
- **VENDAS** Janela para controle financeiro,possuindo:
	- Barra de pesquisa
	- Filtragem
	- Tabela com dados
	- Botão para geração de relatórios


## ⚠️ Projeto em desenvolvimento ⚠️

Este projeto ainda está em fase de desenvolvimento, tendo algumas funcionalidades ja implementadas e funcionais, e outras ainda incompletas ou ainda em planejamento.

## Funcionalidades

- [x] Animação simples do menu lateral
- [x] Redimensionamento responsivo
- [x] Cadastro de clientes
- [x] Cadastro de fornecedores
- [ ] Cadastro de pedidos
  - [x] Formulário de inclusão
  - [ ] Gerar pedido
  - [ ] Alterar pedido
  - [ ] Excluir pedido
  - [ ] Finalizar pedido
  - [ ] Filtragem 
- [ ] Controle de estoque
  - [x] Formulário de inclusão 
  - [ ] Inclusão de itens
  - [ ] Exclusão de itens
  - [ ] Filtragem
  - [ ] Sistema de notificação referente ao estoque
- [ ] Controle de vendas
  - [ ] Historico de vendas
  - [ ] Filtragem
  - [ ] Geração de relatório de vendas em Excel
- [x] Geração de Orçamento em PDF
- [x] Mapeamento das classes
- [ ] Geração de gráficos personalizados para análise de vendas, entrada e saida de produtos etc.
- [ ] Integração entre estoque e venda
- [ ] Dashboard com estatisticas de desempenho
- [ ] Sistema de autenticação
- [ ] Controle de dados
- [ ] Persistencia de dados
- [ ] API de busca de endereços

## 🔨Ferramentas
- [Java 22](https://docs.oracle.com/en/java/javase/22/)
- [Maven](https://maven.apache.org/guides/index.html)
- [JavaFX](https://www.oracle.com/java/technologies/javase/javafx-docs.html)
- [Hibernate](https://hibernate.org/orm/documentation/6.6/)
- [MySQL](https://docs.oracle.com/cd/E17952_01/)
- [OpenPDF](https://github.com/LibrePDF/OpenPDF)

  ## Execução do projeto

  Certifique-se de ter JDK 22 e Maven instalados, além do MySQL na versão 8.0 ou superior.
1. Clone o repositório:
     ```bash
     git clone https://github.com/davisonqueiroz/Projeto_Doceria.git
     ```
2. Execute o Maven para compilar e rodar.  
3. A aplicação utiliza MySQL, configure os dados no arquivo **persistence.xml** dentro da pasta META-INF.
     ```bash
      <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/seu_banco_de_dados"/>
      <property name="javax.persistence.jdbc.user" value=usuario/>
      <property name="javax.persistence.jdbc.password" value=senha/>
     ```
## Liçenca
