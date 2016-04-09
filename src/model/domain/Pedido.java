package model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="tb_pedido")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="nr_pedido")
	private Integer numero;

	@ManyToOne
	@JoinColumn(name="cd_cliente", referencedColumnName="cd_cliente")
	private Cliente cliente;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_pedido")
	private Date data;
	

}

