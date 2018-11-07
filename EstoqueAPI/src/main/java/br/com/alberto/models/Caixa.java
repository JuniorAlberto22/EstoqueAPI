package br.com.alberto.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.alberto.properties.PropertiesUtil;

@Entity
@Table(name = "CAIXA", schema = PropertiesUtil.SCHEMA)
@SequenceGenerator(name = "SEQ_CAIXA", sequenceName = "SEQ_CAIXA", schema = PropertiesUtil.SCHEMA, allocationSize = 1, initialValue = 1)
public class Caixa {

	@Id
	@GeneratedValue(generator="SEQ_CAIXA", strategy=GenerationType.SEQUENCE)
	@Column(name="ID_CAIXA")
	private Long id;
	
	@Column(name="DATA_REGISTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRegistro;
	
	@Column(name="VALOR_MOVIMENTACAO")
	private Double valorMovimentacao;
	
	@ManyToOne(targetEntity=TipoMovimentacao.class, fetch=FetchType.LAZY)
	@JoinColumn(name="TIPO_MOVIMENTACAO", referencedColumnName="ID_MOVIMENTACAO")
	private TipoMovimentacao tipoMovimentacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Double getValorMovimentacao() {
		return valorMovimentacao;
	}

	public void setValorMovimentacao(Double valorMovimentacao) {
		this.valorMovimentacao = valorMovimentacao;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

}
