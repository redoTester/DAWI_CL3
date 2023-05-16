package com.cl3.palomino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cl3.palomino.entity.Proyecto;
import com.cl3.palomino.repository.ProyectoRepository;

@Service
public class ProyectoService {

	@Autowired
	private ProyectoRepository prorepo;
	
	public List<Proyecto> listarProyectos(){
		return prorepo.findAll();
	}
	
}
