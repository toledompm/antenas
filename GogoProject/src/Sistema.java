import java.util.LinkedList;

public class Sistema {
	private LinkedList<Professor> listaProfessores = new LinkedList<Professor>();
	private LinkedList<Aluno> listaAlunos = new LinkedList<Aluno>();
	
	
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
		return false;
	}
	
	public int cadastrarAluno(Aluno a) {
		if(a.getDadosLogin().getEmail() == null || a.getDadosLogin().getSenha() == null) {
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
			return a;
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

	public Professor loginProfessor(DadosLogin dadosLogin){
		for(Professor p: listaProfessores) {
			if(p.getDadosLogin() == dadosLogin) {
				return p;
			}
		}
		return null;
	}
	public int cadastrarProfessor(Professor p) {
		if(p.getDadosLogin().getEmail() == null || p.getDadosLogin().getSenha() == null) {
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
	
	/*public LinkedList<Professor> listarProfessores(){
		return listaProfessores;
	}*/
}

