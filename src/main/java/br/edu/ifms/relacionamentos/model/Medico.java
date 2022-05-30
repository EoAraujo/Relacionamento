package br.edu.ifms.relacionamentos.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private int totalCost;
    private int duration; 

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
    name = "PACIENTE_MEDICO",
    joinColumns = { @JoinColumn(name = "PACIENTE_ID")}
    )
    
    private List<Paciente> pacientes;
}
