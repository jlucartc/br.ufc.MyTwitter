package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import classes.PessoaFisica;
import eventListeners.VoltarListener;
import excecoes.PEException;
import excecoes.UJCException;
import myTwitter.MyTwitter;

public class MyTwitterCadastro extends JFrame{

	private JLabel logo;
	private JLabel usuarioLabel;
	private JLabel aviso;
	private JLabel cpfLabel;
	private JTextField usuario;
	private JTextField cpf;
	private JButton cadastrar;
	private JButton voltar;
	private JPanel botoes;
	private JPanel logoPanel;
	private MyTwitter mytwitter;
	private boolean isPessoaFisica;
	private MyTwitterScreenManager screenManager;
	
	public MyTwitterCadastro(MyTwitterScreenManager screenManager,MyTwitter mytwitter) {
		
		this.screenManager = screenManager;
		this.aviso = new JLabel();
		this.cpfLabel = new JLabel("CPF");
		this.usuarioLabel = new JLabel("Usuário");
		
		this.isPessoaFisica = false;
		this.cpf = new JTextField("Digite seu cpf");
		this.mytwitter = mytwitter;
		this.logo = new JLabel("MyTwitter");
		this.logoPanel = new JPanel();
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
		this.voltar.setMaximumSize(new Dimension(100,30));
		this.voltar.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.voltar.addActionListener(new VoltarListener());
		
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
		
		this.setVisible(true);
		
	}

	public void setAviso(String str,Color cor){
		
		this.aviso.setText(str);
		this.aviso.setForeground(cor);
		
	}
	
	public void fazerCadastro() {
		
		try{
			
			this.mytwitter.criarPerfil(new PessoaFisica(this.usuario.getText(),Long.parseLong(this.cpf.getText())));
			this.setAviso("Cadastro feito com sucesso!",Color.GREEN);
			
		}catch(PEException e){
			
			this.setAviso("Cadastro inválido!",Color.RED);
			
		}catch(UJCException e){
			
			this.setAviso("Cadastro inválido!",Color.RED);
			
		}
		
	}
	
	public long getCpf(){
		
		return Long.parseLong(this.cpf.getText());
		
	}
	
	public String getUsuario(){
		
		return this.usuario.getText();
		
	}
	
	public MyTwitterScreenManager getScreenManager(){
		
		return this.screenManager;
		
	}
	
}
