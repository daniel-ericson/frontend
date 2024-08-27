import java.awt.FlowLayout; // Importa o layout que organiza os componentes um ao lado do outro.
import java.awt.Font; // Importa a classe para manipulação de fontes (tipos de letra).
import java.awt.event.ItemEvent; // Importa a classe para tratar eventos de mudança.
import java.awt.event.ItemListener; // Importa a interface para detectar mudanças em elementos como caixas de seleção.
import java.awt.font.*; // Importa toda a font.
import java.util.*; // Importa toda a util.
import javax.swing.JCheckBox; // Importa a classe para criar caixas de seleção.
import javax.swing.JFrame; // Importa a classe que permite criar janelas gráficas.
import javax.swing.JTextField; // Importa a classe para criar campos de texto.

public class CheckBoxFrame extends JFrame { // Inicia a classe CheckBoxFrame, que herda as propriedades de JFrame (janela).

   private final JTextField textField; // Campo de texto onde o usuário verá as mudanças de estilo de fonte.
   private final JCheckBox boldJCheckBox; // Caixa de seleção para ativar/desativar o estilo negrito.
   private final JCheckBox italicJCheckBox; // Caixa de seleção para ativar/desativar o estilo itálico.
   private final JCheckBox underlineJCheckBox; // Caixa de seleção para ativar/desativar o estilo sublinhado.

   // Construtor da classe CheckBoxFrame. Ele configura os componentes na janela.
   public CheckBoxFrame() {
      super("JCheckBox Test"); // Define o título da janela.
      setLayout(new FlowLayout()); // Define o layout como FlowLayout, organizando os componentes um ao lado do outro.

      // Configura o campo de texto e define a fonte padrão.
      textField = new JTextField("Watch the font style change", 20); // Cria o campo de texto com 20 colunas.
      textField.setFont(new Font("Serif", Font.PLAIN, 14)); // Define a fonte inicial como "Serif", sem negrito ou itálico, com tamanho 14.
      add(textField); // Adiciona o campo de texto à janela.

      // Cria e adiciona as caixas de seleção (negrito e itálico) à janela.
      boldJCheckBox = new JCheckBox("Bold"); // Cria a caixa de seleção para negrito.
      italicJCheckBox = new JCheckBox("Italic"); // Cria a caixa de seleção para itálico.
      underlineJCheckBox = new JCheckBox("Underline"); // Cria a caixa de seleção para sublinhado.
      add(boldJCheckBox); // Adiciona a caixa de seleção de negrito à janela.
      add(italicJCheckBox); // Adiciona a caixa de seleção de itálico à janela.add(italicJCheckBox).
      add(underlineJCheckBox); // Adiciona a caixa de seleção de sublinhdo à janela.

      // Registra os ouvintes de eventos para as caixas de seleção.
      CheckBoxHandler handler = new CheckBoxHandler(); // Cria um manipulador de eventos.
      boldJCheckBox.addItemListener(handler); // Associa o manipulador à caixa de seleção de negrito.
      italicJCheckBox.addItemListener(handler); // Associa o manipulador à caixa de seleção de itálico.
      underlineJCheckBox.addItemListener(handler); // Associa o manipulador à caixa de seleção de sublinado.
   }

   // Classe interna privada que implementa o ItemListener para tratar eventos de mudança nas caixas de seleção.
   private class CheckBoxHandler implements ItemListener {
      // Método chamado quando o estado de uma caixa de seleção muda.
      @Override
      public void itemStateChanged(ItemEvent event) {
         Font font = null; // Declara uma variável para armazenar a nova fonte.

         // Verifica quais caixas de seleção estão marcadas e ajusta a fonte conforme necessário.
         if (boldJCheckBox.isSelected() && italicJCheckBox.isSelected()) // Se ambas as caixas estiverem marcadas:
            font = new Font("Serif", Font.BOLD + Font.ITALIC, 14); // Define a fonte como negrito + itálico.
         else if (boldJCheckBox.isSelected()) // Se apenas a caixa de negrito estiver marcada:
            font = new Font("Serif", Font.BOLD, 14); // Define a fonte como negrito.
         else if (italicJCheckBox.isSelected()) // Se apenas a caixa de itálico estiver marcada:
            font = new Font("Serif", Font.ITALIC, 14); // Define a fonte como itálico.
         else // Se nenhuma caixa estiver marcada:
            font = new Font("Serif", Font.PLAIN, 14); // Define a fonte como padrão (sem negrito ou itálico).  
         
         // Aplica a nova fonte ao campo de texto.
         textField.setFont(font);  
         
         if(underlineJCheckBox.isSelected()) {
         font = textField.getFont();
         Map attributes = font.getAttributes(); 
         attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
         textField.setFont(font.deriveFont(attributes));
         font = new Font(attributes);

      }
      
     }
  }
} // Fim da classe CheckBoxFrame.
