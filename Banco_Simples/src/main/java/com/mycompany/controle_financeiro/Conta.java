/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controle_financeiro;

import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Conta {
 
    private double saldo = 0;
    int numero;
    Cliente titular;


    public Conta(int numero, Cliente titular) {
        this.numero = numero;
        this.titular = titular;
    }
    
    
    public void depositar(double valor){
        
        if(valor >= 0){
        this.saldo += valor;
        }
        else{
        JOptionPane.showMessageDialog(null, "valor negativo! coloque um valor positivo");
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void sacar(double valor){
        
        if(valor > 0 && this.saldo >= valor){
        this.saldo -= valor;
        }
        else{
        JOptionPane.showMessageDialog(null, "valor negativo ou maior que o saldo!");
        }
    }

    public double getSaldo() {
           return this.saldo;
    }
  
    
}
