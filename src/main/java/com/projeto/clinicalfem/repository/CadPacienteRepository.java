package com.projeto.clinicalfem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projeto.clinicalfem.models.CadPaciente;

@Repository
public interface CadPacienteRepository extends CrudRepository<CadPaciente, String>{
	
}
