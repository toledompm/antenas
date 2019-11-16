import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

public class TestJUnit {
	//Declarando os valores dafault de um objeto DadosLogin
	private String emailDadosLogin = "email@DadosLogin";
	private String senhaDadosLogin = "senhaDadosLogin";
	private String emailDadosLoginSecundario = "email@DadosLogin2";
	private String senhaDadosLoginSecundaria = "senhaDadosLogin2";
	
	//Declarando os valores default de um objeto Professor
	private String emailProfessor = "email@Professor";
	private String senhaProfessor = "senhaProfessor";
	private String matriculaProfessor = "mat";
	private String emailProfessorSecundario = "email@Professor2";
	private String senhaProfessorSecundaria = "senhaProfessor2";
	private String matriculaProfessorSecundaria = "mat2";
	
	//Declarando os valores default de um objeto Aluno
	private String emailAluno = "email@Aluno";
	private String senhaAluno = "senhaAluno";
	private String emailAlunoSecundario = "email@Aluno2";
	private String senhaAlunoSecundaria = "senhaAluno2";

	//Declarando os valores default de um objeto Empresario
	private String emailEmpresario = "email@Empresario";
	private String senhaEmpresario = "senhaEmpresario";
	private String cpfEmpresario = "000.000.000-00";
	private String emailEmpresarioSecundario = "email@Empresario2";
	private String senhaEmpresarioSecundaria = "senhaEmpresario2";
	private String cpfEmpresarioSecundario = "000.000.000-01";
	
	//Declarando os valores default de um objeto CADI
	private String emailCadi = "email@Cadi";
	private String senhaCadi = "senhaCadi";
	private String matriculaCadi = "mat";
	private String emailCadiSecundario = "email@Cadi2";
	private String senhaCadiSecundaria = "senhaCadi2";
	private String matriculaCadiSecundaria = "mat2";
	
	//Declarando os valores default de um objeto Entrega
	private String linkGitEntrega = "entrega@git";
	private String dataEntrega = "00/00/00";
	private String linkDeployOpcionalEntrega = "www.site.com";
	private String linkGitEntregaSecundario = "entrega@git2";
	private String dataEntregaSecundaria = "00/00/01";
	private String linkDeployOpcionalEntregaSecundario = "www.site.com2";
	private String alunoEntrega1 = "alunoEntrega@email";
	private String alunoEntrega2 = "alunoEntrega@email2";
	private LinkedList<String> alunosEntrega = new LinkedList<String>();
	
	//Declarando os valores default de um objeto Projeto
	private String descricaoProjeto = "desc Projeto";
	private String descricaoAvancadaProjeto = "desc Avancada Projeto";
	private String tituloProjeto = "tituloProjeto";
	private String tituloProjetoSecundario = "tituloProjetoSecundario";
	private String linkProjeto = "www.linkAuxiliar.com";
	private String linkAvancadoProjeto = "www.linkAvancado.com";
	private String emailEmpresarioProjeto = "empresario@projeto";
	private String emailMembroCadiProjeto = "membroCadi@projeto";
	private String descricaoSecundaria = "desc Projeto Secundaria";
	private String linkSecundario = "www.linkAuxiliar.com2";
	private String alunoProjeto = "alunoProjeto";
	private String professorProjeto = "professorProjeto";
	private String senhaProjeto = "123";
	private int faseProjeto = 1;
	
	private String linkGitEntregaProjeto = "entrega@gitProjeto";
	private String dataEntregaProjeto = "00/00/00Projeto";
	private String linkDeployOpcionalEntregaProjeto = "www.siteProjeto.com";
	private String alunoEntregaProjeto = "alunoEntregaProjeto@email";
	private LinkedList<String> alunosEntregaProjeto = new LinkedList<String>();
	
	public TestJUnit() {
		alunosEntrega.add(alunoEntrega1);
		alunosEntrega.add(alunoEntrega2);
	}
	@Test
	public void testProjeto() {
		Projeto projeto = new Projeto(null,descricaoProjeto,null,tituloProjeto,linkProjeto,null,
									  emailEmpresarioProjeto,null,null,null,null,0);
		
		assertEquals(projeto.getDescricao(),descricaoProjeto);
		assertEquals(projeto.getTitulo(),tituloProjeto);
		assertEquals(projeto.getLink(),linkProjeto);
		assertEquals(projeto.getEmpresario(),emailEmpresarioProjeto);
		
		alunosEntregaProjeto.add(alunoEntregaProjeto);
		Entrega entregaProjeto = new Entrega(linkGitEntregaProjeto,dataEntregaProjeto,linkDeployOpcionalEntregaProjeto,alunosEntregaProjeto);
		projeto.addEntrega(entregaProjeto);
		assertEquals(projeto.getEntregas().contains(entregaProjeto),true);
		projeto.removeEntrega(entregaProjeto);
		assertEquals(projeto.getEntregas().contains(entregaProjeto),false);
		
		projeto.setMembroCadi(emailMembroCadiProjeto);
		projeto.setDescricaoAvancada(descricaoAvancadaProjeto);
		projeto.setLinkAvancado(linkAvancadoProjeto);
		projeto.setStatus(faseProjeto);
		assertEquals(projeto.getMembroCadi(),emailMembroCadiProjeto);
		assertEquals(projeto.getDescricaoAvancada(),descricaoAvancadaProjeto);
		assertEquals(projeto.getLinkAvancado(),linkAvancadoProjeto);
		assertEquals(projeto.getStatus(),faseProjeto);
		
		projeto.setDescricao(descricaoSecundaria);
		projeto.setLink(linkSecundario);
		projeto.setSenha(senhaProjeto);
		assertEquals(projeto.getDescricao(),descricaoSecundaria);
		assertEquals(projeto.getLink(),linkSecundario);
		assertEquals(projeto.getSenha(),senhaProjeto);
		
		assertEquals(projeto.getAlunos().contains(alunoProjeto),false);
		projeto.addAluno(alunoProjeto);
		assertEquals(projeto.getAlunos().contains(alunoProjeto),true);
		projeto.removeAluno(alunoProjeto);
		assertEquals(projeto.getAlunos().contains(alunoProjeto),false);
		
		assertEquals(projeto.getProfessores().contains(professorProjeto),false);
		projeto.addProfessor(professorProjeto);
		assertEquals(projeto.getProfessores().contains(professorProjeto),true);
		projeto.removeProfessor(professorProjeto);
		assertEquals(projeto.getProfessores().contains(professorProjeto),false);
		
		
	}
	
	@Test
	public void testEntrega() {
		Entrega entrega = new Entrega(linkGitEntrega,dataEntrega,linkDeployOpcionalEntrega,alunosEntrega);
		
		assertEquals(entrega.getAlunos(),alunosEntrega);
		assertEquals(entrega.getData(),dataEntrega);
		assertEquals(entrega.getLinkGit(),linkGitEntrega);
		assertEquals(entrega.getLinkDeployOpcional(),linkDeployOpcionalEntrega);
		
		assertEquals(entrega.getAlunos().contains(alunoEntrega1), true);
		entrega.removeAluno(alunoEntrega1);
		assertEquals(entrega.getAlunos().contains(alunoEntrega1), false);
		entrega.addAluno(alunoEntrega1);
		assertEquals(entrega.getAlunos().contains(alunoEntrega1), true);
		
		entrega.setData(dataEntregaSecundaria);
		entrega.setLinkDeployOpcional(linkDeployOpcionalEntregaSecundario);
		entrega.setLinkGit(linkGitEntregaSecundario);
		assertEquals(entrega.getData(),dataEntregaSecundaria);
		assertEquals(entrega.getLinkGit(),linkGitEntregaSecundario);
		assertEquals(entrega.getLinkDeployOpcional(),linkDeployOpcionalEntregaSecundario);
	}

	@Test
	public void testDadosLogin() {
		DadosLogin dadosLogin = new DadosLogin(emailDadosLogin,senhaDadosLogin);
				
		assertEquals(dadosLogin.getEmail(),emailDadosLogin);
		assertEquals(dadosLogin.getSenha(),senhaDadosLogin);
		
		dadosLogin.setEmail(emailDadosLoginSecundario);
		dadosLogin.setSenha(senhaDadosLoginSecundaria);
		
		assertEquals(dadosLogin.getEmail(),emailDadosLoginSecundario);
		assertEquals(dadosLogin.getSenha(),senhaDadosLoginSecundaria);
	}
	
	@Test
	public void testCadi() {
		DadosLogin dadosLoginCadi = new DadosLogin(emailCadi,senhaCadi);
		MembroCadi membroCadi = new MembroCadi(matriculaCadi,dadosLoginCadi);
		
		assertEquals(membroCadi.getDadosLogin(),dadosLoginCadi);
		assertEquals(membroCadi.getMatricula(),matriculaCadi);
		
		DadosLogin dadosLoginCadiSecundario = new DadosLogin(emailCadiSecundario,senhaCadiSecundaria);
		membroCadi.setDadosLogin(dadosLoginCadiSecundario);
		membroCadi.setMatricula(matriculaCadiSecundaria);
		
		assertEquals(membroCadi.getDadosLogin(),dadosLoginCadiSecundario);
		assertEquals(membroCadi.getMatricula(),matriculaCadiSecundaria);
	}
	
	@Test
	public void testEmpresario() {
		DadosLogin dadosLoginEmpresario = new DadosLogin(emailEmpresario,senhaEmpresario);
		Empresario empresario = new Empresario(cpfEmpresario,dadosLoginEmpresario);
		
		assertEquals(empresario.getDadosLogin(),dadosLoginEmpresario);
		assertEquals(empresario.getCpf(),cpfEmpresario);
		
		DadosLogin dadosLoginEmpresarioSecundario = new DadosLogin(emailEmpresarioSecundario,senhaEmpresarioSecundaria);
		empresario.setDadosLogin(dadosLoginEmpresarioSecundario);
		empresario.setCpf(cpfEmpresarioSecundario);
		
		assertEquals(empresario.getDadosLogin(),dadosLoginEmpresarioSecundario);
		assertEquals(empresario.getCpf(),cpfEmpresarioSecundario);
	}
	
	@Test
	public void testAluno() {
		DadosLogin dadosLoginAluno = new DadosLogin(emailAluno,senhaAluno);
		Aluno aluno = new Aluno(dadosLoginAluno);
		
		assertEquals(aluno.getDadosLogin(),dadosLoginAluno);
		
		DadosLogin dadosLoginAlunoSecundario = new DadosLogin(emailAlunoSecundario,senhaAlunoSecundaria);
		aluno.setDadosLogin(dadosLoginAlunoSecundario);
		assertEquals(aluno.getDadosLogin(),dadosLoginAlunoSecundario);
	}
	
	@Test
	public void testProfessor() {
		DadosLogin dadosLoginProfessor = new DadosLogin(emailProfessor,senhaProfessor);
		Professor prof = new Professor(matriculaProfessor,dadosLoginProfessor);
		
		assertEquals(prof.getDadosLogin(),dadosLoginProfessor);
		assertEquals(prof.getMatricula(),matriculaProfessor);
		
		DadosLogin dadosLoginProfessorSecundario = new DadosLogin(emailProfessorSecundario,senhaProfessorSecundaria);
		prof.setDadosLogin(dadosLoginProfessorSecundario);
		prof.setMatricula(matriculaProfessorSecundaria);
		
		assertEquals(prof.getDadosLogin(),dadosLoginProfessorSecundario);
		assertEquals(prof.getMatricula(),matriculaProfessorSecundaria);
	}
	
	@Test
	public void testSistema() {
		Sistema sis = new Sistema();
		DadosLogin dadosLoginProfessor = new DadosLogin(emailProfessor,senhaProfessor);
		Professor professor = new Professor(matriculaProfessor,dadosLoginProfessor);
		Professor professorRepetido = new Professor(matriculaProfessor,dadosLoginProfessor);
		Professor professorNulo = new Professor(null,null);
		
		DadosLogin dadosLoginAluno = new DadosLogin(emailAluno,senhaAluno);
		Aluno aluno = new Aluno(dadosLoginAluno);
		Aluno alunoRepetido = new Aluno(dadosLoginAluno);
		Aluno alunoNulo = new Aluno(null);
		
		DadosLogin dadosLoginEmpresario = new DadosLogin(emailEmpresario,senhaEmpresario);
		Empresario empresario = new Empresario(cpfEmpresario,dadosLoginEmpresario);
		Empresario empresarioRepetido = new Empresario(cpfEmpresario,dadosLoginEmpresario);
		Empresario empresarioNulo = new Empresario(null,null);
		
		DadosLogin dadosLoginCadi = new DadosLogin(emailCadi,senhaCadi);
		MembroCadi membroCadi = new MembroCadi(matriculaCadi,dadosLoginCadi);
		MembroCadi cadiRepetido = new MembroCadi(matriculaCadi,dadosLoginCadi);
		MembroCadi cadiNulo = new MembroCadi(null,null);
		
		LinkedList<String> alunos = new LinkedList<String>();
		alunos.add(emailAluno);
		Projeto projeto = new Projeto(null,descricaoProjeto,null,tituloProjeto,linkProjeto,null,
									  emailEmpresario,null,null,null,null,0);
		Projeto projetoSecundario = new Projeto(null,descricaoProjeto,null,tituloProjetoSecundario,linkProjeto,null,
				  								emailEmpresario,null,null,null,null,0);
		Projeto projetoSecundarioRepetido = new Projeto(null,descricaoProjeto,null,tituloProjetoSecundario,linkProjeto,null,
														emailEmpresario,null,null,null,null,0);
		Projeto projetoRepetido = new Projeto(null,descricaoProjeto,null,tituloProjeto,linkProjeto,null,
				  							  emailEmpresario,null,null,null,null,0);
		Entrega entrega = new Entrega(linkGitEntrega,dataEntrega,linkDeployOpcionalEntrega,alunos);
		
		assertEquals(sis.aprovarProjetoFase1(projeto, emailCadi),404);
		assertEquals(sis.cadastrarProjeto(projeto),201);
		assertEquals(sis.cadastrarProjeto(projetoRepetido),409);
		assertEquals(sis.buscarProjetosPorEmpresario(emailEmpresario).contains(projeto),true);
		assertEquals(sis.buscarProjetosPorEmpresario(emailEmpresarioSecundario).isEmpty(),true);
		assertEquals(sis.buscarProjetosSemAvaliacao().isEmpty(),false);
		assertEquals(sis.addDadosFase2(descricaoAvancadaProjeto, linkAvancadoProjeto, projeto),400);
		
		assertEquals(sis.aprovarProjetoFase1(projeto, emailCadi),200);
		assertEquals(sis.buscarProjetosSemAvaliacao().isEmpty(),true);
		assertEquals(sis.aprovarProjetoFase1(projeto, emailCadi),400);
		assertEquals(sis.aprovarProjetoFase1(null, emailCadi),400);
		assertEquals(sis.buscarProjetosPorMebroCadi(emailCadi).contains(projeto),true);
		assertEquals(sis.buscarProjetosPorMebroCadi(emailCadiSecundario).isEmpty(),true);
		
		
		assertEquals(sis.addProfessorProjeto(emailProfessor, projeto),201);
		assertEquals(sis.addProfessorProjeto(emailProfessor, projeto),409);
		assertEquals(sis.addProfessorProjeto(emailProfessor, null),400);
		assertEquals(sis.buscarProjetosPorProfessor(emailProfessor).contains(projeto),true);
		assertEquals(sis.buscarProjetosPorProfessor(emailProfessorSecundario).isEmpty(),true);
		
		assertEquals(sis.gerarSenha(projeto),201);
		assertEquals(sis.gerarSenha(null),400);
		assertEquals(sis.getProjetos().getFirst().getSenha() != null, true);
		
		assertEquals(sis.alunoParticiparProjeto(sis.getProjetos().getFirst().getSenha(), emailAluno),200);
		assertEquals(sis.alunoParticiparProjeto(null, emailAluno),404);
		assertEquals(sis.getProjetos().getFirst().getAlunos().contains(emailAluno),true);
		assertEquals(sis.buscarProjetosPorAluno(emailAluno).contains(projeto),true);
		assertEquals(sis.buscarProjetosPorAluno(emailAlunoSecundario).isEmpty(),true);
		
		assertEquals(sis.addDadosFase2(descricaoAvancadaProjeto, linkAvancadoProjeto, projeto),201);
		assertEquals(sis.addDadosFase2(descricaoAvancadaProjeto, linkAvancadoProjeto, null),400);
		
		assertEquals(sis.aprovarProjetoFase2(projeto),200);
		assertEquals(sis.aprovarProjetoFase2(projeto),400);
		assertEquals(sis.aprovarProjetoFase2(null),400);
		
		assertEquals(sis.alunoEntregarProjeto(entrega, sis.getProjetos().getFirst().getSenha()),200);
		assertEquals(sis.alunoEntregarProjeto(entrega, null),404);
		
		assertEquals(sis.finalizarProjeto(projeto),200);
		assertEquals(sis.finalizarProjeto(projeto),400);
		assertEquals(sis.finalizarProjeto(null),400);
		assertEquals(sis.finalizarProjeto(projetoSecundario),404);
		
		assertEquals(sis.buscarProjetosFinalizadosPorAluno(emailAluno).contains(projeto),true);
		assertEquals(sis.buscarProjetosFinalizadosPorEmpresario(emailEmpresario).contains(projeto),true);
		assertEquals(sis.buscarProjetosFinalizadosPorMembroCadi(emailCadi).contains(projeto),true);
		assertEquals(sis.buscarProjetosFinalizadosPorProfessor(emailProfessor).contains(projeto),true);
		
		sis.cadastrarProjeto(projetoSecundario);
		assertEquals(sis.buscarProjetosPorEmpresario(emailEmpresario).contains(projetoSecundario),true);
		assertEquals(sis.excluirProjeto(projetoSecundario),200);
		assertEquals(sis.buscarProjetosPorEmpresario(emailEmpresario).contains(projetoSecundario),false);
		assertEquals(sis.excluirProjeto(projetoSecundario),404);
		assertEquals(sis.reprovarProjeto(projetoSecundario, emailCadi),404);
		assertEquals(sis.cadastrarProjeto(projetoSecundarioRepetido),201);
		assertEquals(sis.buscarProjetosPorEmpresario(emailEmpresario).contains(projetoSecundarioRepetido),true);
		assertEquals(sis.reprovarProjeto(projetoSecundarioRepetido, emailCadi),200);
		assertEquals(sis.buscarProjetosPorMebroCadi(emailCadi).contains(projetoSecundarioRepetido),true);
		
		assertEquals(sis.cadastrarCadi(membroCadi), 201);
		assertEquals(sis.cadastrarCadi(cadiRepetido), 409);
		assertEquals(sis.cadastrarCadi(cadiNulo), 400);
		assertEquals(sis.loginCadi(dadosLoginCadi),membroCadi);
		assertEquals(sis.loginCadi(null), null);
		assertEquals(sis.buscarCadiPorEmail(emailCadi),membroCadi);
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
		assertEquals(sis.loginProfessor(dadosLoginProfessor),professor);
		assertEquals(sis.loginProfessor(null),null);	
		
	}
}
