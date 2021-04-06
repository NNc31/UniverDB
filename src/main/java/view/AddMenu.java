package view;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddMenu extends Menu {

    private JButton addButton = new JButton("Додати");
    private JButton backButton = new JButton("Назад");
    private JLabel surnameLabel = new JLabel("Прізвище");
    private JLabel departmentLabel = new JLabel("Кафедра");
    private JLabel birthLabel = new JLabel("Народження");
    private JLabel employmentLabel = new JLabel("Працевлаштування");
    private JLabel positionLabel = new JLabel("Посада");
    private JLabel degreeLabel = new JLabel("Науковий ступінь");
    private JLabel rankLabel = new JLabel("Вчене звання");
    private JTextField surnameField = new JTextField();
    private JTextField departmentField = new JTextField();
    private JTextField birthField = new JTextField();
    private JTextField employmentField = new JTextField();
    private JTextField positionField = new JTextField();
    private JTextField degreeField = new JTextField();
    private JTextField rankField = new JTextField();

    public AddMenu(Controller controller) {
        super(controller);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(addButton)) {

        } else if (e.getSource().equals(backButton)) {

        } else {
            throw new IllegalStateException();
        }
    }
}
