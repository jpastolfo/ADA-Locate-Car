package menu;

import java.util.Scanner;

public class MainUI {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int escolha = -1;

        while (escolha !=0) {
            MainImpressora.imprimirMenu();
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    MainControlador.controlarClienteMenu(scanner);
                    break;
                case 2:
                    MainControlador.controlarCarroMenu(scanner);
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
