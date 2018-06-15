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
		this.myTwitterCadastro.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.myTwitterLogin = new MyTwitterLogin(this,this.repositorio);
		this.myTwitterLogin.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.myTwitterCadastro.setVisible(false);
	
	}
	
	public void cadastro(){
		
		this.myTwitterLogin.setVisible(false);
		this.myTwitterLogin.dispose();
		this.myTwitterLogin.setVisible(false);
		this.myTwitterCadastro.resetar();
		this.myTwitterCadastro.setVisible(true);
		
	}
	
	public void login(){
		
		this.myTwitterCadastro.setVisible(false);
		this.myTwitterCadastro.dispose();
		this.myTwitterCadastro.setVisible(false);
		this.myTwitterLogin.setVisible(true);
		this.myTwitterLogin.resetar();
		
	}
	
	public void home(String usuario){
		
		this.myTwitterLogin.setVisible(false);
		this.myTwitterCadastro.setVisible(false);
		this.myTwitterHome = new MyTwitterHome(usuario);
		this.myTwitterHome.setVisible(true);
		
	}
	
	public MyTwitter getMyTwitter(){
		
		return this.mytwitter;
		
	}
	
	public IRepositorioUsuario getRepositorio(){
		
		return this.repositorio;
		
	}
	
	
	
}
