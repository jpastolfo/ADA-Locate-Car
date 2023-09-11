package servico;

import modelo.*;

import java.time.Duration;

public class AluguelServico {

    public void alugarCarro(Aluguel aluguel, Cliente cliente, Carro carro) {

        Duration duracaoAluguel = Duration.between(aluguel.getDataHoraInicio(), aluguel.getDataHoraFim());

        long horasAlugadas = duracaoAluguel.toHours();

        double precoPorHora = 0.0;

        if (cliente instanceof ClienteFisico) {
            if (horasAlugadas > 5 * 24) {
                precoPorHora = 0.95 * 100.00;
            } else {
                precoPorHora = 100.00;
            }
        } else if (cliente instanceof ClienteJuridico) {
            if (horasAlugadas > 3 * 24) {
                precoPorHora = 0.90 * 150.00;
            } else {
                precoPorHora = 150.00;
            }
        } else {
            System.out.println("Tipo de cliente não reconhecido.");
        }

        aluguel.setPreco(precoPorHora * horasAlugadas);
    }

    public void devolverCarro(Aluguel aluguel, Cliente cliente, Carro carro) {

    }

}
