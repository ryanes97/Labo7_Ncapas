package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.DTO.EstudianteDTO;
import com.uca.capas.domain.Estudiante;

public interface EstudianteService {
	public List<Estudiante> findAll() throws DataAccessException;
	
	public List<EstudianteDTO> pruebaDTO() throws DataAccessException;
	
	public List<Estudiante> filtrarPor(String cadena) throws DataAccessException;
	
	public List<Estudiante> empiezaCon(String cadena) throws DataAccessException;
	
	public Estudiante findOne(Integer code) throws DataAccessException;

	public void save(Estudiante estudiante) throws DataAccessException;

	public void delete(Integer codigoEstudiante) throws DataAccessException;
}
