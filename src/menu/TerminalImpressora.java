package menu;

public class TerminalImpressora {

    protected static void imprimirMenu() {
        System.out.println("Bem-vindo(a) ao ADA LocateCar!");
        System.out.println("Favor, selecione uma das opções abaixo para continuar.");
        System.out.println("[1] Cliente");
        System.out.println("[2] Carro");
        System.out.println("[0] Sair");
    }

    protected static void imprimirClienteMenu() {
        System.out.println("[1] Cliente Físico");
        System.out.println("[2] Cliente Jurídico");
        System.out.println("[0] Voltar");
    }

    protected static void imprimirClienteFisicoMenu() {
        System.out.println("[1] Cadastrar Cliente Físico");
        System.out.println("[2] Buscar Cliente Físico");
        System.out.println("[3] Listar todos Clientes Jurídico");
        System.out.println("[4] Alterar Cliente Físico");
        System.out.println("[5] Deletar Cliente Físico");
        System.out.println("[0] Voltar");
    }

    protected static void imprimirClienteJuridicoMenu() {
        System.out.println("[1] Cadastrar Cliente Jurídico");
        System.out.println("[2] Buscar Cliente Jurídico");
        System.out.println("[3] Listar todos Clientes Jurídico");
        System.out.println("[4] Alterar Cliente Jurídico");
        System.out.println("[5] Deletar Cliente Jurídico");
        System.out.println("[0] Voltar");
    }

    protected static void imprimirCarroMenu() {
        System.out.println("[1] Cadastrar Carro");
        System.out.println("[2] Buscar Carro");
        System.out.println("[3] Listar todos Carros");
        System.out.println("[4] Alterar Carro");
        System.out.println("[5] Deletar Carro");
        System.out.println("[0] Voltar");
    }
}
