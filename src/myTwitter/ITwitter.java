package myTwitter;

import java.util.Vector;

import classes.Perfil;
import classes.Tweet;
import excecoes.MFPException;
import excecoes.PDException;
import excecoes.PEException;
import excecoes.PIException;
import excecoes.SIException;

public interface ITwitter {

	void criarPerfil(Perfil usuario) throws PEException;
	
	void cancelarPerfil(String usuario) throws PIException, PDException;
	
	void tweetar(String usuario, String mensagem) throws PIException, MFPException, PDException;
	
	Vector<Tweet> timeline(String usuario) throws PIException, PDException;
	
	Vector<Tweet> tweets(String usuario) throws PIException, PDException;
	
	void seguir(String seguidor, String seguido) throws PIException, PDException, SIException;
	
	int numeroSeguidores(String usuario) throws PDException, PIException;
	
	Vector<Perfil> seguidores(String usuario) throws PIException, PDException;
	
	Vector<Perfil> seguidos(String usuario) throws PIException, PDException;
	
}
