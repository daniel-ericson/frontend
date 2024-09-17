import java.awt.*; // Importa todos os componentes do módulo AWT.
import java.awt.event.*; // Importa todos os componentes de eventos.
import javax.swing.*; // Importa todos os componentes do módulo SWING. 

public class MenuFrame extends JFrame // Classe MenuFrame que herda de JFrame.
{
   // Define as cores que serão usadas no menu de cores.
   private final Color[] colorValues = 
      {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN};   
   
   private final JRadioButtonMenuItem[] colorItems; // Itens do menu de cores (botão).
   private final JRadioButtonMenuItem[] fonts; // Itens do menu de fontes (botão).
   private final JCheckBoxMenuItem[] styleItems; // Itens do menu de estilo de fonte (caixas de seleção).
   private final JLabel displayJLabel; // Rótulo que exibirá o texto de exemplo.
   private final ButtonGroup fontButtonGroup; // Gerencia os itens do menu de fontes.
   private final ButtonGroup colorButtonGroup; // Gerencia os itens do menu de cores.
   private int style; // Variável que guarda o estilo da fonte (negrito, itálico).

   // Construtor sem argumentos para configurar a GUI.
   public MenuFrame()
   {
      super("Using JMenus"); // Define o título da janela.

      // Cria o menu "File".
      JMenu fileMenu = new JMenu("File"); 
      fileMenu.setMnemonic('F'); // Define a tecla de atalho 'F' para o menu.

      // Cria o item de menu "About...".
      JMenuItem aboutItem = new JMenuItem("About...");
      aboutItem.setMnemonic('A'); // Define a tecla de atalho 'A' para o item.
      fileMenu.add(aboutItem); // Adiciona o item "About" ao menu "File".
      
      // Define a ação para o item "About".
      aboutItem.addActionListener(
         new ActionListener() // Classe interna.
         {  
            // Mostra uma mensagem quando o usuário seleciona "About...".
            @Override
            public void actionPerformed(ActionEvent event)
            {
               JOptionPane.showMessageDialog(MenuFrame.this,
                  "This is an example\nof using menus", // Mensagem exibida.
                  "About", JOptionPane.PLAIN_MESSAGE); // Título e tipo da mensagem.
            } 
         } 
      ); 
 
      // Cria o item de menu "Exit".
      JMenuItem exitItem = new JMenuItem("Exit");
      exitItem.setMnemonic('x'); // Define a tecla de atalho 'x' para o item.
      fileMenu.add(exitItem); // Adiciona o item "Exit" ao menu "File".
      
      // Define a ação para o item "Exit".
      exitItem.addActionListener(
         new ActionListener() // Classe interna.
         {  
            // Finaliza a aplicação quando o usuário clica em "Exit".
            @Override
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0); // Sai da aplicação.
            } 
         }
      ); 

      JMenuBar bar = new JMenuBar(); // Cria a barra de menus.
      setJMenuBar(bar); // Adiciona a barra de menus à aplicação.
      bar.add(fileMenu); // Adiciona o menu "File" à barra de menus.

      JMenu formatMenu = new JMenu("Format"); // Cria o menu "Format".
      formatMenu.setMnemonic('r'); // Define a tecla de atalho 'r' para o menu.

      // Array que lista os nomes das cores.
      String[] colors = {"Black", "Blue", "Red", "Green"};

      JMenu colorMenu = new JMenu("Color"); // Cria o menu "Color".
      colorMenu.setMnemonic('C'); // Define a tecla de atalho 'C' para o menu.

      // Cria os itens de menu (botão) para as cores.
      colorItems = new JRadioButtonMenuItem[colors.length];
      colorButtonGroup = new ButtonGroup(); // Gerencia os botão de cores.
      ItemHandler itemHandler = new ItemHandler(); // Manipulador de eventos para cores.

      // Cria os itens de menu de cores (botão).
      for (int count = 0; count < colors.length; count++) 
      {
         colorItems[count] = 
            new JRadioButtonMenuItem(colors[count]); // Cria item de cor.
         colorMenu.add(colorItems[count]); // Adiciona o item ao menu de cores.
         colorButtonGroup.add(colorItems[count]); // Adiciona o item ao grupo de botões.
         colorItems[count].addActionListener(itemHandler); // Adiciona o manipulador de eventos.
      }

      colorItems[0].setSelected(true); // Seleciona o primeiro item de cor por padrão.

      formatMenu.add(colorMenu); // Adiciona o menu de cores ao menu "Format".
      formatMenu.addSeparator(); // Adiciona um separador no menu.

      // Variaveis que lista os nomes das fontes.
      String[] fontNames = {"Serif", "Monospaced", "SansSerif"};
      JMenu fontMenu = new JMenu("Font"); // Cria o menu "Font".
      fontMenu.setMnemonic('n'); // Define a tecla de atalho 'n' para o menu.
      
      // Cria os itens de menu (botão) para as fontes.
      fonts = new JRadioButtonMenuItem[fontNames.length];
      fontButtonGroup = new ButtonGroup(); // Gerencia os botões de rádio de fontes.

      // Cria os itens de menu de fontes (botão).
      for (int count = 0; count < fonts.length; count++) 
      {
         fonts[count] = new JRadioButtonMenuItem(fontNames[count]); // Cria item de fonte.
         fontMenu.add(fonts[count]); // Adiciona o item ao menu de fontes.
         fontButtonGroup.add(fonts[count]); // Adiciona o item ao grupo de botões.
         fonts[count].addActionListener(itemHandler); // Adiciona o manipulador de eventos.
      } 

      fonts[0].setSelected(true); // Seleciona o primeiro item de fonte por padrão.
      fontMenu.addSeparator(); // Adiciona um separador ao menu de fontes.

      // Nomes dos estilos de fonte.
      String[] styleNames = {"Bold", "Italic"};
      styleItems = new JCheckBoxMenuItem[styleNames.length]; // Cria as caixas de seleção para os estilos.
      StyleHandler styleHandler = new StyleHandler(); // Manipulador de eventos para estilos.

      // Cria as caixas de seleção para os estilos.
      for (int count = 0; count < styleNames.length; count++) 
      {
         styleItems[count] = 
            new JCheckBoxMenuItem(styleNames[count]); // Cria item de estilo.
         fontMenu.add(styleItems[count]); // Adiciona o item ao menu de fontes.
         styleItems[count].addItemListener(styleHandler); // Adiciona o manipulador de eventos.
      }

      formatMenu.add(fontMenu); // Adiciona o menu de fontes ao menu "Format".
      bar.add(formatMenu); // Adiciona o menu "Format" à barra de menus.
     
      // Configura o rótulo para exibir o texto de exemplo.
      displayJLabel = new JLabel("Sample Text", SwingConstants.CENTER); // Centraliza o texto.
      displayJLabel.setForeground(colorValues[0]); // Define a cor inicial do texto (preto).
      displayJLabel.setFont(new Font("Serif", Font.PLAIN, 72)); // Define a fonte inicial.

      getContentPane().setBackground(Color.CYAN); // Define a cor de fundo da janela.
      add(displayJLabel, BorderLayout.CENTER); // Adiciona o rótulo ao centro da janela.
   } // Fim do construtor MenuFrame.

   // Classe interna para manipular eventos de ação dos itens de menu.
   private class ItemHandler implements ActionListener 
   {
      // Processa as seleções de cor e fonte.
      @Override
      public void actionPerformed(ActionEvent event)
      {
         // Processa a seleção de cor.
         for (int count = 0; count < colorItems.length; count++)
         {
            if (colorItems[count].isSelected()) // Se o item de cor estiver selecionado. 
            {
               displayJLabel.setForeground(colorValues[count]); // Altera a cor do texto.
               break;
            } 
         } 

         // Processa a seleção de fonte.
         for (int count = 0; count < fonts.length; count++)
         {
            if (event.getSource() == fonts[count]) // Objeto do "click". 
            {
               displayJLabel.setFont(
                  new Font(fonts[count].getText(), style, 72)); // Altera a fonte do texto.
            }
         }
         repaint(); // Redesenha a aplicação.
      } 
   } // Fim da classe ItemHandler.

   // Classe interna para manipular eventos de item das caixas de seleção de estilo.
   private class StyleHandler implements ItemListener 
   {
      // Processa as seleções de estilo de fonte.
      @Override
      public void itemStateChanged(ItemEvent e)
      {
         String name = displayJLabel.getFont().getName(); // Obtém o nome da fonte atual.
         Font font; // Fonte nova baseada nas seleções do usuário.

         // Verifica quais caixas de seleção estão marcadas e cria a fonte correspondente.
         if (styleItems[0].isSelected() && 
              styleItems[1].isSelected())
            font = new Font(name, Font.BOLD + Font.ITALIC, 72); // Atribui negrito e itálico.
         else if (styleItems[0].isSelected())
            font = new Font(name, Font.BOLD, 72); // Atribui apenas negrito.
         else if (styleItems[1].isSelected())
            font = new Font(name, Font.ITALIC, 72); // Atribui apenas itálico.
         else
            font = new Font(name, Font.PLAIN, 72); // Estilo normal.

         displayJLabel.setFont(font); // Aplica a nova fonte ao texto.
         repaint(); // Redesenha a aplicação.
      } 
   } // Fim da classe StyleHandler.
} // Fim da classe MenuFrame.
