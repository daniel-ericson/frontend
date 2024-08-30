import javax.swing.*;// Importa todo o módulo swing.

public class ListTest // Início da classe .
{
   public static void main(String[] args) // Define do método .
   { //início do bloco de método.
      ListFrame listFrame = new ListFrame(); // Cria uma variavel do tipo ListFrame e cria um novo objeto ListFrame.
      listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define a operação de fechamento da janela.
      listFrame.setSize(350, 150); // Define o tamanho da janela.
      listFrame.setVisible(true); // Torna a janela visível.
   } // Fim do bloco de método.
} // Fim da classe ListTest.
