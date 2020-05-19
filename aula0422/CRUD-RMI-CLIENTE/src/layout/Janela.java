package layout;

import java.awt.Component;
import javax.swing.*;
import views.EscolherFormulario;

public class Janela extends JFrame {

    public Janela() {
        setTitle("SISTEMAS DISTRIBUÍDOS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Center window.

        add(new EscolherFormulario());

        pack();

        setVisible(true);
    }

    public Janela(String nome, Component component) {
        setTitle(nome);
        setLocationRelativeTo(null);  // Center window.

        add(component);

        pack();

        setVisible(true);
    }
    /*}
    public Janela() {
        super("SISTEMAS DISTRIBUÍDOS");
        add(new AdicionarProduto());
        setSize(280, 400);
        setVisible(true);
    }*/
}
