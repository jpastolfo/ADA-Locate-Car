package servico;

import modelo.Carro;
import persistencia.CarroRepositorio;

import java.util.List;

public class CarroServico {

    private final CarroRepositorio carroRepositorio;

    public CarroServico(CarroRepositorio carroRepositorio) {
        this.carroRepositorio = carroRepositorio;
    }

    public Carro cadastrar(Carro carro){
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

    public Carro buscarPorPlaca(String placa) throws Exception {
        if (placa == null) {
            throw new Exception("Carro não encontrado.");
        } else {
            return carroRepositorio.buscarPorId(placa);
        }
    }

    public List<Carro> listarTodos() {
        return carroRepositorio.listarTodos();
    }

    public List<Carro> buscarPorParteNome(String nomeParcial) {
        return carroRepositorio.buscarPorParteNome(nomeParcial);
    }

    public Carro atualizar(String placa, Carro carro) {
        try {
            if (!existeCarro(placa)) {
                System.out.println("Erro. Não encontrado.");
            }

        Carro carroExistente = carroRepositorio.buscarPorPlaca(placa);
        carroExistente.setModelo(carro.getNome());
        carroExistente.setMarca(carro.getMarca());
        carroExistente.setCor(carro.getCor());
        carroExistente.setPlaca(carro.getId());
        carroExistente.setTamanho(carro.getTamanho());
        carroExistente.setAlugado(carro.isAlugado());

        return carroRepositorio.salvar(carroExistente);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean removerCarroPorId(String id) {
        if (carroRepositorio.removerPorId(id)) {
            System.out.println("Carro removido!");
            return true;
        } else {
            System.out.println("Não foi possível remover");
            return false;
        }
    }

    private boolean existeCarro(String id) throws Exception {
        Carro carroEncontrado = buscarPorPlaca(id);
        return carroEncontrado != null;
    }

}
