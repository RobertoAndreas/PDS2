package model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_detalhe_aluguel")
public class DetalheAluguel implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetalheAluguelPK detalheAluguelPK;

	@Column(name = "vl_diario")
	private Double preco;

	@Column(name = "vl_mensal")
	private Double mensal;

	@Column(name = "vl_anual")
	private Double anual;

	@Column(name = "qt_disponivel")
	private Integer quantidade;

	@ManyToOne
	@JoinColumn(name = "cd_cliente", referencedColumnName = "cd_bicicleta", insertable = false, updatable = false)
	private Bicicleta bicicleta;

	@ManyToOne
	@JoinColumn(name = "cd_aluguel", referencedColumnName = "cd_aluguel", insertable = false, updatable = false)
	private Aluguel aluguel;

	public DetalheAluguelPK getDetalheAluguelPK() {
		return detalheAluguelPK;
	}

	public void setDetalheAluguelPK(DetalheAluguelPK detalheAluguelPK) {
		this.detalheAluguelPK = detalheAluguelPK;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getMensal() {
		return mensal;
	}

	public void setMensal(Double mensal) {
		this.mensal = mensal;
	}

	public Double getAnual() {
		return anual;
	}

	public void setAnual(Double anual) {
		this.anual = anual;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Bicicleta getBicicleta() {
		return bicicleta;
	}

	public void setBicicleta(Bicicleta bicicleta) {
		this.bicicleta = bicicleta;
	}

	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((detalheAluguelPK == null) ? 0 : detalheAluguelPK.hashCode());
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
		DetalheAluguel other = (DetalheAluguel) obj;
		if (detalheAluguelPK == null) {
			if (other.detalheAluguelPK != null)
				return false;
		} else if (!detalheAluguelPK.equals(other.detalheAluguelPK))
			return false;
		return true;
	}
}
