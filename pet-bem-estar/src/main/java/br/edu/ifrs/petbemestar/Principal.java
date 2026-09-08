package br.edu.ifrs.petbemestar;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrs.petbemestar.dominio.Animal;
import br.edu.ifrs.petbemestar.dominio.Atendimento;
import br.edu.ifrs.petbemestar.dominio.Cliente;
import br.edu.ifrs.petbemestar.dominio.DiasDeTrabalho;
import br.edu.ifrs.petbemestar.dominio.StatusAtendimento;
import br.edu.ifrs.petbemestar.dominio.TipoAtendimento;
import br.edu.ifrs.petbemestar.dominio.Veterinario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Principal {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petbemestar-pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Cliente tutor = new Cliente("Marlene", "51999990000", new ArrayList<>());

        Animal rex = new Animal(null, "Rex", null, List.of("V10", "Antirrabica"), new ArrayList<>());
        Animal mimi = new Animal(null, "Mimi", null, List.of("Quadrupla"), new ArrayList<>());
        tutor.adicionarAnimal(rex);
        tutor.adicionarAnimal(mimi);

        Veterinario vet = new Veterinario(
                null,
                new ArrayList<>(),
                "Dra. Ana",
                List.of(DiasDeTrabalho.QUARTA, DiasDeTrabalho.QUINTA, DiasDeTrabalho.SEXTA)
        );

        Atendimento consulta = tutor.registrarAtendimento(
                rex, TipoAtendimento.CONSULTA, vet, StatusAtendimento.MARCADO);
        Atendimento banho = tutor.registrarAtendimento(
                mimi, TipoAtendimento.BANHO_E_TOSA, vet, StatusAtendimento.FEITO);

        em.persist(tutor);
        for (Animal animal : tutor.getAnimais()) {
            em.persist(animal);
        }
        em.persist(vet);
        for (Atendimento atendimento : List.of(consulta, banho)) {
            em.persist(atendimento);
        }

        em.getTransaction().commit();

        System.out.println("Cliente id ....... " + tutor.getId());
        System.out.println("Animais .......... " + idsDos(tutor.getAnimais()));
        System.out.println("Veterinario id ... " + vet.getId());
        System.out.println("Atendimentos ..... " + idsDos(List.of(consulta, banho)));

        em.close();
        emf.close();
    }

    private static List<Long> idsDos(List<?> entidades) {
        List<Long> ids = new ArrayList<>();
        for (Object e : entidades) {
            if (e instanceof Animal a) ids.add(a.getId());
            if (e instanceof Atendimento at) ids.add(at.getId());
        }
        return ids;
    }
}
