package com.jonatan.gestao_hospitalar.controller;

import com.jonatan.gestao_hospitalar.model.Medico;
import com.jonatan.gestao_hospitalar.model.Paciente;
import com.jonatan.gestao_hospitalar.model.Prontuario;
import com.jonatan.gestao_hospitalar.repository.MedicoRepository;
import com.jonatan.gestao_hospitalar.repository.PacienteRepository;
import com.jonatan.gestao_hospitalar.repository.ProntuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {

    @Autowired
    private ProntuarioRepository prontuarioRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    // CREATE
    @PostMapping
    public Prontuario criarProntuario(@RequestParam Long pacienteId,
                                      @RequestParam Long medicoId,
                                      @RequestParam String dataHora,
                                      @RequestParam String anotacoes,
                                      @RequestParam(required = false) String receita) {

        Optional<Paciente> paciente = pacienteRepository.findById(pacienteId);
        Optional<Medico> medico = medicoRepository.findById(medicoId);

        if (paciente.isEmpty() || medico.isEmpty()) {
            throw new RuntimeException("Paciente ou médico não encontrado");
        }

        Prontuario prontuario = new Prontuario(
                paciente.get(),
                medico.get(),
                LocalDateTime.parse(dataHora),
                anotacoes,
                receita
        );

        return prontuarioRepository.save(prontuario);
    }

    // READ - Listar todos
    @GetMapping
    public List<Prontuario> listarProntuarios() {
        return prontuarioRepository.findAll();
    }

    // READ - Buscar por ID
    @GetMapping("/{id}")
    public Optional<Prontuario> buscarPorId(@PathVariable Long id) {
        return prontuarioRepository.findById(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        prontuarioRepository.deleteById(id);
    }
}
