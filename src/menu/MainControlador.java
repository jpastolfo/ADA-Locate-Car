package menu;

import java.util.Scanner;

public class MainControlador {

    protected static void controlarClienteMenu(Scanner scanner) {
        int escolha = -1;

        while (escolha != 0) {

            MainImpressora.imprimirClienteMenu();
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

    protected static void controlarCarroMenu(Scanner scanner) {
        int escolha = -1;

        while (escolha != 0) {

            MainImpressora.imprimirCarroMenu();
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
}
