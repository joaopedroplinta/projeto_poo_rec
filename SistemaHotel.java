import pacote_1.*;
import pacote_2.*;
import pacote_3.*;
import java.util.Scanner;
import java.io.*;

public class SistemaHotel {
    private static Scanner scanner = new Scanner(System.in);
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_AMARELO = "\u001B[33m";
    public static final String ANSI_AZUl = "\u001B[34m";
    public static final String ANSI_VERMELHO = "\u001B[31m";

    private static void limparTerminal() {
        try {
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        exibirMenuPrincipal();
    }

    private static void exibirMenuPrincipal() {
        limparTerminal();
        System.out.println(ANSI_AMARELO + "Sistema de Reservas para Hotel" + ANSI_RESET);
        System.out.println(ANSI_AZUl + "1. Entrar como Cliente" + ANSI_RESET);
        System.out.println(ANSI_AZUl + "2. Entrar como Funcionário" + ANSI_RESET);
        System.out.println(ANSI_VERMELHO + "3. Sair" + ANSI_RESET);
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        switch (opcao) {
            case 1:
                menuCliente();
                break;
            case 2:
                menuFuncionario();
                break;
            case 3:
                System.out.println("Sistema encerrado. Até logo!");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                exibirMenuPrincipal();
        }
    }

    private static void menuCliente() {
        limparTerminal();
        System.out.println(ANSI_AMARELO + "Menu do Cliente" + ANSI_RESET);
        // Adicione as opções específicas para o cliente aqui
        System.out.println(ANSI_AZUl + "1. Realizar Reserva" + ANSI_RESET);
        System.out.println(ANSI_AZUl + "2. Consultar Reservas" + ANSI_RESET);
        System.out.println(ANSI_VERMELHO + "-1. Voltar ao Menu Principal" + ANSI_RESET);
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        switch (opcao) {
            case 1:
                System.out.println("Implemente a lógica para realizar reserva aqui.");
                break;
            case 2:
                System.out.println("Implemente a lógica para consultar reservas aqui.");
                break;
            case -1:
                exibirMenuPrincipal();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                menuCliente();
        }
    }

    private static void menuFuncionario() {
        limparTerminal();
        System.out.println(ANSI_AMARELO + "Menu do Funcionário" + ANSI_RESET);
        // Adicione as opções específicas para o funcionário aqui
        System.out.println(ANSI_AZUl + "1. Adicionar Cliente" + ANSI_RESET);
        System.out.println(ANSI_AZUl + "2. Adicionar Reserva" + ANSI_RESET);
        System.out.println(ANSI_AZUl + "3. Adicionar Quartos" + ANSI_RESET);
        System.out.println(ANSI_AZUl + "4. Consultar Clientes" + ANSI_RESET);
        System.out.println(ANSI_AZUl + "5. Consultar Reservas" + ANSI_RESET);
        System.out.println(ANSI_AZUl + "6. Consultar Quartos" + ANSI_RESET);
        System.out.println(ANSI_VERMELHO + "-1. Voltar ao Menu Principal" + ANSI_RESET);
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        switch (opcao) {
            case 1:
                System.out.println("Implemente a lógica para adicionar cliente aqui.");
                break;                
            case 2:
                System.out.println("Implemente a lógica para adicionar reserva aqui.");
                break;
            case 3:
                System.out.println("Implemente a lógica para adicionar quartos aqui.");
                break;
            case 4:
                System.out.println("Implemente a lógica para consultar clientes aqui.");
                break;
            case 5:
                System.out.println("Implemente a lógica para consultar reservas aqui.");
                break;
            case 6:
                System.out.println("Implemente a lógica para consultar quartos aqui.");
                break;
            case -1:
                exibirMenuPrincipal();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                menuFuncionario();
        }
    }
}
