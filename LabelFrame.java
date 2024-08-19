import java.awt.*;
import javax.swing.*; // carrega todos os componetes do módulo de swing da bibloteca javax

public class LabelFrame extends JFrame // Declaração de classe que está recebendo a extenção do componente, sendo a herança o JFrame e sendo o herdeiro o  LabelFrame
{
   private final JLabel label1; // Declaração da variável privada para o uso somente dentro da classe LabelFrame, com variavel tipo JLabel, sendo o "final" indicando ser somente para leitura para naão ser exportado
   private final JLabel label2; // Declaração da variável privada para o uso somente dentro da classe LabelFrame, com variavel tipo JLabel,para texto e ícone
   private final JLabel label3; // Declaração da variável privada para o uso somente dentro da classe LabelFrame, com variavel tipo JLabel,para texto e ícone

   // criação da classe LabelFrame construtor adicionando JLabels para JFrame
   public LabelFrame() // Tem o mesmo nome da classe que tem o mesmo nome do arquivo (Método construtor)
   {
      super("Testing JLabel"); // Define o título da janela na parte superior 
      setLayout(new FlowLayout()); // Criação de objeto que define o layout, como ele vai ser

      // JLabel construtor com uma string argumento
      label1 = new JLabel("Label with text"); //Declaração de variável construção que atribui da new JLabel com o texto "Label with text"
      label1.setToolTipText("This is label1"); //A variavel label1 invoca texto de ferramentas de digas que ao ser acessado(passando o mouse por cima do texto) aparece uma mensagem de texto "This is label1"
      add(label1); // Adiciona um componete de JLable que específicamente é a variável label!

      // JLabel construtor com string, Icon e alinhamento argumentos
      Icon bug = new ImageIcon(getClass().getResource("bug1.png")); // Declaração do tipo de variável do tipo Icon que invoca a clase getClass que invoca o getResource que é a imagem 
      label2 = new JLabel("Label with text and icon", bug, // Atribui o valor a variável recebe um texto, uma imagem e um alinhamento
         SwingConstants.LEFT); // Define o alinhamento da imagem à esquerda  
      label2.setToolTipText("This is label2");//A variável label2 invoca texto de ferramentas de digas que ao ser acessado(passando o mouse por cima do texto) aparece uma mensagem de texto "This is label2"
      add(label2); // Adiciona um componete de JLable que específicamente é a variável label2

      label3 = new JLabel(); // JLabel construtor no argumentos
      label3.setText("Label with icon and text at bottom");// Declara que a variável label3 invoca a exibição do parâmetro texto "Label with icon and text at bottom" do tipo setText
      label3.setIcon(bug); // Invoca o objeto (imagem) bug do tipo icon
      label3.setHorizontalTextPosition(SwingConstants.CENTER); //Declara que a variável label3 invoca o tipo setHorizontalTextPosition com o parâmetro na posição no centro do quadro
      label3.setVerticalTextPosition(SwingConstants.BOTTOM); //Declara que a variável label3 invoca o tipo setVerticalTextPosition com o parâmetro na posição na parte inferior, como uma quebra de linha 
      label3.setToolTipText("This is label3"); //A variável label3 invoca texto de ferramentas de digas que ao ser acessado(passando o mouse por cima do texto) aparece uma mensagem de texto "This is label3"
      add(label3); // Adiciona um componete de JLable que específicamente é a variável label!
   } // Final do bloco do método  
} // Final da classe LabelFrame


