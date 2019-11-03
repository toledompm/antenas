
public class Professor {
	

	private String matricula;
	private DadosLogin dadosLogin = new DadosLogin();
	
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
