package classes;

import dao.AlunoDAO;
import interfaces.InterfaceAluno;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Aluno extends UnicastRemoteObject implements InterfaceAluno {

    private String nome;
    private int matricula;
    private double media;

    public Aluno() throws RemoteException {
        System.out.print("A classe Aluno está disponível remotamente.");
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int getMatricula() {
        return matricula;
    }

    @Override
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public double getMedia() {
        return media;
    }

    @Override
    public void setMedia(double media) {
        this.media = media;
    }

    @Override
    public void adicionar() {
        AlunoDAO.insert(this);
    }

}
