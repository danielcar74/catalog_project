package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
    
    // DEfinição da base e tabelas envolvidas (login e senha)
    private static final String URL = "jdbc:mysql://localhost:3306/catalog_db?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String SENHA = "1234";

    public static Connection getConexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver não encontrado", e);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o Banco de Dados", e);
        }
    }
}