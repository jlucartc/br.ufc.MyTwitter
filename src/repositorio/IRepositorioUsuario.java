package repositorio;

import classes.Perfil;
import excecoes.UJCException;
import excecoes.UNCException;

public interface IRepositorioUsuario {

	void cadastrar(Perfil usuario) throws UJCException;
	
	Perfil buscar(String usuario);
	
	void atualizar(Perfil usuario) throws UNCException;
	
	
}
