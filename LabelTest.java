// Início do codigo "LabelTest"
import javax.swing.JFrame; // Importa uma biblioteca (javax), que é invocado de um módulo (swig), que por sua vez é invocado de um componente ou classe (JFrame) 

public class LabelTest //Define a classe como pública (public class) de nome LabelTest, que é o mesmo do nome do arquivo  
{ // Início do código da classe LabelTest
   public static void main(String[] args) // Método executor do cóidigo, "static"  
   { // Início do bloco de método 
      LabelFrame labelFrame = new LabelFrame(); 
      labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Define o encerramento e saida do código ao clicar em "close"  
      labelFrame.setSize(360, 280); // setSize define o tamanho altura (height) e largura (width) do quadro de exibição
      labelFrame.setVisible(true); // setVisible torna visivel o quadro de exibição. observação: "possivelmente o vscode vem com o padrão de não mostrar, pois, aparece true"
   } // Final do bloco de método
} // Final da classe LabelTest



