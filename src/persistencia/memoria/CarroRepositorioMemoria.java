package persistencia.memoria;

import modelo.Carro;
import persistencia.CarroRepositorio;

public class CarroRepositorioMemoria extends RepositorioMemoriaAbstrato<Carro, Integer> implements CarroRepositorio {

    @Override
    public Carro buscarCarroPorId(Integer id) {
        for (Carro carro : listarTodos()) {
            if (carro.getId().equals(id)) {
                return carro;
            }
        }
        return null;
    }

}
