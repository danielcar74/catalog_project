<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalhes do Item</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background-color: #f4f4f9; }
        .card { background: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 2px 4px rgba(0,0,0,0.1); max-width: 600px; }
        h2 { color: #333; }
        p { font-size: 16px; color: #555; line-height: 1.5; }
        strong { color: #222; }
        .btn { display: inline-block; padding: 8px 15px; background: #007bff; color: white; text-decoration: none; border-radius: 4px; margin-top: 15px; }
        .btn:hover { background: #0056b3; }
    </style>
</head>
<body>
    <div class="card">
        <h2>Detalhes da Mídia</h2>
        <hr>
        <p><strong>ID:</strong> ${item.id}</p>
        <p><strong>Título:</strong> ${item.titulo}</p>
        <p><strong>Autor / Diretor:</strong> ${item.autorDiretor}</p>
        <p><strong>Ano de Lançamento:</strong> ${item.anoLancamento}</p>
        <p><strong>Gênero:</strong> ${item.genero}</p>
        <p><strong>Sinopse:</strong> ${item.sinopse}</p>
        <p><strong>Tipo de Mídia:</strong> ${item.tipoMidia}</p>
        
        <a href="listar_produtos.jsp">Voltar para a Lista</a>
    </div>
</body>
</html>