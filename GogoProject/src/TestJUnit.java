import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestJUnit {
	//Declarando valores defaults para todas comparacoes com um objeto do tipo Professor
	private String emailProfessor = "email@teste";
	private String senhaProfessor = "senha";
	private String matriculaProfessor = "mat";
	
	//inicializando um objeto do tipo Sistema
	private Sistema sis = new Sistema();
	//inicializando um objeto do tipo Professor
	private Professor prof = new Professor();
	
	public TestJUnit() {
		//Setando os valores do objeto Professor para os valores declarados
		prof.setEmail(emailProfessor);
		prof.setSenha(senhaProfessor);
		prof.setMatricula(matriculaProfessor);
		
		//Cadastrando o Professor no sistema
		sis.cadastrarProfessor(prof);
		
		//Executando os testes da classe professor
		testProfessor();
		
		//Executando os testes da classe Sistema
		testSistema();
		
	}
	
	@Test
	public void testSistema() {
		assertEquals(sis.buscarProfessorPorEmail(emailProfessor),prof);
		assertEquals(sis.listarProfessores().contains(prof),true);
		
	}
	
	@Test
	public void testProfessor() {
		assertEquals(prof.getEmail(),emailProfessor);
		assertEquals(prof.getMatricula(),matriculaProfessor);
		assertEquals(prof.getSenha(),senhaProfessor);
	}

}
