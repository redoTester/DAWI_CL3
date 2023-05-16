package com.cl3.palomino.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cl3.palomino.entity.Programador;

public interface ProgramadorRepository extends JpaRepository<Programador, Integer>{

	@Query("select p from Programador p where p.proyecto.codigo=?1")
	public List<Programador> listAllByProject(int codProyect);
	
}
