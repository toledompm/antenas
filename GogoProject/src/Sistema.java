import java.util.LinkedList;

public class Sistema {
	private LinkedList<Professor> listaProfessores = new LinkedList<Professor>();
	private LinkedList<Aluno> listaAlunos = new LinkedList<Aluno>();
	private LinkedList<Empresario> listaEmpresario = new LinkedList<Empresario>();
	
	public Boolean verificarEmailCadastrado(String email) {
		for(Professor p: listaProfessores) {
			if (p.getDadosLogin().getEmail().equals(email)) {
				return true;
			}
		}
		for(Aluno a: listaAlunos) {
			if (a.getDadosLogin().getEmail().equals(email)) {
				return true;
			}
		}
		for(Empresario e: listaEmpresario) {
			if(e.getDadosLogin().getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}
	
	public int cadastrarEmpresario(Empresario e) {
		if(e.getDadosLogin().getEmail() == null || e.getDadosLogin().getSenha() == null || e.getCpf() == null) {
			return 400;
		}
		if(verificarEmailCadastrado(e.getDadosLogin().getEmail()) == true) {
			return 409;
		}
		listaEmpresario.add(e);
		return 201;
	}
	
	public Empresario loginEmpresario(DadosLogin dadosLogin) {
		for(Empresario e: listaEmpresario) {
			if(e.getDadosLogin() == dadosLogin) {
				return e;
			}
		}
		return null;
	}
	
	public LinkedList<Empresario> buscarEmpresarioPorEmailParcial(String email){
		LinkedList<Empresario> empresariosEncontrados = new LinkedList<Empresario>();
		for(Empresario e: listaEmpresario) {
			if(e.getDadosLogin().getEmail().contains(email)) {
				empresariosEncontrados.add(e);
			}
		}
		return empresariosEncontrados;
	}
	
	public Empresario buscarEmpresarioPorEmail(String email) {
		for(Empresario e: listaEmpresario) {
			if(e.getDadosLogin().getEmail().equals(email)) {
				return e;
			}
		}
		return null;
	}
	
	public int cadastrarAluno(Aluno a) {
		if(a.getDadosLogin().getEmail().isEmpty() || a.getDadosLogin().getSenha().isEmpty()) {
			return 400;
		}
		if(verificarEmailCadastrado(a.getDadosLogin().getEmail()) == true) {
			return 409;
		}
		listaAlunos.add(a);
		return 201;
	}
	
	public Aluno loginAluno(DadosLogin dadosLogin) {
		for(Aluno a: listaAlunos) {
			if(a.getDadosLogin() == dadosLogin) {
				return a;
			}
		}
		return null;
	}
	
	public LinkedList<Aluno> buscarAlunoPorEmailParcial(String emailParcial) {
		LinkedList<Aluno> alunosEncontrados = new LinkedList<Aluno>();
		for(Aluno a: listaAlunos) {
			if(a.getDadosLogin().getEmail().contains(emailParcial)) {
				alunosEncontrados.add(a);
			}
		}
		return alunosEncontrados;
	}
	
	public Aluno buscarAlunoPorEmail(String email) {
		for(Aluno a: listaAlunos) {
			if(a.getDadosLogin().getEmail().equals(email)) {
				return a;
			}
		}
		return null;
	}

	public Professor loginProfessor(DadosLogin dadosLogin){
		for(Professor p: listaProfessores) {
			if(p.getDadosLogin() == dadosLogin) {
				return p;
			}
		}
		return null;
	}
	
	public int cadastrarProfessor(Professor p) {
		if(p.getDadosLogin().getEmail().isEmpty() || p.getDadosLogin().getSenha().isEmpty() || p.getMatricula().isEmpty()) {
			return 400;
		}
		if(verificarEmailCadastrado(p.getDadosLogin().getEmail()) == true) {
			return 409;
		}
		listaProfessores.add(p);
		return 201;
	}
	
	public LinkedList<Professor> buscarProfessorPorEmailParcial(String emailParcial) {
		LinkedList<Professor> professoresEncontrados = new LinkedList<Professor>();
		for(Professor p: listaProfessores) {
			if(p.getDadosLogin().getEmail().contains(emailParcial)) {
				professoresEncontrados.add(p);
			}
		}
		return professoresEncontrados;
	}
	
	public Professor buscarProfessorPorEmail(String email) {
		for(Professor p: listaProfessores) {
			if(p.getDadosLogin().getEmail().equals(email)) {
				return p;
			}
		}
		return null;
	}
	
}

