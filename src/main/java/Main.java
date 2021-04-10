import controller.Controller;

import service.APIWord;
import service.WorkerDAO;
import view.MainMenu;
import view.Menu;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();
        Menu menu = new MainMenu(controller);
        menu.showContent();
        APIWord apiWord = new APIWord();
        apiWord.createFile();
    }
}
