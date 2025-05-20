package com.jonatan.gestao_hospitalar.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "consultas")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // várias consultas podem ter o mesmo médico
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    @ManyToOne // várias consultas podem ter o mesmo paciente
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false)
    private String tipo; // exemplo: presencial, online, retorno

    private String observacoes;

    public Consulta() {}

    public Consulta(Medico medico, Paciente paciente, LocalDateTime dataHora, String tipo, String observacoes) {
        this.medico = medico;
        this.paciente = paciente;
        this.dataHora = dataHora;
        this.tipo = tipo;
        this.observacoes = observacoes;
    }

    public Long getId() { return id; }

    public Medico getMedico() { return medico; }
    public void setMedico(Medico medico) { this.medico = medico; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
