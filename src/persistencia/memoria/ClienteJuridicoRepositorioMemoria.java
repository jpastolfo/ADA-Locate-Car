package persistencia.memoria;

import modelo.ClienteJuridico;
import persistencia.ClienteJuridicoRepositorio;

public class ClienteJuridicoRepositorioMemoria extends RepositorioMemoriaAbstrato<ClienteJuridico, Integer> implements ClienteJuridicoRepositorio {

    @Override
    public ClienteJuridico buscarClienteJuridicoPorId(Integer id) {
        for (ClienteJuridico cliente : listarTodos()) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

}
