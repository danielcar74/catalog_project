package teste;

import dao.ConexaoFactory;
import model.ItemMidia;
import dao.ItemMidiaDAO;

public class Teste_Criar {

	public static void main(String[] args) {
		// novo testeCriar no package teste
		ItemMidia novoItem = new ItemMidia(
				"bla bla bla",
				"Roberto S",
				1998,
				"Policial",
				"Um livro sobre conversar.",
				"Livro"
				);
		
		// Instância para inserir dados na tabela ITemMidia na base catalog_db
		ItemMidiaDAO dao = new ItemMidiaDAO();
		dao.inserir(novoItem);

	}

}
