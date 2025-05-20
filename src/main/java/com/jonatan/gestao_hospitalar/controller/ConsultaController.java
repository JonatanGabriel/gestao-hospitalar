package com.jonatan.gestao_hospitalar.controller;

import com.jonatan.gestao_hospitalar.model.Consulta;
import com.jonatan.gestao_hospitalar.model.Medico;
import com.jonatan.gestao_hospitalar.model.Paciente;
import com.jonatan.gestao_hospitalar.repository.ConsultaRepository;
import com.jonatan.gestao_hospitalar.repository.MedicoRepository;
import com.jonatan.gestao_hospitalar.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    // CREATE - Cadastrar nova consulta
    @PostMapping
    public Consulta criarConsulta(@RequestParam Long medicoId,
                                  @RequestParam Long pacienteId,
                                  @RequestParam String dataHora,
                                  @RequestParam String tipo,
                                  @RequestParam(required = false) String observacoes) {

        Optional<Medico> medico = medicoRepository.findById(medicoId);
        Optional<Paciente> paciente = pacienteRepository.findById(pacienteId);

        if (medico.isEmpty() || paciente.isEmpty()) {
            throw new RuntimeException("Médico ou Paciente não encontrado");
        }

        Consulta consulta = new Consulta(
                medico.get(),
                paciente.get(),
                LocalDateTime.parse(dataHora), // formato: "2025-04-20T14:30"
                tipo,
                observacoes
        );

        return consultaRepository.save(consulta);
    }

    // READ - Listar todas as consultas
    @GetMapping
    public List<Consulta> listarConsultas() {
        return consultaRepository.findAll();
    }

    // READ - Buscar consulta por ID
    @GetMapping("/{id}")
    public Optional<Consulta> buscarConsulta(@PathVariable Long id) {
        return consultaRepository.findById(id);
    }

    // DELETE - Excluir consulta
    @DeleteMapping("/{id}")
    public void deletarConsulta(@PathVariable Long id) {
        consultaRepository.deleteById(id);
    }
}
