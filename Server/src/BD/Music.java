package BD;
/**
 * Classe que cria um "Objeto" M�sica, que possui par�metros como titulo, artista
 * estilo,preco, duracao
 */
public class Music 
{
    private String titulo, artista, estilo;
    private float preco;
    private int duracao;

    /**
     * Construtor da Classe Music, passando como par�metro titulo, artista
     * estilo, preco, duracao
     */
    public Music(String titulo, String artista, String estilo, float preco, int duracao) 
    {
    	this.titulo = titulo;
    	this.artista = artista;
    	this.estilo = estilo;
    	this.preco = preco;
    	this.duracao = duracao;
    }

    /**
     * M�todo que retorna o titulo da M�sica
     */
    public String getTitulo() 
    {
        return this.titulo;
    }

    /**
     * M�todo que altera o titulo da M�sica
     */
    public void setTitulo(String titulo) 
    {
        this.titulo = titulo;
    }
    
    /**
     * M�todo que retorna o artista da M�sica
     */
    public String getArtista() 
    {
        return this.artista;
    }

    /**
     * M�todo que altera o artista da M�sica
     */
    public void setArtista(String artista) 
    {
        this.artista = artista;
    }
    
    /**
     * M�todo que retorna o estilo da M�sica
     */
    public String getEstilo() 
    {
        return this.estilo;
    }

    /**
     * M�todo que altera o artista da M�sica
     */
    public void setEstilo(String estilo) 
    {
        this.estilo = estilo;
    }

    /**
     * M�todo que retorna o pre�o da M�sica
     */
    public float getPreco() 
    {
        return this.preco;
    }

    /**
     * M�todo que altera o pre�o da M�sica
     */
    public void setPreco(float preco) 
    {
        this.preco = preco;
    }
    
    /**
     * M�todo que retorna a dura�ao da M�sica
     */
    public int getDuracao() 
    {
        return this.duracao;
    }

    /**
     * M�todo que altera a dura��o da M�sica
     */
    public void setDuracao(int duracao) 
    {
        this.duracao = duracao;
    }
    
    /**
     * M�todo obrigat�rio que auxilia na formata��o da impress�o das M�sicas
     */
    public String toString() 
    {
    	return this.titulo+"  |  "+this.artista+"  |  "+this.estilo+"  |  R$"+this.preco+"  |  "+this.duracao + "s";
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
		
		Music objMusic = (Music) obj;
		
		if(this.artista != objMusic.artista) {
			return false;
		}
		
		if(this.duracao != objMusic.duracao) {
			return false;
		}
		
		if(this.estilo != objMusic.estilo) {
			return false;
		}		
		
		if(this.preco != objMusic.preco) {
			return false;
		}
		
		if(this.titulo != objMusic.titulo) {
			return false;
		}
		
		return true;
	}
    
	public int compareTo(Music music) {
		
		if(this.preco < music.preco) {
			return -1;
		} else if(this.preco > music.preco) {
			return 1;
		} else {
			return 0;
		}
		
	}
	
	public int hashCode() {
		int ret = 666;
		
		ret = ret * 7 + new String (this.artista).hashCode();
		ret = ret * 7 + new Integer (this.duracao).hashCode();
		ret = ret * 7 + new String (this.estilo).hashCode();
		ret = ret * 7 + new String (this.titulo).hashCode();
		ret = ret * 7 + new Float (this.preco).hashCode();
		
		return ret;
	}
}
