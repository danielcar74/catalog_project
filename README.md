# 📚 Sistema de Catálogo de Mídias (Java Web CRUD)

Aplicação web desenvolvida como Projeto Integrador Transdisciplinar (PIT) em Ciência da Computação, com o objetivo de gerenciar um catálogo de mídias (livros, séries e filmes) utilizando Java, Servlets, JSP, JDBC e MySQL[cite: 8, 25].

---

## 🚀 Tecnologias Utilizadas

O projeto foi construído sem o uso de frameworks pesados, aplicando os conceitos fundamentais da tecnologia Java para web:
* **Linguagem:** Java (JDK 17+)[cite: 8, 11]
* **Arquitetura:** Padrão MVC (Model-View-Controller)
* **Controladores:** Java Servlets[cite: 25]
* **Apresentação (View):** JavaServer Pages (JSP) com HTML5 e CSS3 moderno[cite: 25]
* **Persistência:** JDBC (Java Database Connectivity)[cite: 25]
* **Banco de Dados:** MySQL
* **Servidor de Aplicação:** Apache Tomcat[cite: 25]

---

## ⚙️ Funcionalidades Principais (CRUD)

* **Create (Cadastro):** Formulário completo para registrar novos itens informando título, autor/diretor, ano de lançamento, gênero, sinopse e tipo de mídia[cite: 8, 21].
* **Read (Consulta e Listagem):** Exibição em tabela dinâmica de todos os itens cadastrados no banco de dados[cite: 8, 21].
* **Visualização de Detalhes:** Página dedicada para exibir a ficha completa de um item selecionado[cite: 8, 21].
* **Busca por Termo:** Funcionalidade de pesquisa por aproximação (título ou autor/diretor) utilizando comandos SQL seguros[cite: 8, 21].
* **Update (Edição):** Carregamento dinâmico dos dados de um item para alteração e atualização na base de dados[cite: 8, 21].
* **Delete (Exclusão):** Remoção de registros do catálogo com confirmação de segurança[cite: 8, 21].

---

## 🔒 Segurança da Informação

Com o objetivo de mitigar vulnerabilidades comuns em aplicações web, o sistema foi estruturado seguindo boas práticas de segurança[cite: 24, 27]:
* **Prevenção contra SQL Injection:** Todas as operações de persistência e consulta utilizam **`PreparedStatement`** do JDBC, garantindo que as entradas fornecidas pelos usuários sejam tratadas estritamente como dados literais e nunca como códigos executáveis pelo SGBD[cite: 27, 36, 37].

---

## 📂 Estrutura do Projeto

```text
catalogo-midias/
├── src/main/java/
│   ├── controller/     # Servlets (Controladores HTTP)
│   ├── dao/            # Classes de Acesso a Dados (JDBC / PreparedStatement)
│   └── model/          # Classes de Domínio (Beans / POJOs)
└── src/main/webapp/
    ├── index.jsp           # Página inicial do sistema
    ├── listar_produtos.jsp # Tabela de listagem e barra de busca
    ├── novo-produto.jsp    # Formulário de cadastro
    ├── editar-item.jsp     # Formulário de edição
    └── buscar-item.jsp     # Página de visualização de detalhes