package br.edu.ifms.relacionamentos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifms.relacionamentos.model.Medico;
import br.edu.ifms.relacionamentos.model.Paciente;
import br.edu.ifms.relacionamentos.service.MedicoService;
import br.edu.ifms.relacionamentos.service.PacienteService;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @Autowired
    MedicoService medicoService;

    @GetMapping("/")
    public String listAllPacientes(Model html) {
        List<Paciente> pacientesList = pacienteService.getAllPacientes();
        html.addAttribute("pacientesList", pacientesList);
        html.addAttribute("noDataPaciente", new Paciente());
        List<Medico> medicoList = medicoService.getAllMedico();
        html.addAttribute("medicoList", medicoList);
        return "paciente";
    }


    @PostMapping("/save")
    public String savePaciente(@ModelAttribute("noDataPaciente") Paciente paciente) {
        pacienteService.savePaciente(paciente);
        return "redirect:/paciente/";
    }


    @GetMapping("/delete/{id}")
    public String deletePaciente(@PathVariable("id") int id) {
        pacienteService.deletePacienteById(id);
        return "redirect:/paciente/";
    }


    @PostMapping("/update/{id}")
    public String updatePaciente(@PathVariable("id") int id, @ModelAttribute("noDataPaciente") Paciente paciente) {
        pacienteService.savePaciente(paciente);
        return "redirect:/paciente/";
    }
}
