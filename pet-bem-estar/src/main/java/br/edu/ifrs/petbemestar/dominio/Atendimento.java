package br.edu.ifrs.petbemestar.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Atendimento {

    @Id
    private Long id;
    private List<TipoAtendimento> tipoAtendimento;
    private StatusAtendimento status;
    private Cliente cliente;
    private Animal animal;
    private Veterinario veterinario;

    protected Atendimento() {
    }

    public Atendimento(Long id, List<TipoAtendimento> tipoAtendimento, StatusAtendimento status, Cliente cliente, Animal animal, Veterinario veterinario) {
        this.id = id;
        this.tipoAtendimento = tipoAtendimento;
        this.status = status;
        this.cliente = cliente;
        this.animal = animal;
        this.veterinario = veterinario;
    }
}
