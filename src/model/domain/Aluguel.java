package model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Transactional
@XmlRootElement
@Entity
@Table(name = "tb_aluguel")
public class Aluguel implements Serializable {

	private static final long serialVersionUID = -4291797618210467834L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_aluguel")
	private Integer codigo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_cliente", referencedColumnName = "cd_cliente")
	private Cliente cliente;
	
	@ManyToMany
	@JoinTable(name="tb_item_aluguel", 
			   joinColumns= @JoinColumn(name="cd_aluguel"), 
			   inverseJoinColumns= @JoinColumn(name="cd_bicicleta"))
	private List<Bicicleta> bicicletas;

	@Column(name = "vl_diario")
	private String diario;

	@Column(name = "vl_mensal")
	private String mensal;

	@Column(name = "vl_anual")
	private String anual;

	public Aluguel() {
		super();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	@XmlTransient
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDiario() {
		return diario;
	}

	public void setDiario(String diario) {
		this.diario = diario;
	}

	public String getMensal() {
		return mensal;
	}

	public void setMensal(String mensal) {
		this.mensal = mensal;
	}

	public String getAnual() {
		return anual;
	}

	public void setAnual(String anual) {
		this.anual = anual;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluguel other = (Aluguel) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
