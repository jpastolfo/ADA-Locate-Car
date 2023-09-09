import modelo.Carro;
import modelo.Tamanho;
import persistencia.memoria.CarroRepositorioMemoria;
import servico.CarroServico;

public class Main {

    public static void main(String[] args) {

        CarroRepositorioMemoria carroRepositorioMemoria = new CarroRepositorioMemoria();
        CarroServico servico = new CarroServico(carroRepositorioMemoria);

        Carro carro1 = new Carro(1,"civic", "honda", "prata","419s8s-1s1", Tamanho.MEDIO);

        servico.cadastrarCarro(carro1);
        
    }

}
