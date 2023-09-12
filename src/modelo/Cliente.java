package modelo;

import java.util.List;

public abstract class Cliente implements Entidade<Integer>{


    private String id;
    private String nome;
    private String endereco;
    private List<Carro> carrosAlugados;

    public Cliente(String nome, String endereco, List<Carro> carrosAlugados) {
        this.nome = nome;
        this.endereco = endereco;
        this.carrosAlugados = carrosAlugados;
    }

    public Cliente() {
    }


    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Carro> getCarrosAlugados() {
        return carrosAlugados;
    }

    public void setCarrosAlugados(List<Carro> carrosAlugados) {
        this.carrosAlugados = carrosAlugados;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", carrosAlugados=" + carrosAlugados +
                '}';
    }
}
