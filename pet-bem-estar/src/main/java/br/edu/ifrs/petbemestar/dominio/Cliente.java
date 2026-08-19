package br.edu.ifrs.petbemestar.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {

    @Id
    private Long id;
    private String nome;
    private String telefone;
    private List<Animal> animais = new ArrayList<>();

    protected Cliente() {
    }

    public Cliente(String nome, String telefone, List<Animal> animais) {
        this.nome = nome;
        this.telefone = telefone;
        this.animais = animais;
    }

    public Atendimento registrarAtendimento(
            Animal animal,
            TipoAtendimento tipoAtendimento,
            Veterinario, veterinario,
            StatusAtendimento status
    ) {
        if (!animais.contains(animal)) {
            throw new IllegalArgumentException("Este animal nao pertence a este cliente.");
        }

        return new Atendimento(tipoAtendimento, status, this, animal);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }
}
