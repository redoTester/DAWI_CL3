package com.cl3.palomino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cl3.palomino.entity.Programador;
import com.cl3.palomino.repository.ProgramadorRepository;

@Service
public class ProgramadorService {

	@Autowired
	private ProgramadorRepository repo;
	
	
	public List<Programador> listarProgramadoresPorProyecto(int codigo){
		return repo.listAllByProject(codigo);
	}
	
	public void registrar(Programador bean) {
		repo.save(bean);
	}
}
