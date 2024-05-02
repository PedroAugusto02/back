package pedro.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedro.biblioteca.model.Usuario;
import pedro.biblioteca.repository.UserRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioSalvo = userRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(@RequestParam(required = false) Integer age,
                                                        @RequestParam(required = false) Boolean active) {
        List<Usuario> usuarios;
        if (age != null) {
            usuarios = userRepository.findByAge(age);
        } else {
            if (active != null) {
                usuarios = userRepository.findByActive(active);
            }else {
                usuarios = userRepository.findAll();
            }
        }
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {

        Usuario usuarioExistente = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario não encontrado" + id));
        if (usuario.getName() != null) usuarioExistente.setName(usuario.getName());
        if (usuario.getEmail() != null) usuarioExistente.setEmail(usuario.getEmail());
        if (usuario.getAge() != null) usuarioExistente.setAge(usuario.getAge());
        if (usuario.getActive() != null) usuarioExistente.setActive(usuario.getActive());

        Usuario usuarioSalvo = userRepository.save(usuarioExistente);
        return ResponseEntity.ok(usuarioSalvo);

    }

    @PatchMapping("/{id}/available")
    public ResponseEntity<Usuario> toggleUsuario(@PathVariable Long id) {
        Usuario usuario = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        usuario.setActive(!usuario.getActive());
        Usuario usuarioAtualizado = userRepository.save(usuario);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
            userRepository.deleteById(id);
            return ResponseEntity.noContent().build();
    }


}
