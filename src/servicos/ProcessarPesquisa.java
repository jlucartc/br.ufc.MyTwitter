package servicos;

import java.util.Vector;

import classes.Perfil;
import repositorio.IRepositorioUsuario;

public class ProcessarPesquisa {

	private IRepositorioUsuario repositorio;
	
	public ProcessarPesquisa(IRepositorioUsuario repositorio){
		
		this.repositorio = repositorio;
		
	}
	
	public Vector<Perfil> pesquisarPerfis(String pesquisa){

		String[] palavras = pesquisa.split("\\s+");
		
		Vector<Perfil> v = new Vector<Perfil>();
		
		for(int i = 0; i < palavras.length; i++){
			
			Perfil p = this.repositorio.buscar(palavras[i]);
			
			if(p != null){
				
				System.out.println("Usuario: ");
				v.add(p);
				System.out.println("printando...");
				
			}
			
		}
		
		return v;
		
	}
	
}
