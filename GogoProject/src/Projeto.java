import java.util.LinkedList;
public class Projeto {
	private LinkedList<Entrega> entregas = new LinkedList<Entrega>();
	private LinkedList<String> alunos = new LinkedList<String>();
	private LinkedList<String> professores = new LinkedList<String>();
	private String descricao;
	private String descricaoAvancada;
	private String titulo;
	private String link;
	private String linkAvancado;
	private String empresario;
	private String membroCadi;
	private String senha;
	private int fase;
	
	public Projeto(LinkedList<Entrega> entregas, String descricao, String descricaoAvancada, String titulo, String link,
			String linkAvancado, String empresario, String membroCadi, LinkedList<String> alunos, LinkedList<String> professores,
			String senha, int fase) {
		super();
		this.descricao = descricao;
		this.descricaoAvancada = descricaoAvancada;
		this.titulo = titulo;
		this.link = link;
		this.linkAvancado = linkAvancado;
		this.empresario = empresario;
		this.membroCadi = membroCadi;
		this.senha = senha;
		this.fase = fase;
		if(entregas != null) {
			for(Entrega e:entregas) {
				this.entregas.add(e);
			}
		}
		if(alunos != null) {
			for(String a:alunos) {
				this.alunos.add(a);
			}
		}
		if(professores != null) {
			for(String p:professores) {
				this.professores.add(p);
			}
		}
	}
	
	public LinkedList<String> getProfessores() {
		return professores;
	}
	public void addProfessor(String emailProf) {
		this.professores.add(emailProf);
	}
	public void removeProfessor(String emailProf) {
		if(this.professores.contains(emailProf)) {
			this.professores.remove(emailProf);
		}
	}
	public LinkedList<String> getAlunos() {
		return alunos;
	}
	public void addAluno(String emailAluno) {
		this.alunos.add(emailAluno);
	}
	public void removeAluno(String emailAluno) {
		if(this.alunos.contains(emailAluno)) {	
			this.alunos.remove(emailAluno);
		}
	}
	public LinkedList<Entrega> getEntregas() {
		return entregas;
	}
	public void addEntrega(Entrega entrega) {
		this.entregas.add(entrega);
	}
	public void removeEntrega(Entrega entrega) {
		if(this.entregas.contains(entrega)) {
			this.entregas.remove(entrega);
		}
		
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDescricaoAvancada() {
		return descricaoAvancada;
	}
	public void setDescricaoAvancada(String descricaoAvancada) {
		this.descricaoAvancada = descricaoAvancada;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getLinkAvancado() {
		return linkAvancado;
	}
	public void setLinkAvancado(String linkAvancado) {
		this.linkAvancado = linkAvancado;
	}
	public String getEmpresario() {
		return this.empresario;
	}
	public void setEmpresario(String empresario) {
		this.empresario = empresario;
	}
	public String getMembroCadi() {
		return membroCadi;
	}
	public void setMembroCadi(String membroCadi) {
		this.membroCadi = membroCadi;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getFase() {
		return fase;
	}
	public void setFase(int fase) {
		this.fase = fase;
	}
	
	
}
