package ar.com.cdt.javaUTN.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.com.cdt.javaUTN.entity.EstudianteEntity;

public interface EstudianteRepository extends JpaRepository<EstudianteEntity, Long>{

	EstudianteEntity findByDNI(long id);
	
	List<EstudianteEntity> findAll();
}
