import java.awt.*; // Importa todo o módulo awt.
import java.awt.event.*; // Importa todo o componente event.
import javax.swing.*; // Importa todo o módulo swing.

public class ComboBoxFrame extends JFrame // Criação da classe ComboBoxFrame que herda JFrame.
{
   private final JComboBox<String> imagesJComboBox; // ComboBox que contém os nomes dos ícones
   private final JLabel label; // Label que exibe o ícone selecionado.

   private static final String[] names = 
      {"bug1.gif", "bug2.gif",  "travelbug.gif", "buganim.gif","extremeBug.png"};// Nomes de arquivos de imagem.
   private final Icon[] icons = 
   { 
      new ImageIcon(getClass().getResource(names[0])),// Cria um ícone a partir do primeiro nome de arquivo.
      new ImageIcon(getClass().getResource(names[1])), // Cria um ícone a partir do primeiro nome de arquivo.
      new ImageIcon(getClass().getResource(names[2])),// Cria um ícone a partir do primeiro nome de arquivo.
      new ImageIcon(getClass().getResource(names[3])), // Cria um ícone a partir do primeiro nome de arquivo.
      new ImageIcon(getClass().getResource(names[4]))};// Cria um ícone a partir do primeiro nome de arquivo.
      
   // O construtor ComboBoxFrame adiciona JComboBox ao JFrame
   public ComboBoxFrame()
   {
      super("Testing JComboBox"); // Chama o construtor da classe supere define o título da janela.
      setLayout(new FlowLayout()); // Define o layout do frame como FlowLayout (a janela é responsiva).
  
      imagesJComboBox = new JComboBox<String>(names); // Cria o JComboBox com os nomes dos ícones.
      imagesJComboBox.setMaximumRowCount(4); // Define o máximo de três linhas visíveis na lista suspensa.
  
      imagesJComboBox.addItemListener(
          new ItemListener() // Classe interna para tratar eventos do JComboBox.
         {
            // Método que lida com o evento de alteração de item no JComboBox.
            @Override
            public void itemStateChanged(ItemEvent event) 
            {
               // Verifica se o item foi selecionado.
               if (event.getStateChange() == ItemEvent.SELECTED)
                     label.setIcon(icons[
                        imagesJComboBox.getSelectedIndex()]); // Define o ícone no JLabel com base no item selecionado.
            }
         } // Fim da classe interna.
      ); // Fim da chamada ao método addItemListener.
  
      add(imagesJComboBox); // Adiciona o JComboBox ao JFrame.
      label = new JLabel(icons[0]); // Exibe o primeiro ícone no JLabel por padrão.
      add(label); // Adiciona o JLabel ao JFrame.
   }
} // Fim classe ComboBoxFrame