import modelo.Carro;
import modelo.ClienteJuridico;
import modelo.Tamanho;
import persistencia.memoria.CarroRepositorioMemoria;
import persistencia.memoria.ClienteFisicoRepositorioMemoria;
import persistencia.memoria.ClienteJuridicoRepositorioMemoria;
import servico.CarroServico;
import servico.ClienteFisicoServico;
import servico.ClienteJuridicoServico;

public class MainTeste {

    public static void main(String[] args) {

        // CARRO
        CarroRepositorioMemoria carroRepositorioMemoria = new CarroRepositorioMemoria();
        CarroServico carroServico = new CarroServico(carroRepositorioMemoria);

        Carro carro1 = new Carro(1,"civic", "honda", "prata","419s8s-1s1", Tamanho.MEDIO);
        Carro carro2 = new Carro(2,"civic 2", "honda 2", "prata 2","234242419s8s-1s1", Tamanho.PEQUENO);


        System.out.println("********************** \nCadastrando carro 1...");
        carroServico.cadastrar(carro1);

        System.out.println("********************** \nCadastrando carro 2...");
        carroServico.cadastrar(carro2);

        System.out.println("********************** \nCadastrando carro 2...");
        carroServico.cadastrar(carro2);

        // Buscar carro por id
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

        // Remover carro por id
        System.out.println("********************** \nRemovendo carro de id 2");
        carroServico.removerCarroPorId(2);
        try {
            System.out.println("********************** \nBuscando carro de id 2");
            Carro carroBuscado2 = carroServico.buscarPorId(2);
            System.out.println("Carro encontrado! \n id: " + carroBuscado2.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



        // CLIENTE FÍSICO
        ClienteFisicoRepositorioMemoria clienteFisicoRepositorioMemoria = new ClienteFisicoRepositorioMemoria();
        ClienteFisicoServico clienteFisicoServico = new ClienteFisicoServico(clienteFisicoRepositorioMemoria);

        // Buscar cliente físico por id




        // CLIENTE JURÍDICO
        ClienteJuridicoRepositorioMemoria clienteJuridicoRepositorioMemoria = new ClienteJuridicoRepositorioMemoria();
        ClienteJuridicoServico clienteJuridicoServico = new ClienteJuridicoServico(clienteJuridicoRepositorioMemoria);

        // Buscar cliente jurídico por id
    }

}
