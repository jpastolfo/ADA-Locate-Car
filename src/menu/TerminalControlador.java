package menu;


import persistencia.ClienteFisicoRepositorio;
import servico.ClienteFisicoServico;

import java.util.Scanner;

public class TerminalControlador {

    static ClienteFisicoRepositorio clienteFisicoRepositorio;

    static ClienteFisicoServico clienteFisicoServico = new ClienteFisicoServico(clienteFisicoRepositorio);

    protected static void controlarClienteMenu() {
        int escolha = -1;
        Scanner scanner = new Scanner(System.in);

        while (escolha != 0) {
            TerminalImpressora.imprimirClienteMenu();
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    controlarClienteFisicoMenu();
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

    protected static void controlarCarroMenu() {
        int escolha = -1;

        while (escolha != 0) {

            TerminalImpressora.imprimirCarroMenu();

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

    protected static void controlarClienteFisicoMenu() {
        int escolha = -1;
        Scanner scanner = new Scanner(System.in);

        while (escolha != 0) {
            TerminalImpressora.imprimirClienteFisicoMenu();
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