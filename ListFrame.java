import java.awt.*; // Importa todo o módulo awt da biblioteca java.
import javax.swing.*; // Importa todo o módulo swing da biblioteca javax.
import javax.swing.event.*; //Importa todo o componete event do módulo swing da biblioteca javax.

public class ListFrame extends JFrame 

{
   // JList para exibir as cores.
   private final JList<String> colorJList; 

   // Lista com os nomes das cores
   private static final String[] colorNames = {
      "Black", "Blue", "Cyan", "Dark Gray", "Gray", 
      "Green", "Light Gray", "Magenta", "Orange", 
      "Pink", "Red", "White", "Yellow"};
      private static final Color[] colors = {// Lista com os objetos Color correspondentes às cores.
      Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, 
      Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, 
      Color.MAGENTA, Color.ORANGE, Color.PINK, 
      Color.RED, Color.WHITE, Color.YELLOW};

      private final JList<String> sizeJList;
      private static final String[] sizeNames = {"Small", "Medium", "Big"}; // Lista com os objetos com os tamanhos correspondentes aos momes.

   // Construtor da classe ListFrame, que adiciona um JScrollPane contendo um JList ao JFrame.
   public ListFrame()
   {
      super("List Test"); // Define o título da janela.
      setLayout(new FlowLayout()); // Define o layout da nova janela FlowLayout (responsivo).

      // Cria um novo objeto JList com os nomes das cores.
      colorJList = new JList<String>(colorNames); 
      colorJList.setVisibleRowCount(5); // Exibe cinco linhas de uma vez na lista.

      // Configura a lista para permitir apenas uma seleção por vez.
      colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      // Adiciona um JScrollPane contendo o JList ao JFrame.
      add(new JScrollPane(colorJList));

      sizeJList = new JList<String>(sizeNames);
      sizeJList.setVisibleRowCount(5);
      sizeJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      add(new JScrollPane(sizeJList));

      // Adiciona um listener para eventos de seleção na lista.
      colorJList.addListSelectionListener(
         new ListSelectionListener() // Classe interna para tratar eventos.
         {   
            // Trata eventos de seleção na lista.
            @Override
            public void valueChanged(ListSelectionEvent event) // Método para a exibição.
            {
               // Muda a cor de fundo da janela para a cor selecionada na lista.
               getContentPane().setBackground(
                  colors[colorJList.getSelectedIndex()]);
            } 
         } 
      ); 
      sizeJList.addListSelectionListener(
         new ListSelectionListener() // Classe interna para tratar eventos.
         {   
            // Trata eventos de seleção na lista para a mudança de tamanho.
            @Override
            public void valueChanged(ListSelectionEvent event) // Método para a exibição da janela.
            {
               // Muda o tamanho de fundo da janela para a seção selecionada na lista.
               switch (sizeJList.getSelectedIndex()) {
                  case 0:
                  setSize (350,150);
                  break;
                  
                  case 1:
                  setSize (550,350);
                  break;

                  case 2:
                  setSize (750,550);
                  break;

                  default:
                  setSize (350,150);
                  break;
               }
            } 
         } 
      ); 
   }
} 
