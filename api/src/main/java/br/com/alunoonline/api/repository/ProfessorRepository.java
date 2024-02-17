package br.com.alunoonline.api.repository;

import br.com.alunoonline.api.model.Professor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

    @Query("select p from Professor p where p.email= :email")
    Professor findProfessorPorEmail(@Param("email") String email);

    @Query("select p from Professor p where p.nome= :nome and p.email= :email")
    Professor findProfessorPorNomeAndEmail(@Param("nome") String nome, @Param("email") String email);

    @Query("select p from Professor p order by p.nome")
    List<Professor> findAllAndOrderByNome();

}
