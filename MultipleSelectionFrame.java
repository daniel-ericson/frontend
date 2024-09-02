import java.awt.*; // Importa todos os componentes do módulo AWT da biblioteca Java.
import java.awt.event.*; // Importa todos os componentes de eventos do módulo AWT.
import javax.swing.*; // Importa todos os componentes do módulo Swing da biblioteca javax.

public class MultipleSelectionFrame extends JFrame 
{
   private final JList<String> colorJList; // Lista para armazenar os nomes das cores.
   private final JList<String> copyJList; // Lista para armazenar os nomes copiados.
   private final JList<String> copyJList2; // Lista para armazenar os nomes copiados da segunda lista.

   private JButton copyJButton; // Botão para copiar os nomes selecionados.
   private JButton copyJButton2; // Botão para copiar os nomes selecionados da segunda lista.
   private static final String[] colorNames = {"Black", "Blue", "Cyan", 
      "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", 
      "Pink", "Red", "White", "Yellow"}; // Lista com os nomes das cores.

   // Construtor da classe MultipleSelectionFrame
   public MultipleSelectionFrame()
   {
      super("Multiple Selection Lists"); // Define o título da janela.
      setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout.

      colorJList = new JList<String>(colorNames); // Cria a lista com os nomes das cores.
      colorJList.setVisibleRowCount(5); // Define para exibir 5 linhas visíveis.
      colorJList.setSelectionMode(
         ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // Permite a seleção múltipla na lista.
      add(new JScrollPane(colorJList)); // Adiciona um JScrollPane contendo a lista ao JFrame.

      copyJButton = new JButton("Copy >>>"); // Cria o botão de cópia.
      copyJButton.addActionListener(
         new ActionListener() // Classe interna para tratar eventos de clique.
         {  
            // Trata eventos de clique no botão de cópia.
            @Override
            public void actionPerformed(ActionEvent event)
            {
               // Copia os valores selecionados de colorJList para copyJList.
               copyJList.setListData(
                  colorJList.getSelectedValuesList().toArray(
                     new String[0]));
            }
         } 
      ); 
      add(copyJButton); // Adiciona o botão de cópia ao JFrame.

      copyJList = new JList<String>(); // Cria a lista para armazenar os nomes copiados.
      copyJList.setVisibleRowCount(5); // Define para exibir 5 linhas visíveis.
      copyJList.setFixedCellWidth(100); // Define a largura fixa das células da lista.
      copyJList.setFixedCellHeight(15); // Define a altura fixa das células da lista.
      copyJList.setSelectionMode(
         ListSelectionModel.SINGLE_INTERVAL_SELECTION); // Permite a seleção única na lista.
      add(new JScrollPane(copyJList)); // Adiciona um JScrollPane contendo a lista copiada ao JFrame.

      copyJButton2 = new JButton("Copy >>>"); // Cria o botão de cópia.
      copyJButton2.addActionListener(
         new ActionListener() // Classe interna para tratar eventos de clique.
         {  
            // Trata eventos de clique no botão de cópia.
            @Override
            public void actionPerformed(ActionEvent event)
            {
               // Copia os valores selecionados de copyJList para copyJList2.
               copyJList2.setListData(
                  copyJList.getSelectedValuesList().toArray(
                     new String[0]));
            }
         } 
      ); 
      add(copyJButton2); // Adiciona o botão de cópia ao JFrame.

      copyJList2 = new JList<String>(); // Cria a lista para armazenar os nomes copiados.
      copyJList2.setVisibleRowCount(5); // Define para exibir 5 linhas visíveis.
      copyJList2.setFixedCellWidth(100); // Define a largura fixa das células da lista.
      copyJList2.setFixedCellHeight(15); // Define a altura fixa das células da lista.
      copyJList2.setSelectionMode(
         ListSelectionModel.SINGLE_INTERVAL_SELECTION); // Permite a seleção única na lista.
      add(new JScrollPane(copyJList2)); // Adiciona um JScrollPane contendo a lista copiada ao JFrame.
   } 
} // Fim da classe MultipleSelectionFrame
