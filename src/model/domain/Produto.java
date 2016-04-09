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
	@Table(name = "tb_produto")
	public class Produto implements Serializable {

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "cd_produto")
		private Integer codigo;

		@Column(name = "nm_produto")
		private String nome;

		@ManyToOne
		@JoinColumn(name = "cd_categoria", referencedColumnName = "cd_categoria")
		private Categoria categoria;
		
		@Column(name="vl_preco")
		private Double preco;
		
		@Column(name="qt_estoque")
		private Integer quantidade;
		
		@Column(name="nm_imagem")
		private String imagem;

	
}
