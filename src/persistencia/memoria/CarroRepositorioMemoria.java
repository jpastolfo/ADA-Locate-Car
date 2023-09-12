package persistencia.memoria;

import modelo.Carro;
import persistencia.CarroRepositorio;

import java.util.ArrayList;
import java.util.List;

public class CarroRepositorioMemoria extends RepositorioMemoriaAbstrato<Carro, Integer> implements CarroRepositorio {

    @Override
    public List<Carro> buscarPorParteNome(String nomeParcial) {
        List<Carro> carros = new ArrayList<>();
        for (Carro carro : listarTodos()) {
            if (carro.getNome().contains(nomeParcial)) {
                carros.add(carro);
            }
        }
        return carros;
    }

    @Override
    public Carro buscarPorPlaca(String placa) {
        for (Carro carro : listarTodos()) {
            if (carro.getId().equals(placa)) {
                return carro;
            }
        }
        return null;
    }
}
