import modelo.Carro;
import modelo.Tamanho;
import persistencia.memoria.CarroRepositorioMemoria;
import servico.CarroServico;

import java.util.Scanner;

public class MainUI {

    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int escolha = -1;

        while (escolha !=0) {
            imprimirMenu();
            escolha = scanner.nextInt();
            scanner.nextLine();

        switch (escolha) {
            case 1:
                controlarClienteMenu(scanner);
                break;
            case 2:
                controlarCarroMenu(scanner);
                break;
            case 0:
                System.out.println("Saindo do programa...");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
        scanner.close();
}

    private static void controlarClienteMenu(Scanner scanner) {
        int escolha = -1;

        while (escolha != 0) {

            imprimirClienteMenu();
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    break;
                case 2:
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void controlarCarroMenu(Scanner scanner) {
        int escolha = -1;

        while (escolha != 0) {

            imprimirCarroMenu();
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void imprimirClienteMenu() {
        System.out.println("[1] Cliente Físico");
        System.out.println("[2] Cliente Jurídico");
        System.out.println("[0] Voltar");
    }

    private static void imprimirMenu() {
        System.out.println("Bem-vindo(a) ao ADA LocateCar!");
        System.out.println("Favor, selecione uma das opções abaixo para continuar.");
        System.out.println("[1] Cliente");
        System.out.println("[2] Carro");
        System.out.println("[0] Sair");
    }

    private static void imprimirCarroMenu() {
        System.out.println("[1] Cadastrar Carro");
        System.out.println("[2] Buscar Carro");
        System.out.println("[3] Alterar Carro");
        System.out.println("[4] Deletar Carro");
        System.out.println("[0] Voltar");
    }
}
