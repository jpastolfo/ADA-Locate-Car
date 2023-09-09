package menu;

public class MainImpressora {

    protected static void imprimirClienteMenu() {
        System.out.println("[1] Cliente Físico");
        System.out.println("[2] Cliente Jurídico");
        System.out.println("[0] Voltar");
    }

    protected static void imprimirMenu() {
        System.out.println("Bem-vindo(a) ao ADA LocateCar!");
        System.out.println("Favor, selecione uma das opções abaixo para continuar.");
        System.out.println("[1] Cliente");
        System.out.println("[2] Carro");
        System.out.println("[0] Sair");
    }

    protected static void imprimirCarroMenu() {
        System.out.println("[1] Cadastrar Carro");
        System.out.println("[2] Buscar Carro");
        System.out.println("[3] Alterar Carro");
        System.out.println("[4] Deletar Carro");
        System.out.println("[0] Voltar");
    }
}
