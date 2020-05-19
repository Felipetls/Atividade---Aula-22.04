package views;

import interfaces.InterfaceGame;
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

public class AdicionarGame extends JPanel implements ActionListener {

    JTextField campo_nome;
    JTextField campo_ano;
    JTextField campo_nota;

    JButton botao_salvar;

    public AdicionarGame() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridLayout(7, 0));
        JLabel label_nome = new JLabel("Nome: ");
        campo_nome = new JTextField(20);
        JLabel label_ano = new JLabel("Ano: ");
        campo_ano = new JTextField(20);
        JLabel label_nota = new JLabel("Nota: ");
        campo_nota = new JTextField(20);

        botao_salvar = new JButton("Salvar");
        botao_salvar.addActionListener(this);

        add(label_nome);
        add(campo_nome);
        add(label_ano);
        add(campo_ano);
        add(label_nota);
        add(campo_nota);

        add(botao_salvar);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String nome = campo_nome.getText();
        int ano = Integer.parseInt(campo_ano.getText());
        double nota = Double.parseDouble(campo_nota.getText());

        try {
            InterfaceGame gameRemoto = (InterfaceGame) Naming.lookup("rmi://192.168.1.130:1099/Game");

            gameRemoto.setNome(nome);
            gameRemoto.setAno(ano);
            gameRemoto.setNota(nota);

            gameRemoto.adicionar();

            String texto_retorno = "\nNome: " + gameRemoto.getNome() + "\nAno: "
                    + gameRemoto.getAno() + "\nNota: " + gameRemoto.getNota();

            JOptionPane.showMessageDialog(null, texto_retorno, "Dados do Game", JOptionPane.INFORMATION_MESSAGE);
        } catch (RemoteException re) {
            JOptionPane.showMessageDialog(null, "Erro remoto: " + re.toString(), "Erro remoto",
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro local: " + e.toString(), "Erro local",
                    JOptionPane.WARNING_MESSAGE);
        }

    }

}
