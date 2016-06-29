package model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Transactional
@XmlRootElement
@Entity
@Table(name = "tb_bicicleta")
public class Bicicleta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_bicicleta")
	private Integer codigo;

	@NotNull(message="A quantidade deve ser preenchida.")
	@Column(name = "qt_disponivel")
	private Integer quantidade;

	@NotNull(message="O campo marca é obrigatório")
	@Column(name = "ds_marca")
	private String marca;

	@ManyToMany
	@JoinTable(name = "tb_item_aluguel", joinColumns = @JoinColumn(name = "cd_bicicleta"), inverseJoinColumns = @JoinColumn(name = "cd_aluguel"))
	private List<Aluguel> alugueis;

	public Bicicleta() {
		super();
	}

	public Bicicleta(Integer codigo, Integer quantidade, String marca) {
		super();
		this.codigo = codigo;
		this.quantidade = quantidade;
		this.marca = marca;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
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
		Bicicleta other = (Bicicleta) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
