package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Professor;
import br.com.alunoonline.api.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    ProfessorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Professor professor) {

        service.create(professor);

    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Professor> findAll() {

        return service.findAll();

    }

   @GetMapping("/all-asc")
   @ResponseStatus(HttpStatus.OK)
   public List<Professor> findAllAndOrderByNome() {
       return service.findAllAndOrderByNome();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Professor> findById(Long id) {

        return service.findById(id);

    }

    @GetMapping("/nome-email/{nome}/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Professor findProfessorPorNomeAndEmail(@PathVariable String nome, @PathVariable String email) {
        return service.findProfessorPorNomeAndEmail(nome, email);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {

        service.deleteById(id);

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody Professor professor) {

        service.update(id, professor);

    }

}
