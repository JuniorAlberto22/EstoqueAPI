package br.com.alberto.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.alberto.properties.PropertiesUtil;

@Entity
@Table(name = "REGISTRO_PRODUTO", schema = PropertiesUtil.SCHEMA)
@SequenceGenerator(name = "SEQ_REGISTRO_PRODUTO", sequenceName = "SEQ_REGISTRO_PRODUTO", schema = PropertiesUtil.SCHEMA, allocationSize = 1, initialValue = 1)
public class RegistroProduto {

	@Id
	@Column(name = "ID_REGISTRO_PRODUTO")
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATA_REGISTRO")
	private Date dataRegistro;

	@ManyToOne(targetEntity = TipoRegistroProduto.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "TIPO_REGISTRO_PRODUTO", referencedColumnName = "ID_TIPO_REGISTRO")
	private TipoRegistroProduto tipoRegistroProduto;

	@Column(name = "QUANTIDADE_PRODUTO")
	private Integer quantidadeProduto;

	@Column(name = "VALOR_PRODUTO")
	private Double valorProduto;

	@OneToOne(targetEntity = Product.class)
	@JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID_PRODUTO")
	private Product produto;

	@ManyToOne(targetEntity = Usuario.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
	private Usuario usuario;

	@ManyToOne(targetEntity = Usuario.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_USUARIO")
	private Usuario cliente;

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

	public TipoRegistroProduto getTipoRegistroProduto() {
		return tipoRegistroProduto;
	}

	public void setTipoRegistroProduto(TipoRegistroProduto tipoRegistroProduto) {
		this.tipoRegistroProduto = tipoRegistroProduto;
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

	public Product getProduto() {
		return produto;
	}

	public void setProduto(Product produto) {
		this.produto = produto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

}
