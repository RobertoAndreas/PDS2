package model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DetalheAluguelPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "cd_bicicleta")
	private Integer codigoBicicleta;

	public DetalheAluguelPK() {

	}

	public Integer getCodigoBicicleta() {
		return codigoBicicleta;
	}

	public void setcodigoBicicleta(Integer codigoBicicleta) {
		this.codigoBicicleta = codigoBicicleta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoBicicleta == null) ? 0 : codigoBicicleta.hashCode());
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
		DetalheAluguelPK other = (DetalheAluguelPK) obj;
		if (codigoBicicleta == null) {
			if (other.codigoBicicleta != null)
				return false;
		} else if (!codigoBicicleta.equals(other.codigoBicicleta))
			return false;
		       return true;
	}

}
