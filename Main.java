import pacote_1.*;
import pacote_2.*;
import pacote_3.*;
import java.util.Scanner;

public class SistemaHotel {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        exibirMenuPrincipal();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("### Sistema de Reservas para Hotel ###");
        System.out.println("1. Entrar como Cliente");
        System.out.println("2. Entrar como Funcionário");
        System.out.println("3. Sair");
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
        System.out.println("\n### Menu do Cliente ###");
        // Adicione as opções específicas para o cliente aqui
        System.out.println("1. Realizar Reserva");
        System.out.println("2. Consultar Reservas");
        System.out.println("3. Voltar ao Menu Principal");
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
            case 3:
                exibirMenuPrincipal();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                menuCliente();
        }
    }

    private static void menuFuncionario() {
        System.out.println("\n### Menu do Funcionário ###");
        // Adicione as opções específicas para o funcionário aqui
        System.out.println("1. Adicionar Cliente");
        System.out.println("2. Adicionar Reserva");
        System.out.println("3. Voltar ao Menu Principal");
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
                exibirMenuPrincipal();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                menuFuncionario();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        
    }
}
