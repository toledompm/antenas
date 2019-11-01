import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestJUnit {

	@Test
	public void testJUnit() {
		//fail("Not yet implemented");
		testProfessor();
		
	}
	
	@Test
	public void testProfessor() {
		String novoEmail = "email@teste";
		String novaSenha = "senha";
		String novaMatricula = "mat";
		Professor prof = new Professor();
		
		prof.setEmail(novoEmail);
		prof.setSenha(novaSenha);
		prof.setMatricula(novaMatricula);
		
		assertEquals(prof.getEmail(),novoEmail);
		assertEquals(prof.getMatricula(),novaMatricula);
		assertEquals(prof.getSenha(),novaSenha);
	}

}
