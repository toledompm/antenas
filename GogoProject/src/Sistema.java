import java.util.LinkedList;

public class Sistema {
	private LinkedList<Professor> listaProfessores = new LinkedList<Professor>();

	public void cadastrarProfessor(Professor p) {
		listaProfessores.add(p);
	}
	
	public Professor buscarProfessorPorEmail(String email) {
		for(Professor p: listaProfessores) {
			if(p.getEmail().equals(email)) {
				return p;
			}
		}
		return null;
	}
	
	public LinkedList<Professor> listarProfessores(){
		return listaProfessores;
	}
}

