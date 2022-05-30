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
@RequestMapping("/medico")
public class MedicoController {
    
    @Autowired
    MedicoService medicoService;

    @Autowired
    PacienteService pacienteService;

    @GetMapping("/")
    public String listAllMedicos(Model html) {
        List<Medico> medicosList = medicoService.getAllMedico();
        html.addAttribute("medicosList", medicosList);
        html.addAttribute("noDataMedico", new Medico());
        List<Paciente> pacientesList = pacienteService.getAllPacientes();
        html.addAttribute("pacientesList", pacientesList);
        return "medico";
    }


    @PostMapping("/save")
    public String saveMedico(@ModelAttribute("noDataMedico") Medico medico) {
        medicoService.saveMedico(medico);
        return "redirect:/medico/";
    }


    @GetMapping("/delete/{id}")
    public String deleteMedico(@PathVariable("id") int id) {
        medicoService.deleteMedicoById(id);
        return "redirect:/medico/";
    }
    

    @PostMapping("/update/{id}")
    public String updateMedico(@PathVariable("id") int id, @ModelAttribute("noDataMedico") Medico medico) {
        medicoService.saveMedico(medico);
        return "redirect:/medico/";
    }
}
