package com.uca.capas.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.DTO.EstudianteDTO;
import com.uca.capas.domain.Estudiante;
import com.uca.capas.repositories.EstudianteRepo;

@Service
public class EstudianteServiceImpl implements EstudianteService{

	@Autowired
	EstudianteRepo estudianteRepo;
	//EstudianteDAO estudianteDAO;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException 
	{
		//return estudianteRepo.findAll();
		return estudianteRepo.mostrarTodos();
	}
	
	@Override
	public List<EstudianteDTO> pruebaDTO() throws DataAccessException 
	{
		List<EstudianteDTO> estudiantes = estudianteRepo.pruebaDTO().stream().map(obj->{
			EstudianteDTO e = new EstudianteDTO();
			e.setNombre(obj[0].toString());
			e.setApellido(obj[1].toString());
			
			return e;
		}).collect(Collectors.toList());
		
		return estudiantes;
	}
	
	@Override
	public List<Estudiante> filtrarPor(String cadena) throws DataAccessException 
	{
		//return estudianteRepo.findByNombre(cadena);
		return estudianteRepo.mostrarPorNombre(cadena);
	}
	
	@Override
	public List<Estudiante> empiezaCon(String cadena) throws DataAccessException 
	{
		return estudianteRepo.findByApellidoStartingWith(cadena);
	}

	@Override
	public Estudiante findOne(Integer code) throws DataAccessException 
	{
		return estudianteRepo.getOne(code);
	}

	@Override
	@Transactional
	public void save(Estudiante estudiante) throws DataAccessException 
	{
		estudianteRepo.save(estudiante);		
	}

	@Override
	@Transactional
	public void delete(Integer codigoEstudiante) throws DataAccessException 
	{
		estudianteRepo.deleteById(codigoEstudiante);
	}
}
