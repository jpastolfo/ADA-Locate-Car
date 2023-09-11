package servico;


import modelo.Carro;
import modelo.ClienteFisico;
import persistencia.ClienteFisicoRepositorio;

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

    public ClienteFisico buscarPorId(Integer id) throws Exception {
        if (id == null) {
            throw new Exception("Cliente Físico não encontrado.");
        } else {
            return clienteFisicoRepositorio.buscarPorId(id);
        }
    }

    private boolean existeCliente(Integer id) throws Exception {
        ClienteFisico clienteEncontrado = buscarPorId(id);
        return clienteEncontrado != null;
    }

}
