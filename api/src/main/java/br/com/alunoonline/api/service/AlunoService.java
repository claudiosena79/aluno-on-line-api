package br.com.alunoonline.api.service;
import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.model.dto.AlunoDTO;
import br.com.alunoonline.api.repository.AlunoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository repository;


    ModelMapper mapper = new ModelMapper();
    public AlunoDTO consultarAlunoEmail(Long id){
        Aluno aluno = repository.findById(id).get();
        AlunoDTO alunoDTO = mapper.map(aluno, AlunoDTO.class);

        return alunoDTO;
    }

    public void create(Aluno aluno){

        repository.save(aluno);

    }

    public List<Aluno> findAll(){

        return repository.findAll();

    }

    public Aluno findAlunoByEmail(String email) {
        return repository.findAlunoByEmail(email);
    }

    public Aluno findAlunoByNomeAndEmail(String nome, String email){
        return repository.findAlunoByNomeAndEmail(nome, email);
    }

    public List<Aluno> findAllOrderByNome(){
        return repository.findAllOrderByNome();
    }

    public Aluno buscarPorEmailJpql(String email){
        return repository.buscarPorEmaiJpql(email);
    }

    public Optional<Aluno> findById(Long id){

        return repository.findById(id);

    }

    public void update (Long id, Aluno aluno){
        Optional<Aluno> alunoFromDb = findById(id);

        if (alunoFromDb.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"ALUNO NÃO ENCONTRADO");
        }

        Aluno alunoUpdated = alunoFromDb.get();

        alunoUpdated.setNome(aluno.getNome());
        alunoUpdated.setEmail(aluno.getEmail());
        alunoUpdated.setCurso(aluno.getCurso());

        repository.save(alunoUpdated);

    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
