/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controle_financeiro;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Banco {
 
    private List<Cliente> clientes = new ArrayList<>();
    private List<Conta> contas = new ArrayList<>();
    private List<String> historicos = new ArrayList<>();
    
    
    
    public void colocar_historico(String msg){
        historicos.add(msg);
    }
    
    public String exibirHistorico(){
   
        String his = "";
        int contador = 1;
        for(String h : historicos){
            his += "[" + (contador) + "] " + h + "\n";
            contador++;
        }
        
        return his;
    }
    
    public void cadastrarCliente(Cliente cliente){
    for (Cliente c : clientes){
        if(c.getCpf().equals(cliente.getCpf())){
            JOptionPane.showMessageDialog(null, "CPF já cadastrado!");
            return;
        }
    }
        clientes.add(cliente);
    }
    
    public Cliente buscarClientes(String cpf){

        for (Cliente c : clientes){
            if(c.getCpf().equals(cpf)){
                return c;
            }
        }
         JOptionPane.showMessageDialog(null, "Nao há nenhum cliente com esse numero");
        return null;
    }
    
    public void adicionarConta(Conta conta){
        contas.add(conta);
    }
    
    public Conta buscarContas(int num){
    for (Conta c : contas){
        if(c.getNumero() == num){
            return c;
        }
    }
    JOptionPane.showMessageDialog(null, "Nao há nenhuma conta com esse numero");
    return null;
    }
    
    public void Pix(Conta origem, Conta destino, double valor){
        
        if(valor <= 0) return;
        
        String nome_origem = origem.titular.getNome();
        String cpf_origem = origem.titular.getCpf();
        
        String nome_destino= destino.titular.getNome();
        String cpf_destino = destino.titular.getCpf();
        
        
    double saldoOrigem = origem.getSaldo();
    double saldoDestino = destino.getSaldo();

    // verifica se há saldo suficiente antes de subtrair
    if (saldoOrigem < valor) {
        JOptionPane.showMessageDialog(null, "Não há dinheiro em sua conta");
        return;
    }
        origem.setSaldo(saldoOrigem - valor);
        destino.setSaldo(saldoDestino + valor);

        String msg = String.format("%s{cpf: %s} fez o pix de %.2f para %s{cpf: %s}",nome_origem,cpf_origem,valor,nome_destino,cpf_destino);
        colocar_historico(msg);
 
        }
        
}

