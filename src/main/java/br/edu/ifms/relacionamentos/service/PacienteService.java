package br.edu.ifms.relacionamentos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.relacionamentos.model.Paciente;
import br.edu.ifms.relacionamentos.repository.PacienteRepository;

@Service
public class PacienteService {
    
    @Autowired
    PacienteRepository pacienteRepository;


    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }


    public Paciente getPacienteById(int id) {
        return pacienteRepository.getById(id);
    }


    public void savePaciente(Paciente paciente) {
        pacienteRepository.save(paciente);
    }


    public void deletePacienteById(int id) {
        pacienteRepository.deleteById(id);
    }
}
// 