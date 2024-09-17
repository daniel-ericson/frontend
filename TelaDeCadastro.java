import java.awt.*;// Importa todos od componentes do módulo AWT.
import java.awt.event.*;// Importa todos os componentes de EVENT.
import java.sql.*;// Importa o pacote para conexão com o banco de dados.
import javax.swing.*;// Importa todos os compontes do módulo SWING.

public class TelaDeCadastro extends JFrame {
    // Declaração dos componentes da tela de login.
    private final JLabel lblNome; // Rótulo para "nome".
    private final JTextField txtNome; // Campo de texto para entrada de nome.

    private final JLabel lblEmail; // Rótulo para "Email".
    private final JTextField txtEmail; // Campo de texto para entrada de Email.

    private final JLabel lblSenha; // Rótulo para "Senha".
    private final JPasswordField txtSenha; // Campo de senha.

    private final JButton btnCadastrar; // Botão para enviar o login.

    private final JLabel lblNotificacoes; // Rótulo para exibir notificações ao usuário.

    public TelaDeCadastro() 
    {
        super("Tela de cadastro");
        setLayout(new GridLayout(4,2,5,5));
       
      lblNome = new JLabel("Nome:", SwingConstants.RIGHT); // Rótulo com o texto "Nome".
      add(lblNome); // Adiciona o rótulo à janela.

      txtNome = new JTextField(10); // Cria um campo de texto com largura de 10 colunas.
      add(txtNome); // Adiciona o campo de texto à janela.

      lblEmail = new JLabel("E-mail:", SwingConstants.RIGHT); // Cria um rótulo com o texto "E-mail".
      add(lblEmail); // Adiciona o rótulo à janela.

      txtEmail = new JTextField(10); // Cria um campo de texto com largura de 10 colunas.
      add(txtEmail); // Adiciona o campo de texto à janela.
      
      lblSenha = new JLabel("Senha:", SwingConstants.RIGHT); // Cria um rótulo com o texto "Senha".
      add(lblSenha); // Adiciona o rótulo à janela.

      txtSenha = new JPasswordField(10); // Cria um campo de senha com largura de 10 colunas.
      add(txtSenha); // Adiciona o campo de senha à janela.

      btnCadastrar = new JButton("Cadastrar"); // Cria um botão com o texto "Cadastrar".
      add(btnCadastrar); // Adiciona o botão à janela.

      //add(new JLabel("     ")); // Adiciona um rótulo vazio para espaçamento.
      lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER); // Cria um rótulo centralizado para notificações.
      add(lblNotificacoes); // Adiciona o rótulo à janela.

      btnCadastrar.addActionListener(
         new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (txtNome.getText().trim().length()<=0)
                    {
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar um nome para o cadastro. Por favor, digite um nome e tente novamente. "));
                        txtNome.requestFocus();
                        return;
                    }
                    if (txtEmail.getText().trim().length()<=0)
                    {
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar um E-mail para o cadastro. Por favor, digite uma E-mail e tente novamente. "));
                        txtEmail.requestFocus();
                        return;
                    }

                    if (String.valueOf(txtSenha.getPassword()).trim().length()<=0)
                    {
                        lblNotificacoes.setText(setHtmlFormat("É necessário digitar uma senha para o cadastro. Por favor, digite uma senha e tente novamente. "));
                        txtSenha.requestFocus();
                        return;
                    }

                    try {
                        // Tenta se conectar ao banco de dados.
                        Connection conexao = MySQLConnector.conectar();
                        
                        // Consulta SQL para verificar o login e a senha.
                        String strSqlEmail = "select * from `db_senac`.`tbl_senac` where `email` = '" + txtNome.getText() + "';";                    
                        Statement stmSqlEmail = conexao.createStatement();
                        ResultSet rstSqlEmail = stmSqlEmail.executeQuery(strSqlEmail);  
                                          
                        if (rstSqlEmail.next()){ // Avança o cursor do resultado da consulta.
                          lblNotificacoes.setText(setHtmlFormat(setHtmlFormat("Ops! Já existe um usuário utilizando este email. Por favor, digite outro email e tente novamente.")));  // Exibe uma mensagem de sucesso caso o login seja bem-sucedido.
                        }else{
                          lblNotificacoes.setText(setHtmlFormat(setHtmlFormat("Login liberado para cadastro.")));
                          String strSqlCadastrar = " insert into `db_senac`.`tbl_senac`(`nome`, `email`, `senha`) values('"+ txtNome.getText() + "', '"+ txtEmail.getText()+"','"+ String.valueOf(txtSenha.getPassword())+ "')";
                          Statement stmSqlCadastrar =  conexao.createStatement();
                          stmSqlCadastrar.addBatch(strSqlCadastrar);
                          stmSqlCadastrar.executeBatch();
                          lblNotificacoes.setText(setHtmlFormat("Cadastro realizado com sucesso"));
                        }
                          stmSqlEmail.close(); // Fecha o Statement após o uso.                                              
                      
                    } catch (Exception e) {
                        // Exibe uma mensagem de erro caso ocorra uma exceção.
                        lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com o cadastro! Por favor, verifique e tente novamente."));
                        System.err.println("Erro:" + e);
                    }
                }
            }
        );

        setSize(400, 350); // Define o tamanho da janela.
        setVisible(true); // Torna a janela visível.
    }

    private String setHtmlFormat(String strTexto) {
      return "<html><body>" +strTexto + "</body></html>";
    }

    public static void main(String[] args) {
        TelaDeCadastro appTelaDeLogin = new TelaDeCadastro(); // Cria uma nova instância da tela de login.
        appTelaDeLogin.setDefaultCloseOperation(EXIT_ON_CLOSE); // Configura o fechamento da aplicação ao fechar a janela.
    }
}