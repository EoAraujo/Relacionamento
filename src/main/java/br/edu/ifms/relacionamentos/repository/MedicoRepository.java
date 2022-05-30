package br.edu.ifms.relacionamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.relacionamentos.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    
}
