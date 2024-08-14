// Início do programa de adição de entrada e saída 
import javax.swing.JOptionPane; // importa JOptinPane da biblioteca java, ela possibilita criar uma caixa de dialogo  

public class Addition // cria a classe de adição 
{
   public static void main(String[] args) // cria o método de de execussão 
   {
      // Obtem a entrada do usuario atravez da caixa de diálogo que foi criada em JOptinPane
      String firstNumber = // prepara a primeira classe para receber o primeiro número 
         JOptionPane.showInputDialog("Enter first integer"); // exibe uma caixa de diálogo onde solicita para digigitar o primeiro número inteiro, alem de mostrar o botçao de "ok" e "cancel"
      String secondNumber =// prepara a segunda classe para receber o segundo o número 
         JOptionPane.showInputDialog("Enter second integer"); // exibe uma caixa de diálogo onde solicita para digigitar o segundo número inteiro, alem de mostrar o botçao de "ok" e "cancel"

         // converte as entradas de texto em resultados
      int number1 = Integer.parseInt(firstNumber); // converte a primeira entreada de texto no em um número inteiro
      int number2 = Integer.parseInt(secondNumber);// converte a segundaa entreada de texto no em um número inteiro

      int sum = number1 + number2; // realiza o calculo(soma) dos dois numeros inteiros digitados na caisxa de entrada 

      //exibe  o resultado da soma realixada 
      JOptionPane.showMessageDialog(null, "The sum is " + sum, // exibe o resultado da soma  
         "Sum of Two Integers", JOptionPane.PLAIN_MESSAGE); // mostra a uma janela com o texto 
   } 
} // fim do código de adição