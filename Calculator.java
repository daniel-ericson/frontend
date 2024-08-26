import java.awt.*; // Importa uma ferramenta para organizar a tela como uma grade (linhas e colunas)
//import java.awt.event.ActionEvent; // Importa a ferramenta que "entende" quando algo acontece (tipo um clique)
import java.awt.event.*; // Importa algo que "ouve" e responde quando o botão é clicado
import java.util.*; // Importa uma lista onde podemos guardar várias coisas (como letras ou números)
import javax.swing.*; // Importa um botão para clicar
//import javax.swing.JFrame; // Importa a janela onde vai ficar nossa calculadora
//import javax.swing.JLabel; // Importa o texto que aparece na tela (rótulos)
//import javax.swing.JTextField; // Importa a caixinha onde você vai digitar os números
//import javax.swing.SwingConstants; // Importa algo para ajudar a alinhar o texto dos rótulos

// Aqui está a nossa calculadora
public class Calculator extends JFrame {
   // Duas caixinhas onde a gente vai digitar os números
   private final JTextField textField1;
   private final JTextField textField2;

   // Esses rótulos explicam o que as caixinhas fazem
   private final JLabel label1;
   private final JLabel label2;

   // Um botão para fazer a conta e uma área para mostrar o resultado ou mensagens
   private final JButton btnCalcular;
   private final JLabel lblNotificacao;

   // Lista que guarda os números de 0 a 9
   private final String[] numeros = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

   // Aqui é o construtor, onde a gente "monta" nossa calculadora
   public Calculator() 
   {
      super("Calculadora de soma"); // Dá um nome à nossa janela
      setLayout(new GridLayout(3, 2, 5, 5)); // Organiza a tela em 3 linhas e 2 colunas, com espaços entre elas

      // Configura o rótulo e a caixinha para o primeiro número
      label1 = new JLabel("Digite o primeiro número:", SwingConstants.RIGHT); // Alinha o texto à direita
      add(label1);
      textField1 = new JTextField(10); // Caixinha para digitar o primeiro número, com largura de 10
      add(textField1);

      // Configura o rótulo e a caixinha para o segundo número
      label2 = new JLabel("Digite o segundo número:", SwingConstants.RIGHT); // Alinha o texto à direita
      add(label2);
      textField2 = new JTextField(10); // Caixinha para digitar o segundo número, com largura de 10
      add(textField2);

      // Configura o botão de calcular e onde o resultado ou mensagem vão aparecer
      btnCalcular = new JButton("Calcular"); // Cria o botão para fazer a conta
      add(btnCalcular);
      lblNotificacao = new JLabel("Resultado:"); // Área onde o resultado vai aparecer
      add(lblNotificacao);

      // Diz para o botão o que fazer quando for clicado
      TextFieldHandler handler = new TextFieldHandler();
      btnCalcular.addActionListener(handler); // Conecta o "ouvinte" para o botão

      textField1.addKeyListener(new KeyAdapter() {
         @Override
         public void keyReleased (KeyEvent e) {
            if(textField1.getText().length() > 9) {
               String txtField1 = textField1.getText();
               textField1.setText(txtField1.substring(0,9)); 
               lblNotificacao.setText("Ops! Este campo está limitado a apenas 9 caracteres.");
            }
         }
      });

      textField2.addKeyListener(new KeyAdapter() {
         @Override
         public void keyReleased (KeyEvent e) {
            if(textField2.getText().length() > 9) {
               String txtField2 = textField2.getText();
               textField2.setText(txtField2.substring(0,9)); 
               lblNotificacao.setText("Ops! Este campo está limitado a apenas 9 caracteres.");
            }
         }
      });
   }

   // Essa parte é para "ouvir" quando o botão é clicado 
   private class TextFieldHandler implements ActionListener 
   {
      @Override
      public void actionPerformed(ActionEvent event) 
      {
         // Verifica se a primeira caixinha está vazia
         if (textField1.getText().trim().length() == 0) 
         {
            lblNotificacao.setText("O campo 1 está vazio!"); // Diz para o usuário que ele esqueceu de preencher
            textField1.requestFocus(); // Coloca o cursor de volta na caixinha
         } else {
            // Verifica se a segunda caixinha está vazia
            if (textField2.getText().trim().length() == 0) {
               lblNotificacao.setText("O campo 2 está vazio!"); // Diz para o usuário que ele esqueceu de preencher
               textField2.requestFocus(); // Coloca o cursor de volta na caixinha
            } else {
               // Aqui a soma acontece 
               try {
                  // Pega os números das caixinhas e soma
                  textField1.setText(somenteNumeros(textField1.getText()));
                  textField2.setText(somenteNumeros(textField2.getText()));
                  int soma = Integer.valueOf(textField1.getText()) + Integer.valueOf(textField2.getText());
                  lblNotificacao.setText(String.format("Resultado: %s", soma)); // Mostra o resultado
               } catch (Exception e) {
                  // Caso o usuário tenha digitado algo errado (como letras), aparece essa mensagem
                  lblNotificacao.setText("<html><body>Ops! Parece que algo foi digitado errado. Digite apenas números inteiros.<html><body>");
               }
            }
         }
      }

      // Essa parte filtra e remove qualquer coisa que não seja número nas caixinhas
      public String somenteNumeros(String strTexto) {
         boolean achouNumero; // Variável para ver se encontrou um número
         ArrayList<String> caracteresEncontrados = new ArrayList<String>(); // Lista para guardar letras ou símbolos não numéricos

         // Verifica cada letra na caixinha
         for (int c = 0; c < strTexto.length(); c++) {
            String caracterTemp = strTexto.substring(c, c + 1);
            achouNumero = false;

            // Compara cada letra com os números permitidos (0 a 9)
            for (int n = 0; n < numeros.length; n++) {
               if (caracterTemp.equals(numeros[n])) {
                  achouNumero = true; // Se for número, marca como encontrado e sai
                  break;
               }
            }

            // Se não for número, coloca na lista para remover
            if (achouNumero) {
               continue;
            }else{
               caracteresEncontrados.add(caracterTemp);
            }
         }

         // Remove os caracteres que não são números
         for (int c = 0; c < caracteresEncontrados.size(); c++) {
            strTexto = strTexto.replace(caracteresEncontrados.get(c), ""); // Troca letras ou símbolos por nada (remove)
         }
         return strTexto;
      }
   }

   // Aqui é onde o programa começa a rodar
   public static void main(String[] args) 
   {  
      Calculator calculator = new Calculator(); // Cria uma nova calculadora
      calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa quando clicar no "X"
      calculator.setSize(500, 180); // Define o tamanho da janela
      calculator.setVisible(true); // Torna a janela visível
   }
}
