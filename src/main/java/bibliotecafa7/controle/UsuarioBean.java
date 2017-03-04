package bibliotecafa7.controle;

import javax.faces.bean.ManagedBean;

import bibliotecafa7.modelo.Usuario;
import bibliotecafa7.persistencia.dao.UsuarioDAO;

@ManagedBean
public class UsuarioBean {

	private Usuario usuario = new Usuario();

	public String salvar() {
		UsuarioDAO dao  = new UsuarioDAO();
		dao.merge(usuario);
		usuario = new Usuario();
		
		return "/login?faces-redirect=true";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
