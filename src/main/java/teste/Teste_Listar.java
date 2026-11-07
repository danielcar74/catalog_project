package teste;

import java.util.List;
import dao.ConexaoFactory;
import dao.ItemMidiaDAO;
import model.ItemMidia;

public class Teste_Listar {

    public static void main(String[] args) {
        ItemMidiaDAO dao = new ItemMidiaDAO();
        
        // Chamando o método que busca tudo no banco
        List<ItemMidia> itens = dao.listarTodos();

        System.out.println("--- LISTA DE ITENS CADASTRADOS NO BANCO ---");
        
        // Percorrendo a lista e mostrando cada item no console
        for (ItemMidia item : itens) {
            System.out.println("ID: " + item.getId());
            System.out.println("Título: " + item.getTitulo());
            System.out.println("Autor/Diretor: " + item.getAutorDiretor());
            System.out.println("Ano: " + item.getAnoLancamento());
            System.out.println("Gênero: " + item.getGenero());
            System.out.println("Tipo: " + item.getTipoMidia());
            System.out.println("----------------------------------------");
        }
    }
}
