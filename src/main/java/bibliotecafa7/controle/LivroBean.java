package bibliotecafa7.controle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;

import bibliotecafa7.modelo.Categoria;
import bibliotecafa7.modelo.Livro;
import bibliotecafa7.persistencia.dao.LivroDAO;

@ManagedBean
public class LivroBean {

	private Livro livro = new Livro();
	private List<Categoria> categorias = Arrays.asList(Categoria.values());
	
	/*public LivroBean() {
		categorias = 
		for (Iterator iterator = categorias.iterator(); iterator.hasNext();) {
			Categoria categoria = (Categoria) iterator.next();
			System.out.println(categoria.getCategoria());

		}	}*/

	public void salvar() {
		LivroDAO dao = new LivroDAO();
		dao.persist(livro);
		livro = new Livro();
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

}
