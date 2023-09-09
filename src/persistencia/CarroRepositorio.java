package persistencia;

import modelo.Carro;

public interface CarroRepositorio extends Repositorio<Carro, Integer> {

    Carro buscarCarroPorId(Integer id);

    boolean removerCarroPorId(Integer id);
}
