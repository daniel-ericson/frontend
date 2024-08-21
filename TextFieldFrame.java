
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextFieldFrame extends JFrame 
{
   private final JTextField textField1; 
   private final JTextField textField2;
   private final JTextField textField3; 
   private final JPasswordField passwordField;


   public TextFieldFrame()
   {
      super("Testing JTextField and JPasswordField");
      setLayout(new FlowLayout());

      // construtor do campo1 de escrita
      textField1 = new JTextField(10); //definição de variavel textField1 que atrinui o parâmetro de tamanho de  JTextField
      add(textField1); // adiciona o textField1 a tela de exibução JFrame

      // construtor do campo 2 de escrita
      textField2 = new JTextField("Enter your text here now"); //definição de variavel textField2 que atrinui o parâmetro de texto em  JTextField
      add(textField2); // adiciona o textField2 a tela de exibução JFrame

      // construtor do campo 3 de escrita
      textField3 = new JTextField("Uneditable text field", 21);//definição de variavel textField3 que atrinui o parâmetro de texto e um tamanho  em JTextField
      textField3.setEditable(false); // impedindo a edição do texto  
      add(textField3); // adiciona o textField3 a tela de exibução JFrame

      // construtor do campo de escrita "tipo senha"
      passwordField = new JPasswordField("Hidden text"); //definição de variavel passawordField que atrinui o parâmetro de texto em  JPasswordField que não exibe o texto 
      add(passwordField); // adiciona o passwordField a tela de exibução JFrame

      // registros dos eventos 
      TextFieldHandler handler = new TextFieldHandler();
      textField1.addActionListener(handler); // novo manipulador de entrada de texto para campo 1 
      textField2.addActionListener(handler);// novo manipulador de entrada de texto para campo 2 
      textField3.addActionListener(handler);// novo manipulador de entrada de texto para campo 3
      passwordField.addActionListener(handler);// novo manipulador de entrada de texto para campo "senha" 
   } 

   private class TextFieldHandler implements ActionListener 
   {

      @Override
      public void actionPerformed(ActionEvent event)
      {
         String string = ""; 
       
         if (event.getSource() == textField1) // event invoca do metodo getSource e compara com a variavel textField1
            string = String.format("textField1: %s", // formata o a variavel com o tipo string 
               event.getActionCommand());

       
         else if (event.getSource() == textField2)
            string = String.format("textField2: %s",
               event.getActionCommand()); //captura texto que está dentro do imput

       
         else if (event.getSource() == textField3)
            string = String.format("textField3: %s", 
               event.getActionCommand());

         
         else if (event.getSource() == passwordField)
            string = String.format("passwordField: %s", 
               event.getActionCommand()); // captura o texto (valor) que está dentro do imput (objeto)

         
         JOptionPane.showMessageDialog(null, string); 
      } // final de subclasse
   } // final do bloco de código da classe privada TextFieldHandler
} // final classe TextFieldFrame

/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
