import javax.swing.*; //Importa todos os componentes do módulo SWING. 

public class MenuTest
{
   public static void main(String[] args)
   { 
      // Cria uma instância da janela MenuFrame.
      MenuFrame menuFrame = new MenuFrame(); 
      
      // Define a operação padrão ao fechar a janela (encerrar o programa).
      menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      // Define o tamanho da janela (largura 500, altura 200).
      menuFrame.setSize(500, 200); 
      
      // Torna a janela visível.
      menuFrame.setVisible(true);
   } 
} // Fim da MenuTest.
