package com.jonatan.gestao_hospitalar.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "prontuarios")
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false, length = 1000)
    private String anotacoes;

    @Column(length = 1000)
    private String receita;

    public Prontuario() {}

    public Prontuario(Paciente paciente, Medico medico, LocalDateTime dataHora, String anotacoes, String receita) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
        this.anotacoes = anotacoes;
        this.receita = receita;
    }

    public Long getId() { return id; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public Medico getMedico() { return medico; }
    public void setMedico(Medico medico) { this.medico = medico; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public String getAnotacoes() { return anotacoes; }
    public void setAnotacoes(String anotacoes) { this.anotacoes = anotacoes; }

    public String getReceita() { return receita; }
    public void setReceita(String receita) { this.receita = receita; }
}
