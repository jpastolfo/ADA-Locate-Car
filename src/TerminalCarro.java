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

    private static final String CADASTRO_MESSAGEM = "\n*********************************************** \nCadastrando carro de placa ➞ %s";
    private static final String BUSCA_MESSAGEM = "\n*********************************************** \nBuscando carro por placa";
    private static final String REMOCAO_MESSAGEM = "\n*********************************************** \nRemovendo carro";
    private static final String LISTAGEM_MESSAGEM = "\n*********************************************** \nListando todos os carros";
    private static final String ATUALIZACAO_MESSAGEM = "\n*********************************************** \nAtualizando carro";
    private static final String BUSCA_POR_NOME_MESSAGEM = "\n*********************************************** \nBuscando carro por parte de modelo/nome";


    public static void main(String[] args) {

//                                       ------------ VEÍCULO - CARRO ------------

        CarroRepositorio carroRepositorioMemoria = new CarroRepositorioMemoria();
        CarroServico carroServico = new CarroServico(carroRepositorioMemoria);

//                                                 * CADASTRAR CARROS *

        cadastraCarro(carroServico);

//                                             * BUSCAR CARROS POR PLACA *

        buscaPorPlaca(carroServico);

//                                                 * REMOVER CARROS *
        removeCarro(carroServico);

//                                              * BUSCAR CARROS POR NOME *

       buscaPorNome(carroServico);

//                                                 * ATUALIZAR CARRO *

        atualizaCarro(carroServico);

//                                                  * LISTAR CARROS *

        listaCarros(carroServico);
    }

    static void cadastraCarro(CarroServico carroServico) {
        Carro carro1 = new Carro("honda civic", "honda", "prata", "419s8s-1s1", Tamanho.MEDIO, false);
        Carro carro2 = new Carro("toyota corolla", "toyota", "preto", "123abc-456", Tamanho.MEDIO, false);
        Carro carro3 = new Carro("volkswagen golf", "volkswagen", "azul", "789xyz-012", Tamanho.PEQUENO, false);
        Carro carro4 = new Carro("ford fiesta", "ford", "vermelho", "456def-789", Tamanho.MEDIO, false);
        Carro carro5 = new Carro("chevrolet cruze", "chevrolet", "branco", "abc123-789", Tamanho.SUV, false);


        System.out.println(String.format(CADASTRO_MESSAGEM, carro1.getId()));
        carroServico.cadastrar(carro1);

        System.out.println(String.format(CADASTRO_MESSAGEM, carro2.getId()));
        carroServico.cadastrar(carro2);

        System.out.println(String.format(CADASTRO_MESSAGEM, carro3.getId()));
        carroServico.cadastrar(carro3);

        System.out.println(String.format(CADASTRO_MESSAGEM, carro4.getId()));
        carroServico.cadastrar(carro4);

        System.out.println(String.format(CADASTRO_MESSAGEM, carro5.getId()));
        carroServico.cadastrar(carro5);

    }
    static void buscaPorPlaca (CarroServico carroServico){

        try {
            System.out.println(String.format(BUSCA_MESSAGEM));
            Carro carroBuscado1 = carroServico.buscarPorPlaca("419s8s-1s1");
            System.out.println("Carro encontrado! \n id: " + carroBuscado1.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(String.format(BUSCA_MESSAGEM));
            Carro carroBuscado2 = carroServico.buscarPorPlaca("123abc-456");
            System.out.println("Carro encontrado! \n id: " + carroBuscado2.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    static void removeCarro (CarroServico carroServico) {
        System.out.println(String.format(REMOCAO_MESSAGEM));
        carroServico.removerCarroPorPlaca("123abc-456");}
    static void buscaPorNome (CarroServico carroServico){
        System.out.println(BUSCA_POR_NOME_MESSAGEM);
        List<Carro> carrosEncontrados = carroServico.buscarPorParteNome("civic");
        for (Carro carros : carrosEncontrados) {
            System.out.println(carros.getNome());
        }
    }
    static void atualizaCarro (CarroServico carroServico){
        Carro carro1Atualizado = new Carro("honda civic atualizado", "honda atualizado",
                "prata atualizado", "419s8s-1s1", Tamanho.MEDIO, false);
        System.out.println(String.format(ATUALIZACAO_MESSAGEM, carro1Atualizado.getId()));
        carroServico.atualizar(carro1Atualizado.getId(), carro1Atualizado);

        try {
            System.out.println("Carros atualizado! \n Id: " + carro1Atualizado.getId() + "\n"
                    +  carro1Atualizado.getMarca() + "\n" +  carro1Atualizado.getNome() + "\n"
                    +  carro1Atualizado.getCor() + "\n" + carro1Atualizado.getTamanho() );
        }catch (Exception e){
            throw new RuntimeException("Não foi possível atualizar");
        }
    }
    static void listaCarros (CarroServico carroServico){
        System.out.println(LISTAGEM_MESSAGEM);
        List<Carro> todosCarros = carroServico.listarTodos();
        for (Carro carros : todosCarros) {
            System.out.println(carros.getNome());
        }
    }

     }
