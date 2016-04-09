package model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


	@Entity
	@Table(name = "tb_bicicleta")
	public class Bicicleta implements Serializable {

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "cd_bicicleta")
		private Integer codigo;

		@ManyToOne
		@JoinColumn(name = "cd_aluguel", referencedColumnName = "cd_aluguel")
		private DetalheAluguel aluguel;
		
		@Column(name="vl_preco_diario")
		private Double preco;
		
		@Column(name="vl_preco_mensal")
		private Double precoMensal;
		
		@Column(name="vl_preco_anual")
		private Double precoAnual;
		
		@Column(name="qt_disponivel")
		private Integer quantidade;
		
	
}
