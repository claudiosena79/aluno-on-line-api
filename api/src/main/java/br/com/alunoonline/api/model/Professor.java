package br.com.alunoonline.api.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String nome;
    @Email
    private String email;
    @NotEmpty
    private String rg;
    private String cpf;
    @NotEmpty
    private String areaDoConhecimento;
    @NotEmpty
    private String dataDaContratacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getAreaDoConhecimento() {
        return areaDoConhecimento;
    }

    public void setAreaDoConhecimento(String areaDoConhecimento) {
        this.areaDoConhecimento = areaDoConhecimento;
    }

    public String getDataDaContratacao() {
        return dataDaContratacao;
    }

    public void setDataDaContratacao(String dataDaContratacao) {
        this.dataDaContratacao = dataDaContratacao;
    }
}
