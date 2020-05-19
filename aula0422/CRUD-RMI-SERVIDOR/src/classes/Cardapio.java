package classes;

import dao.CardapioDAO;
import interfaces.InterfaceCardapio;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Cardapio extends UnicastRemoteObject implements InterfaceCardapio {

    private String prato;
    private double preco;
    private int porcoes;

    public Cardapio() throws RemoteException {
        System.out.println("A classe Cardapio está disponível remotamente.");
    }

    @Override
    public String getPrato() {
        return prato;
    }

    @Override
    public void setPrato(String prato) {
        this.prato = prato;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public int getPorcoes() {
        return porcoes;
    }

    @Override
    public void setPorcoes(int porcoes) {
        this.porcoes = porcoes;
    }

    @Override
    public void adicionar() {
        CardapioDAO.insert(this);
    }

}
