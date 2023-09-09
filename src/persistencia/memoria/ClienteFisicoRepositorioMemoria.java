package persistencia.memoria;

import modelo.ClienteFisico;
import persistencia.ClienteFisicoRepositorio;

public class ClienteFisicoRepositorioMemoria extends RepositorioMemoriaAbstrato<ClienteFisico, Integer> implements ClienteFisicoRepositorio {

    @Override
    public ClienteFisico buscarClienteFisicoPorId(Integer id) {
        for (ClienteFisico cliente : listarTodos()) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

}
