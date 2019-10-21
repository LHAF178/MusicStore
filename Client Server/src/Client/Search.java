package Client;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Client.Wishes;

public class Search extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5576471938453301432L;
	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtArtista;
	private JTextField txtEstilo;
	private Lista<Music> listaAtual;

	// Encontrado em um tutorial da Internet. Inicia a aplicação em Java.
	// String sql = "SELECT * FROM Musicas WHERE Titulo = txtTitulo";



	/**
	 * Classe que abre a tela usando JFrame, criando todas as Labels, Lista de Músicas e Text Boxes
	 * @throws Exception 
	 *  
	 */
	private Servidor servidor = null;
	
	public Search() throws Exception {
		 
		try {
			servidor = new Servidor(new Socket("localhost", 12345));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		setTitle("Song Shop");
		setResizable(false);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(110, 110, 640, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(6, 6, 6, 6));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Titulo da musica");
		lblTitulo.setBounds(35, 15, 100, 20);
		contentPane.add(lblTitulo);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(10, 40, 150, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);

		JLabel lblArtista = new JLabel("Artista");
		lblArtista.setBounds(300, 15, 100, 20);
		contentPane.add(lblArtista);

		txtArtista = new JTextField();
		txtArtista.setBounds(245, 40, 150, 20);
		contentPane.add(txtArtista);
		txtArtista.setColumns(10);

		JLabel lblEstilo = new JLabel("Estilo");
		lblEstilo.setBounds(535, 15, 100, 20);
		contentPane.add(lblEstilo);

		txtEstilo = new JTextField();
		txtEstilo.setBounds(475, 40, 150, 20);
		contentPane.add(txtEstilo);
		txtEstilo.setColumns(10);

		List listResultado = new List();
		listResultado.setBounds(22, 90, 400, 227);
		contentPane.add(listResultado);

		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBounds(165, 325, 115, 35);
		contentPane.add(btnAdicionar);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(22, 325, 115, 35);
		contentPane.add(btnPesquisar);

		JButton btnLimpar = new JButton("Limpar");

		btnLimpar.setBounds(307, 325, 115, 35);
		contentPane.add(btnLimpar);

		
		JButton btnLimpaCarrinho = new JButton("Limpar");
		btnLimpaCarrinho.setBounds(500, 370, 90, 25);
		contentPane.add(btnLimpaCarrinho);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 75, 640, 5);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(460, 75, 6, 330);
		contentPane.add(separator_1);

		JLabel lblSeuCarrinho = new JLabel("Seu Carrinho");
		lblSeuCarrinho.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeuCarrinho.setBounds(485, 85, 132, 15);
		this.getContentPane().setBackground(Color.lightGray);
		contentPane.add(lblSeuCarrinho);

		JLabel lblMusicasqtd = new JLabel("Musicas:");
		lblMusicasqtd.setBounds(470, 140, 89, 14);
		contentPane.add(lblMusicasqtd);

		JLabel lblDuracao = new JLabel("Duração total:");
		lblDuracao.setBounds(470, 190, 89, 14);
		contentPane.add(lblDuracao);

		JLabel lblDesconto = new JLabel("Desconto:");
		lblDesconto.setBounds(470, 240, 89, 14);
		contentPane.add(lblDesconto);

		JLabel lblValorSomado = new JLabel("Valor somado:");
		lblValorSomado.setBounds(470, 290, 89, 14);
		contentPane.add(lblValorSomado);

		JLabel lblValorFinal = new JLabel("Valor final:");
		lblValorFinal.setBounds(470, 340, 89, 14);
		contentPane.add(lblValorFinal);

		JLabel lblMusicas = new JLabel("0");
		lblMusicas.setBounds(525, 140, 89, 14);
		contentPane.add(lblMusicas);

		JLabel lblDuracaoqtd = new JLabel("0:00");
		lblDuracaoqtd.setBounds(552, 190, 89, 14);
		contentPane.add(lblDuracaoqtd);

		JLabel lblDescontoqtd = new JLabel("0%");
		lblDescontoqtd.setBounds(530, 240, 89, 14);
		contentPane.add(lblDescontoqtd);

		JLabel lblValorSomadoqtd = new JLabel("R$0,00");
		lblValorSomadoqtd.setBounds(555, 290, 89, 14);
		contentPane.add(lblValorSomadoqtd);

		JLabel lblValorFinalqtd = new JLabel("R$0,00");
		lblValorFinalqtd.setBounds(535, 340, 89, 14);
		contentPane.add(lblValorFinalqtd);

		Lista<Music> todas = servidor.listarTodas();
		listaAtual = new Lista<Music>();
		while (!todas.isVazia()) {
			try {
				listResultado.add(todas.getItem().toString());
				listaAtual.insereItem(todas.getItem());
				todas.removeItem();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		Wishes wishes = new Wishes();
		
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					wishes.lista.insereItem(listaAtual.getItem(listResultado.getSelectedIndex() + 1));
				} 
				catch (Exception e1) {
					e1.printStackTrace();
				}
				lblMusicas.setText(String.valueOf(wishes.lista.getTamanho()));
				double duracao = (int)wishes.getDuracao()/60;
				int durmin = (int)duracao;
				double durseg = duracao - durmin;
				lblDuracaoqtd.setText(String.valueOf(durmin) + " min");
				int desconto = wishes.getDesconto();
				lblDescontoqtd.setText(String.valueOf(desconto) + "%");
				float valorsd = wishes.getValorBruto();
				lblValorSomadoqtd.setText("R$ " + new DecimalFormat("#.##").format(valorsd));
				float valorfinal = wishes.getValorFinal();
				lblValorFinalqtd.setText("R$ " + new DecimalFormat("#.##").format(valorfinal));
			}
		});
		
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				listResultado.clear();
				txtArtista.setText("");
				txtEstilo.setText("");
				txtTitulo.setText("");
				listaAtual = new Lista<Music>();
				Lista<Music> todas = new Lista<Music>();
				todas = servidor.listarTodas();
				while (!todas.isVazia()) {
					try {
						listResultado.add(todas.getItem().toString());
						listaAtual.insereItem(todas.getItem());
						todas.removeItem();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		btnPesquisar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				listResultado.clear();
				listaAtual = new Lista<Music>();

				if (txtArtista.getText().length() != 0) {
					Lista<Music> porArtista = servidor.filtrar("Artista", txtArtista.getText());
					while (!porArtista.isVazia()) {
						try {
							listResultado.add(porArtista.getItem().toString());
							listaAtual.insereItem(porArtista.getItem());
							porArtista.removeItem();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					
				}
				
				if (txtEstilo.getText() != null && txtEstilo.getText().length() != 0) {
					Lista<Music> porEstilo = servidor.filtrar("Estilo", txtEstilo.getText());
					while (!porEstilo.isVazia()) {
						try {
							listResultado.add(porEstilo.getItem().toString());
							listaAtual.insereItem(porEstilo.getItem());
							porEstilo.removeItem();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				
				if (txtTitulo.getText().length() != 0) {
					Lista<Music> porTitulo = servidor.filtrar("Titulo", txtTitulo.getText());
					while (!porTitulo.isVazia()) {
						try {
							listResultado.add(porTitulo.getItem().toString());
							listaAtual.insereItem(porTitulo.getItem());
							porTitulo.removeItem();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				
			}
		});
		
		btnLimpaCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 1;
				lblMusicas.setText("0");
				lblValorFinalqtd.setText("R$0,00");
				lblDuracaoqtd.setText("0");
				lblValorSomadoqtd.setText("R$0,00");
				lblDescontoqtd.setText("0%");
				wishes.lista = new Lista<Music>();
			}
		});
	}
}
