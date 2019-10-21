package Client;

public class Lista<TipoItem> 
{
	private class No 
	{ 
		private TipoItem item;
		private No proximo;

		public No(TipoItem item, No proximo) 
		{
			this.item = item;
			this.proximo = proximo;
		}

		public TipoItem getItem() 
		{
			return this.item;
		}

		public No getProximo() 
		{
			return this.proximo;
		}

		@SuppressWarnings("unused")
		public void setItem(TipoItem item) 
		{
			this.item = item;
		}

		public void setProximo(No proximo) 
		{
			this.proximo = proximo;
		}
	} // fim da classe No

	private No primeiro, ultimo;
	private int tamanho;
	
	public Lista()
	{
		this.primeiro = null;
		this.ultimo = null;
		this.tamanho = 0;
	}

	// insere no final da lista
	public void insereItem(TipoItem item) throws Exception 
	{
		if (item == null)
			throw new Exception("Valor ausente");
		
		No penultimo = this.ultimo;
		this.ultimo = new No (item, null);
		
		if(this.isVazia())
			this.primeiro = this.ultimo;
	
		else
			penultimo.setProximo(this.ultimo);
        
        this.tamanho++;
	}
	
	// insere em uma posi��o especifica
	public void insereItem(TipoItem item, int posicao) throws Exception {
		if (item == null)
			throw new Exception("Valor ausente");
		
		if (posicao <= 0 || posicao > (this.getTamanho() + 1))
			throw new Exception("Posi��o inv�lida!");
		
		// verifica vazia ou insercao no final da lista
		if(this.isVazia() || posicao == this.getTamanho() + 1) 
			this.insereItem(item);
		else 
		{// insercao no inicio ou no meio da lista
			
			// cria o novo no
			No novoNo = new No (item, null);
			
			// inser��o no inicio
			if(posicao == 1) 
			{ 
				novoNo.setProximo(this.primeiro);
				this.primeiro  = novoNo;	
			}
			else 
			{// encontra o item anterior a posicao de insercao
				No anterior = this.primeiro;
				for (int i = 2; i < posicao; i++)
					anterior = anterior.getProximo();
				
				// atualiza o proximo do novo e do anterior
				novoNo.setProximo(anterior.getProximo());
				anterior.setProximo(novoNo);
			}
			this.tamanho++;
		}
	}

	// remove do inicio da lista
	public void removeItem() throws Exception 
	{
		if (this.isVazia())
			throw new Exception("Nada guardado");
		
        this.primeiro = this.primeiro.getProximo();
        this.tamanho--;
	}
	
	// remove de uma posi��o espec�fica
	public void removeItem(int posicao) throws Exception 
	{
		if (this.isVazia())
			throw new Exception("Nada guardado");
		
		if (posicao <= 0 || posicao > this.getTamanho())
			throw new Exception("Posi��o inv�lida!");
		
		// remove do inicio
		if(posicao == 1) 
			removeItem();
		else 
		{
			// encontra anterior ao item que sera removido
			No anterior = this.primeiro;
			for (int i = 2; i < posicao; i++)
				anterior = anterior.getProximo();
			
			// atualiza proximo do anterior
			anterior.setProximo(anterior.getProximo().getProximo());
			
			// remocao na ultima posicao, atualiza o ultimo
			if(posicao == this.getTamanho())
				this.ultimo = anterior;
			
			this.tamanho--;
		}
	}

	// recupera o item da primeira posicao 
	public TipoItem getItem() throws Exception 
	{
		if (this.isVazia())
			throw new Exception("Nada guardado");

		return this.primeiro.getItem();
	}

	// recupera o item de uma posicao especifica
	public TipoItem getItem(int posicao) throws Exception 
	{
		if (this.isVazia())
			throw new Exception("Nada guardado");
		
		if (posicao <= 0 || posicao > this.getTamanho())
			throw new Exception("Posi��o inv�lida!");
		
		if (posicao == this.getTamanho())
			return this.ultimo.getItem();
		else 
		{
			// encontra item a ser retornado
			No item = this.primeiro;
			for (int i = 1; i < posicao; i++)
				item = item.getProximo();
						
			return item.getItem();
						
		}
	}
	
	public boolean isVazia() 
	{
		return this.primeiro == null;
	}
	
	public int getTamanho() 
	{
		return this.tamanho;
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
		
		Lista objLista = (Lista) obj;
		
		if(this.primeiro != objLista.primeiro) {
			return false;
		}
		
		if(this.tamanho != objLista.tamanho) {
			return false;
		}
		
		if(this.ultimo != objLista.ultimo) {
			return false;
		}		
		
		return true;
	}
	
	public int compareTo(Lista lista) {
		
		if(this.tamanho < lista.tamanho) {
			return -1;
		} else if(this.tamanho > lista.tamanho) {
			return 1;
		} else {
			return 0;
		}
		
	}
	
	public int hashCode() {
		int ret = 666;
		
		ret = ret * 7 + new Integer (this.tamanho).hashCode();
		ret = ret * 7 + this.primeiro.hashCode();
		ret = ret * 7 + this.ultimo.hashCode();

		return ret;
	}
	
	public String toString() {
		
		int i = 1;
		while(i <= this.getTamanho())
		{
			try {
				return (String) this.getItem();
			} catch (Exception e) {
				e.printStackTrace();
			}
			i++;
		}
		
		return "\nTamanho: " + this.getTamanho();
				
	}
}

