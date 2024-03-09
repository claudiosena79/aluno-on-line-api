package br.com.alunoonline.api.service;
import br.com.alunoonline.api.client.DisciplinaClient;
import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.model.Disciplina;
import br.com.alunoonline.api.model.dto.DisciplinaIntegrationDTO;
import br.com.alunoonline.api.repository.DisciplinaRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class DisciplinaService {
    @Autowired
    DisciplinaRepository repository;
    @Autowired
    DisciplinaClient client;


    public void create(Disciplina disciplina){
        repository.save(disciplina);
    }

    public List findAll(){
        return repository.findAll();
    }

    public List listarDisciplinaPorProfessor(String email){
        return repository.listarDisciplinaPorProfessor(email);
    }

    public List<Disciplina> listarDisciplinaPorAluno(String email){
        return repository.listarDisciplinaPorAluno(email);
    }

    public void importarDisciplinas(){
        log.info("Integração Iniciada");
        List<DisciplinaIntegrationDTO> lista = client.getListaDisciplina();
        for (DisciplinaIntegrationDTO disciplinaDTO: lista){
            var disciplina = new Disciplina();
            disciplina.setNome(disciplinaDTO.getCodigo()+" - "+disciplinaDTO.getNome());
            repository.save(disciplina);
        }
        log.info("Integração Concluída");
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
        disciplinaUpdated.setAluno(disciplina.getAluno());

        repository.save(disciplinaUpdated);

    }
}
