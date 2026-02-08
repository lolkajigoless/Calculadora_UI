/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calcui;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.awt.*;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.text.*;

/**
 *
 * @author user
 */
public class CalcUI extends JFrame {
    
    JLabel rotulo1,rotulo2;
    JButton somar,sub,mult,div,limpar,estilo1,estilo2;
    JTextField num1,num2 ;
    JTextArea area;
    JScrollPane rolagem;
   
    
    public CalcUI(){
    super("Calculadora");
    Container tela = getContentPane();
    setLayout(null);
    rotulo1 = new JLabel("1º Numero: ");
    rotulo2 = new JLabel("2º Numero: ");
    num1 = new JTextField(5);
    num2 = new JTextField(5);
    somar = new JButton("Somar");
    sub = new JButton("Subtrar");
    mult = new JButton("Multiplicar");
    div = new JButton("Dividir");
    limpar = new JButton("Limpar caixas de texto e conta");
    estilo1 = new JButton("");
    estilo2 = new JButton("");
    // Definindo: texto no TextArea , quant. de linhas , quant. de colunas
    area = new JTextArea("",15,15);
    // colocando uma barra de rolagem no JTextArea
    rolagem = new JScrollPane(area);
    
    ImageIcon icone = new ImageIcon(getClass().getResource("/calcui/imagem.jpg"));
    setIconImage(icone.getImage());
    
    num1 = new JTextField(5);
    num2 = new JTextField(5);
    
    tela.setBackground(new Color(171,168,167));
    estilo1.setBackground(Color.white);
    estilo2.setBackground(Color.black);

    // fazendo com que nao seja possivel digitar no JTextArea
    area.setEditable(false);
    
    
    rotulo1.setBounds(70, 20, 100, 20);
    rotulo2.setBounds(70, 60, 100, 20);    
    somar.setBounds(70, 125, 120, 35);
    sub.setBounds(70, 175, 120, 35);
    mult.setBounds(300, 125, 120, 35);
    div.setBounds(300, 175, 120, 35);
    limpar.setBounds(120, 330, 250, 35);
    num1.setBounds(170, 20, 230, 20);
    num2.setBounds(170, 60, 230, 20);
    estilo1.setBounds(10, 300, 50, 50);
    estilo2.setBounds(420, 300, 50, 50);
    // posicionando o JTextArea "integrado" com o JScrollPane
    rolagem.setBounds(150, 230, 190, 90);
    
    
    rotulo1.setFont(new Font("Arial", Font.BOLD,15));
    rotulo2.setFont(new Font("Arial", Font.BOLD,15));
    somar.setFont(new Font("Arial", Font.BOLD,15));
    sub.setFont(new Font("Arial", Font.BOLD,15));
    mult.setFont(new Font("Arial", Font.BOLD,15));
    div.setFont(new Font("Arial", Font.BOLD,15));
    limpar.setFont(new Font("Arial", Font.BOLD,15));
    num1.setFont(new Font("Arial", Font.PLAIN,15));
    num2.setFont(new Font("Arial", Font.PLAIN,15));
    estilo1.setFont(new Font("Arial", Font.PLAIN,15));
    estilo2.setFont(new Font("Arial", Font.PLAIN,15));
    // mudando fonte e outros recursos o JTextArea "integrado" com o JScrollPane
    rolagem.setFont(new Font("Arial", Font.BOLD,15));
    
    // adiciona um evento ao botao  
    somar.addActionListener(
            // "chama" as funcoes de ActionListener
            new ActionListener(){
            // quando o botao for clicado esse metodo é chamado automaticamente e executa o que estiver dentro dele.
            public void actionPerformed(ActionEvent e){

            // tenta(try) o codigo de texto dntro dele    
            try{    
            
            String texto1 = num1.getText().replace(",", ".").trim();
            String texto2 = num2.getText().replace(",", ".").trim();
                
            // pega o conteudo da caixa de texto, deixa sem espacos em branco e se a caixa está vazia
            if(texto1.isEmpty() || texto2.isEmpty()){
            
            // quando a condicao ser atingida irá aparecer uma tela de aviso e retomar o foco na caixa de texto 1    
            JOptionPane.showMessageDialog(null, "Escreva algo nas caixas de texto!","Aviso",JOptionPane.WARNING_MESSAGE);
            num1.requestFocus();
            return;
            }
                
            float numero1,numero2,somar = 0;    
                
            numero1 = Float.parseFloat(texto1);
            numero2 = Float.parseFloat(texto2);
            
            somar = numero1 + numero2;
            // append() faz com que mantenha o que estiver em area a passa a mensagem como parametro no final do conteudo
            area.append("A soma é: " + somar + "\n");
            }catch(Exception a){System.out.println("Ha algo errado!");}
            
        }
    }
);
   
    sub.addActionListener(
            new ActionListener(){
           public void actionPerformed(ActionEvent e){
           try{
               String texto1 = num1.getText().replace(",", ".").trim();
            String texto2 = num2.getText().replace(",", ".").trim();
                
            // pega o conteudo da caixa de texto, deixa sem espacos em branco e se a caixa está vazia
            if(texto1.isEmpty() || texto2.isEmpty()){
            
            // quando a condicao ser atingida irá aparecer uma tela de aviso e retomar o foco na caixa de texto 1    
            JOptionPane.showMessageDialog(null, "Escreva algo nas caixas de texto!","Aviso",JOptionPane.WARNING_MESSAGE);
            num1.requestFocus();
            return;
            }
               float numero1,numero2,sub = 0;    
                
            numero1 = Float.parseFloat(texto1);
            numero2 = Float.parseFloat(texto2);
            
            sub = numero1 - numero2;
           
              area.append("A subtracao é: " + sub + "\n");
               }catch(Exception b){System.out.println("Ha algo errado!");}
           
           }
        }
    );
    
    mult.addActionListener(
            
       new ActionListener(){
    
        public void actionPerformed(ActionEvent e){
            try{
                
            String texto1 = num1.getText().replace(",", ".").trim();
            String texto2 = num2.getText().replace(",", ".").trim();
                
            // pega o conteudo da caixa de texto, deixa sem espacos em branco e se a caixa está vazia
            if(texto1.isEmpty() || texto2.isEmpty()){
            
            // quando a condicao ser atingida irá aparecer uma tela de aviso e retomar o foco na caixa de texto 1    
            JOptionPane.showMessageDialog(null, "Escreva algo nas caixas de texto!","Aviso",JOptionPane.WARNING_MESSAGE);
            num1.requestFocus();
            return;
            }
            
            float numero1,numero2,mult = 0;    
                
            numero1 = Float.parseFloat(texto1);
            numero2 = Float.parseFloat(texto2);
            
            mult = numero1 * numero2;
           area.append("A multiplicação: " + mult + "\n");
         }catch(Exception c){System.out.println("Ha algo errado!");}
            
            
        }
    }
);
    div.addActionListener(
            
            new ActionListener(){
    
        public void actionPerformed(ActionEvent e){
            try{
            String texto1 = num1.getText().replace(",", ".").trim();
            String texto2 = num2.getText().replace(",", ".").trim();
                
            // pega o conteudo da caixa de texto, deixa sem espacos em branco e se a caixa está vazia
            if(texto1.isEmpty() || texto2.isEmpty()){
            
            // quando a condicao ser atingida irá aparecer uma tela de aviso e retomar o foco na caixa de texto 1    
            JOptionPane.showMessageDialog(null, "Escreva algo nas caixas de texto!","Aviso",JOptionPane.WARNING_MESSAGE);
            num1.requestFocus();
            return;
            }
            
            if(texto2.equals(0)){
            JOptionPane.showMessageDialog(null, "nao há divisao com 0","Aviso",JOptionPane.WARNING_MESSAGE);
            return;
            }
            
            float numero1,numero2,div = 0;    
                
            numero1 = Float.parseFloat(texto1);
            numero2 = Float.parseFloat(texto2);
            
            div = numero1 / numero2;
        
            area.append("A divisao é: " + div + "\n");

            }catch(Exception d){System.out.println("Ha algo errado!");}
              
        }
    }
    );
    
    limpar.addActionListener(new ActionListener(){
    
        public void actionPerformed(ActionEvent e){
        
        num1.setText("");
        num2.setText("");
        // seta o texto e nao o append. ou seja reescreve o texto totalmente
        area.setText("");
        num1.requestFocus();
        
        }
    }
    );
   
   // adiciona um evento ao botao, e quando clicado irá mudar a cor de fundo da janela,botoes e letras 
   estilo1.addActionListener(new ActionListener(){
   
       public void actionPerformed(ActionEvent e){
       
    tela.setBackground(Color.white);
    somar.setBackground(Color.white);
    sub.setBackground(Color.white);
    mult.setBackground(Color.white);
    div.setBackground(Color.white);
    limpar.setBackground(Color.white);
    rotulo1.setBackground(Color.white);
    rotulo2.setBackground(Color.white);
    somar.setBackground(Color.white);
    sub.setBackground(Color.white);
    mult.setBackground(Color.white);
    div.setBackground(Color.white);
    limpar.setBackground(Color.white);
    num1.setBackground(Color.white);
    num2.setBackground(Color.white);
    estilo1.setBackground(Color.white);
    somar.setBackground(Color.white);
    sub.setBackground(Color.white);
    mult.setBackground(Color.white);
    div.setBackground(Color.white);
    limpar.setBackground(Color.white);
    rotulo1.setForeground(Color.black);
    rotulo2.setForeground(Color.black);
    somar.setForeground(Color.black);
    sub.setForeground(Color.black);
    mult.setForeground(Color.black);
    div.setForeground(Color.black);
    limpar.setForeground(Color.black);
    num1.setForeground(Color.black);
    num2.setForeground(Color.black);
    estilo1.setForeground(Color.black);  
    num1.requestFocus();
       }
   });
   
   estilo2.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
       
      tela.setBackground(Color.black);
      somar.setBackground(new Color(27, 27, 27));
      sub.setBackground(new Color(27, 27, 27));
      mult.setBackground(new Color(27, 27, 27));
      div.setBackground(new Color(27, 27, 27));
      limpar.setBackground(new Color(27, 27, 27));
      rotulo1.setForeground(new Color(71, 253, 219));
      rotulo2.setForeground(new Color(71, 253, 219));
      somar.setForeground(new Color(71, 253, 219));
      sub.setForeground(new Color(71, 253, 219));
      mult.setForeground(new Color(71, 253, 219));
      div.setForeground(new Color(71, 253, 219));
      limpar.setForeground(new Color(71, 253, 219));
      num1.setForeground(Color.black);
      num2.setForeground(Color.black);
      estilo1.setForeground(new Color(71, 253, 219));
      num1.requestFocus(); 
       }
     
   });
  
    tela.add(rotulo1);
    tela.add(rotulo2);
    tela.add(num1);
    tela.add(num2);
    tela.add(somar);
    tela.add(sub);
    tela.add(mult);
    tela.add(div);
    tela.add(limpar);
    tela.add(estilo1);
    tela.add(estilo2);
    tela.add(rolagem);
    
    setSize(500,400);
    setVisible(true);
    setLocationRelativeTo(null);
    
    }

}















































