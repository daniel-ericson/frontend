import java.sql.*;

public class NavegadorDeRegistro extends TelaDePesquisa {
    // Método para realizar a pesquisa no banco de dados com base no texto digitado pelo usuário.
    public static void pesquisar() {
        try {
            // Verifica se o texto de pesquisa é diferente do usuário atual.
            if (txtPesquisa.getText().trim().equals(txtUsuario) == false) {
                limparCampos(""); // Limpa os campos de entrada.
                Connection conexao = MySQLConnector.conectar(); // Estabelece a conexão com o banco de dados.
                // Prepara a consulta SQL para buscar registros onde o nome ou email contém o texto pesquisado.
                String strSqlPesquisa = "select * from `db_senac`.`tbl_senac` where `nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%' order by `id` asc;";
                Statement stmSqlPesquisa = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rstSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa); // Executa a consulta.

                // Verifica se existem resultados na pesquisa.
                if (rstSqlPesquisa.next()) {
                    rstSqlPesquisa.last(); // Move o cursor para o último registro para contar.
                    int rowNumbers = rstSqlPesquisa.getRow(); // Obtém o número total de registros encontrados.
                    rstSqlPesquisa.first(); // Retorna o cursor para o primeiro registro.

                    // Atualiza a interface com o número de resultados encontrados.
                    lblNotificacoes.setText(setHtmlFormat("Legal! Foi(Foram) encontrado(s) " + rowNumbers + " resultado(s)."));
                    // Preenche os campos de texto com os dados do primeiro registro encontrado.
                    txtId.setText(rstSqlPesquisa.getString("id"));
                    txtNome.setText(rstSqlPesquisa.getString("nome"));
                    txtEmail.setText(rstSqlPesquisa.getString("email"));
                    txtUsuario = txtPesquisa.getText(); // Armazena a pesquisa atual.
                    btnPesquisar.setEnabled(false); // Desabilita o botão de pesquisa para evitar duplicação.
                    
                    // Habilita os botões de navegação se houver mais de um resultado.
                    if (rowNumbers > 1) {
                        btnProximo.setEnabled(true);
                        btnUltimo.setEnabled(true);
                    }
                } else {
                    txtUsuario = txtPesquisa.getText(); // Atualiza o usuário atual.
                    btnPesquisar.setEnabled(false); // Desabilita o botão de pesquisa.
                    // Informa que nenhum resultado foi encontrado.
                    lblNotificacoes.setText(setHtmlFormat("Poxa vida! Não foram encontrados resultados para: \"" + txtPesquisa.getText() + "\"."));
                }
                stmSqlPesquisa.close(); // Fecha a declaração.
            }
        } catch (Exception e) {
            // Exibe mensagem de erro se a pesquisa falhar.
            lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e); // Exibe o erro no console.
        }
    }

    // Método para navegar para o primeiro registro encontrado na pesquisa.
    public static void primeiroRegistro() {
        try {
            limparCampos("Você está no primeiro registro."); // Limpa campos e informa ao usuário.
            Connection conexao = MySQLConnector.conectar(); // Conecta ao banco de dados.
            // Consulta SQL para obter os registros com base na pesquisa anterior.
            String strSqlPesquisa = "select * from `db_senac`.`tbl_senac` where `nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%' order by `id` asc;";
            Statement stmSqlPesquisa = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlPesquisa = stmSqlPesquisa.executeQuery(strSqlPesquisa); // Executa a consulta.

            // Verifica se existem resultados na pesquisa.
            if (rstSqlPesquisa.next()) {
                // Preenche os campos de texto com os dados do primeiro registro encontrado.
                txtId.setText(rstSqlPesquisa.getString("id"));
                txtNome.setText(rstSqlPesquisa.getString("nome"));
                txtEmail.setText(rstSqlPesquisa.getString("email"));
                btnPesquisar.setEnabled(false); // Desabilita o botão de pesquisa.
                btnProximo.setEnabled(true); // Habilita o botão de próximo registro.
                btnUltimo.setEnabled(true); // Habilita o botão do último registro.
            } else {
                txtUsuario = txtPesquisa.getText(); // Atualiza o usuário atual.
                btnPesquisar.setEnabled(false); // Desabilita o botão de pesquisa.
                // Informa que nenhum resultado foi encontrado.
                lblNotificacoes.setText(setHtmlFormat("Poxa vida! Não foram encontrados resultados para: \"" + txtPesquisa.getText() + "\"."));
            }
            stmSqlPesquisa.close(); // Fecha a declaração.
        } catch (Exception e) {
            // Exibe mensagem de erro se a pesquisa falhar.
            lblNotificacoes.setText(setHtmlFormat("Não foi possível prosseguir com a pesquisa! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e); // Exibe o erro no console.
        }
    }

    // Método para navegar para o registro anterior na lista de resultados.
    public static void registroAnterior() {
        try {
            String idAtual = txtId.getText(); // Armazena o ID do registro atual.
            String nomeAtual = txtNome.getText(); // Armazena o nome do registro atual.
            String emailAtual = txtEmail.getText(); // Armazena o email do registro atual.
            limparCampos("Registro anterior posicionado com sucesso."); // Limpa campos e informa ao usuário.
            Connection conexao = MySQLConnector.conectar(); // Conecta ao banco de dados.
            // Consulta SQL para obter o registro anterior baseado no ID atual.
            String strSqlProximoRegistro = "select * from `db_senac`.`tbl_senac` where (`nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%') and `id` < " + idAtual + " order by `id` desc;";
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro); // Executa a consulta.

            // Verifica se há um registro anterior.
            if (rstSqlProximoRegistro.next()) {
                // Preenche os campos de texto com os dados do registro anterior encontrado.
                txtId.setText(rstSqlProximoRegistro.getString("id"));
                txtNome.setText(rstSqlProximoRegistro.getString("nome"));
                txtEmail.setText(rstSqlProximoRegistro.getString("email"));
                // Habilita os botões de navegação.
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true);
                btnProximo.setEnabled(true);
                btnUltimo.setEnabled(true);
            } else {
                // Se não houver registro anterior, mantém os valores atuais.
                txtId.setText(idAtual);
                txtNome.setText(nomeAtual);
                txtEmail.setText(emailAtual);
                // Habilita os botões de navegação.
                btnProximo.setEnabled(true);
                btnUltimo.setEnabled(true);
                lblNotificacoes.setText("Você chegou ao primeiro registro."); // Informa que chegou ao primeiro registro.
            }
            stmSqlProximoRegistro.close(); // Fecha a declaração.
        } catch (Exception e) {
            // Exibe mensagem de erro se não for possível encontrar o registro anterior.
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar o próximo registro! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e); // Exibe o erro no console.
        }
    }

    // Método para navegar para o próximo registro na lista de resultados.
    public static void proximoRegistro() {
        try {
            String idAtual = txtId.getText(); // Armazena o ID do registro atual.
            String nomeAtual = txtNome.getText(); // Armazena o nome do registro atual.
            String emailAtual = txtEmail.getText(); // Armazena o email do registro atual.
            limparCampos("Próximo registro posicionado com sucesso."); // Limpa campos e informa ao usuário.
            Connection conexao = MySQLConnector.conectar(); // Conecta ao banco de dados.
            // Consulta SQL para obter o próximo registro baseado no ID atual.
            String strSqlProximoRegistro = "select * from `db_senac`.`tbl_senac` where (`nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%') and `id` > " + idAtual + " order by `id` asc;";
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro); // Executa a consulta.

            // Verifica se há um próximo registro.
            if (rstSqlProximoRegistro.next()) {
                // Preenche os campos de texto com os dados do próximo registro encontrado.
                txtId.setText(rstSqlProximoRegistro.getString("id"));
                txtNome.setText(rstSqlProximoRegistro.getString("nome"));
                txtEmail.setText(rstSqlProximoRegistro.getString("email"));
                // Habilita os botões de navegação.
                btnPrimeiro.setEnabled(true);
                btnAnterior.setEnabled(true);
                btnProximo.setEnabled(true);
                btnUltimo.setEnabled(true);
            } else {
                // Se não houver próximo registro, mantém os valores atuais.
                txtId.setText(idAtual);
                txtNome.setText(nomeAtual);
                txtEmail.setText(emailAtual);
                // Habilita os botões de navegação.
                btnProximo.setEnabled(false); // Desabilita o botão de próximo se não houver próximo registro.
                btnUltimo.setEnabled(false); // Desabilita o botão de último se não houver próximo registro.
                lblNotificacoes.setText("Você chegou ao último registro."); // Informa que chegou ao último registro.
            }
            stmSqlProximoRegistro.close(); // Fecha a declaração.
        } catch (Exception e) {
            // Exibe mensagem de erro se não for possível encontrar o próximo registro.
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar o próximo registro! Por favor, verifique e tente novamente."));
            System.err.println("Erro: " + e); // Exibe o erro no console.
        }
    }

    // Método para navegar para o último registro encontrado na pesquisa.
    public static void ultimoRegistro() {
        try { // Inicia um bloco try para capturar exceções que possam ocorrer.
            String idAtual = txtId.getText(); // Armazena o texto atual do campo txtId na variável idAtual.
            String nomeAtual = txtNome.getText(); // Armazena o texto atual do campo txtNome na variável nomeAtual.
            String emailAtual = txtEmail.getText(); // Armazena o texto atual do campo txtEmail na variável emailAtual.
            limparCampos(""); // Chama o método limparCampos para limpar os campos de entrada e mensagens.
            Connection conexao = MySQLConnector.conectar(); // Estabelece uma conexão com o banco de dados usando MySQLConnector.
            String strSqlProximoRegistro = "select * from `db_senac`.`tbl_senac` where `nome` like '%" + txtPesquisa.getText() + "%' or `email` like '%" + txtPesquisa.getText() + "%' order by `id` desc;"; // Cria uma string SQL para buscar registros na tabela tbl_senac onde o nome ou email contém o texto de pesquisa.
            Statement stmSqlProximoRegistro = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); // Cria um Statement para executar a consulta SQL, permitindo navegação e leitura.
            ResultSet rstSqlProximoRegistro = stmSqlProximoRegistro.executeQuery(strSqlProximoRegistro); // Executa a consulta SQL e armazena o resultado em um ResultSet.
            if (rstSqlProximoRegistro.next()) { // Verifica se há um próximo registro no ResultSet.
                txtId.setText(rstSqlProximoRegistro.getString("id")); // Define o campo txtId com o ID do registro atual do ResultSet.
                txtNome.setText(rstSqlProximoRegistro.getString("nome")); // Define o campo txtNome com o nome do registro atual do ResultSet.
                txtEmail.setText(rstSqlProximoRegistro.getString("email")); // Define o campo txtEmail com o email do registro atual do ResultSet.
                btnPrimeiro.setEnabled(true); // Habilita o botão btnPrimeiro para navegação.
                btnAnterior.setEnabled(true); // Habilita o botão btnAnterior para navegação.
                lblNotificacoes.setText("Você chegou ao último registro."); // Exibe mensagem informando que o último registro foi alcançado.
            } else { // Caso não haja registros no ResultSet.
                txtId.setText(idAtual); // Restaura o campo txtId com o valor armazenado anteriormente em idAtual.
                txtNome.setText(nomeAtual); // Restaura o campo txtNome com o valor armazenado anteriormente em nomeAtual.
                txtEmail.setText(emailAtual); // Restaura o campo txtEmail com o valor armazenado anteriormente em emailAtual.
                btnPrimeiro.setEnabled(true); // Habilita o botão btnPrimeiro para navegação.
                btnAnterior.setEnabled(true); // Habilita o botão btnAnterior para navegação.
                lblNotificacoes.setText("Você chegou ao último registro."); // Exibe mensagem informando que o último registro foi alcançado, mesmo sem novos registros.
            }
            stmSqlProximoRegistro.close(); // Fecha o Statement para liberar recursos.
        } catch (Exception e) { // Captura qualquer exceção que ocorrer no bloco try.
            lblNotificacoes.setText(setHtmlFormat("Não foi possível encontrar o último registro! Por favor, verifique e tente novamente.")); // Exibe mensagem de erro formatada no rótulo lblNotificacoes.
            System.err.println("Erro: " + e); // Imprime o erro no console para depuração.
        }
    }
}