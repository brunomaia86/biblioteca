package bibliotecafa7.controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bibliotecafa7.modelo.Usuario;
import bibliotecafa7.persistencia.dao.UsuarioDAO;

@ManagedBean
@SessionScoped
public class UsuarioBean {

	private Usuario usuario;

	public String salvar() {
		UsuarioDAO dao  = new UsuarioDAO();
		dao.persist(usuario);
		usuario = new Usuario();
		
		return "login";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
