package model.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_detalhe_aluguel")
public class DetalheAluguel {
	
	@EmbeddedId
	private DetalheAluguelPK detalhepedidoPK;
	

	@Column(name="vl_preco_diario")
	private Double preco;
	
	@Column(name="vl_preco_mensal")
	private Double precoMensal;
	
	@Column(name="vl_preco_anual")
	private Double precoAnual;
	
	@Column(name="qt_disponivel")
	private Integer quantidade;

	@ManyToOne
	@JoinColumn(name = "cd_bicicleta", referencedColumnName = "cd_bicicleta", insertable=false, updatable=false)
	private Bicicleta bicicleta;
}

