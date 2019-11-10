import java.util.LinkedList;
public class Entrega {
	private String linkGit;
	private String data;
	private String linkGitOpcional;
	private LinkedList<String> aluno = new LinkedList<String>();
	
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
	public String getLinkGitOpcional() {
		return linkGitOpcional;
	}
	public void setLinkGitOpcional(String linkGitOpcional) {
		this.linkGitOpcional = linkGitOpcional;
	}
	public LinkedList<String> getAluno() {
		return aluno;
	}
	public void setAluno(LinkedList<String> aluno) {
		this.aluno = aluno;
	}
	

}
