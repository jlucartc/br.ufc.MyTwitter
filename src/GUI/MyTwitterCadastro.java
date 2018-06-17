package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GUI.classesAbstratas.MyTwitterViewCadastro;
import GUI.interfaces.MyTwitterView;
import GUI.interfaces.MyTwitterViewManager;
import classes.PessoaFisica;
import excecoes.PEException;
import excecoes.UJCException;
import listeners.FazerCadastroListener;
import listeners.PlaceholderListener;
import listeners.TerminarListener;
import listeners.VoltarListener;
import myTwitter.MyTwitter;

@SuppressWarnings("serial")
public class MyTwitterCadastro extends 	MyTwitterViewCadastro implements MyTwitterView{

	private JLabel usuarioLabel;
	private JLabel aviso;
	private JLabel cpfLabel;
	private JTextField usuario;
	private JTextField cpf;
	private JButton cadastrar;
	private JButton voltar;
	private JPanel botoes;
	private MyTwitter mytwitter;
	private MyTwitterViewManager viewManager;
	
	public MyTwitterCadastro(MyTwitterViewManager viewManager,MyTwitter mytwitter) {
		
		this.viewManager = viewManager;
		this.aviso = new JLabel();
		this.aviso.setAlignmentX(CENTER_ALIGNMENT);
		this.cpfLabel = new JLabel("CPF");
		this.usuarioLabel = new JLabel("Usuário");
		
		this.cpf = new JTextField("Digite seu cpf: ");
		this.mytwitter = mytwitter;
		this.usuario = new JTextField("Digite seu usuário: ");
		this.cadastrar = new JButton("Cadastrar");
		this.voltar = new JButton("Voltar");
		this.botoes = new JPanel();	
		
		this.setMinimumSize(new Dimension(400,1200));
		this.cpf.setMaximumSize(new Dimension(300,30));
		this.cpf.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.usuario.setMaximumSize(new Dimension(300,30));
		this.usuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.cadastrar.setMaximumSize(new Dimension(100,30));
		this.cadastrar.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.cadastrar.addActionListener(new FazerCadastroListener());
		this.voltar.setMaximumSize(new Dimension(100,30));
		this.voltar.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.voltar.addActionListener(new VoltarListener());
		this.usuario.addMouseListener(new PlaceholderListener());
		this.cpf.addMouseListener(new PlaceholderListener());
		
		this.botoes.setLayout(new FlowLayout());
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		
		//this.logoPanel.add(this.logo);
		this.botoes.add(this.cadastrar);
		this.botoes.add(this.voltar);
		this.botoes.setMaximumSize(new Dimension(300,30));
		this.botoes.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//this.add(this.logoPanel);
		this.add(this.aviso);
		this.add(Box.createRigidArea(new Dimension(0,10)));
		this.add(this.usuarioLabel);
		this.add(Box.createRigidArea(new Dimension(0,10)));
		this.add(this.usuario);
		this.add(Box.createRigidArea(new Dimension(0,10)));
		this.add(this.cpfLabel);
		this.add(Box.createRigidArea(new Dimension(0,10)));
		this.add(this.cpf);
		this.add(Box.createRigidArea(new Dimension(0,100)));
		this.add(this.botoes);
		this.addWindowListener(new TerminarListener());
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public void setAviso(String str,Color cor){
		
		this.aviso.setText(str);
		this.aviso.setForeground(cor);
		
	}
	
	public void fazerCadastro() {
		
		try{
			
			this.mytwitter.criarPerfil(new PessoaFisica(this.getUsuario(),Long.parseLong(this.cpf.getText())));
			this.setAviso("Cadastro feito com sucesso!",Color.GREEN);
			System.out.println(this.usuario.getText());
			System.out.println(this.usuario.getText().length());
			
		}catch(PEException | UJCException e){
			
			this.setAviso("Usuário inválido",Color.RED);
			
		}catch(NumberFormatException e){
			this.setAviso("CPF em formato inválido",Color.red);
			//e.printStackTrace();
		}catch (IOException e) {
			this.setAviso("Erro no cadastro",Color.red);
			//e.printStackTrace();
		}
		
	}
	
	public long getCpf(){
		
		return Long.parseLong(this.cpf.getText().trim());
		
	}
	
	public String getUsuario(){
		
		return this.usuario.getText().trim();
		
	}
	
	public void resetar(){
		
		this.aviso.setText("");
		this.usuario.setText("Digite seu usuário: ");
		this.cpf.setText("Digite seu cpf: ");
		
	}

	@Override
	public MyTwitterViewManager getViewManager() {
		
		return this.viewManager;
		
	}

	@Override
	public void mostrar(boolean mostrar) {
		
		this.setVisible(mostrar);
		
	}

	@Override
	public void recarregarView() {
		
		this.resetar();
		
	}
	
}
