package com.jpaproject.veiculos.dominio;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "veiculo")
@NamedQueries({
	@NamedQuery(name = "Veiculo.comProprietarioPorValor",
			query = "from Veiculo v inner join fetch v.proprietario where v.valor > :valor"),
	@NamedQuery(name = "Veiculo.porModelo",
	query = "from Veiculo where modelo like :modelo")})
public class Veiculo {

	private Long codigo;
	private String fabricante;
	private String modelo;
	private Integer anoFabricacao;
	private Integer anoModelo;
	private BigDecimal valor;
	private TipoCombustivel tipoCombustivel;
	private Date dataCadastro;
	private String especificacoes;
	private byte[] foto;
	private Proprietario proprietario;
	private Set<Acessorio> acessorios = new HashSet<>();

	public Veiculo() {
		super();
	}

	//A inclusão do GenerationType.AUTO é optatíva, pois por default o JPA seta ele como AUTO
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@GeneratedValue
	//@GeneratedValue(generator = "inc")
	//@GenericGenerator(name = "inc", strategy = "increment")
	//@Column(name = "cod_veiculo")
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	@Column(length = 60, nullable = false)
	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	@Column(length = 60, nullable = false)
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Column(name = "ano_fabricacao", nullable = false)
	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	@Column(name = "ano_modelo", nullable = false)
	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	@Column(precision = 10, scale = 2, nullable = false)
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Column(name = "tipo_combustivel", nullable = false)
	@Enumerated(EnumType.STRING)
	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro", nullable = false)
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Lob	
	public String getEspecificacoes() {
		return especificacoes;
	}

	public void setEspecificacoes(String especificacoes) {
		this.especificacoes = especificacoes;
	}

	@Lob
	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	@ManyToOne
	@JoinColumn(name = "cod_proprietario")
	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	@ManyToMany
	@JoinTable(name = "veiculo_acessorios",
	joinColumns = @JoinColumn(name = "cod_veiculo"),
	inverseJoinColumns = @JoinColumn(name = "cod_acessorio"))
	public Set<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(Set<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	//	@Transient
	//	public String getDescricao() {
	//		return this.getFabricante() + " " + this.getModelo()
	//		+ " " + this.getAnoFabricacao() + "/" + this.getAnoModelo()
	//		+ " por apenas " + this.getValor();
	//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acessorios == null) ? 0 : acessorios.hashCode());
		result = prime * result + ((anoFabricacao == null) ? 0 : anoFabricacao.hashCode());
		result = prime * result + ((anoModelo == null) ? 0 : anoModelo.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((especificacoes == null) ? 0 : especificacoes.hashCode());
		result = prime * result + ((fabricante == null) ? 0 : fabricante.hashCode());
		result = prime * result + Arrays.hashCode(foto);
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
		result = prime * result + ((proprietario == null) ? 0 : proprietario.hashCode());
		result = prime * result + ((tipoCombustivel == null) ? 0 : tipoCombustivel.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		Veiculo other = (Veiculo) obj;
		if (acessorios == null) {
			if (other.acessorios != null)
				return false;
		} else if (!acessorios.equals(other.acessorios))
			return false;
		if (anoFabricacao == null) {
			if (other.anoFabricacao != null)
				return false;
		} else if (!anoFabricacao.equals(other.anoFabricacao))
			return false;
		if (anoModelo == null) {
			if (other.anoModelo != null)
				return false;
		} else if (!anoModelo.equals(other.anoModelo))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (especificacoes == null) {
			if (other.especificacoes != null)
				return false;
		} else if (!especificacoes.equals(other.especificacoes))
			return false;
		if (fabricante == null) {
			if (other.fabricante != null)
				return false;
		} else if (!fabricante.equals(other.fabricante))
			return false;
		if (!Arrays.equals(foto, other.foto))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		if (proprietario == null) {
			if (other.proprietario != null)
				return false;
		} else if (!proprietario.equals(other.proprietario))
			return false;
		if (tipoCombustivel != other.tipoCombustivel)
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}



}
