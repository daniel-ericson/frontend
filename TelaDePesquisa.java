import java.awt.*; // Importa classes para a interface gráfica.
import java.awt.event.*; // Importa classes para tratamento de eventos.
import javax.swing.*; // Importa classes para componentes da interface gráfica.
// import java.sql.*; // Importação comentada para conexão com banco de dados.

public class TelaDePesquisa extends JFrame {
    // Declaração de componentes da interface.
    public static JLabel lblPesquisa; // Rótulo para a pesquisa.
    public static JTextField txtPesquisa; // Campo de texto para entrada da pesquisa.

    public static JLabel lblId; // Rótulo para o ID.
    public static JTextField txtId; // Campo de texto para exibição do ID.

    public static JLabel lblNome; // Rótulo para o Nome.
    public static JTextField txtNome; // Campo de texto para exibição do Nome.

    public static JLabel lblEmail; // Rótulo para o Email.
    public static JTextField txtEmail; // Campo de texto para exibição do Email.

    public static JButton btnPesquisar; // Botão para iniciar a pesquisa.
    public static JButton btnPrimeiro; // Botão para ir ao primeiro registro.
    public static JButton btnAnterior; // Botão para ir ao registro anterior.
    public static JButton btnProximo; // Botão para ir ao próximo registro.
    public static JButton btnUltimo; // Botão para ir ao último registro.

    public static JLabel lblNotificacoes; // Rótulo para mensagens de notificação.

    public static int tamanhoInputs = 20; // Define o tamanho dos campos de entrada.
    public static String txtUsuario = ""; // Armazena a entrada do usuário.

    public TelaDePesquisa() {
        super("Tela de Pesquisa"); // Define o título da janela.
        setLayout(new GridLayout(7, 1, 5, 5)); // Define o layout da tela.

        // Criação do painel para a linha de pesquisa.
        JPanel linha_lblPesquisa = new JPanel(new GridLayout(1, 2));
        lblPesquisa = new JLabel("Pesquisa:", SwingConstants.CENTER); // Rótulo de pesquisa.
        linha_lblPesquisa.add(lblPesquisa);

        // Botão de pesquisa.
        btnPesquisar = new JButton("🔍");
        btnPesquisar.setToolTipText("Pesquisar"); // Dica ao passar o mouse.
        btnPesquisar.setEnabled(false); // Botão inicialmente desabilitado.
        linha_lblPesquisa.add(btnPesquisar);
        add(linha_lblPesquisa); // Adiciona o painel à tela.

        // Criação do painel para a entrada da pesquisa.
        JPanel linha_inputPesquisa = new JPanel(new GridLayout(1, 1));
        txtPesquisa = new JTextField(tamanhoInputs); // Campo de texto para pesquisa.
        linha_inputPesquisa.add(txtPesquisa);
        add(linha_inputPesquisa); // Adiciona o painel à tela.

        // Criação do painel para exibir o ID.
        JPanel linha_id = new JPanel(new GridLayout(1, 2));
        lblId = new JLabel("Id:", SwingConstants.RIGHT); // Rótulo do ID.
        linha_id.add(lblId);
        txtId = new JTextField(tamanhoInputs); // Campo para ID.
        txtId.setEnabled(false); // Campo não editável.
        linha_id.add(txtId);
        add(linha_id); // Adiciona o painel à tela.

        // Criação do painel para exibir o Nome.
        JPanel linha_nome = new JPanel(new GridLayout(1, 2));
        lblNome = new JLabel("Nome:", SwingConstants.RIGHT); // Rótulo do Nome.
        linha_nome.add(lblNome);
        txtNome = new JTextField(tamanhoInputs); // Campo para Nome.
        txtNome.setEditable(false); // Campo não editável.
        linha_nome.add(txtNome);
        add(linha_nome); // Adiciona o painel à tela.

        // Criação do painel para exibir o Email.
        JPanel linha_email = new JPanel(new GridLayout(1, 2));
        lblEmail = new JLabel("Email:", SwingConstants.RIGHT); // Rótulo do Email.
        linha_email.add(lblEmail);
        txtEmail = new JTextField(10); // Campo para Email.
        txtEmail.setEditable(false); // Campo não editável.
        linha_email.add(txtEmail);
        add(linha_email); // Adiciona o painel à tela.

        // Criação do painel para os botões de navegação.
        JPanel linha_botoes = new JPanel(new GridLayout(1, 4));
        btnPrimeiro = new JButton("<<");
        btnPrimeiro.setEnabled(false); // Botão inicialmente desabilitado.
        linha_botoes.add(btnPrimeiro);

        btnAnterior = new JButton("<");
        btnAnterior.setEnabled(false); // Botão inicialmente desabilitado.
        linha_botoes.add(btnAnterior);

        btnProximo = new JButton(">");
        btnProximo.setEnabled(false); // Botão inicialmente desabilitado.
        linha_botoes.add(btnProximo);

        btnUltimo = new JButton(">>");
        btnUltimo.setEnabled(false); // Botão inicialmente desabilitado.
        linha_botoes.add(btnUltimo);
        add(linha_botoes); // Adiciona o painel à tela.

        // Criação do painel para mensagens de notificação.
        JPanel linha_notificacoes = new JPanel(new GridLayout(1, 1));
        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER); // Rótulo de notificações.
        linha_notificacoes.add(lblNotificacoes);
        add(linha_notificacoes); // Adiciona o painel à tela.

        // Adiciona ação ao botão de pesquisar.
        btnPesquisar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    // Verifica se o campo de pesquisa está vazio.
                    if (txtPesquisa.getText().trim().length() <= 0) {
                        lblNotificacoes.setText(setHtmlFormat("Por favor, digite algo e tente novamente.")); // Mensagem de erro.
                        txtPesquisa.requestFocus(); // Foca no campo de pesquisa.
                        return;
                    } else {
                        NavegadorDeRegistro.pesquisar(); // Chama o método de pesquisa.
                    }
                }
            }
        );

        // Adiciona ação ao botão de primeiro registro.
        btnPrimeiro.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (ntfCampoVazio() == false) { // Verifica se o campo de pesquisa não está vazio.
                        NavegadorDeRegistro.primeiroRegistro(); // Chama o método para ir ao primeiro registro.
                    }
                }
            }
        );

        // Adiciona ação ao botão de registro anterior.
        btnAnterior.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (ntfCampoVazio() == false) { // Verifica se o campo de pesquisa não está vazio.
                        NavegadorDeRegistro.registroAnterior(); // Chama o método para ir ao registro anterior.
                    }
                }
            }
        );

        // Adiciona ação ao botão de próximo registro.
        btnProximo.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (ntfCampoVazio() == false) { // Verifica se o campo de pesquisa não está vazio.
                        NavegadorDeRegistro.proximoRegistro(); // Chama o método para ir ao próximo registro.
                    }
                }
            }
        );

        // Adiciona ação ao botão de último registro.
        btnUltimo.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (ntfCampoVazio() == false) { // Verifica se o campo de pesquisa não está vazio.
                        NavegadorDeRegistro.ultimoRegistro(); // Chama o método para ir ao último registro.
                    }
                }
            }
        );

        // Adiciona um listener para o campo de pesquisa.
        txtPesquisa.addKeyListener(
            new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    // Verifica se o texto mudou e se o campo não está vazio.
                    if (txtPesquisa.getText().trim().equals(txtUsuario) == false && txtPesquisa.getText().trim().length() > 0) {
                        if (e.getKeyCode() == 10) { // Se a tecla Enter foi pressionada.
                            NavegadorDeRegistro.pesquisar(); // Chama o método de pesquisa.
                        }
                    } else {
                        limparCampos("Digite algo para continuar."); // Limpa os campos se a pesquisa estiver vazia.
                    }
                    btnPesquisar.setEnabled(true); // Habilita o botão de pesquisa.
                }
            }
        );

        // Configurações da janela.
        setSize(250, 300); // Define o tamanho da janela.
        setVisible(true); // Torna a janela visível.
        txtPesquisa.requestFocus(); // Foca no campo de pesquisa.
    }

    // Método para verificar se o campo de pesquisa está vazio.
    public static boolean ntfCampoVazio() {
        if (txtPesquisa.getText().trim().length() <= 0) {
            lblNotificacoes.setText(setHtmlFormat("Ops! Campo vazio. Por favor, digite algo e tente novamente.")); // Mensagem de erro.
            txtPesquisa.requestFocus(); // Foca no campo de pesquisa.
            return true; // Retorna verdadeiro se o campo está vazio.
        } else {
            return false; // Retorna falso se o campo não está vazio.
        }
    }

    // Método para limpar os campos de entrada.
    public static void limparCampos(String notificacao) {
        btnPesquisar.setEnabled(false); // Desabilita o botão de pesquisa.
        txtId.setText(""); // Limpa o campo ID.
        txtNome.setText(""); // Limpa o campo Nome.
        txtEmail.setText(""); // Limpa o campo Email.
        btnPrimeiro.setEnabled(false); // Desabilita o botão de primeiro registro.
        btnAnterior.setEnabled(false); // Desabilita o botão de registro anterior.
        btnProximo.setEnabled(false); // Desabilita o botão de próximo registro.
        btnUltimo.setEnabled(false); // Desabilita o botão de último registro.
        if (notificacao.trim().length() > 0) {
            lblNotificacoes.setText(setHtmlFormat(notificacao)); // Exibe mensagem de notificação.
        }
    }

    // Método para formatar texto em HTML.
    public static String setHtmlFormat(String strTexto) {
        return "<html><body>" + strTexto + "</body></html>"; // Retorna texto formatado em HTML.
    }

    // Método principal para execução do programa.
    public static void main(String[] args) {
        TelaDePesquisa appTelaDePesquisa = new TelaDePesquisa(); // Cria uma instância da tela de pesquisa.
        appTelaDePesquisa.setDefaultCloseOperation(EXIT_ON_CLOSE); // Define a operação ao fechar a janela.
    }
}
