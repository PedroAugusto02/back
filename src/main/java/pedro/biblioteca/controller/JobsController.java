package pedro.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedro.biblioteca.model.Jobs;
import pedro.biblioteca.model.Usuario;
import pedro.biblioteca.repository.JobsRepository;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/jobs")
public class JobsController {

    @Autowired
    JobsRepository jobsRepository;

    @PostMapping
    public ResponseEntity<Jobs> criarTrabalho(@RequestBody Jobs trabalho) {
        Jobs job = jobsRepository.save(trabalho);
        return ResponseEntity.status(HttpStatus.CREATED).body(job);
    }

    @GetMapping
    public ResponseEntity<List<Jobs>> listar() {
        List<Jobs> jobs = jobsRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(jobs);
    }

}
