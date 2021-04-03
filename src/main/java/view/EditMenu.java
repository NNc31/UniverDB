package view;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EditMenu extends Menu {

    private JButton editButton = new JButton("Змінити");
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

    public EditMenu(Controller controller) {
        super(controller);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
