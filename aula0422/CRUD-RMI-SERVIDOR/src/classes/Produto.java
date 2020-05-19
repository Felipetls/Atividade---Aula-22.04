package classes;

import dao.ProdutoDAO;
import interfaces.InterfaceProduto;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Produto extends UnicastRemoteObject implements InterfaceProduto {

    private String descricao;
    private double preco;
    private int quantidade;

    public Produto() throws RemoteException {
        System.out.print("A classe produto está disponível remotamente.");
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    @Override
    public void adicionar(){
        ProdutoDAO.insert(this);
    }
    
}
