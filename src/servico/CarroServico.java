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

    public Carro buscarPorId(Integer id) throws Exception {
        if (id == null) {
            throw new Exception("Carro não encontrado.");
        } else {
            return carroRepositorio.buscarPorId(id);
        }
    }

    public List<Carro> listarTodos() {
        return carroRepositorio.listarTodos();
    }

    public List<Carro> buscarPorParteNome(String nomeParcial) {
        return carroRepositorio.buscarPorParteNome(nomeParcial);
    }

    public void atualizar(Carro carro) {
        try {
            if (!existeCarro(carro.getId())) {
                System.out.println("Erro. Não encontrado.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Carro carroAtualizado = new Carro(carro.getId(), carro.getNome(), carro.getMarca(),
                 carro.getCor(), carro.getPlaca(), carro.getTamanho());

        carroRepositorio.salvar(carroAtualizado);

        System.out.println("Carro atualizado!");
    }

    public boolean removerCarroPorId(Integer id) {
        if (carroRepositorio.removerPorId(id)) {
            System.out.println("Carro removido!");
            return true;
        } else {
            System.out.println("Não foi possível remover");
            return false;
        }
    }

    private boolean existeCarro(Integer id) throws Exception {
        Carro carroEncontrado = buscarPorId(id);
        return carroEncontrado != null;
    }

}
