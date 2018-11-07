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
@Table(name = "USUARIO", schema = PropertiesUtil.SCHEMA)
@SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO", schema = PropertiesUtil.SCHEMA, allocationSize = 1, initialValue = 1)
public class Usuario {

	@Id
	@Column(name = "ID_USUARIO")
	@GeneratedValue(generator = "SEQ_USUARIO", strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne(targetEntity=TipoAcessoUsuario.class, fetch=FetchType.LAZY)
	@JoinColumn(name="TIPO_ACESSO_USUARIO", referencedColumnName="ID_ACESSO_USUARIO")
	private TipoAcessoUsuario tipoAcessoUsuario;
	
	@Column(name="DATA_REGISTRO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataRegistro;
	
	@Column(name="LOGIN")
	private String login;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="NOME")
	private String nome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public TipoAcessoUsuario getTipoAcessoUsuario() {
		return tipoAcessoUsuario;
	}

	public void setTipoAcessoUsuario(TipoAcessoUsuario tipoAcessoUsuario) {
		this.tipoAcessoUsuario = tipoAcessoUsuario;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
