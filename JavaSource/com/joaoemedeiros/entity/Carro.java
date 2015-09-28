/**
 * 
 */
package com.joaoemedeiros.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author joaomedeiros95
 *
 */
@Entity
public class Carro extends Entidade {

	@Column
	private String nome;
	
	@Column
	private String marca;

	@Column
	private Integer ano;
	
	@Override
	@Id
	@GeneratedValue
	public Integer getId() {
		return super.getId();
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public Integer getAno() {
		return ano;
	}
	
	public void setAno(Integer ano) {
		this.ano = ano;
	}

}
