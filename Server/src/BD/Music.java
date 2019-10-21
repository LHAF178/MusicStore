package BD;
/**
 * Classe que cria um "Objeto" Música, que possui parâmetros como titulo, artista
 * estilo,preco, duracao
 */
public class Music 
{
    private String titulo, artista, estilo;
    private float preco;
    private int duracao;

    /**
     * Construtor da Classe Music, passando como parâmetro titulo, artista
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
     * Método que retorna o titulo da Música
     */
    public String getTitulo() 
    {
        return this.titulo;
    }

    /**
     * Método que altera o titulo da Música
     */
    public void setTitulo(String titulo) 
    {
        this.titulo = titulo;
    }
    
    /**
     * Método que retorna o artista da Música
     */
    public String getArtista() 
    {
        return this.artista;
    }

    /**
     * Método que altera o artista da Música
     */
    public void setArtista(String artista) 
    {
        this.artista = artista;
    }
    
    /**
     * Método que retorna o estilo da Música
     */
    public String getEstilo() 
    {
        return this.estilo;
    }

    /**
     * Método que altera o artista da Música
     */
    public void setEstilo(String estilo) 
    {
        this.estilo = estilo;
    }

    /**
     * Método que retorna o preço da Música
     */
    public float getPreco() 
    {
        return this.preco;
    }

    /**
     * Método que altera o preço da Música
     */
    public void setPreco(float preco) 
    {
        this.preco = preco;
    }
    
    /**
     * Método que retorna a duraçao da Música
     */
    public int getDuracao() 
    {
        return this.duracao;
    }

    /**
     * Método que altera a duração da Música
     */
    public void setDuracao(int duracao) 
    {
        this.duracao = duracao;
    }
    
    /**
     * Método obrigatório que auxilia na formatação da impressão das Músicas
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
