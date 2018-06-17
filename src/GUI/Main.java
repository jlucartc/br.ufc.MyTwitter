package GUI;

import repositorio.RepositorioUsuarioXML;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
	
			MyTwitterScreenManager mytwitterScreenManager = new MyTwitterScreenManager(new RepositorioUsuarioXML()); 
	
	}

}
