package ar.com.cdt.javaUTN.bo;

import java.util.List;
import java.util.Optional;

import ar.com.cdt.javaUTN.entity.EstudianteEntity;
import ar.com.cdt.javaUTN.models.EstudianteModels;


public interface EstudianteBo {

	public  EstudianteEntity guardarEstudiante(EstudianteModels estudiante);
	
	public Optional<EstudianteEntity> modificarEstudiante(EstudianteModels estudiante, Long id);
	
	public void eliminarEstudiante(Long id);
	
	public List<EstudianteEntity> consultarEstudiantes();
	
	public String obtenerPromedioBebidas();
}
