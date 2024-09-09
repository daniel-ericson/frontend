import java.awt.*;// Importa todos od componentes do módulo AWT.
import java.awt.event.*;// Importa todos os componentes de EVENT.
import java.sql.*;// Importa o pacote para conexão com o banco de dados.
import javax.swing.*;// Importa todos os compontes do módulo SWING.

public class TelaDeLogin extends JFrame {
    // Declaração dos componentes da tela de login.
    private final JLabel lblLogin; // Rótulo para "Login".
    private final JTextField txtLogin; // Campo de texto para entrada de login.

    private final JLabel lblSenha; // Rótulo para "Senha".
    private final JPasswordField txtSenha; // Campo de senha.

    private final JButton btnEntrar; // Botão para enviar o login.

    private final JLabel lblNotificacoes; // Rótulo para exibir notificações ao usuário.

    public TelaDeLogin() 
    {
        super("Tela de Login"); // Configura o título da janela.
        setLayout(new FlowLayout()); // Define o layout da janela.

        // Inicializa e adiciona os componentes na tela.
        lblLogin = new JLabel("Login:");
        add(lblLogin);

        txtLogin = new JTextField(10); // Campo de login com tamanho 10.
        add(txtLogin);

        lblSenha = new JLabel("Senha:");
        add(lblSenha);

        txtSenha = new JPasswordField(10); // Campo de senha com tamanho 10.
        add(txtSenha);

        btnEntrar = new JButton("Entrar"); // Botão de login.
        add(btnEntrar);

        // Rótulo para exibir notificações como mensagens de erro ou sucesso.
        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);
        add(lblNotificacoes);

        // Evento associado ao botão "Entrar".
        btnEntrar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    try {
                        // Tenta se conectar ao banco de dados.
                        Connection conexao = MySQLConnector.conectar();
                        
                        // Consulta SQL para verificar o login e a senha.
                        String strSqlLogin = "select * from `db_senac`.`tbl_senac` where `email` = '" + txtLogin.getText() + "' and `senha` = '" + String.valueOf(txtSenha.getPassword()) + "'";                        
                        Statement stmSqlLogin = conexao.createStatement();
                        ResultSet rstSqlLogin = stmSqlLogin.executeQuery(strSqlLogin);  
                                          
                        if (rstSqlLogin.next()){ // Avança o cursor do resultado da consulta.
                          lblNotificacoes.setText(setHtmlFormat(setHtmlFormat("Conectado com sucesso!!!")));  // Exibe uma mensagem de sucesso caso o login seja bem-sucedido.
                        }else{
                          lblNotificacoes.setText(setHtmlFormat(setHtmlFormat("Login e/ou senha não encontrado! Por favor, verifique e tente novamente.")));
                        }
                          stmSqlLogin.close(); // Fecha o Statement após o uso.                                              
                      
                    } catch (Exception e) {
                        // Exibe uma mensagem de erro caso ocorra uma exceção.
                        lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar o login e/ou senha digitados/informados! Por favor, verifique e tente novamente. Veja o erro: " + e));
                    }
                }
            }
        );

        setSize(150, 200); // Define o tamanho da janela.
        setVisible(true); // Torna a janela visível.
    }

    private String setHtmlFormat(String strTexto) {
      return "<html><body>" +strTexto + "</body></html>";
    }

    public static void main(String[] args) {
        TelaDeLogin appTelaDeLogin = new TelaDeLogin(); // Cria uma nova instância da tela de login.
        appTelaDeLogin.setDefaultCloseOperation(EXIT_ON_CLOSE); // Configura o fechamento da aplicação ao fechar a janela.
    }
}