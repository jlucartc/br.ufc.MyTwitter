package GUI;

import classes.Perfil;
import classes.PessoaFisica;
import myTwitter.MyTwitter;
import repositorio.IRepositorioUsuario;
import repositorio.RepositorioUsuarioXML;

public class Main {

	public static void main(String[] args) {
		try {
	
			MyTwitterScreenManager mytwitterScreenManager = new MyTwitterScreenManager(new RepositorioUsuarioXML()); 
			/*MyTwitterLogin login = new MyTwitterLogin(repositorio);
			MyTwitterCadastro janela = new MyTwitterCadastro(mytwitter);*/
			/*Perfil perfil = new PessoaFisica();
			perfil.setUsuario("Usuario 1");
			MyTwitterHome home = new MyTwitterHome(perfil);*/
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
