package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;
    private Lista<Cliente> clientes;

    /**
     * Classe Server que abre as conexões para aguardar a conexão de um cliente. Quando um cliente é conectado, 
     * ele é colocado em uma lista "Clientes", assim permanecendo até se desconectar.
     * @param porta
     */
    public Server(int porta) { 
        this.clientes = new Lista<Cliente>();
        try {
            this.serverSocket = new ServerSocket(porta);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0); // Nao foi possivel iniciar o server socket...
        }

        System.out.println("\nAguardando conexoes...");
        for (;;) { // Aguarda as conexoes
            try {
                Socket conectou = this.serverSocket.accept();
                Cliente novo = new Cliente(conectou);
                novo.start(); // Inicia o handler de comunicados (Metodo run)
                System.out.println("Novo cliente conectado");
                try {
                    this.clientes.insereItem(novo);
                } catch (Exception e) {
                    e.printStackTrace(); // Lista joga muita exception...
                }
            } catch (IOException e) {
                e.printStackTrace(); // Algum erro de conexao inesperado...
                break;
            }
        }
    
    }

    public boolean equals(Object obj) {

		if(this==obj) {
			return true;
		}
		
		if(obj==null) {
			return false;
		}
		
		if(this.getClass() != obj.getClass()) {
			return false;
		}
		
		Server objServer = (Server) obj;
		
		if(this.clientes != objServer.clientes) {
			return false;
		}
		
		if(this.serverSocket != objServer.serverSocket) {
			return false;
		}
		
		return true;
	}
    
    public int hashCode() {
		int ret = 666;
		int i = 1;
		
		while(i <= clientes.getTamanho())
		{
			ret = ret * 7 + this.clientes.hashCode();
		}
		ret = ret * 7 + this.serverSocket.hashCode();

		return ret;
	}
    
    public Lista<Cliente> getClientes() 
    {
        return this.clientes;
    }
   
    public String toString() {
		return "ServerSocket: " + serverSocket +
				"\nClientes Conectados: " + clientes.getTamanho();
	}
}