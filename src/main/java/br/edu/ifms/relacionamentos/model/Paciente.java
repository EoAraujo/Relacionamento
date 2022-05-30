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
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String position;
    private String diagnostico;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "MEDICO_PACIENTE", 
        joinColumns = { @JoinColumn(name = "MEDICO_ID")}
    )
    private List<Medico> medicos;
}
