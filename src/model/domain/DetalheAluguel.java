package model.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_detalhe_aluguel")
public class DetalheAluguel {
	
	@EmbeddedId
	private DetalheAluguelPK detalhepedidoPK;
	

	@Column(name="vl_diario")
	private Double preco;
	
	@Column(name="vl_mensal")
	private Double mensal;
	
	@Column(name="vl_anual")
	private Double anual;
	
	@Column(name="qt_disponivel")
	private Integer quantidade;
	
	@ManyToOne
	@JoinColumn(name = "cd_cliente", referencedColumnName = "cd_bicicleta", insertable=false, updatable=false)
	private Bicicleta bicicleta;

	@ManyToOne
	@JoinColumn(name = "cd_aluguel", referencedColumnName = "cd_aluguel", insertable=false, updatable=false)
	private Aluguel aluguel;
}

