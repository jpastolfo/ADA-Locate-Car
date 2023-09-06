import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ClienteFisico joao = new ClienteFisico("João", "Campinas", new ArrayList<>(), "123456789-0");
        ClienteJuridico empresaJoao = new ClienteJuridico("Empresa","Campinas",new ArrayList<>());

        System.out.println(joao.toString());
        System.out.println(empresaJoao.toString());

    }
}