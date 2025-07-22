import menu.Menu;
import util.RepositoryInitializer;

public class App {
    public static void main(String[] args) throws Exception {
        RepositoryInitializer.inicializar();        
        try {
            Menu menu = new Menu();
            menu.exibir();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println("Aplicação encerrada.");
    }
}
