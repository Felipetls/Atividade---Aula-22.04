package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import layout.Janela;

public class EscolherFormulario extends JPanel implements ActionListener {

    private final JButton aluno;
    private final JButton cardapio;
    private final JButton carro;
    private final JButton game;
    private final JButton produto;

    public EscolherFormulario() {
        aluno = new JButton("Aluno");
        aluno.addActionListener(this);
        cardapio = new JButton("Cardapio");
        cardapio.addActionListener(this);
        carro = new JButton("Carro");
        carro.addActionListener(this);
        game = new JButton("Game");
        game.addActionListener(this);
        produto = new JButton("Produto");
        produto.addActionListener(this);

        add(aluno);
        add(cardapio);
        add(carro);
        add(game);
        add(produto);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == aluno) {
            new Janela("Aluno", new AdicionarAluno());
        }
        if (ae.getSource() == cardapio) {
            new Janela("Cardapio", new AdicionarCardapio());
        }
        if (ae.getSource() == carro) {
            new Janela("Carro", new AdicionarCarro());
        }
        if (ae.getSource() == game) {
            new Janela("Game", new AdicionarGame());
        }
        if (ae.getSource() == produto) {
            new Janela("Produto", new AdicionarProduto());
        }
    }

}
