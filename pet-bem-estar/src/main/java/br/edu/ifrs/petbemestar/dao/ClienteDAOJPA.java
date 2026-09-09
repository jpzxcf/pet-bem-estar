package br.edu.ifrs.petbemestar.dao;

import java.util.List;

import br.edu.ifrs.petbemestar.dominio.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ClienteDAOJPA implements ClienteDAO {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("petbemestar-pu");

    public void salvar(Cliente cliente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public Cliente buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Cliente cliente = em.find(Cliente.class, id);
        em.close();
        return cliente;
    }

    public List<Cliente> listarTodos() {
        EntityManager em = emf.createEntityManager();
        List<Cliente> clientes = em
                .createQuery("SELECT c FROM Cliente c", Cliente.class)
                .getResultList();
        em.close();
        return clientes;
    }

    public void atualizar(Cliente cliente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Cliente cliente = em.find(Cliente.class, id);
        em.remove(cliente);
        em.getTransaction().commit();
        em.close();
    }
}
