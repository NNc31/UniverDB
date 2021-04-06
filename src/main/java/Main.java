import controller.Controller;
import view.MainMenu;
import view.Menu;

public class Main {

    public static void main(String[] args) {
        Menu menu = new MainMenu(new Controller());
        menu.showContent();
    }
}
