package bibliotecafa7.controle;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bibliotecafa7.modelo.Categoria;
import bibliotecafa7.modelo.Livro;
import bibliotecafa7.persistencia.dao.LivroDAO;

@ManagedBean
@SessionScoped
public class LivroBean {

	private Livro livro = new Livro();
	private Set<Livro> livros;
	private List<Categoria> categorias = Arrays.asList(Categoria.values());
	private Date dataAtual = new Date();
	
	@PostConstruct
	public void init() {
		LivroDAO dao = new LivroDAO();
		livros = dao.list();
	}

	public String salvar() {
		LivroDAO dao = new LivroDAO();
		dao.persist(livro);
		livro = new Livro();
		livros = null;

		return "lista-livros?faces-redirect=true";
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Set<Livro> getLivros() {
		if (livros == null) {
			LivroDAO dao = new LivroDAO();
			livros = dao.list();
			return livros;
		} else
			return livros;
	}

	public void setLivros(Set<Livro> livros) {
		this.livros = livros;
	}

	public Date getDataAtual() {
		return dataAtual;
	}

	public void setDataAtual(Date dataAtual) {
		this.dataAtual = dataAtual;
	}

}
