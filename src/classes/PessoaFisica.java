package classes;

public class PessoaFisica extends Perfil{

	long cpf;
	
	public PessoaFisica(String usuario, long cpf){
		
		this.setCpf(cpf);
		this.setUsuario(usuario);
		this.setAtivo(true);
		
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	
	
	
}
