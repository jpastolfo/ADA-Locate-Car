import modelo.ClienteFisico;
import modelo.ClienteJuridico;
import persistencia.memoria.ClienteFisicoRepositorioMemoria;
import persistencia.memoria.ClienteJuridicoRepositorioMemoria;
import servico.ClienteFisicoServico;
import servico.ClienteJuridicoServico;

import java.util.List;

public class TerminalCliente {

    private static final String CADASTRO_CLIENTE_FISICO_MESSAGEM = "\n********************** \nCadastrando Cliente Físico %d...";
    private static final String BUSCA_CLIENTE_FISICO_MESSAGEM = "\n********************** \nBuscando Cliente Físico de id %d";
    private static final String ATUALIZACAO_CLIENTE_FISICO_MESSAGEM = "\n********************** \nAtualizando Cliente Físico de id %d";
    private static final String LISTAGEM_CLIENTE_FISICO_MESSAGEM = "\n********************** \nListando todos os Clientes Físicos";

    private static final String CADASTRO_CLIENTE_JURIDICO_MESSAGEM = "\n********************** \nCadastrando Cliente Jurídico %d...";
    private static final String BUSCA_CLIENTE_JURIDICO_MESSAGE = "\n********************** \nBuscando Cliente Jurídico de id %d";
    private static final String ATUALIZACAO_CLIENTE_JURIDICO_MESSAGEM = "\n********************** \nAtualizando Cliente Jurídico de id %d";
    private static final String LISTAGEM_CLIENTE_JURIDICO_MESSAGEM = "\n********************** \nListando todos os Clientes Jurídicos";


    public static void main(String[] args) {

        // ------------ CLIENTE FÍSICO ------------
        ClienteFisicoRepositorioMemoria clienteFisicoRepositorioMemoria = new ClienteFisicoRepositorioMemoria();
        ClienteFisicoServico clienteFisicoServico = new ClienteFisicoServico(clienteFisicoRepositorioMemoria);

        ClienteFisico clienteFisico1 = new ClienteFisico(1, "Claudio Silva",
                "Rua das Magnolias, 313, Santo André, São Paulo", null, "045.786.543-65");

        ClienteFisico clienteFisico2 = new ClienteFisico(2,"Fernando Souza",
                "Rua das Camelias, 654, São Bernardo, São Paulo", null, "954.654.655-56");

        ClienteFisico clienteFisico3 = new ClienteFisico(2,"Fernando Souza",
                "Rua das Camelias, 654, São Bernardo, São Paulo", null, "954.654.655-56");



        System.out.println(String.format(CADASTRO_CLIENTE_FISICO_MESSAGEM, clienteFisico1.getId()));
        clienteFisicoServico.cadastrar(clienteFisico1);

        System.out.println(String.format(CADASTRO_CLIENTE_FISICO_MESSAGEM, clienteFisico2.getId()));
        clienteFisicoServico.cadastrar(clienteFisico2);

        System.out.println(String.format(CADASTRO_CLIENTE_FISICO_MESSAGEM, clienteFisico3.getId()));
        clienteFisicoServico.cadastrar(clienteFisico3);

        // BUSCAR CLIENTE FÍSICO POR ID
        try {
            System.out.println(String.format(BUSCA_CLIENTE_FISICO_MESSAGEM, 1));
            ClienteFisico clienteFisicoBuscado1 = clienteFisicoServico.buscarPorId(1);
            System.out.println("ClienteFisico encontrado! \n id: " + clienteFisicoBuscado1.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(String.format(BUSCA_CLIENTE_FISICO_MESSAGEM, 2));
            ClienteFisico clienteFisicoBuscado2 = clienteFisicoServico.buscarPorId(2);
            System.out.println("Carro encontrado! \n id: " + clienteFisicoBuscado2.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // ATUALIZAR CLIENTE FÍSICO
        ClienteFisico clienteFisico1Atualizado = new ClienteFisico(2,"Fernando Souza ATUALIZADO",
                "Rua das Camelias, 654, São Bernardo, São Paulo", null, "954.654.655-56");
        System.out.println(String.format(ATUALIZACAO_CLIENTE_FISICO_MESSAGEM, 2));
        clienteFisicoServico.atualizar(1, clienteFisico1Atualizado);

        // LISTAR TODOS
        System.out.println(LISTAGEM_CLIENTE_FISICO_MESSAGEM);
        List<ClienteFisico> todosClientesFisicos = clienteFisicoServico.listarTodos();
        for (ClienteFisico clientesFisicos : todosClientesFisicos) {
            System.out.println(clientesFisicos.getNome());
        }



        

        // ------------ CLIENTE JURÍDICO ------------
        ClienteJuridicoRepositorioMemoria clienteJuridicoRepositorioMemoria = new ClienteJuridicoRepositorioMemoria();
        ClienteJuridicoServico clienteJuridicoServico = new ClienteJuridicoServico(clienteJuridicoRepositorioMemoria);

        ClienteJuridico clienteJuridico1 = new ClienteJuridico(1, "Springer Carrier Ltda",
                "Rua Getulio Vargas, 675, São Caetano, São Paulo", null, "12.232.343/3434-34");

        ClienteJuridico clienteJuridico2 = new ClienteJuridico(2,"Dell Ltda",
                "Rua Fernando Guimaraes, 484, Marilia, SP", null, "12.232.343/3434-35");

        ClienteJuridico clienteJuridico3 = new ClienteJuridico(3,"Dell 3 Ltda",
                "Rua Fernando Guimaraes, 484, Marilia, SP", null, "12.232.343/3434-35");

        // CADASTRAR CLIENTES JURÍDICOS
        System.out.println(String.format(CADASTRO_CLIENTE_JURIDICO_MESSAGEM, clienteJuridico1.getId()));
        clienteJuridicoServico.cadastrar(clienteJuridico1);

        System.out.println(String.format(CADASTRO_CLIENTE_JURIDICO_MESSAGEM, clienteJuridico2.getId()));
        clienteJuridicoServico.cadastrar(clienteJuridico2);

        System.out.println(String.format(CADASTRO_CLIENTE_JURIDICO_MESSAGEM, clienteJuridico3.getId()));
        clienteJuridicoServico.cadastrar(clienteJuridico3);

        // BUSCAR CLIENTE JURÍDICO POR ID
        try {
            System.out.println(String.format(BUSCA_CLIENTE_JURIDICO_MESSAGE, 1));
            ClienteJuridico clienteJuridicoBuscado1 = clienteJuridicoServico.buscarPorId(1);
            System.out.println("ClienteJuridico encontrado! \n id: " + clienteJuridicoBuscado1.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(String.format(BUSCA_CLIENTE_JURIDICO_MESSAGE, 2));
            ClienteJuridico clienteJuridicoBuscado2 = clienteJuridicoServico.buscarPorId(2);
            System.out.println("Carro encontrado! \n id: " + clienteJuridicoBuscado2.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // ATUALIZAR CLIENTE JURÍDICO
        ClienteJuridico clienteJuridico1Atualizado = new ClienteJuridico(2,"Dell ATUALIZADA Ltda",
                "Rua Fernando Guimaraes, 484, Marilia, SP", null, "12.232.343/3434-35");
        System.out.println(String.format(ATUALIZACAO_CLIENTE_JURIDICO_MESSAGEM, 2));
        clienteJuridicoServico.atualizar(1, clienteJuridico1Atualizado);

        // LISTAR TODOS
        System.out.println(LISTAGEM_CLIENTE_JURIDICO_MESSAGEM);
        List<ClienteJuridico> todosClientesJuridicos = clienteJuridicoServico.listarTodos();
        for (ClienteJuridico clientesJuridicos : todosClientesJuridicos) {
            System.out.println(clientesJuridicos.getNome());
        }

    }

}
