package model;

import java.io.*;
import util.MyClassException;

public class Lab08ContaCorrente {
    private int numAge;
    private int numConta;
    private String nome;
    private double saldo;
    
    public Lab08ContaCorrente(int numAge, int numConta, String nome, double saldo) throws MyClassException {
        if (numAge < 1 || numAge > 9999) throw new MyClassException("Agência inválida");
        if (numConta < 1 || numConta > 9999999) throw new MyClassException("Conta inválida");
        this.numAge = numAge;
        this.numConta = numConta;
        this.nome = nome;
        this.saldo = saldo;
    }
    
    public Lab08ContaCorrente(int numAge, int numConta) throws MyClassException {
        this.numAge = numAge;
        this.numConta = numConta;
        recuperar();
    }
    
    public void saque(double pValor) throws MyClassException {
        if (pValor > saldo) throw new MyClassException("Saldo insuficiente");
        saldo -= pValor;
    }
    
    public void deposito(double pValor) {
        saldo += pValor;
    }
    
    public void imprimir() {
        System.out.println("Numero da Agencia: " + numAge);
        System.out.println("Numero da Conta: " + numConta);
        System.out.println("Nome do Cliente: " + nome);
        System.out.println("Saldo: " + saldo);
    }
    
    public void recuperar() throws MyClassException {
        try (BufferedReader reader = new BufferedReader(new FileReader(numAge + "." + numConta + ".dat"))) {
            nome = reader.readLine();
            saldo = Double.parseDouble(reader.readLine());
        } catch (IOException e) {
            throw new MyClassException("Erro ao recuperar dados");
        }
    }
    
    public void gravar() throws MyClassException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(numAge + "." + numConta + ".dat"))) {
            writer.println(nome);
            writer.println(saldo);
        } catch (IOException e) {
            throw new MyClassException("Erro ao gravar dados");
        }
    }
}
