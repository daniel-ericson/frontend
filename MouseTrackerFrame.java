import java.awt.*; // Importa todos os componentes do módulo AWT da biblioteca Java.
import java.awt.event.*; // Importa todos os componentes de eventos do módulo AWT.
import javax.swing.*; // Importa todos os componentes do módulo Swing da biblioteca javax.

public class MouseTrackerFrame extends JFrame {
   private final JPanel mousePanel; // Painel onde os eventos do mouse ocorrem.
   private final JLabel statusBar; // Barra de status que exibe informações sobre eventos.

   // Construtor de MouseTrackerFrame configura a interface gráfica e registra os manipuladores de eventos do mouse.
   public MouseTrackerFrame() {
      super("Demonstrating Mouse Events"); // Define o título da janela.

      mousePanel = new JPanel(); // Cria um novo JPanel.
      mousePanel.setBackground(Color.WHITE); // Define a cor de fundo do painel.
      add(mousePanel, BorderLayout.CENTER); // Adiciona o painel ao centro do JFrame.

      statusBar = new JLabel("Mouse outside JPanel"); // Cria a barra de status.
      add(statusBar, BorderLayout.SOUTH); // Adiciona a barra de status na parte inferior do JFrame.

      // Cria e registra o listener para eventos do mouse e movimento do mouse.
      MouseHandler handler = new MouseHandler(); 
      mousePanel.addMouseListener(handler); // Adiciona o MouseListener ao painel.
      mousePanel.addMouseMotionListener(handler); // Adiciona o MouseMotionListener ao painel.
   } 

   // Classe interna para manipular eventos do mouse e movimento do mouse.
   private class MouseHandler implements MouseListener, MouseMotionListener {

      // Manipula o evento quando o mouse é clicado (pressionado e solto rapidamente).
      @Override
      public void mouseClicked(MouseEvent event) {
         statusBar.setText(String.format("Clicked at [left: %d, top: %d, right: %d, bottom: %d]", //[x,y] 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY())); // Atualiza a barra de status com as coordenadas do clique e mostra a distância o mause se encontra em relação aos seus eixos de origem.
      } 

      // Manipula o evento quando o mouse é pressionado.
      @Override
      public void mousePressed(MouseEvent event) {
         statusBar.setText(String.format("Pressed at [left: %d, top: %d, right: %d, bottom: %d]", //[x,y] 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY())); // Atualiza a barra de status com as coordenadas da pressão e mostra a distância o mause se encontra em relação aos seus eixos de origem.
      }

      // Manipula o evento quando o mouse é solto.
      @Override
      public void mouseReleased(MouseEvent event) {
         statusBar.setText(String.format("Released at [left: %d, top: %d, right: %d, bottom: %d]", //[x,y] 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY())); // Atualiza a barra de status com as coordenadas da liberação e mostra a distância o mause se encontra em relação aos seus eixos de origem.
      }

      // Manipula o evento quando o mouse entra na área do painel.
      @Override
      public void mouseEntered(MouseEvent event) {
         statusBar.setText(String.format("Mouse entered at [left: %d, top: %d, right: %d, bottom: %d]", //[x,y] 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY())); // Atualiza a barra de status com as coordenadas da entrada e mostra a distância o mause se encontra em relação aos seus eixos de origem.
         mousePanel.setBackground(Color.GREEN); // Altera a cor de fundo do painel para verde.
      }

      // Manipula o evento quando o mouse sai da área do painel.
      @Override
      public void mouseExited(MouseEvent event) {
         statusBar.setText("Mouse outside JPanel"); // Atualiza a barra de status para indicar que o mouse está fora do painel.
         mousePanel.setBackground(Color.WHITE); // Altera a cor de fundo do painel para branco.
      }

      // Manipula o evento quando o usuário arrasta o mouse com o botão pressionado.
      @Override
      public void mouseDragged(MouseEvent event) {
         statusBar.setText(String.format("Dragged at [left: %d, top: %d, right: %d, bottom: %d]", //[x,y] 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY())); // Atualiza a barra de status com as coordenadas do arrasto e mostra a distância o mause se encontra em relação aos seus eixos de origem.
      } 
      
      // Manipula o evento quando o usuário move o mouse.
      @Override
      public void mouseMoved(MouseEvent event) {
         statusBar.setText(String.format("Moved at [left: %d, top: %d, right: %d, bottom: %d]", //[x,y] 
            event.getX(), event.getY(), mousePanel.getWidth() - event.getX(), mousePanel.getHeight() - event.getY())); // Atualiza a barra de status com as coordenadas do movimento e mostra a distância o mause se encontra em relação aos seus eixos de origem.
      } 
   } // Fim da classe interna MouseHandler.
} // Fim da classe MouseTrackerFrame.