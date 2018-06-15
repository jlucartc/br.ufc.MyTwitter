package classes;

public class PessoaJuridica extends Perfil{

	long cnpj;

	public PessoaJuridica(String usuario, long cnpj){
		
		this.setUsuario(usuario);
		this.setCnpj(cnpj);
		this.setAtivo(true);
		
	}
	
	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
	
	
	
}
