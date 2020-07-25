import java.util.LinkedList;
public class Entrega {
	private String linkGit;
	private String data;
	private String linkDeployOpcional;
	private LinkedList<String> alunos = new LinkedList<String>();
	
	public Entrega(String linkGit, String data, String linkDeployOpcional, LinkedList<String> alunos) {
		super();
		this.linkGit = linkGit;
		this.data = data;
		this.linkDeployOpcional = linkDeployOpcional;
		for(String a: alunos) {
			this.alunos.add(a);
		}
	}
	
	public String getLinkGit() {
		return linkGit;
	}
	public void setLinkGit(String linkGit) {
		this.linkGit = linkGit;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getLinkDeployOpcional() {
		return linkDeployOpcional;
	}
	public void setLinkDeployOpcional(String linkDeployOpcional) {
		this.linkDeployOpcional = linkDeployOpcional;
	}
	public LinkedList<String> getAlunos() {
		return alunos;
	}
	public void addAluno(String aluno) {
		this.alunos.add(aluno);
	}
	public void removeAluno(String aluno) {
		for(String a:this.alunos) {
			if(a.equals(aluno)) {
				this.alunos.remove(a);
			}
		}
	}
	

}
