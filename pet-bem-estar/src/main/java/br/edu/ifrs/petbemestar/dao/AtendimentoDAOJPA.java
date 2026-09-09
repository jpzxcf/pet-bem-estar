package br.edu.ifrs.petbemestar.dao;

import java.util.List;

import br.edu.ifrs.petbemestar.dominio.Atendimento;
import br.edu.ifrs.petbemestar.dominio.StatusAtendimento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AtendimentoDAOJPA implements AtendimentoDAO {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("petbemestar-pu");

    public void salvar(Atendimento atendimento) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(atendimento);
        em.getTransaction().commit();
        em.close();
    }

    public Atendimento buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Atendimento atendimento = em.find(Atendimento.class, id);
        em.close();
        return atendimento;
    }

    public List<Atendimento> listarTodos() {
        EntityManager em = emf.createEntityManager();
        List<Atendimento> atendimentos = em
                .createQuery("SELECT a FROM Atendimento a", Atendimento.class)
                .getResultList();
        em.close();
        return atendimentos;
    }

    public void atualizar(Atendimento atendimento) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(atendimento);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Atendimento atendimento = em.find(Atendimento.class, id);
        em.remove(atendimento);
        em.getTransaction().commit();
        em.close();
    }

    public List<Atendimento> listarPorAnimal(Long idAnimal) {
        EntityManager em = emf.createEntityManager();
        List<Atendimento> atendimentos = em
                .createQuery("SELECT a FROM Atendimento a WHERE a.animal.id = :idAnimal", Atendimento.class)
                .setParameter("idAnimal", idAnimal)
                .getResultList();
        em.close();
        return atendimentos;
    }

    public List<Atendimento> listarPorStatus(StatusAtendimento status) {
        EntityManager em = emf.createEntityManager();
        List<Atendimento> atendimentos = em
                .createQuery("SELECT a FROM Atendimento a WHERE a.status = :status", Atendimento.class)
                .setParameter("status", status)
                .getResultList();
        em.close();
        return atendimentos;
    }
}
