/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.controle_financeiro;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class App {

    public static void main(String[] args) {
    
    int num = 1;
    Banco banco = new Banco();
   
    while(true){
    
    int escolha = Integer.parseInt(JOptionPane.showInputDialog("0 - sair\n1 - criar conta\n2 - entrar conta\n3 - depositar\n4 - sacar\n5 - Pix\n6 - Historico\n"));
           
    if(escolha == 0){ JOptionPane.showMessageDialog(null, "Muito obrigado por usar nossos serviços"); break;}
    
        switch (escolha) {
            case 1 -> {
                    String nome = JOptionPane.showInputDialog("seu nome:");
                    
                    if (nome == null || nome.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nome inválido!");
                        return;
                    }
                    
                    String cpf = JOptionPane.showInputDialog("seu cpf:");
                    if(cpf != null){
                        cpf = cpf.replaceAll("\\D", ""); // remove pontos e hífen  
                    
                        if(cpf.length() == 11){
                            Cliente cliente = new Cliente(nome, cpf);
                            Conta conta = new Conta(num, cliente);
                            JOptionPane.showMessageDialog(null, "numero da conta: " + num);
                            num++;
                            banco.cadastrarCliente(cliente);
                            banco.adicionarConta(conta);
                        }
                        else {
                         JOptionPane.showMessageDialog(null, "O CPF precisa ter 11 caracteres!");
                         return;
                        }
                        
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Operação cancelada!");
                        return;
                    }
                    
                }
            case 2 ->                 {
                    int numeroConta = Integer.parseInt(
                            JOptionPane.showInputDialog("Digite o número da conta:")
                    );      
                    Conta conta = banco.buscarContas(numeroConta);
                    if(conta != null){
                        JOptionPane.showMessageDialog(
                                null,
                                "Bem-vindo, " + conta.titular.getNome() +
                                        String.format("\nSaldo: %.2f", conta.getSaldo())
                        );
                    } else {
                        JOptionPane.showMessageDialog(null, "Conta não encontrada!");
                    }               
                }
            case 3 ->                 {
                    int numeroConta = Integer.parseInt(
                            JOptionPane.showInputDialog("numero da conta: ")
                    );              Conta conta = banco.buscarContas(numeroConta);
                    if(conta == null) return;
                    String valor_sFor = JOptionPane.showInputDialog("Valor: ");
                    String valor_For = valor_sFor.replace(",", ".");
                    Double valor = Double.parseDouble(valor_For);
                    String msg = String.format("%s{cpf: %s} depositou %.2f",conta.titular.getNome(), conta.titular.getCpf(), valor);
                    banco.colocar_historico(msg);
                    if(valor >= 0) conta.depositar(valor);
                    else return;
                }
            case 4 ->{
                    int numeroConta = Integer.parseInt(
                            JOptionPane.showInputDialog("numero da conta: ")
                    );              Conta conta = banco.buscarContas(numeroConta);
                    if(conta == null) return;
                    String valor_sFor = JOptionPane.showInputDialog("Valor: ");
                    String valor_For = valor_sFor.replace(",", ".");
                    Double valor = Double.parseDouble(valor_For);
                    String msg = String.format("%s{cpf: %s} sacou %.2f",conta.titular.getNome(), conta.titular.getCpf(), valor);
                    banco.colocar_historico(msg);
                    if(valor >= 0) conta.sacar(valor);
                    else return;
                }
            case 5 ->                 {
                    int numeroContaOr = Integer.parseInt(
                            JOptionPane.showInputDialog("numero da conta de origem: ")
                    );              int numeroContaDe = Integer.parseInt(
                            JOptionPane.showInputDialog("numero da conta de destino: ")
                    );              Conta contaOr = banco.buscarContas(numeroContaOr);
                    Conta contaDe = banco.buscarContas(numeroContaDe);
                    if(contaOr == null || contaDe == null) return;
                    Double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor: "));
                    banco.Pix(contaOr, contaDe, valor);
                }
            case 6 ->                 {
                    String historico = banco.exibirHistorico();
                    JOptionPane.showMessageDialog(null, historico);
                }
            default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
        }
    
    }
    }
}
