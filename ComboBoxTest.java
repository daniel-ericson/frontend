import javax.swing.JFrame; // Importação das bibliotecas .

public class ComboBoxTest // Criação da classe ComboBoxTest.
{ // Início da classe ComboBoxTest.
   public static void main(String[] args) // Criação do método que executa o programa.
   { // Início da criação do bloco do método.
      ComboBoxFrame comboBoxFrame = new ComboBoxFrame(); // Cria um contrutor no ComboBoxFrame.
      comboBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Define a operação padrão de fechamento da janela (encerra o programa).
      comboBoxFrame.setSize(350, 150); // Define o tamanho da janela.
      comboBoxFrame.setVisible(true); // Torna a janela visível.
   } // Fim do bloco da criação do método.
} // Fim da classe ComboBoxTest.