package bibliotecafa7.controle;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import bibliotecafa7.modelo.Usuario;
import bibliotecafa7.persistencia.dao.UsuarioDAO;

@ManagedBean
public class AutenticadorBean {

	private static Map<String, String> mapa = new HashMap<String, String>();

	private String usuario;
	private String senha;

	@PostConstruct
	public void init() {
		UsuarioDAO dao = new UsuarioDAO();
		Set<Usuario> clientes = dao.list();
		
		for (Usuario cliente : clientes) {
			mapa.put(cliente.getUsuario(), cliente.getSenha());
		}
	}
	
	public String autentica() {
		FacesContext fc = FacesContext.getCurrentInstance();

		if (AutenticadorBean.mapa.containsKey(this.usuario)
				&& AutenticadorBean.mapa.get(this.usuario).equals(this.senha)) {
			ExternalContext ec = fc.getExternalContext();
			HttpSession session = (HttpSession) ec.getSession(false);
			session.setAttribute("usuario", this.usuario);
			
			return "pagina-inicial?faces-redirect=true";
 		} else {
 			FacesMessage fm = new FacesMessage("Usuario e/ou senha invalido");
 			fm.setSeverity(FacesMessage.SEVERITY_ERROR);
 			fc.addMessage(null, fm);
 			return "login";
 		}
	}
	
	public String sair() {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpSession session = (HttpSession) ec.getSession(false);
		session.removeAttribute("usuario");
		
		return "login";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
