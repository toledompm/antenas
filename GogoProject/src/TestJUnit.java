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

	
	public TestJUnit() {
		//Executando os testes da classe DadosLogin
		testDadosLogin();
		
		//Executando os testes da classe Professor
		testProfessor();
		
		//Executando os testes da classe Sistema
		testSistema();
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
	public void testSistema() {
		Sistema sis = new Sistema();
		
		Professor professor = new Professor();
		Professor professorRepetido = new Professor();
		Professor professorNulo = new Professor();
		DadosLogin dadosLoginProfessor = new DadosLogin();
		
		dadosLoginProfessor.setEmail(emailProfessor);
		dadosLoginProfessor.setSenha(senhaProfessor);
		professor.setDadosLogin(dadosLoginProfessor);
		professorRepetido.setDadosLogin(dadosLoginProfessor);
		
		Aluno aluno = new Aluno();
		Aluno alunoRepetido = new Aluno();
		Aluno alunoNulo = new Aluno();
		DadosLogin dadosLoginAluno = new DadosLogin();
		
		dadosLoginAluno.setEmail(emailAluno);
		dadosLoginAluno.setSenha(senhaAluno);
		aluno.setDadosLogin(dadosLoginAluno);
		alunoRepetido.setDadosLogin(dadosLoginAluno);
		
		assertEquals(sis.cadastrarAluno(aluno),201);
		assertEquals(sis.cadastrarAluno(alunoRepetido),409);
		assertEquals(sis.cadastrarAluno(alunoNulo), 400);
		assertEquals(sis.buscarAlunoPorEmailParcial(emailAluno).contains(aluno),true);
		assertEquals(sis.loginAluno(dadosLoginAluno),aluno);
		
		assertEquals(sis.cadastrarProfessor(professor),201);
		assertEquals(sis.cadastrarProfessor(professorRepetido),409);
		assertEquals(sis.cadastrarProfessor(professorNulo),400);
		assertEquals(sis.buscarProfessorPorEmailParcial(emailProfessor).contains(professor),true);
		//assertEquals(sis.listarProfessores().contains(professor),true);
		assertEquals(sis.loginProfessor(dadosLoginProfessor),professor);
		
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

}
