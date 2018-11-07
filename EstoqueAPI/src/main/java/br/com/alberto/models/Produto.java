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
@Table(name = "PRODUTO", schema = PropertiesUtil.SCHEMA)
@SequenceGenerator(name = "SEQ_PRODUTO", sequenceName = "SEQ_PRODUTO", schema = PropertiesUtil.SCHEMA, allocationSize = 1, initialValue = 1)
public class Produto {

	@Id
	@GeneratedValue(generator = "SEQ_PRODUTO", strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_PRODUTO")
	private Long id;

	@Column(name = "NOME_PRODUTO")
	private String nomeProduto;

	@Column(name = "QUANTIDADE_PRODUTO")
	private Integer quantidadeProduto;

	@Column(name = "VALOR_PRODUTO")
	private Double valorProduto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}

	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}

	public Double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(Double valorProduto) {
		this.valorProduto = valorProduto;
	}

}
