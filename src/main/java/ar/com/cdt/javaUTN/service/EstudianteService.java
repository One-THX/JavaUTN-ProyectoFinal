package ar.com.cdt.javaUTN.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.cdt.javaUTN.bo.EstudianteBo;
import ar.com.cdt.javaUTN.bo.impl.EstudianteBoImpl;
import ar.com.cdt.javaUTN.entity.EstudianteEntity;
import ar.com.cdt.javaUTN.models.EstudianteModels;

@SpringBootApplication
@RestController
public class EstudianteService {

	public static final Logger logger = LoggerFactory.getLogger(EstudianteBoImpl.class);

	@Autowired
	EstudianteBo estudianteBo;

	//OBTENER ESTUDIANTES
	@GetMapping("/obtenerEstudiantes")
	public List<EstudianteEntity> getAllEstudiantes() {
		logger.info("EstudianteService - entra en la funcion getAllEstudiantes");
		
		return estudianteBo.consultarEstudiantes();

	}
	//AGREGAR
	@PostMapping("/guardar")
	public EstudianteEntity save(@RequestBody EstudianteModels estudiante) {
		logger.info("EstudianteService - entra en la funcion save");

		return estudianteBo.guardarEstudiante(estudiante);
	}

	//MODIFICAR
	@PutMapping("/modificar/{id}")
	public Optional<EstudianteEntity> update(@RequestBody EstudianteModels estudiante, @PathVariable Long id) {
		logger.info("EstudianteService - entra en la funcion update: {}",estudiante.toString());
		
		return estudianteBo.modificarEstudiante(estudiante, id);
	};

	//ELIMINAR
	@DeleteMapping("/eliminar/{id}")
	public void delete(@PathVariable Long id) {
		logger.info("EstudianteService - entra en la funcion delete: {}", id);
		estudianteBo.eliminarEstudiante(id);
	}
	//OBTENER PROMEDIO BEBIDAS
	
	@GetMapping("/obtenerPromedioBebidas")
	public String getPromedioBebidas() {
		logger.info("EstudianteService - entra en la funcion getPromedioBebidas {}");
		return estudianteBo.obtenerPromedioBebidas();

	}
}
