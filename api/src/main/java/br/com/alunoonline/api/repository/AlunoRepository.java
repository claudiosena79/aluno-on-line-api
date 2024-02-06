package br.com.alunoonline.api.repository;

import br.com.alunoonline.api.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Aluno findAlunoByEmail(String email);
    Aluno findAlunoByNomeAndEmail(String nome, String email);

    @Query("select a from Aluno a order by a.nome asc")
    List<Aluno> findAllOrderByNome();

    @Query("select a from Aluno a where a.email = :email")
    Aluno buscarPorEmaiJpql(@Param("email") String email);

}
