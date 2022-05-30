package br.edu.ifms.relacionamentos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.relacionamentos.model.Medico;
import br.edu.ifms.relacionamentos.repository.MedicoRepository;

@Service
public class MedicoService {
    
    @Autowired
    MedicoRepository medicoRepository;


    public List<Medico> getAllMedico() {
        return medicoRepository.findAll();
    }

    
    public Medico getMedicoById(int id) {
        return medicoRepository.getById(id);
    }


    public void saveMedico(Medico medico) {
        medicoRepository.save(medico);
    }


    public void deleteMedicoById(int id) {
        medicoRepository.deleteById(id);
    }
}
