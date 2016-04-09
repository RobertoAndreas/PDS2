package model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

	
	@Entity
	@Table(name = "tb_categoria")
	public class Categoria implements Serializable {

		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="cd_categoria")
		private Integer codigo;
		
		@OneToMany(mappedBy="categoria")
		private List<Produto> produtos;
		
		@Column(name="nm_categoria")
		private String nome;
		
		@Column(name="ds_categoria")
		private String categoria;
		
	

}
