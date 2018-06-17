package GUI;

import GUI.classesAbstratas.MyTwitterViewCadastro;
import GUI.classesAbstratas.MyTwitterViewHome;
import GUI.classesAbstratas.MyTwitterViewLogin;
import GUI.interfaces.MyTwitterView;
import GUI.interfaces.MyTwitterViewManager;
import myTwitter.MyTwitter;
import repositorio.IRepositorioUsuario;

public class MyTwitterScreenManager implements MyTwitterViewManager{

	private MyTwitterViewCadastro myTwitterCadastro;
	private MyTwitterViewLogin myTwitterLogin;
	private MyTwitterViewHome myTwitterHome;
	private MyTwitter mytwitter;
	private IRepositorioUsuario repositorio;

	
	public MyTwitterScreenManager(IRepositorioUsuario repositorio){
	
		this.repositorio = repositorio;
		this.mytwitter = new MyTwitter(this.repositorio);
		
		this.myTwitterHome = new MyTwitterHome(this,"",this.mytwitter);
		this.myTwitterCadastro = new MyTwitterCadastro(this,this.mytwitter);
		this.myTwitterLogin = (MyTwitterViewLogin) new MyTwitterLogin(this,this.repositorio);
		
		this.ativarView(this.myTwitterLogin.getClass());
	
	}

	
	public MyTwitter getMyTwitter(){
		
		return this.mytwitter;
		
	}
	
	public IRepositorioUsuario getRepositorio(){
		
		return this.repositorio;
		
	}

	public void encerrar() {
		
		System.exit(0);
		
	}
	
	public MyTwitterViewLogin getMyTwitterLogin(){
		
		return this.myTwitterLogin;
		
	}
	
	public MyTwitterViewCadastro getMyTwitterCadastro(){
		
		return this.myTwitterCadastro;
		
	}
	
	public MyTwitterViewHome getMyTwitterHome(){
		
		return this.myTwitterHome;
		
	}


	@Override
	public void ativarView(Class view) {
		
		if(MyTwitterViewCadastro.class.isAssignableFrom(view)){
			
			this.myTwitterHome.mostrar(false);
			this.myTwitterLogin.mostrar(false);
			this.myTwitterCadastro.recarregarView();
			this.myTwitterCadastro.mostrar(true);
			
		}else if(MyTwitterViewHome.class.isAssignableFrom(view)){
			
			this.myTwitterCadastro.mostrar(false);
			this.myTwitterLogin.mostrar(false);
			this.myTwitterHome.dispose();
			this.myTwitterHome = new MyTwitterHome(this,this.myTwitterLogin.getUsuario(),this.mytwitter);
			this.myTwitterHome.recarregarView();
			this.myTwitterHome.mostrar(true);

			
		}else if(MyTwitterLogin.class.isAssignableFrom(view)){
			
			this.myTwitterHome.mostrar(false);
			this.myTwitterCadastro.mostrar(false);
			this.myTwitterLogin.recarregarView();
			this.myTwitterLogin.mostrar(true);
			
		}
		
	}


	@Override
	public MyTwitterView getView(Class view) {
		
		if(MyTwitterViewHome.class.isAssignableFrom(view)){
			
			return this.myTwitterHome;
			
		}else if(MyTwitterViewHome.class.isAssignableFrom(view)){
			
			return this.myTwitterLogin;
			
		}else if(MyTwitterViewCadastro.class.isAssignableFrom(view)){
			
			return this.myTwitterCadastro;
			
		}
		
		return null;
		
	}
	
}
