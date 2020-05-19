package dao;

import classes.Game;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class GameDAO {

    public static void insert(Game game) {
        String sql = "INSERT INTO game(nome, ano, nota) VALUES (?, ?, ?)";

        try {
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, game.getNome());
            stmt.setInt(2, game.getAno());
            stmt.setDouble(3, game.getNota());

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
