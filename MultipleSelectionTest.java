import javax.swing.*; // Importa todo o módulo swing.

public class MultipleSelectionTest // Início da classe .
{
   public static void main(String[] args)// Define do método .
   { //início do bloco de método.
      MultipleSelectionFrame multipleSelectionFrame =
         new MultipleSelectionFrame(); // Cria uma variavel do tipo multipleSelectionFrame e cria um novo objeto multipleSelectionFrame.
      multipleSelectionFrame.setDefaultCloseOperation(
         JFrame.EXIT_ON_CLOSE);// Define a operação de fechamento da janela.
      multipleSelectionFrame.setSize(550, 150); // Define o tamanho da janela.
      multipleSelectionFrame.setVisible(true); // Torna a janela visível.
   } // Fim do bloco de método.
} // Fim da classe MultipleSelectionTest