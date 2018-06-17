package classes;

import java.util.Vector;

public abstract class Perfil {

	private String usuario;
	private Vector<Perfil> seguidos;
	private Vector<Perfil> seguidores;
	private Vector<Tweet> timeline;
	private boolean ativo;
	
	public Perfil(){
		
		this.seguidores = new Vector<Perfil>();
		this.seguidos = new Vector<Perfil>();
		this.timeline = new Vector<Tweet>();
		
	}

	public void addSeguido(Perfil usuario) {
		
		this.seguidos.addElement(usuario);
		
	}
	
	public void addSeguidor(Perfil usuario){
		
		this.seguidores.addElement(usuario);
		
	}
	
	public void addTweet(Tweet tweet) {
		
		this.timeline.addElement(tweet);
		
	}
	
	public void setUsuario(String usuario) {
	
		this.usuario = usuario;
		
	}
	
	public String getUsuario(){
		
		return this.usuario;
		
	}
	
	public Vector<Perfil> getSeguidos(){
		
		return this.seguidos;
		
	}
	
	public Vector<Perfil> getSeguidores(){ 
		
		return this.seguidores; 
		
	}
	
	public Vector<Tweet> getTimeline(){
		
		return this.timeline;
		
	}

	public void setAtivo(boolean valor) {
		
		this.ativo = valor;
		
	}
	
	public boolean isAtivo() {
		
		return this.ativo;
		
	}
	
}
