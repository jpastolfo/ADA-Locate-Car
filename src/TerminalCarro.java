import modelo.Carro;
import modelo.ClienteFisico;
import modelo.ClienteJuridico;
import modelo.Tamanho;
import persistencia.CarroRepositorio;
import persistencia.memoria.CarroRepositorioMemoria;
import persistencia.memoria.ClienteFisicoRepositorioMemoria;
import persistencia.memoria.ClienteJuridicoRepositorioMemoria;
import servico.CarroServico;
import servico.ClienteFisicoServico;
import servico.ClienteJuridicoServico;

import java.util.List;

public class TerminalCarro {

    public static void main(String[] args) {

        // CARRO
        CarroRepositorio carroRepositorioMemoria = new CarroRepositorioMemoria();
        CarroServico carroServico = new CarroServico(carroRepositorioMemoria);

        // Cadastrando carros
        Carro carro1 = new Carro(1,"honda civic", "honda", "prata","419s8s-1s1", Tamanho.MEDIO);
        Carro carro2 = new Carro(2,"honda civic 2", "honda 2", "prata 2","234242419s8s-1s1", Tamanho.PEQUENO);
        Carro carro3 = new Carro(3,"honda civic 3", "honda 3", "prata 3","23dadada", Tamanho.SUV);

        System.out.println("********************** \nCadastrando carro 1...");
        carroServico.cadastrar(carro1);

        System.out.println("********************** \nCadastrando carro 2...");
        carroServico.cadastrar(carro2);

        System.out.println("********************** \nCadastrando carro 2...");
        carroServico.cadastrar(carro3);

        // Buscar carro de id 1 e id 2
        try {
            System.out.println("********************** \nBuscando carro de id 1");
            Carro carroBuscado1 = carroServico.buscarPorId(1);
            System.out.println("Carro encontrado! \n id: " + carroBuscado1.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("********************** \nBuscando carro de id 2");
            Carro carroBuscado2 = carroServico.buscarPorId(2);
            System.out.println("Carro encontrado! \n id: " + carroBuscado2.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Remover carro por id e depois buscar para verificar se foi removido mesmo
        System.out.println("********************** \nRemovendo carro de id 2");
        carroServico.removerCarroPorId(2);

      /*  try {
            System.out.println("********************** \nBuscando carro de id 2");
            Carro carroBuscado2 = carroServico.buscarPorId(2);
            System.out.println("Carro encontrado! \n id: " + carroBuscado2.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } */

        // Buscar Carros Por Parte do Nome
        System.out.println("********************** \nBuscando carro por parte de nome");
        List<Carro> carrosEncontrados = carroServico.buscarPorParteNome("civic");
        for (Carro carros : carrosEncontrados) {
            System.out.println(carros.getNome());
        }

        // Atualizar Carro

    }

}
