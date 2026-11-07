package dao;
import model.ItemMidia;

public class TestarConexao {

	public static void main(String[] args) {
		// Criar um objeto teste na base do MySQL DB
		ItemMidia novoItem = new ItemMidia(
				"Matrix",
				"Wachowski",
				1999,
				"Ficção Científica",
				"Um hacker, Neo, descobre a realidade simulada da Matrix.",
				"Filme"
				);
		
		//Instancia para inserir dado na tabela do DB catalogo
		ItemMidiaDAO dao = new ItemMidiaDAO();
		dao.inserir(novoItem);

	}

}
