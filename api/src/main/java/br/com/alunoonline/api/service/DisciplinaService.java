package br.com.alunoonline.api.service;
import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {
    @Autowired
    DisciplinaRepository repository;


    public void create(Disciplina disciplina){
        repository.save(disciplina);
    }

    public List findAll(){
        return repository.findAll();
    }

    public List ListarDisciplinasPorProfessor(String email){
        return repository.listarDisciplinasPorProfessor(email);
    }

    public Optional<Disciplina> findById(Long id){
        return repository.findById(id);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public void update(Long id, Disciplina disciplina){
        Optional<Disciplina> disciplinaFromBD = findById(id);

        if (disciplinaFromBD.isEmpty()){

            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"DISCIPLINA NÃO ENCONTRADA");
        }

        Disciplina disciplinaUpdated = disciplinaFromBD.get();

        disciplinaUpdated.setNome(disciplina.getNome());
        disciplinaUpdated.setCurso(disciplina.getCurso());
        disciplinaUpdated.setProfessor(disciplina.getProfessor());

        repository.save(disciplinaUpdated);

    }
}
