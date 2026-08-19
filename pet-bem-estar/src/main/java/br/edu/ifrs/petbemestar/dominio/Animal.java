package br.edu.ifrs.petbemestar.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Animal {

    @Id
    private Long id;
    private String nome;
    private Cliente dono;
    private List<String> vacinas;
    private List<Atendimento> atendimentos;

    public Animal(Long id, String nome, Cliente dono, List<String> vacinas, List<Atendimento> atendimentos) {
        this.id = id;
        this.nome = nome;
        this.dono = dono;
        this.vacinas = vacinas;
        this.atendimentos = atendimentos;
    }
}
