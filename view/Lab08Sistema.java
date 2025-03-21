package view;

import java.util.Scanner;
import model.Lab08ContaCorrente;
import util.MyClassException;

public class Lab08Sistema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        try {
            do {
                System.out.println("1 - Cadastramento");
                System.out.println("2 - Saque");
                System.out.println("3 - Deposito");
                System.out.println("4 - Consulta");
                System.out.println("9 - Fim");
                System.out.print("Opcao: ");
                opcao = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcao) {
                    case 1:
                        execCadastramento(scanner);
                        break;
                    case 2:
                        execSaque(scanner);
                        break;
                    case 3:
                        execDeposito(scanner);
                        break;
                    case 4:
                        execConsulta();
                        break;
                    case 9:
                        System.out.println("Encerrando o sistema...");
                        break;
                    default:
                        System.out.println("Opcao invalida. Tente novamente.");
                }
                System.out.println();
            } while (opcao != 9);
        } catch (MyClassException e) {
            System.out.println("Classe: " + e.getClass());
            System.out.println("Mensagem Objeto: " + e.getMessage());
            System.out.println("Mensagem Negocio: " + e.getLocalizedMessage());
        } finally {
            scanner.close();
        }
    }
    
    private static void execCadastramento(Scanner scanner) throws MyClassException {
        System.out.print("Numero da Agencia: ");
        int agencia = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Numero da Conta: ");
        int contaNum = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        
        System.out.print("Saldo: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine();
        
        Lab08ContaCorrente conta = new Lab08ContaCorrente(agencia, contaNum, nome, saldo);
        conta.gravar();
        System.out.println("Cadastramento realizado");
    }
    
    private static void execSaque(Scanner scanner) throws MyClassException {
        System.out.print("Numero da Agencia: ");
        int agencia = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Numero da Conta: ");
        int contaNum = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Valor do Saque: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        
        Lab08ContaCorrente conta = new Lab08ContaCorrente(agencia, contaNum);
        conta.saque(valor);
        conta.gravar();
        System.out.println("Saque realizado");
    }
    
    private static void execDeposito(Scanner scanner) throws MyClassException {
        System.out.print("Numero da Agencia: ");
        int agencia = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Numero da Conta: ");
        int contaNum = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Valor do Deposito: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        
        Lab08ContaCorrente conta = new Lab08ContaCorrente(agencia, contaNum);
        conta.deposito(valor);
        conta.gravar();
        System.out.println("Deposito realizado");
    }
    
    private static void execConsulta() throws MyClassException {
        System.out.print("Numero da Agencia: ");
        Scanner scanner = new Scanner(System.in);
        int agencia = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Numero da Conta: ");
        int contaNum = scanner.nextInt();
        scanner.nextLine();
        
        Lab08ContaCorrente conta = new Lab08ContaCorrente(agencia, contaNum);
        conta.imprimir();
    }
}
