package classes;

import dao.GameDAO;
import interfaces.InterfaceGame;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Game extends UnicastRemoteObject implements InterfaceGame {

    private String nome;
    private int ano;
    private double nota;

    public Game() throws RemoteException {
        System.out.print("A classe Game está disponível remotamente.");
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
    public int getAno() {
        return ano;
    }

    @Override
    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public double getNota() {
        return nota;
    }

    @Override
    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public void adicionar() {
        GameDAO.insert(this);
    }
}
