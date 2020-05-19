package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoDB {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "abcd1234";
    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/crud_rmi?"
            + "useTimezone=true&serverTimezone=UTC";

    public static Connection retornaConexao() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            return connection;
        } catch (Exception e) {
            System.out.println("Erro: " + e.toString());
        }
        return null;
    }

}
