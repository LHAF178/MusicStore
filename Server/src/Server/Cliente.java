package Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import BD.Music;
import Outros.Comunicado;

public class Cliente extends Thread {

    private Socket socket;

    /**
     * Recebe o comunicado requisitado pelo Cliente ("CON") e envia de volta, como resposta,
     * o comunicado com a mensagem ("MUS"), significando a pesquisa de Músicas no Banco de Dados.
     * @param socket
     */
    public Cliente(Socket socket) {
        this.socket = socket;
    }

    /**
     * Sobrescreve o metodo Thread.run, recebendo o comunicado enviado pelo Cliente,
     * requisitando as músicas.
     */
    public void run() { // Sobrescreve metodo Thread.run
        for (;;) {
            try {
                ObjectInputStream in = new ObjectInputStream(this.socket.getInputStream());
                Comunicado recebiComunicado = (Comunicado) in.readObject();
                
                // Procesar as reqs do cliente
                processarComunicado(recebiComunicado);
            } catch (Exception e) {
                e.printStackTrace(); // Algum erro de IO ou de objeto recebido e do tipo Comunicado.
                break;
            }
        }
    }


    /**
     * Classe que checa a mensagem recebida do cliente, e em caso da mensagem ("CON"), é enviada 
     * de volta a mensagem ("MUS"), significando a pesquisa e a coleta de Músicas no Banco de Dados 
     * @param recebido
     * @throws Exception
     */
    private void processarComunicado(Comunicado recebido) throws Exception
	{
		switch (recebido.getComando()) { 
            case "CON":
                
                ObjectOutputStream out = new ObjectOutputStream(this.socket.getOutputStream());
                if (recebido.getComplemento1().equals("TODAS") && recebido.getComplemento2().equals("TODAS")) { // enviar todas musicas
                    Lista<Music> todas = Main.bancoConnection.pegarTodas();
                    while (!todas.isVazia()) {
                        Music aux = todas.getItem();
                        Comunicado pacote = new Comunicado("MUS",aux.getTitulo(),aux.getArtista(),aux.getEstilo(),""+aux.getPreco(),""+aux.getDuracao());
                        out.writeObject(pacote);
                        todas.removeItem();
                    }
                    out.writeObject(new Comunicado("FIC")); // Acabou de enviar
                    out.flush();
                } else if (!recebido.getComplemento1().equals("TODAS") && !recebido.getComplemento2().equals("TODAS")) {
                    Lista<Music> todas = Main.bancoConnection.filtrar(recebido.getComplemento1(), recebido.getComplemento2());
                    while (!todas.isVazia()) {
                        Music aux = todas.getItem();
                        Comunicado pacote = new Comunicado("MUS",aux.getTitulo(),aux.getArtista(),aux.getEstilo(),""+aux.getPreco(),""+aux.getDuracao());
                        out.writeObject(pacote);
                        todas.removeItem();
                    }
                    out.writeObject(new Comunicado("FIC")); // Acabou de enviar
                    out.flush();
                } else {
                    
                	//Erro?
                }

                break;
        
            default:
                break;
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
		
		Cliente objCliente = (Cliente) obj;
		
		if(this.socket != objCliente.socket) {
			return false;
		}
			
		
		return true;
	}
 
    public int hashCode() {
		int ret = 666;
		
		ret = ret * 7 + this.socket.hashCode();

		return ret;
	}
    
    public String toString() {
		return "Socket: " + socket;
	}

}