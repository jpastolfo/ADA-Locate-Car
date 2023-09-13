package servico;

import modelo.*;
import persistencia.CarroRepositorio;

import java.time.Duration;
import java.time.LocalDateTime;
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

    public void alugarCarro(Cliente cliente, Carro carro, LocalDateTime dataHoraFim) {

        Duration duracaoAluguel = Duration.between(LocalDateTime.now(), dataHoraFim);
        long horasAlugadas = duracaoAluguel.toHours();
        double precoPorHora = 0.0;
        double precoTotal = 0.0;

        if (!carro.isAlugado()) {
            if (cliente instanceof ClienteFisico) {
                if (horasAlugadas > 5 * 24) {
                    precoPorHora = 0.95 * 100.00;
                } else {
                    precoPorHora = 100.00;
                }
                cliente.getCarrosAlugados().add(carro);
                precoTotal = precoPorHora * horasAlugadas;
                System.out.println("Preço total: " + precoTotal);
            } else if (cliente instanceof ClienteJuridico) {
                if (horasAlugadas > 3 * 24) {
                    precoPorHora = 0.90 * 150.00;
                } else {
                    precoPorHora = 150.00;
                }
                cliente.getCarrosAlugados().add(carro);
                precoTotal = precoPorHora * horasAlugadas;
                System.out.println("Preço total: " + precoTotal);
            } else {
                System.out.println("Tipo de cliente não reconhecido.");
            }
        } else {
            System.out.println("O carro já está alugado. Não é possível completar a operação!");
        }

    }

    public void devolverCarro(Cliente cliente, Carro carro) {
        if (carro.isAlugado()) {
            if (cliente instanceof ClienteFisico) {
                cliente.getCarrosAlugados().remove(carro);
                System.out.println("Carro devolvido com sucesso!");
            } else if (cliente instanceof ClienteJuridico) {
                cliente.getCarrosAlugados().remove(carro);
                System.out.println("Carro devolvido com sucesso!");
            }
        } else {
            System.out.println("O carro não está alugado. Não é possível completar aoperação!");
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

    public boolean removerCarroPorPlaca(String placa) {
        if (carroRepositorio.removerPorId(placa)) {
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
