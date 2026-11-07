package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.ItemMidiaDAO;
import model.ItemMidia;


// MÉTODO para atualizar item

@WebServlet("/atualizarItem")
public class AtualizarItemServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String autorDiretor = request.getParameter("autorDiretor");
        int anoLancamento = Integer.parseInt(request.getParameter("anoLancamento"));
        String genero = request.getParameter("genero");
        String sinopse = request.getParameter("sinopse");
        String tipoMidia = request.getParameter("tipoMidia");

        ItemMidia item = new ItemMidia();
        item.setId(id);
        item.setTitulo(titulo);
        item.setAutorDiretor(autorDiretor);
        item.setAnoLancamento(anoLancamento);
        item.setGenero(genero);
        item.setSinopse(sinopse);
        item.setTipoMidia(tipoMidia);

        try {
            ItemMidiaDAO dao = new ItemMidiaDAO();
            dao.atualizar(item);

            // Redireciona de volta para a lista atualizada
            response.sendRedirect("listar_produtos.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Erro ao atualizar no banco: " + e.getMessage());
        }
    }
}