package br.edu.ifrs.petbemestar;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrs.petbemestar.dao.AtendimentoDAO;
import br.edu.ifrs.petbemestar.dao.AtendimentoDAOJPA;
import br.edu.ifrs.petbemestar.dao.ClienteDAO;
import br.edu.ifrs.petbemestar.dao.ClienteDAOJPA;
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

        Atendimento consulta = tutor.registrarAtendimento(rex, TipoAtendimento.CONSULTA, vet, StatusAtendimento.MARCADO);
        Atendimento banho = tutor.registrarAtendimento(rex, TipoAtendimento.BANHO, vet, StatusAtendimento.FEITO);
        Atendimento tosa = tutor.registrarAtendimento(mimi, TipoAtendimento.TOSA, vet, StatusAtendimento.MARCADO);

        em.persist(tutor);
        em.persist(rex);
        em.persist(mimi);
        em.persist(vet);
        em.persist(consulta);
        em.persist(banho);
        em.persist(tosa);

        em.getTransaction().commit();
        em.close();
        emf.close();

        ClienteDAO clienteDAO = new ClienteDAOJPA();
        AtendimentoDAO atendimentoDAO = new AtendimentoDAOJPA();

        Cliente marlene = clienteDAO.buscarPorId(tutor.getId());
        marlene.setTelefone("51988887777");
        clienteDAO.atualizar(marlene);

        atendimentoDAO.remover(tosa.getId());

        List<Atendimento> atendimentosDoRex = atendimentoDAO.listarPorAnimal(rex.getId());
        System.out.println("Telefone atualizado: " + clienteDAO.buscarPorId(tutor.getId()).getTelefone());
        System.out.println("Atendimentos do Rex: " + atendimentosDoRex.size());
        System.out.println("Marcados: " + atendimentoDAO.listarPorStatus(StatusAtendimento.MARCADO).size());
    }
}
