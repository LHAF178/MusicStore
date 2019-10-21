package Client;

import java.net.Socket;

/**
 * 
 * Classe que inicia o cliente e executa a tela, localizada na classe Search
 *
 */
public class Main {
	
	public static void main(String[] args) throws Exception {
		System.out.println("Iniciando o cliente!");
		
		Search tela = new Search();
		tela.setVisible(true);
	}

}
