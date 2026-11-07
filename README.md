# PROJETO INTEGRADOS TRANSDISCIPLINAR (PIT): Sistema de Catálogo de Mídias (Java Web CRUD)

Aplicação web desenvolvida POR Daniel Graziano de Carvalgo como Projeto Integrador Transdisciplinar (PIT) em Ciência da Computação. O objetivo é criar uma solução em Java para gerenciar um catálogo de mídias (livros e filmes). O stack utilizado foi Java, Servlets, JSP, JDBC e MySQL.

---

## Tecnologias Utilizadas

O projeto foi construído com sistemas gratuitos e serviu o propósito de aplicar os conceitos fundamentais da tecnologia Java para web:
* **Linguagem:** Java (JDK 17+)
* **Arquitetura:** Padrão MVC (Model-View-Controller)
* **Controladores:** Java Servlets
* **Apresentação:** JavaServer Pages (JSP) e HTML
* **Persistência:** JDBC (Java Database Connectivity)
* **Banco de Dados:** MySQL
* **Servidor de Aplicação:** Apache Tomcat

---

## Funcionalidades Principais (CRUD)

* **Create (Cadastro):** Formulário completo para registrar novos itens informando título, autor/diretor, ano de lançamento, gênero, sinopse e tipo de mídia[cite: 8, 21].
* **Read (Consulta e Listagem):** Exibição em tabela dinâmica de todos os itens cadastrados no banco de dados[cite: 8, 21].
* **Visualização de Detalhes:** Página dedicada para exibir a ficha completa de um item selecionado[cite: 8, 21].
* **Busca por Termo:** Funcionalidade de pesquisa por aproximação (título ou autor/diretor) utilizando comandos SQL seguros[cite: 8, 21].
* **Update (Edição):** Carregamento dinâmico dos dados de um item para alteração e atualização na base de dados[cite: 8, 21].
* **Delete (Exclusão):** Remoção de registros do catálogo com confirmação de segurança[cite: 8, 21].

---

## Segurança da Informação

Para mitigar vulnerabilidades em aplicações web (como usuários que tentem inserir dados e comandos no banco de dados relacional) - o sistema foi estruturado seguindo as seguintes práticas de segurança:
* **Prevenção contra SQL Injection:** Todas as operações de persistência e consulta utilizam **`PreparedStatement`**. Isso garante que as entradas fornecidas pelos usuários sejam tratadas apenas como dados e nunca como códigos executáveis.

---

## Estrutura do Projeto (usado IDE eclipse)

```text
catalogo-midias/
├─ src/main/java/
│  ├── controller/         # Servlets (Controladores HTTP)
│  ├── dao/                # Classes de Acesso a Dados (JDBC / PreparedStatement)
│  └── model/              # Classes de Domínio (Beans / POJOs)
└─ src/main/webapp/
   ├── index.jsp           # Página inicial do sistema
   ├── listar_produtos.jsp # Tabela de listagem e barra de busca
   ├── novo-produto.jsp    # Formulário de cadastro
   ├── editar-item.jsp     # Formulário de edição
   └── buscar-item.jsp     # Página de visualização de detalhes