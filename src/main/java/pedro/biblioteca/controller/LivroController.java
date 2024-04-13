package pedro.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedro.biblioteca.model.Livro;
import pedro.biblioteca.repository.LivroRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    LivroRepository livroRepository;

    @PostMapping
    public ResponseEntity<Livro> createLivro(@RequestBody Livro livro) {
        livro.setAvailable(true);
        Livro savedLivro = livroRepository.save(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLivro);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> getLivros(@RequestParam(required = false) String genre,
                                                 @RequestParam(required = false) String available,
                                                 @RequestParam(required = false) Integer rating) {
        List<Livro> livros;
        if(genre != null) {
            livros = livroRepository.findByGenre(genre);
        } else if (available != null) {
            livros = livroRepository.findByGenre(available);
        } else if (rating != null) {
            livros = livroRepository.findByRating(rating);
        } else {
            livros = livroRepository.findAll();
        }

        return ResponseEntity.ok(livros);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> updateLivro(@RequestBody Livro livro, @PathVariable Long id) {

        Livro livroExistente = livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado com o ID: " + id));

        if(livro.getTitle() != null) livroExistente.setTitle(livro.getTitle());
        if(livro.getAuthor() != null) livroExistente.setAuthor(livro.getAuthor());
        if(livro.getGenre() != null) livroExistente.setGenre(livro.getGenre());
        if(livro.getPublication_year() != null) livroExistente.setPublication_year(livro.getPublication_year());
        if(livro.getPages() != null) livroExistente.setPages(livro.getPages());
        if(livro.getRating() != null) livroExistente.setRating(livro.getRating());

        Livro livroAtualizado = livroRepository.save(livroExistente);
        return ResponseEntity.ok(livroAtualizado);
    }

    @PatchMapping("/{id}/available")
    public ResponseEntity<Livro> togleLivro(@PathVariable Long id) {
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        livro.setAvailable(!livro.isAvailable());
        Livro livroAtualizado = livroRepository.save(livro);
        return ResponseEntity.ok(livroAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivro(@PathVariable Long id) {
        livroRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
