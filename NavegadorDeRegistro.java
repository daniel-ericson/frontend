import java.sql.*; // Importa as bibliotecas de SQL para conexão e execução de comandos no banco de dados
import java.util.*; // Importa as classes utilitárias, como ArrayList

// A classe NavegadorDeRegistro herda de TelaDeAtualizacao
public class NavegadorDeRegistro extends TelaDeAtualizacao {

    // Método que popula os IDs em uma lista de IDs disponíveis
    public static void popularIds() {
        try {
            // Cria um ArrayList temporário de strings para armazenar os IDs
            ArrayList<String> idsTemp = new ArrayList<>();
            idsTemp.add("Selecione aqui o id"); // Adiciona uma opção padrão

            // Estabelece conexão com o banco de dados
            Connection conexao = MySQLConnector.conectar();

            // String de consulta SQL para pegar todos os registros ordenados por ID
            String strSqlPopularIds = "select * from `db_senac`.`tbl_senac` order by `id` asc;";

            // Cria um statement que pode percorrer o ResultSet em ambos sentidos e não permite alterações
            Statement stmSqlPopularIds = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            // Executa a consulta SQL e armazena o resultado em um ResultSet
            ResultSet rstSqlPopularIds = stmSqlPopularIds.executeQuery(strSqlPopularIds);

            // Percorre os resultados e adiciona os IDs no ArrayList
            while (rstSqlPopularIds.next()) {
                idsTemp.add(rstSqlPopularIds.getString("id"));
            }

            // Converte o ArrayList para um array de strings e o armazena na variável ids
            ids = idsTemp.toArray(new String[0]);

            // Fecha o statement
            stmSqlPopularIds.close();

        // Tratamento de exceções
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar os ids! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e); // Exibe a mensagem de erro no console
        }
    }

    // Método que atualiza o ID selecionado
    public static void atualizarId() {
        try {
            String atualizarNome = ""; // Inicializa a variável de atualização de nome
            String atualizarEmail = ""; // Inicializa a variável de atualização de email
            String atualizarSenha = ""; // Inicializa a variável de atualização de senha

            // Verifica se o nome foi alterado, comparando o valor atual com o original
            if (txtNome.getText().trim().equals(nomeAtual) == false) {
                atualizarNome = "`nome` = '" + txtNome.getText() + "'"; // Define a string de atualização
            }

            // Verifica se o email foi alterado
            if (txtEmail.getText().trim().equals(emailAtual) == false) {
                if (atualizarNome.length() > 0) {
                    atualizarEmail = " and "; // Se o nome também foi alterado, adiciona "and" para concatenar as atualizações
                }
                atualizarEmail += "`email` = '" + txtEmail.getText() + "'"; // Define a string de atualização
            }

            // Verifica se a senha foi alterada
            if (String.valueOf(txtSenha.getPassword()).trim().equals(senhaAtual) == false) {
                if (atualizarNome.length() > 0 || atualizarEmail.length() > 0) {
                    atualizarSenha = " and "; // Se o nome ou o email também foram alterados, adiciona "and"
                }
                atualizarSenha += "`senha` = '" + txtSenha.getPassword().toString() + "'"; // Define a string de atualização
            }

            // Se alguma informação foi alterada, faz a atualização no banco de dados
            if (atualizarNome.length() > 0 || atualizarEmail.length() > 0 || atualizarSenha.length() > 0) {
                Connection conexao = MySQLConnector.conectar(); // Conecta ao banco de dados
                // Monta a string SQL para atualizar os campos no banco de dados
                String strSqlAtualizarId = "update `db_senac`.`tbl_senac` set " + atualizarNome + atualizarEmail + atualizarSenha + " where `id` = " + cbxId.getSelectedItem().toString() + ";";
                System.out.println(strSqlAtualizarId); // Exibe a query para depuração
                Statement stmSqlAtualizarId = conexao.createStatement(); // Cria um statement para executar a query
                stmSqlAtualizarId.addBatch(strSqlAtualizarId); // Adiciona a query ao batch
                stmSqlAtualizarId.executeBatch(); // Executa a query

                // Atualiza os valores locais com os novos dados
                nomeAtual = txtNome.getText();
                emailAtual = txtEmail.getText();
                senhaAtual = String.valueOf(txtSenha.getPassword());

                // Fecha o statement
                stmSqlAtualizarId.close();

                // Exibe uma notificação de sucesso
                lblNotificacoes.setText("O id " + cbxId.getSelectedItem().toString() + " foi atualizado com sucesso!");
            } else {
                // Se não houver atualizações, exibe uma notificação
                lblNotificacoes.setText("Não foram encontradas alterações para atualizar o id " + cbxId.getSelectedItem().toString());
            }
        // Tratamento de exceções
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível atualizar o id! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e); // Exibe a mensagem de erro no console
        }
    }

    // Método para limpar os campos do formulário
    public static void limparCampos() {
        txtNome.setText(""); // Limpa o campo de nome
        txtEmail.setText(""); // Limpa o campo de email
        txtSenha.setText(""); // Limpa o campo de senha
        cbxId.setSelectedIndex(0); // Reseta a seleção de ID
    }

    // Método para atualizar os campos do formulário com os dados de um ID específico
    public static void atualizarCampos(String id) {
        try {
            // Verifica se um ID válido foi selecionado
            if (cbxId.getSelectedIndex() > 0) {
                Connection conexao = MySQLConnector.conectar(); // Conecta ao banco de dados

                // Monta a query para selecionar os dados do ID
                String strSqlAtualizarCampos = "select * from `db_senac`.`tbl_senac` where `id` = " + id + ";";

                // Cria um statement que permite percorrer o ResultSet em ambos os sentidos
                Statement stmSqlAtualizarCampos = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

                // Executa a query e armazena o resultado
                ResultSet rstSqlAtualizarCampos = stmSqlAtualizarCampos.executeQuery(strSqlAtualizarCampos);

                // Se o ID foi encontrado, atualiza os campos do formulário
                if (rstSqlAtualizarCampos.next()) {
                    txtNome.setText(rstSqlAtualizarCampos.getString("nome"));
                    nomeAtual = txtNome.getText(); // Armazena o nome atual para comparação futura
                    txtEmail.setText(rstSqlAtualizarCampos.getString("email"));
                    emailAtual = txtEmail.getText(); // Armazena o email atual para comparação futura
                    txtSenha.setText(rstSqlAtualizarCampos.getString("senha"));
                    senhaAtual = String.valueOf(txtSenha.getPassword()); // Armazena a senha atual

                    lblNotificacoes.setText("Campos atualizados com sucesso!");
                } else {
                    // Se o ID não foi encontrado, exibe uma notificação
                    lblNotificacoes.setText("Ops! Não foi encontrado o id selecionado. Por favor, verifique e tente novamente.");
                }

                // Fecha o statement
                stmSqlAtualizarCampos.close();
            } else {
                // Se nenhum ID foi selecionado, limpa os campos e exibe uma notificação
                lblNotificacoes.setText("Selecione um id para continuar.");
                limparCampos();
            }
        // Tratamento de exceções
        } catch (Exception e) {
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar os ids! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e); // Exibe a mensagem de erro no console
        }
    }
}
