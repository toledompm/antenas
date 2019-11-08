import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestJUnit {
	//Declarando os valores dafault de um objeto DadosLogin
	private String emailDadosLogin = "email@DadosLogin";
	private String senhaDadosLogin = "senhaDadosLogin";
	
	//Declarando os valores default de um objeto Professor
	private String emailProfessor = "email@Professor";
	private String senhaProfessor = "senhaProfessor";
	private String matriculaProfessor = "mat";
	
	//Declarando os valores default de um objeto Aluno
	private String emailAluno = "email@Aluno";
	private String senhaAluno = "senhaAluno";

	//Declarando os valores default de um objeto Empresario
	private String emailEmpresario = "email@Empresario";
	private String senhaEmpresario = "senhaEmpresario";
	private String cpfEmpresario = "000.000.000-00";
	
	//Declarando os valores default de um objeto CADI
	private String emailCadi = "email@Cadi";
	private String senhaCadi = "senhaCadi";
	private String matriculaCadi = "mat";
	
	public TestJUnit() {
		//Executando os testes da classe DadosLogin
		testDadosLogin();
		
		//Executando os testes da classe Professor
		testProfessor();
		
		//Executando os testes da classe Sistema
		testSistema();
		
		//Executando os testes da classe Aluno
		testAluno();
		
		//Executando os testes da classe Empresario
		testEmpresario();
		
		//Executando os testes da classe Cadi
		testCadi();
	}
	@Test
	public void testCadi() {
		CADI cadi = new CADI();
		DadosLogin dadosLoginCadi = new DadosLogin();
		
		dadosLoginCadi.setEmail(emailCadi);
		dadosLoginCadi.setSenha(senhaCadi);
		cadi.setDadosLogin(dadosLoginCadi);
		cadi.setMatricula(matriculaCadi);
		
		assertEquals(cadi.getDadosLogin(),dadosLoginCadi);
		assertEquals(cadi.getMatricula(),matriculaCadi);
	}
	
	@Test
	public void testEmpresario() {
		Empresario empresario = new Empresario();
		DadosLogin dadosLoginEmpresario = new DadosLogin();
		
		dadosLoginEmpresario.setEmail(emailEmpresario);
		dadosLoginEmpresario.setSenha(senhaEmpresario);
		
		empresario.setCpf(cpfEmpresario);
		empresario.setDadosLogin(dadosLoginEmpresario);
		
		assertEquals(empresario.getDadosLogin(),dadosLoginEmpresario);
		assertEquals(empresario.getCpf(),cpfEmpresario);
	}
	
	@Test
	public void testAluno() {
		Aluno aluno = new Aluno();
		DadosLogin dadosLoginAluno = new DadosLogin();
		
		dadosLoginAluno.setEmail(emailAluno);
		dadosLoginAluno.setSenha(senhaAluno);
		
		aluno.setDadosLogin(dadosLoginAluno);
		assertEquals(aluno.getDadosLogin(),dadosLoginAluno);
	}
	@Test
	public void testDadosLogin() {
		DadosLogin dadosLogin = new DadosLogin();
		dadosLogin.setEmail(emailDadosLogin);
		dadosLogin.setSenha(senhaDadosLogin);
				
		assertEquals(dadosLogin.getEmail(),emailDadosLogin);
		assertEquals(dadosLogin.getSenha(),senhaDadosLogin);
	}
	@Test
	public void testProfessor() {
		Professor prof = new Professor();
		DadosLogin dadosLoginProfessor = new DadosLogin();
		
		dadosLoginProfessor.setEmail(emailProfessor);
		dadosLoginProfessor.setSenha(senhaProfessor);
		prof.setDadosLogin(dadosLoginProfessor);
		prof.setMatricula(matriculaProfessor);
		
		assertEquals(prof.getDadosLogin(),dadosLoginProfessor);
		assertEquals(prof.getMatricula(),matriculaProfessor);
	}
	@Test
	public void testSistema() {
		Sistema sis = new Sistema();
		
		Professor professor = new Professor();
		Professor professorRepetido = new Professor();
		Professor professorNulo = new Professor();
		DadosLogin dadosLoginProfessor = new DadosLogin();
		
		dadosLoginProfessor.setEmail(emailProfessor);
		dadosLoginProfessor.setSenha(senhaProfessor);
		professor.setDadosLogin(dadosLoginProfessor);
		professor.setMatricula(matriculaProfessor);
		professorRepetido.setDadosLogin(dadosLoginProfessor);
		professorRepetido.setMatricula(matriculaProfessor);
		
		Aluno aluno = new Aluno();
		Aluno alunoRepetido = new Aluno();
		Aluno alunoNulo = new Aluno();
		DadosLogin dadosLoginAluno = new DadosLogin();
		
		dadosLoginAluno.setEmail(emailAluno);
		dadosLoginAluno.setSenha(senhaAluno);
		aluno.setDadosLogin(dadosLoginAluno);
		alunoRepetido.setDadosLogin(dadosLoginAluno);
		
		Empresario empresario = new Empresario();
		Empresario empresarioRepetido = new Empresario();
		Empresario empresarioNulo = new Empresario();
		DadosLogin dadosLoginEmpresario = new DadosLogin();
		
		dadosLoginEmpresario.setEmail(emailEmpresario);
		dadosLoginEmpresario.setSenha(senhaEmpresario);
		
		empresario.setDadosLogin(dadosLoginEmpresario);
		empresario.setCpf(cpfEmpresario);
		empresarioRepetido.setDadosLogin(dadosLoginEmpresario);
		empresarioRepetido.setCpf(cpfEmpresario);
		
		CADI cadi = new CADI();
		CADI cadiRepetido = new CADI();
		CADI cadiNulo = new CADI();
		DadosLogin dadosLoginCadi = new DadosLogin();
		
		dadosLoginCadi.setEmail(emailCadi);
		dadosLoginCadi.setSenha(senhaCadi);
		
		cadi.setDadosLogin(dadosLoginCadi);
		cadi.setMatricula(matriculaCadi);
		cadiRepetido.setDadosLogin(dadosLoginCadi);
		cadiRepetido.setMatricula(matriculaCadi);
		
		assertEquals(sis.cadastrarCadi(cadi), 201);
		assertEquals(sis.cadastrarCadi(cadiRepetido), 409);
		assertEquals(sis.cadastrarCadi(cadiNulo), 400);
		assertEquals(sis.loginCadi(dadosLoginCadi),cadi);
		assertEquals(sis.loginCadi(null), null);
		assertEquals(sis.buscarCadiPorEmail(emailCadi),cadi);
		assertEquals(sis.buscarCadiPorEmail(null),null);
		
		assertEquals(sis.cadastrarEmpresario(empresario), 201);
		assertEquals(sis.cadastrarEmpresario(empresarioRepetido),409);
		assertEquals(sis.cadastrarEmpresario(empresarioNulo), 400);
		assertEquals(sis.buscarEmpresarioPorEmailParcial(emailEmpresario).contains(empresario),true);
		assertEquals(sis.buscarEmpresarioPorEmail(emailEmpresario),empresario);
		assertEquals(sis.buscarEmpresarioPorEmail(null),null);
		assertEquals(sis.loginEmpresario(dadosLoginEmpresario),empresario);
		assertEquals(sis.loginEmpresario(null),null);
		
		assertEquals(sis.cadastrarAluno(aluno),201);
		assertEquals(sis.cadastrarAluno(alunoRepetido),409);
		assertEquals(sis.cadastrarAluno(alunoNulo), 400);
		assertEquals(sis.buscarAlunoPorEmailParcial(emailAluno).contains(aluno),true);
		assertEquals(sis.buscarAlunoPorEmail(emailAluno),aluno);
		assertEquals(sis.buscarAlunoPorEmail(null),null);
		assertEquals(sis.loginAluno(dadosLoginAluno),aluno);
		assertEquals(sis.loginAluno(null),null);
		
		assertEquals(sis.cadastrarProfessor(professor),201);
		assertEquals(sis.cadastrarProfessor(professorRepetido),409);
		assertEquals(sis.cadastrarProfessor(professorNulo),400);
		assertEquals(sis.buscarProfessorPorEmailParcial(emailProfessor).contains(professor),true);
		assertEquals(sis.buscarProfessorPorEmail(emailProfessor),professor);
		assertEquals(sis.buscarProfessorPorEmail(null),null);
		//assertEquals(sis.listarProfessores().contains(professor),true);
		assertEquals(sis.loginProfessor(dadosLoginProfessor),professor);
		assertEquals(sis.loginProfessor(null),null);
		
	}
}
