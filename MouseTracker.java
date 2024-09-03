import javax.swing.JFrame; // Importa o componente JFrame do módulo swing da biblioteca javax 

public class MouseTracker // Início da classe .
{ // Início do bloco de codigo da classe.
   public static void main(String[] args) // Define do método .
   { //início do bloco de método
      MouseTrackerFrame mouseTrackerFrame = new MouseTrackerFrame(); // Cria uma variável de MouseTrackerFrame.
      mouseTrackerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define a operação padrão de fechamento da janela.
      mouseTrackerFrame.setSize(300, 100); // Define o tamanho da janela.
      mouseTrackerFrame.setVisible(true); // Torna a janela visível.
   } // Fim do bloco de método.
} // Fim da classe MouseTracker