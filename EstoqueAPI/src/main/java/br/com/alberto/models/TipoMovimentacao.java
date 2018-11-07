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
@Table(name = "TIPO_MOVIMENTACAO", schema = PropertiesUtil.SCHEMA)
@SequenceGenerator(name="SEQ_TIPO_MOVIMENTACAO", schema=PropertiesUtil.SCHEMA, allocationSize=1,
initialValue=1, sequenceName="SEQ_TIPO_MOVIMENTACAO")
public class TipoMovimentacao {

	@Id
	@GeneratedValue(generator="SEQ_TIPO_MOVIMENTACAO", strategy=GenerationType.SEQUENCE)
	@Column(name="ID_MOVIMENTACAO")
	private Long id;

	@Column(name="DESCRICAO_MOVIMENTACAO")
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
