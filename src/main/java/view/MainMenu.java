package view;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MainMenu extends Menu {

    private JTextArea textArea = new JTextArea();
    private JTextField idField = new JTextField();
    private JLabel idLabel = new JLabel("ID");
    private JLabel titleLabel = new JLabel("Універ БД");
    private JButton addButton = new JButton("Додати");
    private JButton editButton = new JButton("Змінити");
    private JButton deleteButton = new JButton("Видалити");
    private JButton filterButton = new JButton("Фільтрувати");
    private JButton saveButton = new JButton("Зберегти");

    public MainMenu(Controller controller) {
        super(controller);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
