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

    private static final String CADASTRO_MESSAGEM = "\n********************** \nCadastrando carro de id %d";
    private static final String BUSCA_MESSAGEM = "\n********************** \nBuscando carro de id %d";
    private static final String REMOCAO_MESSAGEM = "\n********************** \nRemovendo carro de id %d";
    private static final String LISTAGEM_MESSAGEM = "\n********************** \nListando todos os carros";
    private static final String ATUALIZACAO_MESSAGEM = "\n********************** \nAtualizando carro de id %d";
    private static final String BUSCA_POR_NOME_MESSAGEM = "\n********************** \nBuscando carro por parte de nome";


    public static void main(String[] args) {


        // CARRO
        CarroRepositorio carroRepositorioMemoria = new CarroRepositorioMemoria();
        CarroServico carroServico = new CarroServico(carroRepositorioMemoria);

        // CADASTRANDO CARROS
        Carro carro1 = new Carro(1, "honda civic", "honda", "prata", "419s8s-1s1", Tamanho.MEDIO);
        Carro carro2 = new Carro(2, "honda civic 2", "honda 2", "prata 2", "234242419s8s-1s1", Tamanho.PEQUENO);
        Carro carro3 = new Carro(3, "honda civic 3", "honda 3", "prata 3", "23dadada", Tamanho.SUV);

        System.out.println(String.format(CADASTRO_MESSAGEM, carro1.getId()));
        carroServico.cadastrar(carro1);

        System.out.println(String.format(CADASTRO_MESSAGEM, carro2.getId()));
        carroServico.cadastrar(carro2);

        System.out.println(String.format(CADASTRO_MESSAGEM, carro3.getId()));
        carroServico.cadastrar(carro3);

        // BUSCAR CARRO DE ID 1 E ID 2
        try {
            System.out.println(String.format(BUSCA_MESSAGEM, 1));
            Carro carroBuscado1 = carroServico.buscarPorId(1);
            System.out.println("Carro encontrado! \n id: " + carroBuscado1.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(String.format(BUSCA_MESSAGEM, 2));
            Carro carroBuscado2 = carroServico.buscarPorId(2);
            System.out.println("Carro encontrado! \n id: " + carroBuscado2.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // REMOVER CARRO POR ID E DEPOIS BUSCAR PARA VERIFICAR SE FOI REMOVIDO
        System.out.println(String.format(REMOCAO_MESSAGEM, 2));
        carroServico.removerCarroPorId(2);

        /* Não é necessário buscar novamente o carro removido
        try {
            System.out.println("********************** \nBuscando carro de id 2");
            Carro carroBuscado2 = carroServico.buscarPorId(2);
            System.out.println("Carro encontrado! \n id: " + carroBuscado2.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } */

        // BUSCAR CARROS POR PARTE NOME
        System.out.println(BUSCA_POR_NOME_MESSAGEM);
        List<Carro> carrosEncontrados = carroServico.buscarPorParteNome("civic");
        for (Carro carros : carrosEncontrados) {
            System.out.println(carros.getNome());
        }

        // ATUALIZAR CARRO
        Carro carro1Atualizado = new Carro(1, "honda civic atualizado", "honda atualizado",
                "prata atualizado", "23dadassda", Tamanho.MEDIO);
        System.out.println(String.format(ATUALIZACAO_MESSAGEM, 1));
        carroServico.atualizar(1, carro1Atualizado);

        // LISTAR TODOS CARROS
        System.out.println(LISTAGEM_MESSAGEM);
        List<Carro> todosCarros = carroServico.listarTodos();
        for (Carro carros : todosCarros) {
            System.out.println(carros.getNome());
        }
    }
}
