package com.cl3.palomino.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_proyecto")
public class Proyecto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_proyecto")
	private Integer codigo;
	
	@Column(name="nom_proyecto")
	private String nombre;
	
	@JsonIgnore
	@OneToMany(mappedBy = "proyecto")
	private List<Programador> listaProgramadores;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Programador> getListaProgramadores() {
		return listaProgramadores;
	}

	public void setListaProgramadores(List<Programador> listaProgramadores) {
		this.listaProgramadores = listaProgramadores;
	}
	
	
}
