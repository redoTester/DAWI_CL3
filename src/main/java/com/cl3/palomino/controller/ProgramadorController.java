package com.cl3.palomino.controller;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cl3.palomino.entity.Programador;
import com.cl3.palomino.entity.Proyecto;
import com.cl3.palomino.service.ProgramadorService;
import com.cl3.palomino.service.ProyectoService;
import com.cl3.palomino.utils.Libreria;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/Programador")
public class ProgramadorController {

	@Autowired
	private ProgramadorService servicioProgramador;
	
	@Autowired
	private ProyectoService servicioProyecto;
	
	
	@RequestMapping("/lista")
	public String lista(Model model) {
		model.addAttribute("proyectos",servicioProyecto.listarProyectos());
		return "Programador";
	}
	
	@RequestMapping("/consulta")
	@ResponseBody
	public List<Programador> cosulta(@RequestParam("codigo") Integer cod) {
		return servicioProgramador.listarProgramadoresPorProyecto(cod);
	}
	
	@RequestMapping("/registrar")
	public String registrar(@RequestParam("codigo") Integer cod,
			@RequestParam("nombre") String nom,@RequestParam("apellido") String ape,
			@RequestParam("dni") int dni,@RequestParam("hijos") int hijos,
			@RequestParam("sueldo") double sueldo,@RequestParam("proyecto") int codProy,
			RedirectAttributes redirect) {
		
		try {
			Programador p= new Programador();
			
			p.setCodigo(cod);
			p.setNombre(nom);
			p.setApellido(ape);
			p.setDni(dni);
			p.setHijos(hijos);
			p.setSueldo(sueldo);
			
			Proyecto pj= new Proyecto();
			pj.setCodigo(codProy);
		
			
			p.setProyecto(pj);
			
			servicioProgramador.registrar(p);
			redirect.addFlashAttribute("MENSAJE","Programador registrado");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error en el registro");
			e.printStackTrace();
			e.printStackTrace();
		}
		return "redirect:/Programador/lista";
	}
	
	@RequestMapping("/reporte")
	public void reporte(HttpServletResponse response,@RequestParam("codigo") Integer cod) {
		try {
			//obtener todos los medicamentos
			List<Programador> data=servicioProgramador.listarProgramadoresPorProyecto(cod);
			//acceder al reporte "reporte_medicamentos.jrxml"
			File file=ResourceUtils.getFile("classpath:reporte_programadores.jrxml");
			//origen de datos convertir data a tipo JRBeanCollectionDataSource
			JRBeanCollectionDataSource info=new JRBeanCollectionDataSource(data);
			//invocar al método generarReporte
			JasperPrint print=Libreria.generarReporte(file, info);
			//salida en el navegador en formato pdf
			response.setContentType("application/pdf");
			//salida de flujo
			OutputStream salida=response.getOutputStream();
			//exportar a pdf
			JasperExportManager.exportReportToPdfStream(print, salida);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
