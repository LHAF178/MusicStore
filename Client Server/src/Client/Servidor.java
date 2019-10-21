package Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Outros.Comunicado;

public class Servidor {
	
	private Socket conexao;
	
	public Servidor(Socket socket) {
		this.conexao = socket;
	}

	public Socket getConexao() {
		return conexao;
	}
	
	public void enviar(Comunicado comunica) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(this.conexao.getOutputStream());
			out.writeObject(comunica);
			out.flush(); // Libera o fluxo de rede
		} catch (IOException e) {
			e.printStackTrace(); // Algum erro para enviar o comunicado
		}
			
	}
	
	public synchronized Lista<Music> listarTodas() { // synchronized pq esse metodo so pode ser executado uma vez
		Lista<Music> resultado = new Lista<Music>();
		try {
			enviar(new Comunicado("CON", "TODAS", "TODAS"));
			ObjectInputStream in = new ObjectInputStream(this.conexao.getInputStream());
			for (;;)  {
				Comunicado recebido = (Comunicado) in.readObject();
				if (recebido.getComando().equalsIgnoreCase("FIC")) break;
				resultado.insereItem(new Music(recebido.getComplemento1(), recebido.getComplemento2(), recebido.getComplemento3(), Float.parseFloat(recebido.getComplemento4()), Integer.parseInt(recebido.getComplemento5())));
			}
		} catch (Exception e) {
			e.printStackTrace(); // Algum erro do comunicado ou parse de Music
		}
		
		return resultado;
	}
	
	public synchronized Lista<Music> filtrar(String criterio, String busca)
	{
		Lista<Music> resultado = new Lista<Music>();
		
		try
		{
			enviar(new Comunicado("CON", criterio, busca));
			ObjectInputStream in = new ObjectInputStream(this.conexao.getInputStream());
			for(;;)
			{
				Comunicado recebido = (Comunicado) in.readObject();
				if (recebido.getComando().equalsIgnoreCase("FIC")) break;
				resultado.insereItem(new Music(recebido.getComplemento1(), recebido.getComplemento2(), recebido.getComplemento3(), Float.parseFloat(recebido.getComplemento4()), Integer.parseInt(recebido.getComplemento5())));
			}
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return resultado;
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
		
		Servidor objServidor = (Servidor) obj;
		
		if(this.conexao != objServidor.conexao) {
			return false;
		}

		return true;
	}

	public int hashCode() {
		int ret = 666;
		
		ret = ret * 7 + this.conexao.hashCode();

		return ret;
	}
	
public String toString() {
		
		return "Socket: " + conexao;
	}
}
