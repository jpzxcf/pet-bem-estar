package br.edu.ifrs.petbemestar.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Veterinario {

    @Id
    private Long id;
    private String nome;
    private List<String> vacinas;
    private List<DiasDaSemana> diasAtendimento;

    public Veterinario(Long id, List<String> vacinas, String nome, List<DiasDaSemana> diasAtendimento) {
        this.id = id;
        this.vacinas = vacinas;
        this.nome = nome;
        this.diasAtendimento = diasAtendimento;
    }
}
