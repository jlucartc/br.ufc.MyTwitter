package GUI;

import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import myTwitter.MyTwitter;
import repositorio.IRepositorioUsuario;

public class MyTwitterScreenManager extends JFrame{

	private MyTwitterCadastro myTwitterCadastro;
	private MyTwitterLogin myTwitterLogin;
	private MyTwitterHome myTwitterHome;
	private MyTwitter mytwitter;
	private IRepositorioUsuario repositorio;
	
	public MyTwitterScreenManager(IRepositorioUsuario repositorio){
	
		this.repositorio = repositorio;
		this.mytwitter = new MyTwitter(this.repositorio);
		
		this.myTwitterCadastro = new MyTwitterCadastro(this,this.mytwitter);
		//this.myTwitterCadastro.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.myTwitterLogin = new MyTwitterLogin(this,this.repositorio);
		//this.myTwitterLogin.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.myTwitterCadastro.setVisible(false);
	
	}
	
	public void cadastro(){
		
		this.myTwitterLogin.setVisible(false);
		this.myTwitterLogin.dispatchEvent(new WindowEvent(this.myTwitterLogin, WindowEvent.WINDOW_CLOSING));
		//this.myTwitterLogin.dispose();
		this.myTwitterLogin = new MyTwitterLogin(this,this.getRepositorio());
		this.myTwitterLogin.setVisible(false);
		this.myTwitterCadastro.setVisible(true);
		
	}
	
	public void login(){
		
		this.myTwitterCadastro.setVisible(false);
		this.myTwitterCadastro.dispatchEvent(new WindowEvent(this.myTwitterCadastro, WindowEvent.WINDOW_CLOSING));
		//this.myTwitterCadastro.dispose();
		this.myTwitterCadastro = new MyTwitterCadastro(this,this.getMyTwitter());
		this.myTwitterCadastro.setVisible(false);
		this.myTwitterLogin.setVisible(true);
		
	}
	
	public void home(){
		
		this.myTwitterLogin.setVisible(false);
		this.myTwitterCadastro.setVisible(false);
		
	}
	
	public MyTwitter getMyTwitter(){
		
		return this.mytwitter;
		
	}
	
	public IRepositorioUsuario getRepositorio(){
		
		return this.repositorio;
		
	}
	
	
	
}
