import modelo.Carro;
import modelo.ClienteFisico;
import modelo.ClienteJuridico;
import modelo.Tamanho;
import persistencia.memoria.ClienteFisicoRepositorioMemoria;
import persistencia.memoria.ClienteJuridicoRepositorioMemoria;
import servico.ClienteFisicoServico;
import servico.ClienteJuridicoServico;

import java.util.List;

public class TerminalCliente {

    private static final String CADASTRO_CLIENTE_FISICO_MESSAGEM = "\n*********************************************** \nCadastrando Cliente Físico ➞ Id: ";
    private static final String BUSCA_CLIENTE_FISICO_MESSAGEM = "\n*********************************************** \nBuscando Cliente Físico";
    private static final String ATUALIZACAO_CLIENTE_FISICO_MESSAGEM = "\n*********************************************** \nAtualizando Cliente Físico";
    private static final String LISTAGEM_CLIENTE_FISICO_MESSAGEM = "\n*********************************************** \nListando todos os Clientes Físicos";

    private static final String CADASTRO_CLIENTE_JURIDICO_MESSAGEM = "\n***************************************************** \nCadastrando Cliente Jurídico ➞ Id: ";
    private static final String BUSCA_CLIENTE_JURIDICO_MESSAGE = "\n***************************************************** \nBuscando Cliente Jurídico";
    private static final String ATUALIZACAO_CLIENTE_JURIDICO_MESSAGEM = "\n***************************************************** \nAtualizando Cliente Jurídico";
    private static final String LISTAGEM_CLIENTE_JURIDICO_MESSAGEM = "\n***************************************************** \nListando todos os Clientes Jurídicos";


    public static void main(String[] args) {

                                 // ------------ CLIENTE FÍSICO ------------

        ClienteFisicoRepositorioMemoria clienteFisicoRepositorioMemoria = new ClienteFisicoRepositorioMemoria();
        ClienteFisicoServico clienteFisicoServico = new ClienteFisicoServico(clienteFisicoRepositorioMemoria);

//                                   * CADASTRAR CLIENTE FÍSICO *

        cadastraClienteFisico(clienteFisicoServico);

//                                    * BUSCAR CLIENTE FÍSICO *

        buscaClienteFisicoPorId(clienteFisicoServico);

//                                  * ATUALIZAR CLIENTE FÍSICO *

        atualizaClienteFisico(clienteFisicoServico);

//                                * LISTAR TODOS OS CLIENTES FÍSICOS *

        listaTodosClientesFisicos(clienteFisicoServico);



//                               ------------ CLIENTE JURÍDICO ------------


        ClienteJuridicoRepositorioMemoria clienteJuridicoRepositorioMemoria = new ClienteJuridicoRepositorioMemoria();
        ClienteJuridicoServico clienteJuridicoServico = new ClienteJuridicoServico(clienteJuridicoRepositorioMemoria);

//                                   * CADASTRAR CLIENTE JURÍDICO *

        cadastraClienteJuridico(clienteJuridicoServico);

//                                     * BUSCAR CLIENTE JURÍDICO *

        buscaClienteJuridicoPorId(clienteJuridicoServico);

//                                    * ATUALIZAR CLIENTE JURÍDICO *

        atualizaClienteJuridico(clienteJuridicoServico);

//                                * LISTAR TODOS OS CLIENTES JURÍDICOS *

        listaTodosClientesJuridicos(clienteJuridicoServico);

    }

    static void cadastraClienteFisico (ClienteFisicoServico clienteFisicoServico){

        ClienteFisico clienteFisico1 = new ClienteFisico("Claudio Silva",
                "Rua das Magnolias, 313, Santo André, São Paulo", null, "045.786.543-65");

        ClienteFisico clienteFisico2 = new ClienteFisico("Fernando Souza",
                "Rua das Camelias, 654, São Bernardo, São Paulo", null, "954.654.655-56");

        ClienteFisico clienteFisico3 = new ClienteFisico("Jorge Miguel",
                "Rua das Camelias, 654, São Bernardo, São Paulo", null, "324.654.899-56");


        System.out.println(CADASTRO_CLIENTE_FISICO_MESSAGEM + clienteFisico1.getId());
        clienteFisicoServico.cadastrar(clienteFisico1);

        System.out.println(CADASTRO_CLIENTE_FISICO_MESSAGEM + clienteFisico2.getId());
        clienteFisicoServico.cadastrar(clienteFisico2);

        System.out.println(CADASTRO_CLIENTE_FISICO_MESSAGEM + clienteFisico3.getId());
        clienteFisicoServico.cadastrar(clienteFisico3);
    }
    static void buscaClienteFisicoPorId (ClienteFisicoServico clienteFisicoServico){

        try {
            System.out.println(String.format(BUSCA_CLIENTE_FISICO_MESSAGEM , 2));
            ClienteFisico clienteFisicoBuscado1 = clienteFisicoServico.buscarPorId("045.786.543-65");
            System.out.println("Cliente Fisico encontrado! \n Id: " + clienteFisicoBuscado1.getId() + "\n" + clienteFisicoBuscado1.getNome() + "\n" + clienteFisicoBuscado1.getEndereco());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(String.format(BUSCA_CLIENTE_FISICO_MESSAGEM , 2));
            ClienteFisico clienteFisicoBuscado2 = clienteFisicoServico.buscarPorId("954.654.655-56");
            System.out.println("Cliente Fisico encontrado! \n Id: " + clienteFisicoBuscado2.getId() + "\n" + clienteFisicoBuscado2.getNome() + "\n" + clienteFisicoBuscado2.getEndereco());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(String.format(BUSCA_CLIENTE_FISICO_MESSAGEM , 2));
            ClienteFisico clienteFisicoBuscado3 = clienteFisicoServico.buscarPorId("324.654.899-56");
            System.out.println("Cliente Fisico encontrado! \n Id: " + clienteFisicoBuscado3.getId() + "\n" + clienteFisicoBuscado3.getNome() + "\n" + clienteFisicoBuscado3.getEndereco());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    static void atualizaClienteFisico (ClienteFisicoServico clienteFisicoServico){

        ClienteFisico clienteFisico1atualizado = new ClienteFisico("Claudio Silva Souza",
                "Rua das Flores, 313, Manto Santo, São Paulo", null, "045.786.543-65" );
        System.out.println(String.format(ATUALIZACAO_CLIENTE_FISICO_MESSAGEM, clienteFisico1atualizado.getId()));
        clienteFisicoServico.atualizar(clienteFisico1atualizado.getId(), clienteFisico1atualizado);

        try {
            System.out.println("Cliente atualizado! \n Id: " + clienteFisico1atualizado.getId() + "\n"
                    +  clienteFisico1atualizado.getNome() + "\n" +  clienteFisico1atualizado.getEndereco() + "\n"
                    +  clienteFisico1atualizado.getCarrosAlugados());
        }catch (Exception e){
            throw new RuntimeException("Não foi possível atualizar");
        }
    }
    static void listaTodosClientesFisicos (ClienteFisicoServico clienteFisicoServico){

        System.out.println(String.format(LISTAGEM_CLIENTE_FISICO_MESSAGEM, 4));
        List<ClienteFisico> todosClientesFisicos = clienteFisicoServico.listarTodos();
        for (ClienteFisico clientesFisicos : todosClientesFisicos) {
            System.out.println(clientesFisicos.getNome());
        }
    }

    static void cadastraClienteJuridico (ClienteJuridicoServico clienteJuridicoServico){

        ClienteJuridico clienteJuridico1 = new ClienteJuridico( "Springer Carrier Ltda",
                "Rua Getulio Vargas, 675, São Caetano, São Paulo", null, "12.232.343/3434-34");

        ClienteJuridico clienteJuridico2 = new ClienteJuridico("Dell Ltda",
                "Rua Fernando Guimaraes, 484, Marilia, SP", null, "09.232.343/3434-35");

        ClienteJuridico clienteJuridico3 = new ClienteJuridico("Skycyan Ltda",
                "Rua Fernando Guimaraes, 484, Marilia, SP", null, "32.232.343/3434-40");

        // CADASTRAR CLIENTES JURÍDICOS
        System.out.println((CADASTRO_CLIENTE_JURIDICO_MESSAGEM + clienteJuridico1.getId()));
        clienteJuridicoServico.cadastrar(clienteJuridico1);

        System.out.println((CADASTRO_CLIENTE_JURIDICO_MESSAGEM + clienteJuridico2.getId()));
        clienteJuridicoServico.cadastrar(clienteJuridico2);

        System.out.println((CADASTRO_CLIENTE_JURIDICO_MESSAGEM + clienteJuridico3.getId()));
        clienteJuridicoServico.cadastrar(clienteJuridico3);

    }
    static void buscaClienteJuridicoPorId (ClienteJuridicoServico clienteJuridicoServico){

        try {
            System.out.println(String.format(BUSCA_CLIENTE_JURIDICO_MESSAGE , 2));
            ClienteJuridico clienteJuridicoBuscado1 = clienteJuridicoServico.buscarPorId("12.232.343/3434-34");
            System.out.println("Cliente Jurídico encontrado! \n Id: " + clienteJuridicoBuscado1.getId() + "\n" + clienteJuridicoBuscado1.getNome() + "\n" + clienteJuridicoBuscado1.getEndereco());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(String.format(BUSCA_CLIENTE_JURIDICO_MESSAGE, 2));
            ClienteJuridico clienteJuridicoBuscado2 = clienteJuridicoServico.buscarPorId("09.232.343/3434-35");
            System.out.println("Cliente Jurídico encontrado! \n id: " + clienteJuridicoBuscado2.getId() + "\n" + clienteJuridicoBuscado2.getNome() + "\n" + clienteJuridicoBuscado2.getEndereco());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(String.format(BUSCA_CLIENTE_JURIDICO_MESSAGE, 2));
            ClienteJuridico clienteJuridicoBuscado3 = clienteJuridicoServico.buscarPorId("09.232.343/3434-35");
            System.out.println("Cliente Jurídico encontrado! \n id: " + clienteJuridicoBuscado3.getId() + "\n" + clienteJuridicoBuscado3.getNome() + "\n" + clienteJuridicoBuscado3.getEndereco());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    static void atualizaClienteJuridico (ClienteJuridicoServico clienteJuridicoServico){

        ClienteJuridico clienteJuridico1Atualizado = new ClienteJuridico("Spring Car",
                "Rua dos Namorados, 654, São salvador, Rio de Janeiro", null, "12.232.343/3434-34");
        System.out.println(String.format(ATUALIZACAO_CLIENTE_JURIDICO_MESSAGEM, clienteJuridico1Atualizado.getId()));
        clienteJuridicoServico.atualizar(clienteJuridico1Atualizado.getId(), clienteJuridico1Atualizado);

        try {
            System.out.println("Cliente atualizado! \n Id: " + clienteJuridico1Atualizado.getId() + "\n"
                    +  clienteJuridico1Atualizado.getNome() + "\n" +  clienteJuridico1Atualizado.getEndereco() + "\n"
                    +  clienteJuridico1Atualizado.getCarrosAlugados());
        }catch (Exception e){
            throw new RuntimeException("Não foi possível atualizar");
        }
    }
    static void listaTodosClientesJuridicos (ClienteJuridicoServico clienteJuridicoServico) {

        System.out.println(LISTAGEM_CLIENTE_JURIDICO_MESSAGEM);
        List<ClienteJuridico> todosClientesJuridicos = clienteJuridicoServico.listarTodos();
        for (ClienteJuridico clientesJuridicos : todosClientesJuridicos) {
            System.out.println(clientesJuridicos.getNome());
        }
    }

}
