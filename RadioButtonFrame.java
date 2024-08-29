
import java.awt.Color; // Importa a classe Color para definir cores.
import java.awt.FlowLayout; // Importa FlowLayout para o layout dos componentes.
import java.awt.Font; // Importa a classe Font para definir estilos de fonte.
import java.awt.event.ItemEvent; // Importa ItemEvent para eventos de seleção.
import java.awt.event.ItemListener; // Importa ItemListener para ouvir eventos de seleção.


import javax.swing.ButtonGroup; // Importa ButtonGroup para agrupar botões de rádio.
import javax.swing.JFrame; // Importa JFrame para criar a janela.
import javax.swing.JRadioButton; // Importa JRadioButton para criar botões de rádio.
import javax.swing.JTextField; // Importa JTextField para exibir e editar texto.


public class RadioButtonFrame extends JFrame {
    private JTextField textField; // Campo de texto usado para exibir e modificar o texto.
    private Font plainFont; // Fonte para o estilo de texto simples.
    private Font boldFont; // Fonte para o estilo de texto em negrito.
    private Font italicFont; // Fonte para o estilo de texto em itálico.
    private Font boldItalicFont; // Fonte para o estilo de texto em negrito e itálico.


    private Color blueColor; // Cor azul.
    private Color redColor; // Cor vermelha.
    private Color yellowColor; // Cor amarela.
    private Color blackColor; // Cor preta.


    private JRadioButton plainJRadioButton; // Botão de rádio para texto simples.
    private JRadioButton boldJRadioButton; // Botão de rádio para texto em negrito.
    private JRadioButton italicJRadioButton; // Botão de rádio para texto em itálico.
    private JRadioButton boldItalicJRadioButton; // Botão de rádio para texto em negrito e itálico.
    private ButtonGroup radioGroup; // Grupo de botões para estilos de fonte.


    private JRadioButton blueJRadioButton; // Botão de rádio para cor azul.
    private JRadioButton redJRadioButton; // Botão de rádio para cor vermelha.
    private JRadioButton yellowJRadioButton; // Botão de rádio para cor amarela.
    private JRadioButton blackJRadioButton; // Botão de rádio para cor preta.
    private ButtonGroup colorRadioGroup; // Grupo de botões para cores.


    // Construtor da classe RadioButtonFrame que adiciona JRadioButtons ao JFrame.
    public RadioButtonFrame() {
        super("RadioButton Test"); // Define o título da janela.
        setLayout(new FlowLayout()); // Define o layout da janela como FlowLayout.


        textField = new JTextField("Watch the font style change", 25); // Cria o campo de texto com uma mensagem inicial.
        add(textField); // Adiciona o campo de texto ao JFrame.


        // Cria os botões de rádio para seleção de estilo de fonte.
        plainJRadioButton = new JRadioButton("Plain", true); // Botão para fonte simples, selecionado por padrão.
        boldJRadioButton = new JRadioButton("Bold", false); // Botão para fonte em negrito.
        italicJRadioButton = new JRadioButton("Italic", false); // Botão para fonte em itálico.
        boldItalicJRadioButton = new JRadioButton("Bold/Italic", false); // Botão para fonte em negrito e itálico.


        add(plainJRadioButton); // Adiciona o botão de fonte simples ao JFrame.
        add(boldJRadioButton); // Adiciona o botão de fonte em negrito ao JFrame.
        add(italicJRadioButton); // Adiciona o botão de fonte em itálico ao JFrame.
        add(boldItalicJRadioButton); // Adiciona o botão de fonte em negrito e itálico ao JFrame.


        // Cria os botões de rádio para seleção de cor.
        blueJRadioButton = new JRadioButton("Azul", false); // Botão para cor azul.
        redJRadioButton = new JRadioButton("Vermelho", false); // Botão para cor vermelha.
        yellowJRadioButton = new JRadioButton("Amarelo", false); // Botão para cor amarela.
        blackJRadioButton = new JRadioButton("Preto", true); // Botão para cor preta, selecionado por padrão.


        add(blueJRadioButton); // Adiciona o botão de cor azul ao JFrame.
        add(redJRadioButton); // Adiciona o botão de cor vermelha ao JFrame.
        add(yellowJRadioButton); // Adiciona o botão de cor amarela ao JFrame.
        add(blackJRadioButton); // Adiciona o botão de cor preta ao JFrame.


        // Criação de grupos de botões para organizar os botões de estilo de fonte.
        radioGroup = new ButtonGroup(); // Cria um grupo para os botões de estilo de fonte.
        radioGroup.add(plainJRadioButton); // Adiciona o botão de fonte simples ao grupo.
        radioGroup.add(boldJRadioButton); // Adiciona o botão de fonte em negrito ao grupo.
        radioGroup.add(italicJRadioButton); // Adiciona o botão de fonte em itálico ao grupo.
        radioGroup.add(boldItalicJRadioButton); // Adiciona o botão de fonte em negrito e itálico ao grupo.


        // Criação de grupos de botões para organizar os botões de cor.
        colorRadioGroup = new ButtonGroup(); // Cria um grupo para os botões de cor.
        colorRadioGroup.add(blueJRadioButton); // Adiciona o botão de cor azul ao grupo.
        colorRadioGroup.add(redJRadioButton); // Adiciona o botão de cor vermelha ao grupo.
        colorRadioGroup.add(yellowJRadioButton); // Adiciona o botão de cor amarela ao grupo.
        colorRadioGroup.add(blackJRadioButton); // Adiciona o botão de cor preta ao grupo.


        // Criação dos objetos de fonte.
        plainFont = new Font("Serif", Font.PLAIN, 14); // Fonte para texto simples.
        boldFont = new Font("Serif", Font.BOLD, 14); // Fonte para texto em negrito.
        italicFont = new Font("Serif", Font.ITALIC, 14); // Fonte para texto em itálico.
        boldItalicFont = new Font("Serif", Font.BOLD + Font.ITALIC, 14); // Fonte para texto em negrito e itálico.
        textField.setFont(plainFont); // Define a fonte inicial do campo de texto como simples.


        // Criação dos objetos de cor.
        blueColor = new Color(0, 0, 255); // Define a cor azul.
        redColor = new Color(255, 0, 0); // Define a cor vermelha.
        yellowColor = new Color(255, 255, 0); // Define a cor amarela.
        blackColor = new Color(0, 0, 0); // Define a cor preta.


        // Registra eventos para os botões de estilo de fonte.
        plainJRadioButton.addItemListener(new RadioButtonHandler(plainFont)); // Associa o botão de fonte simples ao handler.
        boldJRadioButton.addItemListener(new RadioButtonHandler(boldFont)); // Associa o botão de fonte em negrito ao handler.
        italicJRadioButton.addItemListener(new RadioButtonHandler(italicFont)); // Associa o botão de fonte em itálico ao handler.
        boldItalicJRadioButton.addItemListener(new RadioButtonHandler(boldItalicFont)); // Associa o botão de fonte negrito e itálico ao handler.


        // Registra eventos para os botões de cor.
        blueJRadioButton.addItemListener(new ColorRadioButtonHandler(blueColor)); // Associa o botão de cor azul ao handler.
        redJRadioButton.addItemListener(new ColorRadioButtonHandler(redColor)); // Associa o botão de cor vermelha ao handler.
        yellowJRadioButton.addItemListener(new ColorRadioButtonHandler(yellowColor)); // Associa o botão de cor amarela ao handler.
        blackJRadioButton.addItemListener(new ColorRadioButtonHandler(blackColor)); // Associa o botão de cor preta ao handler.
    }


    // Classe interna privada para lidar com eventos dos botões de estilo de fonte.
    private class RadioButtonHandler implements ItemListener {
        private Font font; // Fonte associada a este listener.


        // Construtor que inicializa o handler com a fonte especificada.
        public RadioButtonHandler(Font f) {
            font = f; // Atribui a fonte ao handler.
        }


        // Método que trata eventos de mudança de estado dos botões de rádio.
        @Override
        public void itemStateChanged(ItemEvent event) {
            textField.setFont(font); // Altera a fonte do campo de texto para a fonte associada.
        }
    }


    // Classe interna privada para lidar com eventos dos botões de cor.
    private class ColorRadioButtonHandler implements ItemListener {
        private Color color; // Cor associada a este listener.


        // Construtor que inicializa o handler com a cor especificada.
        public ColorRadioButtonHandler(Color c) {
            color = c; // Atribui a cor ao handler.
        }


        // Método que trata eventos de mudança de estado dos botões de rádio.
        @Override
        public void itemStateChanged(ItemEvent event) {
            textField.setForeground(color); // Altera a cor do texto para a cor associada.
        }
    }
} // Fim da classe RadioButtonFrame
