package servico;

import modelo.ClienteFisico;
import modelo.ClienteJuridico;
import persistencia.ClienteJuridicoRepositorio;

import java.util.List;

public class ClienteJuridicoServico {

    private final ClienteJuridicoRepositorio clienteJuridicoRepositorio;

    public ClienteJuridicoServico(ClienteJuridicoRepositorio clienteFisicoRepositorio) {
        this.clienteJuridicoRepositorio = clienteFisicoRepositorio;
    }

    public ClienteJuridico cadastrar(ClienteJuridico cliente){
        try {
            if (!existeCliente(cliente.getId())) {
                System.out.println("Cliente Jurídico cadastrado!");
                return clienteJuridicoRepositorio.salvar(cliente);
            } else {
                System.out.println("Cliente Jurídico já existe");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public ClienteJuridico buscarPorId(Integer id) throws Exception {
        if (id == null) {
            throw new Exception("Cliente Jurídico não encontrado.");
        } else {
            return clienteJuridicoRepositorio.buscarPorId(id);
        }
    }

    public List<ClienteJuridico> listarTodos() {
        return clienteJuridicoRepositorio.listarTodos();
    }

    public ClienteJuridico atualizar(Integer id, ClienteJuridico cliente) {
        try {
            if (!existeCliente(id)) {
                System.out.println("Erro. Não encontrado.");
            }

            ClienteJuridico clienteExistente = clienteJuridicoRepositorio.buscarPorId(id);
            clienteExistente.setNome(cliente.getNome());
            clienteExistente.setCnpj(cliente.getCnpj());
            clienteExistente.setEndereco(cliente.getEndereco());

            return clienteJuridicoRepositorio.salvar(clienteExistente);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    private boolean existeCliente(Integer id) throws Exception {
        ClienteJuridico clienteEncontrado = buscarPorId(id);
        return clienteEncontrado != null;
    }

}
