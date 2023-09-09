package servico;

import modelo.Carro;
import persistencia.CarroRepositorio;

public class CarroServico {

    private final CarroRepositorio carroRepositorio;

    public CarroServico(CarroRepositorio carroRepositorio) {
        this.carroRepositorio = carroRepositorio;
    }

    public Carro cadastrarCarro(Carro carro){
        try {
            if (!existeCarro(carro.getId())) {
                System.out.println("Carro cadastrado!");
                return carroRepositorio.salvar(carro);
            } else {
                System.out.println("Carro já existe");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Carro buscarPorId(Integer id) throws Exception {
        if (id == null) {
            throw new Exception("Carro não encontrado.");
        } else {
            return carroRepositorio.buscarPorId(id);
        }

    }

    private boolean existeCarro(Integer id) throws Exception {
        Carro carroEncontrado = buscarPorId(id);
        return carroEncontrado != null;
    }

}
