package com.cl3.palomino;

import java.security.Provider.Service;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cl3.palomino.entity.Proyecto;

@SpringBootTest
class Ec3PalominoDeLaVegaApplicationTests {

	@Autowired
	private com.cl3.palomino.service.ProyectoService repo;
	
	
	@Test
	void contextLoads() {
		
		List<Proyecto> data= repo.listarProyectos();
		for(Proyecto a :data)
			System.out.println(a.getCodigo()+"---"+a.getNombre());
		
	}

}
