<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.ItemMidia" %>
<%
    // Recupera o objeto 'item' que o Servlet mandou
    ItemMidia item = (ItemMidia) request.getAttribute("item");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Item de Mídia</title>
</head>
<body>
    <h2>Editar Item</h2>
    
    <form action="atualizarItem" method="post">
        <!-- CAMPO OCULTO PARA GUARDAR O ID -->
        <input type="hidden" name="id" value="<%= item.getId() %>">
        
        <label>Título:</label><br>
        <input type="text" name="titulo" value="<%= item.getTitulo() %>" required><br><br>
        
        <label>Autor / Diretor:</label><br>
        <input type="text" name="autorDiretor" value="<%= item.getAutorDiretor() %>"><br><br>
        
        <label>Ano de Lançamento:</label><br>
        <input type="number" name="anoLancamento" value="<%= item.getAnoLancamento() %>"><br><br>
        
        <label>Gênero:</label><br>
        <input type="text" name="genero" value="<%= item.getGenero() %>"><br><br>
        
        <label>Sinopse:</label><br>
        <textarea name="sinopse"><%= item.getSinopse() %></textarea><br><br>
        
        <label>Tipo de Mídia:</label><br>
        <input type="text" name="tipoMidia" value="<%= item.getTipoMidia() %>"><br><br>
        
        <button type="submit">Salvar Alterações</button>
    </form>
    
    <br>
    <a href="listar_produtos.jsp">Voltar para a lista</a>
</body>
</html>