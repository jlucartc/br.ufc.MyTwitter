package repositorio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import com.thoughtworks.xstream.XStream;

import classes.Perfil;
import excecoes.PIException;
import excecoes.UNCException;

public class RepositorioUsuarioXML implements IRepositorioUsuario{

	private Vector<Perfil> usuarios;
	
	private String nomeArquivo;
	
	public RepositorioUsuarioXML() {
		
		try {
			
			this.carregarUsuarios();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void cadastrar(Perfil usuario) {
		
		this.usuarios.addElement(usuario);
		
	}

	@Override
	public Perfil buscar(String usuario){
		
		Iterator<Perfil> iterator = this.usuarios.iterator();
		
		while(iterator.hasNext()) {
			
				Perfil perfil = iterator.next();
			
				if(perfil.getUsuario().equals(usuario)) {
					
					return perfil;
					
				}
			
		}
		
		return null;
		
	}

	@Override
	public void atualizar(Perfil usuario) throws UNCException {
	
		//
		
	}
	
	void carregarUsuarios() throws IOException{
		
		File arquivo = new File(this.nomeArquivo);
		
		FileInputStream entrada = new FileInputStream(arquivo);
		
		if(!arquivo.exists()){
			
			arquivo.mkdirs();
			
		}else {
			
			XStream xstream = new XStream();
			
			this.usuarios = (Vector<Perfil>) xstream.fromXML(entrada);
			
		}
		
	}
	
	void salvarUsuarios() throws IOException{
		
		File arquivo = new File(this.nomeArquivo);
		
		FileOutputStream saida = new FileOutputStream(arquivo);
		
		if(!arquivo.exists()) {
			
			arquivo.mkdirs();
			
		}else {
			
			XStream xstream = new XStream();
			
			xstream.toXML(this.usuarios, saida);
			
		}
		
	}
	
}
