package br.edu.ifrs.petbemestar.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Atendimento {

    @Id
    private Long id;
    private TipoAtendimento tipoAtendimento;
    private StatusAtendimento status;
    private Cliente cliente;
    private Animal animal;
    private Veterinario veterinario;

    protected Atendimento() {
    }

    public Atendimento(Long id, TipoAtendimento tipoAtendimento, StatusAtendimento status, Cliente cliente, Animal animal, Veterinario veterinario) {
        this.id = id;
        this.tipoAtendimento = tipoAtendimento;
        this.status = status;
        this.cliente = cliente;
        this.animal = animal;
        this.veterinario = veterinario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoAtendimento getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public StatusAtendimento getStatus() {
        return status;
    }

    public void setStatus(StatusAtendimento status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
}
