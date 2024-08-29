import javax.swing.JFrame;
// Classe principal para testar a funcionalidade da classe RadioButtonFrame.
public class RadioButtonTest  
{
    // O método principal que executa o programa.
   public static void main(String[] args)
   {
      // Cria uma instância de RadioButtonFrame, que é uma janela com radio buttons.
      RadioButtonFrame radioButtonFrame = new RadioButtonFrame();
      // Define a operação padrão de fechamento da janela (encerra o programa).
      radioButtonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Define o tamanho da janela.
      radioButtonFrame.setSize(300, 135);
      // Torna a janela visível.
      radioButtonFrame.setVisible(true);
   }
} // Fim da classe RadioButtonTest
