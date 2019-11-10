
public class Professor {
	

	private String matricula;
	private DadosLogin dadosLogin;
	
	public Professor(String matricula, DadosLogin dadosLogin) {
		super();
		this.matricula = matricula;
		this.dadosLogin = dadosLogin;
	}
	
	public DadosLogin getDadosLogin() {
		return dadosLogin;
	}
	public void setDadosLogin(DadosLogin dadosLogin) {
		this.dadosLogin = dadosLogin;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
}
