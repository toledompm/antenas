
public class MembroCadi {
	private String matricula;
	private DadosLogin dadosLogin;
	
	public MembroCadi(String matricula, DadosLogin dadosLogin) {
		super();
		this.matricula = matricula;
		this.dadosLogin = dadosLogin;
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public DadosLogin getDadosLogin() {
		return dadosLogin;
	}
	public void setDadosLogin(DadosLogin dadosLogin) {
		this.dadosLogin = dadosLogin;
	}
	
	
}
