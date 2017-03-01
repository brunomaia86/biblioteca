package bibliotecafa7.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Emprestimo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Date dataEmprestimo;
	private Date dataDevolucao;
	private Double valor;
	//private Cliente cliente;
	//private Livro livro;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	/*@ManyToOne
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@OneToMany
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
*/
}
