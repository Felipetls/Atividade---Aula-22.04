package views;

import interfaces.InterfaceCardapio;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AdicionarCardapio extends JPanel implements ActionListener {

    JTextField campo_prato;
    JTextField campo_preco;
    JTextField campo_porcoes;

    JButton botao_salvar;

    public AdicionarCardapio() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridLayout(7, 0));
        JLabel label_prato = new JLabel("Prato: ");
        campo_prato = new JTextField(20);
        JLabel label_preco = new JLabel("Preço: ");
        campo_preco = new JTextField(20);
        JLabel label_porcoes = new JLabel("Porções: ");
        campo_porcoes = new JTextField(20);

        botao_salvar = new JButton("Salvar");
        botao_salvar.addActionListener(this);

        add(label_prato);
        add(campo_prato);
        add(label_preco);
        add(campo_preco);
        add(label_porcoes);
        add(campo_porcoes);

        add(botao_salvar);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String prato = campo_prato.getText();
        double preco = Double.parseDouble(campo_preco.getText());
        int porcoes = Integer.parseInt(campo_porcoes.getText());

        try {
            InterfaceCardapio cardapioRemoto = (InterfaceCardapio) Naming.lookup("rmi://192.168.1.130:1099/Cardapio");

            cardapioRemoto.setPrato(prato);
            cardapioRemoto.setPreco(preco);
            cardapioRemoto.setPorcoes(porcoes);

            cardapioRemoto.adicionar();

            String texto_retorno = "\nPrato: " + cardapioRemoto.getPrato() + "\nPreço: "
                    + cardapioRemoto.getPreco() + "\nPorções: " + cardapioRemoto.getPorcoes();

            JOptionPane.showMessageDialog(null, texto_retorno, "Dados do Cardapio", JOptionPane.INFORMATION_MESSAGE);
        } catch (RemoteException re) {
            JOptionPane.showMessageDialog(null, "Erro remoto: " + re.toString(), "Erro remoto",
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro local: " + e.toString(), "Erro local",
                    JOptionPane.WARNING_MESSAGE);
        }

    }

}
