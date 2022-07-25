package com.deliveryacert.deliveryacertapi.api.controller;

import com.deliveryacert.deliveryacertapi.api.security.JWTLoginFilter;
import com.deliveryacert.deliveryacertapi.api.security.TokenAuthenticationService;
import com.deliveryacert.deliveryacertapi.domain.model.Usuario;
import com.deliveryacert.deliveryacertapi.domain.repository.UsuarioRepository;
import com.deliveryacert.deliveryacertapi.domain.service.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

//    @Autowired
//    private JWTLoginFilter jwtLoginFilter;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{usuarioId}")
    public Usuario buscar(@PathVariable Long usuarioId){
        return usuarioService.buscarOuFalhar(usuarioId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario adicionar(@RequestBody Usuario usuario) {
        System.out.println("nome: "+usuario.getNome());
        System.out.println("nome: "+usuario.getEmail());
        System.out.println("nome: "+usuario.getSenha());
        return usuarioService.salvar(usuario);
    }

    @PutMapping("/{usuarioId}")
    public Usuario atualizar(@PathVariable Long usuarioId, @RequestBody Usuario usuario) {
        Usuario usuarioAtual = usuarioService.buscarOuFalhar(usuarioId);

        BeanUtils.copyProperties(usuario, usuarioAtual, "id", "dataCadastro");

        return usuarioService.salvar(usuarioAtual);
    }

    @DeleteMapping("/{usuarioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long usuarioId) {
        usuarioService.excluir(usuarioId);
    }

//    @PostMapping("/login")
//    public void logar(@RequestBody Usuario usuario){
//        jwtLoginFilter.attemptAuthentication(usuario, );
//    }
}
