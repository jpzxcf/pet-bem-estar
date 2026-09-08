package br.edu.ifrs.petbemestar.dominio;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Animal {

    @Id
    private Long id;
    private String nome;
    private Cliente dono;
    private List<String> vacinas;
    private List<Atendimento> atendimentos = new ArrayList<>();

    protected Animal() {
    }

    public Animal(Long id, String nome, Cliente dono, List<String> vacinas, List<Atendimento> atendimentos) {
        this.id = id;
        this.nome = nome;
        this.dono = dono;
        this.vacinas = vacinas;
        this.atendimentos = atendimentos;
    }

    public void adicionarAtendimento(Atendimento atendimento) {
        atendimentos.add(atendimento);
        atendimento.setAnimal(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente getDono() {
        return dono;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
    }

    public List<String> getVacinas() {
        return vacinas;
    }

    public void setVacinas(List<String> vacinas) {
        this.vacinas = vacinas;
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }
}
