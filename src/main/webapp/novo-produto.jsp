<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastrar Novo Produto</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background-color: #f4f4f9; }
        .form-container { background: #fff; padding: 25px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); max-width: 400px; }
        h2 { color: #333; margin-top: 0; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; color: #555; }
        input[type="text"], input[type="number"] { width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; }
        button { background-color: #28a745; color: white; padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; }
        button:hover { background-color: #218838; }
        .back-link { display: block; margin-top: 15px; color: #007bff; text-decoration: none; }
        .back-link:hover { text-decoration: underline; }
    </style>
</head>
<body>

    <div class="form-container">

        <h2>Cadastrar Novo Produto</h2>
        
        <!-- O formulário envia os dados via POST para um Servlet -->
        <form action="salvarProduto" method="post">
            <div class="form-group">
                <label for="nome">Nome do Produto:</label>
                <input type="text" id="titulo" name="titulo" required>
            </div>
            
            <div class="form-group">
                <label for="preco">Autor / Diretor:</label>
                <input type="text" id="autordiretor" name="autordiretor" required>
            </div>
            
            <div class="form-group">
                <label for="preco">Ano Lançamento:</label>
                <input type="number" id="anolancamento" name="anolancamento" required>
            </div>
            
            <div class="form-group">
                <label for="preco">Genero:</label>
                <input type="text" id="genero" name="genero" required>
            </div>                     
            
            <div class="form-group">
                <label for="quantidade">Sinopse:</label>
                <input type="text" id="sinopse" name="sinopse" required>
            </div>
            
            <div class="form-group">
                <label for="quantidade">Tipo Midia:</label>
                <input type="text" id="tipomidia" name="tipomidia" required>            
            </div>
            <button type="submit">Salvar Produto</button>
        </form>
        
        <a href="listar_produtos.jsp" class="back-link">Voltar para a lista</a>
        <a href="index.jsp">Página Principal</a>
    </div>

</body>
</html>