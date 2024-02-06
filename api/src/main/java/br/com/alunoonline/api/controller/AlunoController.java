package br.com.alunoonline.api.controller;

import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Aluno aluno){

        service.create(aluno);

   }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> findAll(){

        return service.findAll();

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Aluno> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/email/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Aluno findAlunoByEmail(@PathVariable String email){
        return service.findAlunoByEmail(email);
    }
    @GetMapping("/nome-email/{nome}/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Aluno findAlunoByNomeAndEmail(@PathVariable String nome, @PathVariable String email){
        return service.findAlunoByNomeAndEmail(nome, email);
    }
    @GetMapping("/all/nome/asc")
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> findAllOrderByNome(){
        return service.findAllOrderByNome();
    }

    @GetMapping("/email/jpq/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Aluno buscarPorEmailJpql(@PathVariable String email){
        return service.buscarPorEmailJpql(email);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)

    public void updated(@PathVariable Long id, @RequestBody Aluno aluno){
        service.update(id, aluno);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }


}
