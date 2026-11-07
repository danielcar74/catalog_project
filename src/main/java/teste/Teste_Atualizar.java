package teste;

import java.util.List;
import dao.ConexaoFactory;
import dao.ItemMidiaDAO;
import model.ItemMidia;


public class Teste_Atualizar {

	public static void main(String[] args) {
		ItemMidiaDAO dao = new ItemMidiaDAO();
		
		// Dados de atualização
		ItemMidia itemAtualizado = new ItemMidia();
		itemAtualizado.setId(1); // Usar Id que já existe no banco para atualizar objeto
		itemAtualizado.setTitulo("Matrix - Edição Especial Remasterizada");
		itemAtualizado.setAutorDiretor("Wachowski Sisters");
		itemAtualizado.setAnoLancamento(1999);
		itemAtualizado.setGenero("Ficção Científica");
		itemAtualizado.setSinopse("Um jovem hacker descobre a realizada simulada. Versão com novas cenas");
		itemAtualizado.setTipoMidia("Filme");
		
		//Comando para executar a atualização.
		dao.atualizar(itemAtualizado);

	}

}
