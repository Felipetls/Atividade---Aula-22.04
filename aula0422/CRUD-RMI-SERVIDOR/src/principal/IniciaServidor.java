package principal;

import java.rmi.registry.LocateRegistry;
import classes.Produto;
import dao.ConexaoDB;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.sql.Connection;

public class IniciaServidor {

    public static void main(String[] args) {

        try {
            System.out.println("Iniciando Servidor");

            Connection conn = null;

            try {
                conn = ConexaoDB.retornaConexao();
                if (conn != null) {
                    System.out.println("Conectado ao bando de dados.");
                } else {
                    System.out.println("Erro de conexão ao banco de dados.");
                }
            } catch (Exception edb) {
                System.out.println("Erro no banco de dados: " + edb.toString());
            }

            LocateRegistry.createRegistry(1099);

            Produto objetoProduto = new Produto();
            Naming.rebind("rmi://127.0.0.1:1099/Produto", objetoProduto);

        } catch (RemoteException re) {
            System.out.println("Erro remoto: " + re.toString());
        } catch (Exception e) {
            System.out.println("Erro local: " + e.toString());
        }

    }

}
