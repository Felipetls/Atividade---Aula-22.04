package dao;

import classes.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AlunoDAO {

    public static void insert(Aluno aluno) {
        String sql = "INSERT INTO aluno(nome, matriculo, media) VALUES (?, ?, ?)";

        try {
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getMatricula());
            stmt.setDouble(3, aluno.getMedia());

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
