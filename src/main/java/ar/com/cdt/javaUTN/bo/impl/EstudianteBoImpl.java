package ar.com.cdt.javaUTN.bo.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import ar.com.cdt.javaUTN.bo.EstudianteBo;
import ar.com.cdt.javaUTN.entity.EstudianteEntity;
import ar.com.cdt.javaUTN.models.EstudianteModels;
import ar.com.cdt.javaUTN.repository.EstudianteRepository;

@Component
public class EstudianteBoImpl implements EstudianteBo {
	
	public static final Logger logger = LoggerFactory.getLogger(EstudianteBoImpl.class);
	int cantidadBebidasPorPersona;
	double cantidadPacBebidas;

	@Autowired
	EstudianteRepository repository;
	
	@Override
    public List<EstudianteEntity> consultarEstudiantes(){
	  return repository.findAll();
    }

	@Override
	public EstudianteEntity guardarEstudiante(EstudianteModels estudiante) {

	 logger.info("EstudianteboImpl - Entra en la funcion guardarEstudiante {}", estudiante.toString());
	    
     EstudianteEntity entity = new EstudianteEntity();
     entity.setNombre(estudiante.nombre);
     entity.setApellido(estudiante.apellido);
     entity.setDNI(estudiante.DNI);
     entity.setEdad(estudiante.edad);
		
 		return repository.save(entity);
	}
	
	@Override
    public Optional<EstudianteEntity> modificarEstudiante(EstudianteModels estudiante, Long id) {
   		
		logger.info("EstudianteboImpl - Entra en la funcion modificarEstudiante {}");

        return repository.findById(id)
            .map(estudiantee -> {
            	estudiantee.setNombre(estudiante.getNombre());
            	estudiantee.setApellido(estudiante.getApellido());
            	estudiantee.setDNI(estudiante.getDNI());
            	estudiantee.setEdad(estudiante.getEdad());
                return repository.save(estudiantee);
             });

    }
	
	@Override
    public void eliminarEstudiante(Long id) {
		
		logger.info("Entra en la funcion eliminarEstudiante {}");
		
         repository.deleteById(id);
    }
	
	@Override
    public String obtenerPromedioBebidas(){
   		
		logger.info("EstudianteboImpl - Entra en la funcion obtenerPromedioBebidas {}");
   		
		cantidadBebidasPorPersona= 0;   
	       repository.findAll().forEach(estudiante -> {
	    		
	        if ((estudiante.edad >= 20)&&(estudiante.edad <= 30)) {
	        	cantidadBebidasPorPersona = cantidadBebidasPorPersona + 3;
	    	}
	        if ((estudiante.edad >= 31)&&(estudiante.edad <= 45)) {
	        	cantidadBebidasPorPersona = cantidadBebidasPorPersona + 2;	
	    	}
	        if ((estudiante.edad >= 45)) {
	        	cantidadBebidasPorPersona = cantidadBebidasPorPersona + 1;
	    	}
	       });
	       
	       if(cantidadBebidasPorPersona >= 6) {
	           cantidadPacBebidas = cantidadBebidasPorPersona / 6;
	           if(cantidadPacBebidas % 2 != 0) {
	        	   cantidadPacBebidas = (int)cantidadPacBebidas +1;
	           }
	       }else {
	    	   return  "Se calculo " + (int)cantidadPacBebidas + " pack de cerveza para la cantidad de personas que asistiran a la reunion de despedida";
	       }
	       
	       return  "Se calcularon " + (int)cantidadPacBebidas + " packs de cerveza para la cantidad de personas que asistiran a la reunion de despedida";
    }
}
