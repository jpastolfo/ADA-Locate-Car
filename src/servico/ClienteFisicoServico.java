package servico;


import modelo.Carro;
import modelo.Cliente;
import modelo.ClienteFisico;
import persistencia.ClienteFisicoRepositorio;

import java.util.List;
import java.util.Scanner;

public class ClienteFisicoServico {

    private final ClienteFisicoRepositorio clienteFisicoRepositorio;

    public ClienteFisicoServico(ClienteFisicoRepositorio clienteFisicoRepositorio) {
        this.clienteFisicoRepositorio = clienteFisicoRepositorio;
    }

    public ClienteFisico cadastrar(ClienteFisico cliente) {
        try {

            if (!existeCliente(cliente.getId())) {
                System.out.println("Cliente Físico cadastrado!");
                return clienteFisicoRepositorio.salvar(cliente);
            } else {
                System.out.println("Cliente Físico já existe");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public ClienteFisico buscarPorId(String id) throws Exception {
        if (id == null) {
            throw new Exception("Cliente Físico não encontrado.");
        } else {
            return clienteFisicoRepositorio.buscarPorId(id);
        }
    }

    public List<ClienteFisico> listarTodos() {
        return clienteFisicoRepositorio.listarTodos();
    }

    public ClienteFisico atualizar(String id, ClienteFisico cliente) {
        try {
            if (!existeCliente(id)) {
                System.out.println("Erro. Não encontrado.");
            }

            ClienteFisico clienteExistente = clienteFisicoRepositorio.buscarPorId(id);
            clienteExistente.setNome(cliente.getNome());
            clienteExistente.setCpf(cliente.getCpf());
            clienteExistente.setEndereco(cliente.getEndereco());

            return clienteFisicoRepositorio.salvar(clienteExistente);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean existeCliente(String id) throws Exception {
        ClienteFisico clienteEncontrado = buscarPorId(id);
        return clienteEncontrado != null;
    }

}
