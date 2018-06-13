package myTwitter;

import java.util.Iterator;
import java.util.Vector;

import classes.*;
import excecoes.MFPException;
import excecoes.PDException;
import excecoes.PEException;
import excecoes.PIException;
import excecoes.SIException;
import excecoes.UJCException;
import repositorio.*;

public class MyTwitter implements ITwitter{

	private IRepositorioUsuario repositorio;
	
	public MyTwitter(IRepositorioUsuario repositorio) {
		
		this.repositorio = repositorio;
		
	}

	@Override
	public void criarPerfil(Perfil usuario) throws PEException, UJCException {
		
		if(this.repositorio.buscar(usuario.getUsuario()) == null){
			
			this.repositorio.cadastrar(usuario);
			
		}else {
			
			throw new PEException();
			
		}
		
	}
	@Override
	public void cancelarPerfil(String usuario) throws PIException,PDException{

		Perfil perfil = this.repositorio.buscar(usuario);
		
		if(perfil != null) {

			if(perfil.isAtivo()) {
				
				perfil.setAtivo(false);
				
			}else {
				
				throw new PDException();
				
			}
			
		}else {
			
			throw new PIException();
			
		}
		
	}

	@Override
	public void tweetar(String usuario, String mensagem) throws PIException, MFPException, PDException{
		if(mensagem.length() <= 140) {
			
			Tweet tweet = new Tweet();
			
			tweet.setMensagem(mensagem);
			tweet.setUsuario(usuario);
			
			Perfil perfil = this.repositorio.buscar(usuario);
			
			if(perfil != null) {
			
				if(perfil.isAtivo()) {
					
					perfil.addTweet(tweet);
					
					Iterator<Perfil> iterator = perfil.getSeguidores().iterator();
					
					while(iterator.hasNext()) {
						
						Perfil item = iterator.next();
						
						item.addTweet(tweet);
						
					}
					
				}else{
					
					throw new PDException();
					
				}
				
			}else {
				
				throw new PIException();
			}
			
		}else {
			
			throw new MFPException();
			
		}
		
	}

	@Override
	public Vector<Tweet> timeline(String usuario) throws PIException,PDException{
		
		Perfil perfil = this.repositorio.buscar(usuario);
		
		if(perfil != null) {
			
			if(perfil.isAtivo()){
				
				return perfil.getTimeline();
				
			}else {
				
				throw new PDException();
				
			}
			
		}else {
			
			throw new PIException();
			
		}
		
	}

	@Override
	public Vector<Tweet> tweets(String usuario) throws PIException, PDException{
		
		Perfil perfil = this.repositorio.buscar(usuario);
		
		if(perfil != null) {
			
			if(perfil.isAtivo()) {
				
				Vector<Tweet> tweets = perfil.getTimeline();
				
				Iterator<Tweet> iterator = tweets.iterator();
				
				while(iterator.hasNext()) {
					
					Tweet tweet = iterator.next();
					
					if(!tweet.getUsuario().equals(usuario)) {
						
						iterator.remove();
						
					}
					
				}
				
				return tweets;
				
			}else {
				
				throw new PDException();
				
			}
			
		}else {
			
			throw new PIException();
			
		}
	}

	@Override
	public void seguir(String seguidor, String seguido) throws PIException, PDException, SIException{
		Perfil perfilSeguidor = this.repositorio.buscar(seguidor);
		
		Perfil perfilSeguido = this.repositorio.buscar(seguido);
		
		if(perfilSeguidor != null && perfilSeguido != null) {
			
			if(perfilSeguidor.isAtivo() && perfilSeguido.isAtivo()){
				
				if(perfilSeguidor.getUsuario() != perfilSeguido.getUsuario()){
					
					perfilSeguidor.addSeguido(perfilSeguido);
					
					perfilSeguido.addSeguidor(perfilSeguidor);
					
				}else{
					
					throw new SIException();
					
				}
				
			}else {
				
				throw new PDException();
				
			}
			
		}else {
			
			throw new PIException();
			
		}
		
	}

	@Override
	public int numeroSeguidores(String usuario) throws PIException,PDException{
		Perfil perfil = this.repositorio.buscar(usuario);
		
		if(perfil != null) {
			
			if(perfil.isAtivo()) {
				
				Iterator<Perfil> iterator = perfil.getSeguidores().iterator();
				
				int quantidade = 0;
				
				while(iterator.hasNext()) {
					
					Perfil seguidor = iterator.next();
					
					if(this.repositorio.buscar(seguidor.getUsuario()) != null){
						
						if(seguidor.isAtivo()) {
							
							quantidade+=1;
							
						}else {
							
							throw new PDException();
							
						}
						
					}else {
						
						throw new PIException();
						
					}
					
				}
				
				return quantidade;
				
			}else{
				
				throw new PDException();
				
			}
			
		}else {
			
			throw new PIException();
			
		}
	}

	@Override
	public Vector<Perfil> seguidores(String usuario) throws PIException, PDException {
		
		Perfil perfil = this.repositorio.buscar(usuario);
		
		if(perfil != null){
			
			if(perfil.isAtivo()) {
			
				Vector<Perfil> seguidores = perfil.getSeguidores();
				
				Iterator<Perfil> iterator = seguidores.iterator();
				
				while(iterator.hasNext()){
					
					Perfil seguidor = iterator.next();
					
					if(this.repositorio.buscar(seguidor.getUsuario()) != null || !(seguidor.isAtivo()) ) {
						
						iterator.remove();
						
					}
					
				}
				
				return seguidores;
				
			}else {
				
				throw new PDException();
				
			}
			
		}else {
			
			throw new PIException();
			
		}
		
	}

	@Override
	public Vector<Perfil> seguidos(String usuario) throws PIException, PDException{

		Perfil perfil = this.repositorio.buscar(usuario);
		
		if(perfil != null){
			
			if(perfil.isAtivo()) {
				
				Vector<Perfil> seguidos = perfil.getSeguidos();
				
				Iterator<Perfil> iterator = seguidos.iterator();
				
				while(iterator.hasNext()) {
					
					Perfil seguido = iterator.next();
					
					if(this.repositorio.buscar(seguido.getUsuario()) == null || !(seguido.isAtivo()) ){
						
						iterator.remove();
						
					}
					
				}
				
				return seguidos;
				
			}else {
				
				throw new PDException();
				
			}
			
		}else{
			
			throw new PIException();
			
		}
		
	}
}
