package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.ItemMidiaDAO;
import model.ItemMidia;

// O @WebServlet define o endereço que o formulário HTML vai chamar
@WebServlet("/salvarProduto")
public class SalvarProdutoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Configura a codificação para aceitar acentos corretamente
        request.setCharacterEncoding("UTF-8");
        
        // 2. Pega os dados digitados no formulário HTML (usando os 'name' dos inputs)
        String titulo = request.getParameter("titulo");
        String autordiretor = request.getParameter("autordiretor");
        String anolancamentoStr = request.getParameter("anolancamento");
        String genero = request.getParameter("genero");
        String sinopse = request.getParameter("sinopse");
        String tipomidia = request.getParameter("tipomidia");
        int anolancamento = Integer.parseInt(anolancamentoStr);// Converte STRING em INT / para os tipos corretos do Java
        
        // 3. INSTANCIA o objeto Produto (criando o "molde" preenchido na memória)
        ItemMidia produto = new ItemMidia();
        produto.setTitulo(titulo);
        produto.setAutorDiretor(autordiretor);
        produto.setAnoLancamento(anolancamento);
        produto.setGenero(genero);
        produto.setSinopse(sinopse);
        produto.setTipoMidia(tipomidia);

        
        try {
            // 4. INSTANCIA o DAO e chama o método para gravar no MySQL - e INSERT no banco
            ItemMidiaDAO dao = new ItemMidiaDAO();
            dao.inserir(produto); // Executa o INSERT no banco
            
            // 5. Redireciona o usuário de volta para a lista de produtos
            response.sendRedirect("listar_produtos.jsp");
            
        } catch (Exception e) {
            e.printStackTrace();
            // Print em caso de erro no banco
            response.getWriter().println("Erro ao salvar produto no banco: " + e.getMessage());
        }
    }
}