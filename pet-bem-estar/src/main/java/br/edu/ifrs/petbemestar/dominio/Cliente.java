package br.edu.ifrs.petbemestar.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;

    @OneToMany(mappedBy = "dono")
    private List<Animal> animais = new ArrayList<>();

    @OneToMany(mappedBy = "cliente")
    private List<Atendimento> atendimentos = new ArrayList<>();

    protected Cliente() {
    }

    public Cliente(String nome, String telefone, List<Animal> animais) {
        this.nome = nome;
        this.telefone = telefone;
        this.animais = animais;
    }

    public void adicionarAnimal(Animal animal) {
        animais.add(animal);
        animal.setDono(this);
    }

    public Atendimento registrarAtendimento(
            Animal animal,
            TipoAtendimento tipoAtendimento,
            Veterinario veterinario,
            StatusAtendimento status
    ) {
        if (!animais.contains(animal)) {
            throw new IllegalArgumentException("Este animal nao pertence a este cliente.");
        }

        Atendimento atendimento = new Atendimento(null, tipoAtendimento, status, this, animal, veterinario);
        atendimentos.add(atendimento);
        animal.adicionarAtendimento(atendimento);
        veterinario.adicionarAtendimento(atendimento);

        return atendimento;
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

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }
}
