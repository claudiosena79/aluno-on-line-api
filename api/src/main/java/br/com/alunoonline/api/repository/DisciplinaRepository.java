package br.com.alunoonline.api.repository;

import br.com.alunoonline.api.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    @Query("select d from Disciplina d where d.professor.email =:email order by d.nome asc")
    List<Disciplina> listarDisciplinaPorProfessor(@PathVariable String email);

    @Query("select d from Disciplina d where d.aluno.email= :email order by nome asc")
    List<Disciplina> listarDisciplinaPorAluno(@PathVariable String email);
    }


