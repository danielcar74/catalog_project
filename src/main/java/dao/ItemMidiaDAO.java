package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.ItemMidia;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

public class ItemMidiaDAO {

    public void inserir(ItemMidia item) {
// MÉTODO: Criar ou inserir objetos nas colunas da tabela ItemMidia dentro da base catalog_db
        // Instrução SQL protegida contra SQL Injection com o uso de interrogações (?)
        String sql = "INSERT INTO item_midia (titulo, autor_diretor, ano_lancamento, genero, sinopse, tipo_midia) VALUES (?, ?, ?, ?, ?, ?)";
        
        // O try-with-resources (abaixo) fecha a conexão e o statement automaticamente após executar
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {   //uso do PreparedStatement considera as entradas apenas como dados
            
            // Atribuindo os valores do objeto ItemMidia para os parâmetros do SQL
            stmt.setString(1, item.getTitulo());
            stmt.setString(2, item.getAutorDiretor());
            stmt.setInt(3, item.getAnoLancamento());
            stmt.setString(4, item.getGenero());
            stmt.setString(5, item.getSinopse());
            stmt.setString(6, item.getTipoMidia());
            
            stmt.executeUpdate();
            System.out.println("Item cadastrado com sucesso no banco de dados");
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir o item no banco de dados: " + e.getMessage(), e);
        }
    }
    
 // MÉTODO: Listar todos os itens cadastrados
    public List<ItemMidia> listarTodos() {
        String sql = "SELECT * FROM item_midia";
        List<ItemMidia> lista = new ArrayList<>();

        // O try-with-resources garante que conexão, statement e resultSet serão fechados sozinhos
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Enquanto houver uma próxima linha na tabela do banco...
            while (rs.next()) {
                ItemMidia item = new ItemMidia();
                
                // Puxando os dados de cada coluna e guardando no objeto
                item.setId(rs.getInt("id"));
                item.setTitulo(rs.getString("titulo"));
                item.setAutorDiretor(rs.getString("autor_diretor"));
                item.setAnoLancamento(rs.getInt("ano_lancamento"));
                item.setGenero(rs.getString("genero"));
                item.setSinopse(rs.getString("sinopse"));
                item.setTipoMidia(rs.getString("tipo_midia"));

                // Adicionar o item preenchido na lista
                lista.add(item);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar os itens do banco de dados: " + e.getMessage(), e);
        }

        return lista;
    }
    
 // MÉTODO: atualizar item no banco
    public ItemMidia buscarPorId(int id) {
        String sql = "SELECT * FROM item_midia WHERE id = ?";
        ItemMidia item = null;
        
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    item = new ItemMidia();
                    item.setId(rs.getInt("id"));
                    item.setTitulo(rs.getString("titulo"));
                    item.setAutorDiretor(rs.getString("autor_diretor"));
                    item.setAnoLancamento(rs.getInt("ano_lancamento"));
                    item.setGenero(rs.getString("genero"));
                    item.setSinopse(rs.getString("sinopse"));
                    item.setTipoMidia(rs.getString("tipo_midia"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar item por ID: " + e.getMessage(), e);
        }
        return item;
    }    

 // MÉTODO: Atualizar ou update do item no banco
    public void atualizar(ItemMidia item) {
        String sql = "UPDATE item_midia SET titulo = ?, autor_diretor = ?, ano_lancamento = ?, genero = ?, sinopse = ?, tipo_midia = ? WHERE id = ?";
        
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Atribuindo os novos valores nos campos que serão atualizados
            stmt.setString(1, item.getTitulo());
            stmt.setString(2, item.getAutorDiretor());
            stmt.setInt(3, item.getAnoLancamento());
            stmt.setString(4, item.getGenero());
            stmt.setString(5, item.getSinopse());
            stmt.setString(6, item.getTipoMidia());
            stmt.setInt(7, item.getId());// Coloquei um getId para colocar no WHERE e dizer QUAL produto alterar
            
            stmt.executeUpdate();
            System.out.println("Item atualizado com sucesso.");
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o item: " + e.getMessage(), e);
        }
    }
    
 // MÉTODO: excluir item do banco - usando o Id
    public void excluir(int id) {
    	String sql = "DELETE FROM item_midia WHERE id = ?";
    	
    	try (Connection conn = ConexaoFactory.getConexao();
    			PreparedStatement stmt = conn.prepareStatement(sql)) {
    		
    		// DEfinir o id que será removido da base
    		stmt.setInt(1, id);
    		
    		stmt.executeUpdate();
    		System.out.println("Item excluido com sucesso.");
    		
    	} catch (SQLException e) {
    		throw new RuntimeException("Erro ao excluir item: " + e.getMessage(), e);
    		
    	}
    	
    }
    
// MÉTODO: Buscar item ou itens por título  ou autor/diretor
//ATENÇÃO: método protegido contra SQL INJECTION
    public List<ItemMidia> buscarPorTermo(String termo) {
    	String sql="SELECT * FROM item_midia WHERE titulo LIKE ? OR autor_diretor LIKE ? ORDER BY id DESC";
    	List<ItemMidia> lista = new ArrayList<>();
    	
    	try (Connection conn = ConexaoFactory.getConexao();
    			PreparedStatement stmt = conn.prepareStatement(sql)) {
    		
    		// Usei % para procurar titulo, autor/diretor que contenha pelo menos parte do termo buscado
    		String argumento = "%" + termo + "%";
            stmt.setString(1, argumento);
            stmt.setString(2, argumento);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ItemMidia item = new ItemMidia();
                    item.setId(rs.getInt("id"));
                    item.setTitulo(rs.getString("titulo"));
                    item.setAutorDiretor(rs.getString("autor_diretor"));
                    item.setAnoLancamento(rs.getInt("ano_lancamento"));
                    item.setGenero(rs.getString("genero"));
                    item.setSinopse(rs.getString("sinopse"));
                    item.setTipoMidia(rs.getString("tipo_midia"));
                    lista.add(item);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar itens: " + e.getMessage(), e);
        }
        return lista;
    }
      

}