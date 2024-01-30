import pacote_1.*;
import pacote_2.*;
import pacote_3.*;
import java.util.Scanner;
import java.io.*;

public class SistemaHotel {
    private static Scanner scanner = new Scanner(System.in);
    private static Cliente clienteAtual;
    private static Funcionario funcionarioAtual;

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
        scanner.nextLine(); 

        switch (opcao) {
            case 1:
                loginCliente();
                break;
            case 2:
                loginFuncionario();
                break;
            case 3:
                System.out.println("Sistema encerrado. Até logo!");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                exibirMenuPrincipal();
        }
    }

    private static void loginCliente() {
        limparTerminal();
        System.out.println(ANSI_AMARELO + "Login do Cliente" + ANSI_RESET);
        System.out.print("CPF: ");
        String cpfCliente = scanner.nextLine();
        System.out.print("Nome: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Endereço: ");
        String enderecoCliente = scanner.nextLine();
        System.out.print("Telefone: ");
        int telefoneCliente = scanner.nextInt();

        clienteAtual = new Cliente(1, cpfCliente, nomeCliente, enderecoCliente, telefoneCliente);
        menuCliente();
    }

    private static void loginFuncionario() {
        limparTerminal();
        System.out.println(ANSI_AMARELO + "Login do Funcionário" + ANSI_RESET);
        System.out.print("CPF: ");
        String cpfFuncionario = scanner.nextLine();
        System.out.print("Nome: ");
        String nomeFuncionario = scanner.nextLine();
        System.out.print("Endereço: ");
        String enderecoFuncionario = scanner.nextLine();
        System.out.print("Telefone: ");
        int telefoneFuncionario = scanner.nextInt();

        funcionarioAtual = new Funcionario(1, cpfFuncionario, nomeFuncionario, telefoneFuncionario, enderecoFuncionario);
        menuFuncionario();
    }

    // Restante do código permanece o mesmo...
}
