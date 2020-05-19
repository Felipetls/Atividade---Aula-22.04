package views;

import interfaces.InterfaceAluno;
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

public class AdicionarAluno extends JPanel implements ActionListener {

    JTextField campo_nome;
    JTextField campo_media;
    JTextField campo_matricula;

    JButton botao_salvar;

    public AdicionarAluno() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridLayout(7, 0));
        JLabel label_nome = new JLabel("Nome: ");
        campo_nome = new JTextField(20);
        JLabel label_media = new JLabel("Média: ");
        campo_media = new JTextField(20);
        JLabel label_matricula = new JLabel("Matrícula: ");
        campo_matricula = new JTextField(20);

        botao_salvar = new JButton("Salvar");
        botao_salvar.addActionListener(this);

        add(label_nome);
        add(campo_nome);
        add(label_media);
        add(campo_media);
        add(label_matricula);
        add(campo_matricula);

        add(botao_salvar);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String nome = campo_nome.getText();
        double media = Double.parseDouble(campo_media.getText());
        int matricula = Integer.parseInt(campo_matricula.getText());

        try {
            InterfaceAluno alunoRemoto = (InterfaceAluno) Naming.lookup("rmi://192.168.1.130:1099/Aluno");

            alunoRemoto.setNome(nome);
            alunoRemoto.setMedia(media);
            alunoRemoto.setMatricula(matricula);

            alunoRemoto.adicionar();

            String texto_retorno = "\nNome: " + alunoRemoto.getNome() + "\nMédia: "
                    + alunoRemoto.getMedia() + "\nMatrícula: " + alunoRemoto.getMatricula();

            JOptionPane.showMessageDialog(null, texto_retorno, "Dados do Aluno", JOptionPane.INFORMATION_MESSAGE);
        } catch (RemoteException re) {
            JOptionPane.showMessageDialog(null, "Erro remoto: " + re.toString(), "Erro remoto",
                    JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro local: " + e.toString(), "Erro local",
                    JOptionPane.WARNING_MESSAGE);
        }

    }

}
