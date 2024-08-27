import javax.swing.JFrame; // Importa a classe JFrame para criar janelas gráficas.

public class CheckBoxTest { // Inicia a classe CheckBoxTest.

   public static void main(String[] args) { // Inicia o método principal, onde a execução do programa começa.

      // Cria um novo objeto da classe CheckBoxFrame.
      // Esse objeto representa a janela onde os componentes serão exibidos.
      CheckBoxFrame checkBoxFrame = new CheckBoxFrame();

      // Define o comportamento da janela quando o "X" for clicado, fazendo o programa encerrar.
      checkBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Define o tamanho da janela, com 275 pixels de largura e 100 pixels de altura.
      checkBoxFrame.setSize(275, 100);

      // Torna a janela visível para o usuário.
      checkBoxFrame.setVisible(true);
   } // Fim do método main.

} // Fim da classe CheckBoxTest.