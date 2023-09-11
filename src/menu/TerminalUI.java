package menu;

import java.util.Scanner;

public class TerminalUI {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int escolha = -1;

        while (escolha !=0) {
            TerminalImpressora.imprimirMenu();
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    TerminalControlador.controlarClienteMenu();
                    break;
                case 2:
                    TerminalControlador.controlarCarroMenu();
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
}
