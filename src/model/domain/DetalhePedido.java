package model.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_detalhe_pedido")
public class DetalhePedido {
	
	@EmbeddedId
	private DetalhePedidoPK detalhepedidoPK;
	

	@Column(name="vl_preco")
	private Double preco;
	
	@Column(name="qt_solicitado")
	private Integer quantidade;
	
	@Column(name="vl_desconto")
	private Double desconto;
	
	
	@ManyToOne
	@JoinColumn(name = "nr_pedido", referencedColumnName = "nr_pedido", insertable=false, updatable=false)
	private Pedido pedido;


	@ManyToOne
	@JoinColumn(name = "cd_produto", referencedColumnName = "cd_produto", insertable=false, updatable=false)
	private Produto produto;
}

