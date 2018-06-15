package repositorio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import com.thoughtworks.xstream.XStream;

import classes.Perfil;
import excecoes.UJCException;
import excecoes.UNCException;

public class RepositorioUsuarioXML implements IRepositorioUsuario{

	private Vector<Perfil> usuarios;
	private String nomeArquivo;
	private String caminho;
	
	
	public RepositorioUsuarioXML() {
		
		this.caminho = "/home/luca/MyTwitter";
		this.nomeArquivo = "/perfis.xml";
		
		try {
			
			this.carregarUsuarios();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void cadastrar(Perfil usuario) throws UJCException, IOException{
		
		this.usuarios.add(usuario);
		this.salvarUsuarios();
		
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
	public void atualizar(Perfil usuario) throws UNCException, IOException {
	
		Perfil perfil = this.buscar(usuario.getUsuario());
				
		if(perfil != null){
			
			perfil = usuario;
			
		}else{
			
			throw new UNCException();
			
		}
		
		this.salvarUsuarios();
					
		
	}
	
	void carregarUsuarios() throws IOException{
		
		File arquivo = new File(this.caminho);
		
		if(!arquivo.exists()){
			
			arquivo.mkdirs();
			
		}
		
		arquivo = new File(this.caminho+this.nomeArquivo);
		
		if(!arquivo.exists()){
			
			this.usuarios = new Vector();
			
		}else{
			FileInputStream entrada = new FileInputStream(arquivo);
			
				
			XStream xstream = new XStream();
				
			this.usuarios = (Vector<Perfil>) xstream.fromXML(entrada);
		}
		
	}
	
	void salvarUsuarios() throws IOException{
		
		File arquivo = new File(this.caminho);
		
		if(!arquivo.exists()) {
			
			arquivo.mkdirs();
			
		}
			
		arquivo = new File(this.caminho+this.nomeArquivo);
		
		if(!arquivo.exists()){
			
			arquivo.createNewFile();
			
		}
				
		FileOutputStream saida = new FileOutputStream(arquivo);
		
		XStream xstream = new XStream();
			
		xstream.toXML(this.usuarios, saida);
			
		
	}
	
}
