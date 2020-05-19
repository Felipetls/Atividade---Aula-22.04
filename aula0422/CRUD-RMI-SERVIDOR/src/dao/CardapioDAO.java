package dao;

import classes.Cardapio;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CardapioDAO {

    public static void insert(Cardapio cardapio) {
        String sql = "INSERT INTO cardapio(prato, preco, porcoes) VALUES (?, ?, ?)";

        try {
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, cardapio.getPrato());
            stmt.setDouble(2, cardapio.getPreco());
            stmt.setInt(3, cardapio.getPorcoes());

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
