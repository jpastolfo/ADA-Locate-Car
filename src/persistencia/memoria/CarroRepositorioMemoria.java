package persistencia.memoria;

import modelo.Carro;
import persistencia.CarroRepositorio;

public class CarroRepositorioMemoria extends RepositorioMemoriaAbstrato<Carro, Integer> implements CarroRepositorio {

    @Override
    public Carro buscarCarroPorModelo(String modelo) {
        for (Carro carro : listarTodos()) {
            if (carro.getModelo().equals(modelo)) {
                return carro;
            }
        }
        return null;
    }

}
