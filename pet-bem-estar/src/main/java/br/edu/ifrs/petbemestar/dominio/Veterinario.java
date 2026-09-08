package br.edu.ifrs.petbemestar.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.List;

@Entity
public class Veterinario {

    @Id
    private Long id;
    private String nome;
    private List<String> vacinas;
    private List<DiasDeTrabalho> diasAtendimento;

    public Veterinario(Long id, List<String> vacinas, String nome, List<DiasDeTrabalho> diasAtendimento) {
        this.id = id;
        this.vacinas = vacinas;
        this.nome = nome;
        this.diasAtendimento = diasAtendimento;
    }
}
