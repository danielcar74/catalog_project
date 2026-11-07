package servlet; // ou package servlet; dependendo de como está o seu pacote

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.ItemMidiaDAO;
import model.ItemMidia;

@WebServlet("/carregarItem")
public class CarregarItemServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        
        try {
            ItemMidiaDAO dao = new ItemMidiaDAO();
            ItemMidia item = dao.buscarPorId(id);
            
            request.setAttribute("item", item);
            request.getRequestDispatcher("editar-item.jsp").forward(request, response);
            
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Erro ao carregar item para edição: " + e.getMessage());
        }
    }
}