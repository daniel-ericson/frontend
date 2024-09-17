// Importa as classes necessárias para a criação de interfaces gráficas.
import javax.swing.JFrame;

public class  TelaDeCadastroTest extends JFrame { // Define uma classe que herda de JFrame, usada para criar uma janela.
    
    public static void main(String[] args) {
        // Cria uma variavel da tela de login.
        TelaDeCadastroTest appTelaDeLogin = new TelaDeCadastroTest();
        
        // Define a operação de fechamento padrão para encerrar o programa ao fechar a janela.
        appTelaDeLogin.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}