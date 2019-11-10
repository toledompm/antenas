import java.util.LinkedList;
public class Projeto {
	private LinkedList<String> entregas = new LinkedList<String>();
	private String descricao;
	private String descricaoAvancada;
	private String titulo;
	private String link;
	private String linkAvancado;
	private String Empresario;
	private String membroCadi;
	public LinkedList<String> getEntregas() {
		return entregas;
	}
	public void setEntregas(LinkedList<String> entregas) {
		this.entregas = entregas;
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
		return Empresario;
	}
	public void setEmpresario(String empresario) {
		Empresario = empresario;
	}
	public String getMembroCadi() {
		return membroCadi;
	}
	public void setMembroCadi(String membroCadi) {
		this.membroCadi = membroCadi;
	}
	
	
}
