package teste;

import java.util.List;
import dao.ConexaoFactory;
import dao.ItemMidiaDAO;
import model.ItemMidia;

public class Teste_Excluir {

	public static void main(String[] args) {
		ItemMidiaDAO dao = new ItemMidiaDAO();
		
		// Definir item para deletar segundo id
		int idParaDeletar = 9;
		
		// Linha para excluir os dados do objeto no banco
		dao.excluir(idParaDeletar);

	}

}
