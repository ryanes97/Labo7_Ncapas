package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.EstudianteDAO;
import com.uca.capas.domain.Estudiante;

@Controller
public class MainController {
	
	@Autowired
	private EstudianteDAO estudianteDAO;
	
	@RequestMapping("/inicio")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = new Estudiante();
		mav.addObject("estudiante", estudiante);
		mav.setViewName("index");
		
		return mav;
	}
	
	@RequestMapping("/formEstudiante")
	public ModelAndView formEstudiante(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) 
		{
			mav.setViewName("index");
		}
		else 
		{
			estudianteDAO.addOne(estudiante);
			Estudiante newEstudiante = new Estudiante();
			mav.addObject("estudiante", newEstudiante);
			mav.setViewName("index");
		}
		
		return mav;
	}
	
	@RequestMapping("/listado")
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		
		try {
			estudiantes = estudianteDAO.findALL();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("listado");
		
		return mav;
	}
}
