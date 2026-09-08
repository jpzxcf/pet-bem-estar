package br.edu.ifrs.petbemestar.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Veterinario {

    @Id
    private Long id;
    private String nome;
    private List<String> vacinas;
    private List<DiasDeTrabalho> diasAtendimento;
    private List<Atendimento> atendimentos = new ArrayList<>();

    protected Veterinario() {
    }

    public Veterinario(Long id, List<String> vacinas, String nome, List<DiasDeTrabalho> diasAtendimento) {
        this.id = id;
        this.vacinas = vacinas;
        this.nome = nome;
        this.diasAtendimento = diasAtendimento;
    }

    public void adicionarAtendimento(Atendimento atendimento) {
        atendimentos.add(atendimento);
        atendimento.setVeterinario(this);
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

    public List<String> getVacinas() {
        return vacinas;
    }

    public void setVacinas(List<String> vacinas) {
        this.vacinas = vacinas;
    }

    public List<DiasDeTrabalho> getDiasAtendimento() {
        return diasAtendimento;
    }

    public void setDiasAtendimento(List<DiasDeTrabalho> diasAtendimento) {
        this.diasAtendimento = diasAtendimento;
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }
}
