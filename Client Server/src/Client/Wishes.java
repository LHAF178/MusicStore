package Client;

import Client.Lista;
import Client.Music;

/**
 * Classe que representa as músicas desejadas e usa de métodos para adiciona-los 
 * à lista de desejos, além de fazer os cálculos do desconto e obter o preço final.
 */
public class Wishes 
{
	public Lista<Music> lista = new Lista<Music>();
	
	/**
	 * Construtor da classe Wishes que retorna a lista de músicas
	 */
	public Wishes() throws Exception
	{
		this.lista = new Lista<Music>();
	}
	
	/**
	 * Método que adiciona uma determinada música na lista de desejos
	 */
	public void addDesejo(Music musica) throws Exception
	{
		this.lista.insereItem(musica);
	}
	
	/**
	 *Método que remove uma determinada música de uma posição específica da lista de desejos
	 */
	public void removeDesejo(int posicao) throws Exception
	{
		if(posicao < 1)
			throw new Exception("A posição não pode ser menor que um");
		lista.removeItem(posicao);
	}
	
	/**
	 * Método que remove uma determinada música da lista de desejos
	 */
	public void removeDesejo() throws Exception
	{
		this.lista.removeItem();
	}
	
	/**
	 * Método que retorna uma música da lista
	 */
	public Music getMusica()
	{
		Music retorno = null;
		try
		{
			retorno = this.lista.getItem();
		}
		catch(Exception erro)
		{//lista vazia
		}
		return retorno;
	}
	
	/**
	 * Método que retorna a lista de músicas
	 */
	public Lista<Music> getLista()
	{
		return this.lista;
	}
	
	/**
	 * Método que retorna uma música de uma posição específica da lista 
	 */
	public Music getMusica(int posicao)
	{
		Music retorno = null;
		try
		{
			retorno = this.lista.getItem(posicao);
		}
		catch(Exception erro)
		{//lista vazia
		}
		return retorno;
	}
	
	/**
	 * Método que retorna o Valor Final Somado, sem o desconto
	 */
	public float getValorBruto()
	{
		float retorno = 0;
		try
		{
			for(int i=1;i<=this.lista.getTamanho();i++)
				retorno = retorno + ((Music)this.lista.getItem(i)).getPreco();
		}
		catch (Exception e) 
		{
		}
		return retorno;
	}
	
	/**
	 * Método que retorna o Valor Final Somado, com o desconto
	 */
	public float getValorFinal()
	{
		float retorno = this.getValorBruto();
		//retorno = retorno - retorno * (this.getDesconto() / 100);
		
		if(this.getDesconto() == 10)
		{
			retorno = (float) (retorno - (retorno*0.1));
		}
		
		if(this.getDesconto() == 20)
		{
			retorno = (float)(retorno - (retorno*0.2));
			return retorno;
		}
		
		if(this.getDesconto() == 30)
		{
			retorno = (float)(retorno - (retorno*0.3));
			return retorno;
		}
		
		return retorno;
	}
	
	/**
	 * Método que retorna a quantidade de desconto dependendo da duração
	 */
	public int getDesconto()
	{
		int desconto = 0;
		if(this.getDuracao()/60 >= 30 && this.getDuracao()/60 < 60)
			desconto = 10;
		if(this.getDuracao()/60 >= 60 && this.getDuracao()/60 < 90)
			desconto = 20;
		if(this.getDuracao()/60 >= 90)
			desconto = 30;
		
		return desconto;
	}
	
	/**
	 * Método que retorna a duração total da lista
	 */
	public int getDuracao()
	{
		int retorno = 0;
		try
		{
			for(int i=1;i<=this.lista.getTamanho();i++)
				retorno = retorno + ((Music)this.lista.getItem(i)).getDuracao();
		}
		catch (Exception e) 
		{
		}
		return retorno;
	}
	
	/**
	 * Método que retorna a quantidade de músicas da lista (tamanho)
	 */
	public int getQuantidade()
	{
		return this.lista.getTamanho();
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
		
		return true;
	}
	
	public int hashCode() {
		int ret = 666;
		int i = 1;
		
		while(i <= lista.getTamanho())
		{
			ret = ret * 7 + this.lista.hashCode();
		}

		
		return ret;
	}
	
	public String toString() {
		return "Tamanho: " + this.lista.getTamanho();
		
	}
}
