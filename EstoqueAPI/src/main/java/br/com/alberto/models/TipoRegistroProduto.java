package br.com.alberto.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.alberto.properties.PropertiesUtil;

@Entity
@Table(name = "TIPO_REGISTRO_PRODUTO", schema = PropertiesUtil.SCHEMA)
@SequenceGenerator(name = "SEQ_TIPO_REGISTRO_PRODUTO", sequenceName = "SEQ_TIPO_REGISTRO_PRODUTO", schema = PropertiesUtil.SCHEMA, allocationSize = 1, initialValue = 1)
public class TipoRegistroProduto {

	@Id
	@Column(name = "ID_TIPO_REGISTRO")
	@GeneratedValue(generator = "SEQ_TIPO_REGISTRO_PRODUTO", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "DESCRICAO_REGISTRO_PRODUTO")
	private String descricaoRegistroProduto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaoRegistroProduto() {
		return descricaoRegistroProduto;
	}

	public void setDescricaoRegistroProduto(String descricaoRegistroProduto) {
		this.descricaoRegistroProduto = descricaoRegistroProduto;
	}

}
