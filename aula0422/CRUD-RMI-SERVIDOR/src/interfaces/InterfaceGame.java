package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceGame extends Remote {
    public String getNome() throws RemoteException;
    public void setNome(String nome) throws RemoteException;
    public int getAno() throws RemoteException;
    public void setAno(int ano) throws RemoteException;
    public double getNota() throws RemoteException;
    public void setNota(double nota) throws RemoteException;
    public void adicionar() throws RemoteException;
}
