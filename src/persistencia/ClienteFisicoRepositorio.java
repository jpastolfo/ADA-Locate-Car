package persistencia;

import modelo.ClienteFisico;

public interface ClienteFisicoRepositorio extends Repositorio<ClienteFisico, Integer> {

    ClienteFisico buscarClienteFisicoPorId(Integer id);
}
