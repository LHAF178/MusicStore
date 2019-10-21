package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Server.Lista;
// LOCAL: "jdbc:sqlserver://localhost:1433;databaseName=SPIC;user=LHAF178\\\\lucas_000;integratedSecurity=true;"
// PUC: "jdbc:sqlserver://fs5.acd.puc-campinas.edu.br;user=poo1929;password=Xqmeu2"

/**
 *Classe que usa a connection string do Banco de Dados, além de usar o ResultSet, Statement,
 *para realizar ações na tabela Musicas, localizada nesse banco
 * 
 */
public class BancoConnection {

    private Connection conexao;

    public BancoConnection() {
        try {
            conexao = DriverManager.getConnection(
            		"jdbc:sqlserver://localhost:1433;databaseName=SPIC;user=LHAF178\\\\\\\\lucas_000;integratedSecurity=true;");

        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0); // Não foi possivel conectar-se ao banco.
        }
    }

    /**
     * Método utilizado para puxar todas as músicas localizadas na Tabela Music,
     * usando os comandos e as Querys do SQLServer
     * @return
     */
    public Lista<Music> pegarTodas() {
    	//@Entity
    	//@Table(name = "Musicas")
        Lista<Music> resultado = new Lista<Music>();
        try {
            Statement st = conexao.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM [dbo].[Musicas]");
            while (res.next()) { // Possui uma proxima linha no banco
                try {
                    resultado.insereItem(new Music(res.getString("Titulo"), res.getString("Artista"),
                            res.getString("Estilo"), res.getFloat("Preco"), res.getInt("Duracao")));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Ocorreu algum erro de SQL
        }

        return resultado;
        
    }

    /**
     * Método usado para filtar as músicas que serão selecionadas para puxar do banco de dados
     * @param criterio
     * @param busca
     * @return
     */
    public Lista<Music> filtrar(String criterio, String busca) {
        Lista<Music> resultado = new Lista<Music>();
        try {
            Statement st = conexao.createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM [dbo].[Musicas] WHERE " + criterio + " = '"+busca+"'");
            while (res.next()) { // Possui uma proxima linha no banco
                try {
                    resultado.insereItem(new Music(res.getString("Titulo"), res.getString("Artista"),
                            res.getString("Estilo"), res.getFloat("Preco"), res.getInt("Duracao")));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Ocorreu algum erro de SQL
        } 

        return resultado;
        
    }

    /**
     * Método para retornar a conexão obtida com o banco
     * @return
     */
    public Connection getConexao() {
        return this.conexao;
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
		
		BancoConnection objMusic = (BancoConnection) obj;
		
		if(this.conexao != objMusic.conexao) {
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
		if(conexao.equals(" ")) 
		{
			return "Insira uma Connection String para se Conectar ao banco";
		}
		
		return "\nConnection String: " + "jdbc:sqlserver://localhost:1433;databaseName=SPIC;user=LHAF178\\\\\\\\lucas_000;integratedSecurity=true;";
	}
}