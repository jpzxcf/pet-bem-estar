package br.edu.ifrs.petbemestar.dao;

import java.util.List;

import br.edu.ifrs.petbemestar.dominio.Cliente;

public interface ClienteDAO {
    void salvar(Cliente cliente);
    Cliente buscarPorId(Long id);
    List<Cliente> listarTodos();
    void atualizar(Cliente cliente);
    void remover(Long id);
}
