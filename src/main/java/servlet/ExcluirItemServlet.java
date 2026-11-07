package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.ItemMidiaDAO;

@WebServlet("/excluirItem")
public class ExcluirItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        // Pega o ID enviado pela URL
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);

        try {
            ItemMidiaDAO dao = new ItemMidiaDAO();
            dao.excluir(id); // Método que você cria no DAO: DELETE FROM item_midia WHERE id = ?

            // Redireciona de volta para a lista atualizada
            response.sendRedirect("listar_produtos.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Erro ao excluir: " + e.getMessage());
        }
    }
}