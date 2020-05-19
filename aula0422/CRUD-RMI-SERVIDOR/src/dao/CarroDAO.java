package dao;

import classes.Carro;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CarroDAO {

    public static void insert(Carro carro) {
        String sql = "INSERT INTO carro(modelo, ano, nota) VALUES (?, ?, ?)";

        try {
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, carro.getModelo());
            stmt.setInt(2, carro.getAno());
            stmt.setDouble(3, carro.getNota());

            stmt.execute();

        } catch (Exception e) {
            System.out.println("Erro na função INSERT: " + e.toString());
        }
    }

    public void update() {
    }

    public void delete() {
    }

    public void select() {
    }

}
