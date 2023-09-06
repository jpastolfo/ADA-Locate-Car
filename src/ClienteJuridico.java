import java.util.List;

public class ClienteJuridico extends Cliente {
    String cnpj;

    public ClienteJuridico(String nome, String endereco, List<Carro> carrosAlugados) {
        super(nome, endereco, carrosAlugados);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "ClienteJuridico{" +
                "cnpj='" + cnpj + '\'' +
                '}';
    }
}
