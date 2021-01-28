package com.parus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@NotNull
	private long id;

	@Column(name = "nome")
	@NotNull
	private String nome;

	@Column(name = "rendimentoMensal")
	@NotNull
	private Integer rendimentoMensal;

	@Column(name = "endereco")
	@NotNull
	private String endereco;

	@Column(name = "status")
	@Enumerated(value = EnumType.STRING)
	private Risco status;

	@Column(name = "taxa_juros")
	private Double juros;

	public Risco valorPossivel() {
		if (rendimentoMensal <= 2000) {
			setStatus(Risco.C);
		} else if (rendimentoMensal > 2000 && rendimentoMensal < 8000) {
			setStatus(Risco.B);
		} else {
			setStatus(Risco.A);
		}
		return getStatus();
	}

	public double taxaJuros() {
		if (status == Risco.C) {
			juros = (10.0 / 100) * rendimentoMensal;
			setJuros(juros);
		} else if (status == Risco.B) {
			juros = (5.0 / 100) * rendimentoMensal;
			setJuros(juros);
		} else if (status == Risco.A) {
			juros = (1.9 / 100) * rendimentoMensal;
		}

		return getJuros();
	}

	public Cliente() {
	}

	public Cliente(long id, String nome, Integer rendimentoMensal, String endereco, Risco status, Double juros) {
		this.id = id;
		this.nome = nome;
		this.rendimentoMensal = rendimentoMensal;
		this.endereco = endereco;
		this.status = status;
		this.juros = juros;
	}

	public Cliente(Cliente entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.rendimentoMensal = entity.getRendimentoMensal();
		this.endereco = entity.getEndereco();
		this.status = entity.valorPossivel();
		this.juros = entity.taxaJuros();
	}
} 
