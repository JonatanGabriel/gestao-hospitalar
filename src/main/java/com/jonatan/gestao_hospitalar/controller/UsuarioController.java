package com.jonatan.gestao_hospitalar.controller;

import com.jonatan.gestao_hospitalar.dto.UsuarioDTO;
import com.jonatan.gestao_hospitalar.dto.LoginDTO;
import com.jonatan.gestao_hospitalar.model.Usuario;
import com.jonatan.gestao_hospitalar.repository.UsuarioRepository;
import com.jonatan.gestao_hospitalar.service.TokenService;
import com.jonatan.gestao_hospitalar.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // POST /usuarios
    // Cadastra um novo usuário com senha criptografada
    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        return usuarioService.cadastrar(usuarioDTO);
    }

    // POST /usuarios/login
    // Faz login e retorna token JWT se os dados estiverem corretos
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        var usuario = usuarioRepository.findByEmail(loginDTO.getEmail());

        if (usuario.isEmpty()) {
            return ResponseEntity.status(401).body("Usuário não encontrado");
        }

        var usuarioEncontrado = usuario.get();

        boolean senhaCorreta = new BCryptPasswordEncoder().matches(
                loginDTO.getSenha(),
                usuarioEncontrado.getSenha()
        );

        if (!senhaCorreta) {
            return ResponseEntity.status(401).body("Senha incorreta");
        }

        String token = tokenService.gerarToken(usuarioEncontrado.getEmail());

        return ResponseEntity.ok("Bearer " + token);
    }
}
