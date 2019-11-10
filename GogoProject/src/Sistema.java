import java.util.LinkedList;

public class Sistema {
	private LinkedList<Professor> professores = new LinkedList<Professor>();
	private LinkedList<Aluno> alunos = new LinkedList<Aluno>();
	private LinkedList<Empresario> empresarios = new LinkedList<Empresario>();
	private LinkedList<CADI> membrosCadi = new LinkedList<CADI>();
	private LinkedList<Projeto> projetos = new LinkedList<Projeto>();
	
	public int empresarioAdicionarDadosFase2(String descricaoAvancada, String linkAvancado, Projeto proj) {
		for(Projeto p: projetos) {
			if(p == proj) {
				if(p.getFase() == 1) {
					p.setDescricaoAvancada(descricaoAvancada);
					p.setLinkAvancado(linkAvancado);
				}
			}
		}
		return 404;
	}
	public int aprovarProjetoFase1(Projeto proj) {
		for(Projeto p:projetos) {
			if(p == proj) {
				if(p.getFase() == 0) {
					p.setFase(1);
					return 200;
				}
				return 400;
			}
		}
		return 404;
	}
	public int aprovarProjetoFase2(Projeto proj, String emailCadi) {
		for(Projeto p:projetos) {
			if(p == proj) {
				if(proj.getFase() == 1) {
					p.setFase(2);
					p.setMembroCadi(emailCadi);
					return 200;
				}
				return 400;
			}
		}
		return 404;
	}
	public int reprovarProjeto(Projeto proj, String emailCadi) {
		for(Projeto p:projetos) {
			if(p == proj) {
				p.setFase(-1);
				if(proj.getFase() == 1) {
					proj.setMembroCadi(emailCadi);
					return 200;
				}
				return 400;
			}
		}
		return 404;
	}
	public int adicionarProfessorAProjeto(String emailProfessor,Projeto proj) {
		for(Projeto p: projetos) {
			if(p == proj) {
				if(p.getProfessores().contains(emailProfessor)) {
					return 409;
				}
				p.addProfessor(emailProfessor);
				return 201;
			}
		}
		return 404;
	}
	public int alunoEntregarProjeto(Entrega ent, String senha) {
		for(Projeto p: projetos) {
			if(p.getSenha().equals(senha)) {
				p.addEntrega(ent);
				return 200;
			}
		}
		return 404;
	}
	public int alunoParticiparProjeto(String senha, String emailAluno) {
		for(Projeto p: projetos) {
			if(p.getSenha().equals(senha)) {
				p.addAluno(emailAluno);
				return 200;
			}
		}
		return 404;
	}
	public boolean verificarTituloCadastrado(Projeto proj) {
		for(Projeto p:projetos) {
			if(p.getTitulo().equals(proj.getTitulo()) && p.getEmpresario().equals(proj.getEmpresario())) {
				return true;
			}
		}
		return false;
	}
	public int cadastrarProjeto(Projeto p) {
		if(verificarTituloCadastrado(p)) {
			return 409;
		}
		projetos.add(p);
		return 201;
	}
	public LinkedList<Projeto> buscarProjetoPorEmpresario(String emailEmp) {
		LinkedList<Projeto> projetosEncontrados = new LinkedList<Projeto>();
		for(Projeto p: projetos) {
			if(p.getEmpresario().equals(emailEmp)) {
				projetosEncontrados.add(p);
			}
		}
		return projetosEncontrados;
	}
	public LinkedList<Projeto> buscarProjetosPorMebroCadi(String emailCadi) {
		LinkedList<Projeto> projetosEncontrados = new LinkedList<Projeto>();
		for(Projeto p: projetos) {
			if(p.getMembroCadi().equals(emailCadi)) {
				projetosEncontrados.add(p);
			}
		}
		return projetosEncontrados;
	}
	public LinkedList<Projeto> buscarProjetosPorProfessor(String emailProfessor) {
		LinkedList<Projeto> projetosEncontrados = new LinkedList<Projeto>();
		for(Projeto p: projetos) {
			if(p.getProfessores().contains(emailProfessor)) {
				projetosEncontrados.add(p);
			}
		}
		return projetosEncontrados;
	}
	public LinkedList<Projeto> buscarProjetosPorAluno(String emailAluno) {
		LinkedList<Projeto> projetosEncontrados = new LinkedList<Projeto>();
		for(Projeto p: projetos) {
			if(p.getAlunos().contains(emailAluno)) {
				projetosEncontrados.add(p);
			}
		}
		return projetosEncontrados;
	}
	public LinkedList<Projeto> buscarProjetosNaoAvaliados(){
		LinkedList<Projeto> projetosEncontrados = new LinkedList<Projeto>();
		for(Projeto p: projetos) {
			if(p.getMembroCadi().equals(null)) {
				projetosEncontrados.add(p);
			}
		}
		return projetosEncontrados;
	}
	public boolean verificarEmailCadastrado(String email) {
		for(Professor p: professores) {
			if (p.getDadosLogin().getEmail().equals(email)) {
				return true;
			}
		}
		for(Aluno a: alunos) {
			if (a.getDadosLogin().getEmail().equals(email)) {
				return true;
			}
		}
		for(Empresario e: empresarios) {
			if(e.getDadosLogin().getEmail().equals(email)) {
				return true;
			}
		}
		for(CADI c: membrosCadi) {
			if(c.getDadosLogin().getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}
	
	public int cadastrarCadi(CADI c) {
		try {
			if(c.getDadosLogin().getEmail() == null || c.getDadosLogin().getEmail() == null || c.getMatricula() == null) {
				return 400;
			}
		}catch (NullPointerException err) {
			return 400;
		}
		if(verificarEmailCadastrado(c.getDadosLogin().getEmail())){
			return 409;
		}
		membrosCadi.add(c);
		return 201;
	}
	
	public CADI loginCadi(DadosLogin dadosLoginCadi) {
		for(CADI c:membrosCadi) {
			if(c.getDadosLogin() == dadosLoginCadi) {
				return c;
			}
		}
		return null;
	}
	
	public CADI buscarCadiPorEmail(String email) {
		for(CADI c:membrosCadi) {
			if(c.getDadosLogin().getEmail().equals(email)) {
				return c;
			}
		}
		return null;
	}
	
	public int cadastrarEmpresario(Empresario e) {
		try {
			if(e.getDadosLogin().getEmail() == null || e.getDadosLogin().getSenha() == null || e.getCpf() == null) {
				return 400;
			}
		}catch (NullPointerException err) {
				return 400;
		}
		if(verificarEmailCadastrado(e.getDadosLogin().getEmail()) == true) {
			return 409;
		}
		empresarios.add(e);
		return 201;
	}
	
	public Empresario loginEmpresario(DadosLogin dadosLogin) {
		for(Empresario e: empresarios) {
			if(e.getDadosLogin() == dadosLogin) {
				return e;
			}
		}
		return null;
	}
	
	public LinkedList<Empresario> buscarEmpresarioPorEmailParcial(String email){
		LinkedList<Empresario> empresariosEncontrados = new LinkedList<Empresario>();
		for(Empresario e: empresarios) {
			if(e.getDadosLogin().getEmail().contains(email)) {
				empresariosEncontrados.add(e);
			}
		}
		return empresariosEncontrados;
	}
	
	public Empresario buscarEmpresarioPorEmail(String email) {
		for(Empresario e: empresarios) {
			if(e.getDadosLogin().getEmail().equals(email)) {
				return e;
			}
		}
		return null;
	}
	
	public int cadastrarAluno(Aluno a) {
		try {
			if(a.getDadosLogin().getEmail().isEmpty() || a.getDadosLogin().getSenha().isEmpty()) {
				return 400;
			}
		} catch(NullPointerException err) {
			return 400;
		}
		if(verificarEmailCadastrado(a.getDadosLogin().getEmail()) == true) {
			return 409;
		}
		alunos.add(a);
		return 201;
	}
	
	public Aluno loginAluno(DadosLogin dadosLogin) {
		for(Aluno a: alunos) {
			if(a.getDadosLogin() == dadosLogin) {
				return a;
			}
		}
		return null;
	}
	
	public LinkedList<Aluno> buscarAlunoPorEmailParcial(String emailParcial) {
		LinkedList<Aluno> alunosEncontrados = new LinkedList<Aluno>();
		for(Aluno a: alunos) {
			if(a.getDadosLogin().getEmail().contains(emailParcial)) {
				alunosEncontrados.add(a);
			}
		}
		return alunosEncontrados;
	}
	
	public Aluno buscarAlunoPorEmail(String email) {
		for(Aluno a: alunos) {
			if(a.getDadosLogin().getEmail().equals(email)) {
				return a;
			}
		}
		return null;
	}

	public Professor loginProfessor(DadosLogin dadosLogin){
		for(Professor p: professores) {
			if(p.getDadosLogin() == dadosLogin) {
				return p;
			}
		}
		return null;
	}
	
	public int cadastrarProfessor(Professor p) {
		try {
			if(p.getDadosLogin().getEmail().isEmpty() || p.getDadosLogin().getSenha().isEmpty() || p.getMatricula().isEmpty()) {
				return 400;
			}
		}catch(NullPointerException err) {
			return 400;
		}
		if(verificarEmailCadastrado(p.getDadosLogin().getEmail()) == true) {
			return 409;
		}
		professores.add(p);
		return 201;
	}
	
	public LinkedList<Professor> buscarProfessorPorEmailParcial(String emailParcial) {
		LinkedList<Professor> professoresEncontrados = new LinkedList<Professor>();
		for(Professor p: professores) {
			if(p.getDadosLogin().getEmail().contains(emailParcial)) {
				professoresEncontrados.add(p);
			}
		}
		return professoresEncontrados;
	}
	
	public Professor buscarProfessorPorEmail(String email) {
		for(Professor p: professores) {
			if(p.getDadosLogin().getEmail().equals(email)) {
				return p;
			}
		}
		return null;
	}
	
}

