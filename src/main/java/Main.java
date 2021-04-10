import controller.Controller;
import view.AddMenu;
import view.MainMenu;
import view.Menu;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();
        Menu menu = new AddMenu(controller);
        menu.showContent();
    }
}
