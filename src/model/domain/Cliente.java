package model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Transactional
@XmlRootElement
@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_cliente")
	private Integer codigo;

	@Size(min=10,message="Nome do cliente precisa ter pelo menos 10 caracteres")
	@NotNull(message="O campo nome é obrigatório")
	@Column(name = "nm_cliente")
	private String nome;

	@Size(min=10,message="O endereço precisa ter pelo menos 10 caracteres")
	@NotNull(message="O campo endereço é obrigatório")
	@Column(name = "ds_endereco")
	private String endereco;

	@NotNull(message="O campo cidade é obrigatório")
	@Column(name = "ds_cidade")
	private String cidade;

	@NotNull(message="O campo cep é obrigatório")
	@Pattern(regexp="\\d{5}-\\d{3}",message="Campo CEP precisa estar no padrão 00000-000")
	@Column(name = "ds_cep")
	private String cep;

	
	@NotNull(message="O campo país é obrigatório")
	@Column(name = "ds_pais")
	private String pais;

	@NotNull(message="O campo telefone é obrigatório")
	@Pattern(regexp="\\d{4}-\\d{4}",message="Telefone precisa estar no padrão 0000-0000")
	@Column(name = "ds_telefone")
	private String telefone;

	@OneToMany(mappedBy = "cliente",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Aluguel> alugueis;

	public Cliente() {
		super();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@XmlTransient
	public List<Aluguel> getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
		Cliente other = (Cliente) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}