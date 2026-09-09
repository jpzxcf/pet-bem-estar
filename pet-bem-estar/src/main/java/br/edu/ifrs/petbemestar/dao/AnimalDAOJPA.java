package br.edu.ifrs.petbemestar.dao;

import java.util.List;

import br.edu.ifrs.petbemestar.dominio.Animal;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AnimalDAOJPA implements AnimalDAO {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("petbemestar-pu");

    public void salvar(Animal animal) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(animal);
        em.getTransaction().commit();
        em.close();
    }

    public Animal buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Animal animal = em.find(Animal.class, id);
        em.close();
        return animal;
    }

    public List<Animal> listarTodos() {
        EntityManager em = emf.createEntityManager();
        List<Animal> animais = em
                .createQuery("SELECT a FROM Animal a", Animal.class)
                .getResultList();
        em.close();
        return animais;
    }

    public void atualizar(Animal animal) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(animal);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Animal animal = em.find(Animal.class, id);
        em.remove(animal);
        em.getTransaction().commit();
        em.close();
    }
}
