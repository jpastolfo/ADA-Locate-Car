import modelo.ClienteFisico;
import modelo.ClienteJuridico;
import persistencia.memoria.ClienteFisicoRepositorioMemoria;
import persistencia.memoria.ClienteJuridicoRepositorioMemoria;
import servico.ClienteFisicoServico;
import servico.ClienteJuridicoServico;

public class TerminalCliente {

    private static final String CADASTRO_CLIENTE_FISICO_MESSAGEM = "\n********************** \nCadastrando Cliente Fisico %d...";
    private static final String BUSCA_CLIENTE_FISICO_MESSAGEM = "\n********************** \nBuscando Cliente Fisico de id %d";
    private static final String CADASTRO_CLIENTE_JURIDICO_MESSAGEM = "\n********************** \nCadastrando Cliente Juridico %d...";
    private static final String BUSCA_CLIENTE_JURIDICO_MESSAGEM = "\n********************** \nBuscando Cliente Juridico de id %d";


    public static void main(String[] args) {

        // CLIENTE FÍSICO
        ClienteFisicoRepositorioMemoria clienteFisicoRepositorioMemoria = new ClienteFisicoRepositorioMemoria();
        ClienteFisicoServico clienteFisicoServico = new ClienteFisicoServico(clienteFisicoRepositorioMemoria);

        ClienteFisico clienteFisico1 = new ClienteFisico(1, "Claudio Silva",
                "Rua das Magnolias, 313, Santo André, São Paulo", null, "045.786.543-65");

        ClienteFisico clienteFisico2 = new ClienteFisico(2,"Fernando Souza",
                "Rua das Camelias, 654, São Bernardo, São Paulo", null, "954.654.655-56");

        ClienteFisico clienteFisico3 = new ClienteFisico(2,"Fernando Souza",
                "Rua das Camelias, 654, São Bernardo, São Paulo", null, "954.654.655-56");


        System.out.println(String.format(CADASTRO_CLIENTE_FISICO_MESSAGEM, 1));
        clienteFisicoServico.cadastrar(clienteFisico1);

        System.out.println(String.format(CADASTRO_CLIENTE_FISICO_MESSAGEM, 2));
        clienteFisicoServico.cadastrar(clienteFisico2);

        System.out.println(String.format(CADASTRO_CLIENTE_FISICO_MESSAGEM, 3));
        clienteFisicoServico.cadastrar(clienteFisico3);
        // Buscar cliente físico por id

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

        // CLIENTE JURÍDICO
        ClienteJuridicoRepositorioMemoria clienteJuridicoRepositorioMemoria = new ClienteJuridicoRepositorioMemoria();
        ClienteJuridicoServico clienteJuridicoServico = new ClienteJuridicoServico(clienteJuridicoRepositorioMemoria);

        ClienteJuridico clienteJuridico1 = new ClienteJuridico(1, "Springer Carrier Ltda",
                "Rua Getulio Vargas, 675, São Caetano, São Paulo", null, "12.232.343/3434-34");

        ClienteJuridico clienteJuridico2 = new ClienteJuridico(2,"Dell Ltda",
                "Rua Fernando Guimaraes, 484, Marilia, SP", null, "12.232.343/3434-35");

        ClienteJuridico clienteJuridico3 = new ClienteJuridico(3,"Dell 3 Ltda",
                "Rua Fernando Guimaraes, 484, Marilia, SP", null, "12.232.343/3434-35");


        System.out.println(String.format(CADASTRO_CLIENTE_JURIDICO_MESSAGEM, 1));
        clienteJuridicoServico.cadastrar(clienteJuridico1);

        System.out.println(String.format(CADASTRO_CLIENTE_JURIDICO_MESSAGEM, 2));
        clienteJuridicoServico.cadastrar(clienteJuridico2);

        System.out.println(String.format(CADASTRO_CLIENTE_JURIDICO_MESSAGEM, 3));
        clienteJuridicoServico.cadastrar(clienteJuridico3);

        // Buscar cliente jurídico por id
        try {
            System.out.println(String.format(BUSCA_CLIENTE_JURIDICO_MESSAGEM, 1));
            ClienteJuridico clienteJuridicoBuscado1 = clienteJuridicoServico.buscarPorId(1);
            System.out.println("ClienteJuridico encontrado! \n id: " + clienteJuridicoBuscado1.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println(String.format(BUSCA_CLIENTE_JURIDICO_MESSAGEM, 2));
            ClienteJuridico clienteJuridicoBuscado2 = clienteJuridicoServico.buscarPorId(2);
            System.out.println("Carro encontrado! \n id: " + clienteJuridicoBuscado2.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
