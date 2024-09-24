import java.sql.*; // Importa todos os caomponentes do modulos sql para usar o banco de dados do MySQL.

public class MySQLConnector {
    // Método que estabelece a conexão com o banco de dados MySQL.
    public static Connection conectar() {
        String status = "Nada aconteceu ainda..."; // Mensagem padrão indicando o status da conexão.
        String mysqlHost = "127.0.0.1"; // Endereço do servidor MySQL (localhost).
        String mysqlDb = "db_senac"; // Nome do banco de dados a ser conectado.
        String mysqlUser = "root"; // Usuário do banco de dados.
        String mysqlPassword = "senac@02"; // Senha do banco de dados.
        String mysqlPort = "3306"; // Porta padrão do MySQL.
        // String de conexão JDBC com o banco de dados MySQL.
        String mysqlUrl = "jdbc:mysql://" + mysqlHost + ":" + mysqlPort + "/" + mysqlDb + "?user=" + mysqlUser + "&password=" + mysqlPassword;
        Connection conn = null; // Objeto de conexão que será retornado.
        
        try {
            // Carrega a classe do driver JDBC do MySQL e cria uma variável.
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            // Estabelece a conexão com o banco de dados.
            conn = DriverManager.getConnection(mysqlUrl);
            status = "Conexão realizada com sucesso!"; // Mensagem de sucesso na conexão.
        } catch (Exception e) {
            // Captura qualquer exceção que ocorra durante a conexão e atualiza o status com a mensagem de erro.
            status = "Ops! Algo de errado não está certo com a conexão com o banco de dados MySQL! Mensagem do servidor: " + e;
        }
        // Exibe o status da conexão no console.
        System.out.println(status);
        return conn; // Retorna o objeto de conexão.
    }
}
