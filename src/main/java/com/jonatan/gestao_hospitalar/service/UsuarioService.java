package com.jonatan.gestao_hospitalar.service;

import com.jonatan.gestao_hospitalar.dto.UsuarioDTO;
import com.jonatan.gestao_hospitalar.model.Usuario;
import com.jonatan.gestao_hospitalar.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // Classe que criptografa a senha

    public Usuario cadastrar(UsuarioDTO usuarioDTO) {
        // Criptografa a senha antes de salvar
        String senhaCriptografada = passwordEncoder.encode(usuarioDTO.getSenha());

        Usuario novoUsuario = new Usuario(
                usuarioDTO.getNome(),
                usuarioDTO.getEmail(),
                senhaCriptografada
        );

        return usuarioRepository.save(novoUsuario);
    }
}
