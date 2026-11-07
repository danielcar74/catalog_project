<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.ItemMidia" %>
<%@ page import="dao.ItemMidiaDAO" %>
<%@ page import="dao.ConexaoFactory" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Catálogo - Lista de Produtos</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background-color: #f4f4f9; }
        h2 { color: #333; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; background: #fff; }
        th, td { padding: 12px; border: 1px solid #ddd; text-align: left; }
        th { background-color: #007bff; color: white; }
        tr:nth-child(even) { background-color: #f9f9f9; }
        .btn-acao { color: #007bff; text-decoration: none; }
        .btn-acao:hover { text-decoration: underline; }
    </style>
</head>
<body>

    <h2>Lista de Produtos Cadastrados</h2>
    
    <!-- Formulário de Busca Simples -->
    <form action="listar_produtos.jsp" method="get">
        <input type="text" name="termo" placeholder="Pesquisar por título ou autor..." style="padding: 6px; width: 250px;" value="<%= request.getParameter("termo") != null ? request.getParameter("termo") : "" %>">
        <button type="submit" style="padding: 6px 12px;">Buscar</button>
        <a href="listar_produtos.jsp" style="margin-left: 10px;">Limpar Filtro</a>
    </form>
    <br>

    <!-- Links de Navegação -->
    <a href="novo-produto.jsp">Cadastrar outro item</a> |
    <a href="index.jsp">Voltar ao Início</a>

    <table>
        <tr>
            <th>ID</th>
            <th>Título</th>
            <th>Autor / Diretor</th>
            <th>Ano Lançamento</th>
            <th>Gênero</th>
            <th>Sinopse</th>
            <th>Tipo Mídia</th>                                    
            <th>Ações</th>                                    
        </tr>
        
        <%
            try {
                ItemMidiaDAO dao = new ItemMidiaDAO();
                String termo = request.getParameter("termo");
                List<ItemMidia> lista;
                
                // Define se traz a lista filtrada ou completa
                if (termo != null && !termo.trim().isEmpty()) {
                    lista = dao.buscarPorTermo(termo);
                } else {
                    lista = dao.listarTodos();
                }
                
                if (lista != null && !lista.isEmpty()) {
                    for (ItemMidia p : lista) {
        %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getTitulo() %></td>
            <td><%= p.getAutorDiretor() %></td>
            <td><%= p.getAnoLancamento() %></td>
            <td><%= p.getGenero() %></td>   
            <td><%= p.getSinopse() %></td>
            <td><%= p.getTipoMidia() %></td>              
            <td>
                <a class="btn-acao" href="buscarItem?id=<%= p.getId() %>">Detalhes</a> | 
                <a class="btn-acao" href="carregarItem?id=<%= p.getId() %>">Editar</a> | 
                <a class="btn-acao" href="excluirItem?id=<%= p.getId() %>" onclick="return confirm('Tem certeza que deseja excluir?');" style="color: red;">Excluir</a>
            </td>           
        </tr>
        <% 
                    }
                } else {
        %>
        <tr>
            <td colspan="8" style="text-align: center;">Nenhum produto encontrado.</td>
        </tr>
        <% 
                }
            } catch (Exception e) {
        %>
        <tr>
            <td colspan="8" style="color: red; text-align: center;">Erro ao carregar dados: <%= e.getMessage() %></td>
        </tr>
        <% 
            } 
        %>
    </table>  

</body>
</html>