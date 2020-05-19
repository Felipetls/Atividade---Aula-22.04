package classes;

import dao.CarroDAO;
import interfaces.InterfaceCarro;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Carro extends UnicastRemoteObject implements InterfaceCarro {

    private String modelo;
    private int ano;
    private double nota;

    public Carro() throws RemoteException {
        System.out.print("A classe Carro está disponível remotamente.");
    }

    @Override
    public String getModelo() {
        return modelo;
    }

    @Override
    public void setModelo(String modelo) {
        this.modelo = modelo;
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
        CarroDAO.insert(this);
    }

}
