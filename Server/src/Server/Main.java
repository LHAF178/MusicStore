package Server;

import BD.BancoConnection;

public class Main
{
/**
 * Classe Main do Programa Servidor. 
 * Abre a conexão do banco de dados puxando da classe BancoConnection
 */
	public static BancoConnection bancoConnection;

	public static void main(String[] args) 
	{

        int porta=12345;
        
		System.out.println("Tentando conectar ao banco de dados.... Aguarde (Deve levar até 15 segundos)");
		bancoConnection = new BancoConnection(); // Ao chamar o new a conexao é aberta.
		System.out.println("Conectado ao banco de dados!");
		System.out.println(bancoConnection.toString());
		   
		Server servidor = new Server(porta);
        
        
	}
}
