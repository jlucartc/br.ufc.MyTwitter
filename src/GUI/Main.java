package GUI;

import classes.Perfil;
import classes.PessoaFisica;

public class Main {

	public static void main(String[] args) {
		try {
	
			MyTwitterLogin login = new MyTwitterLogin();
			MyTwitterCadastro janela = new MyTwitterCadastro();
			Perfil perfil = new PessoaFisica();
			perfil.setUsuario("Usuario 1");
			MyTwitterHome home = new MyTwitterHome(perfil);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
