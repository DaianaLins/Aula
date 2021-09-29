package com.projeto.clinicalfem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.projeto.clinicalfem.models.CadMedico;

@Repository
public interface CadMedicoRepository extends CrudRepository<CadMedico, String>{


}
