package view;

import controller.Controller;
import model.CheckData;
import model.Worker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AddMenu extends Menu {

    private JButton addButton = new JButton("Додати");
    private JButton backButton = new JButton("Назад");
    private JLabel surnameLabel = new JLabel("Прізвище");
    private JLabel departmentLabel = new JLabel("Кафедра");
    private JLabel birthLabel = new JLabel("Дата народження");
    private JLabel employmentLabel = new JLabel("Дата працевлаштування");
    private JLabel positionLabel = new JLabel("Посада");
    private JLabel degreeLabel = new JLabel("Науковий ступінь");
    private JLabel rankLabel = new JLabel("Вчене звання");
    private JTextField surnameField = new JTextField(10);
    private JTextField departmentField = new JTextField(10);
    private JTextField birthField = new JTextField(6);
    private JTextField employmentField = new JTextField(6);
    private JTextField positionField = new JTextField(8);
    private JComboBox<String> degreeBox;
    private JComboBox<String> rankBox;

    public AddMenu(Controller controller) {
        super(controller);
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        addButton.addActionListener(this);
        backButton.addActionListener(this);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 15, 5, 5);
        gbc.anchor = GridBagConstraints.EAST;
        contentPane.add(surnameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 5, 5, 15);
        gbc.anchor = GridBagConstraints.WEST;
        contentPane.add(surnameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 15, 5, 5);
        gbc.anchor = GridBagConstraints.EAST;
        contentPane.add(departmentLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 5, 5, 15);
        gbc.anchor = GridBagConstraints.WEST;
        contentPane.add(departmentField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 15, 5, 5);
        gbc.anchor = GridBagConstraints.EAST;
        contentPane.add(birthLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 5, 5, 15);
        gbc.anchor = GridBagConstraints.WEST;
        contentPane.add(birthField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(10, 15, 5, 5);
        gbc.anchor = GridBagConstraints.EAST;
        contentPane.add(employmentLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.insets = new Insets(10, 5, 5, 15);
        gbc.anchor = GridBagConstraints.WEST;
        contentPane.add(employmentField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(10, 15, 5, 5);
        gbc.anchor = GridBagConstraints.EAST;
        contentPane.add(positionLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.insets = new Insets(10, 5, 5, 15);
        gbc.anchor = GridBagConstraints.WEST;
        contentPane.add(positionField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.insets = new Insets(10, 15, 5, 5);
        gbc.anchor = GridBagConstraints.EAST;
        contentPane.add(degreeLabel, gbc);


        String[] degrees = {"Кандидат", "Доктор_наук", "Відсутній"};
        degreeBox = new JComboBox<>(degrees);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.insets = new Insets(10, 5, 5, 15);
        gbc.anchor = GridBagConstraints.WEST;
        contentPane.add(degreeBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.insets = new Insets(10, 15, 5, 5);
        gbc.anchor = GridBagConstraints.EAST;
        contentPane.add(rankLabel, gbc);

        String[] ranks = {"Доцент", "Професор", "Відсутнє"};
        rankBox = new JComboBox<>(ranks);
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.insets = new Insets(10, 5, 5, 15);
        gbc.anchor = GridBagConstraints.WEST;
        contentPane.add(rankBox, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(backButton);
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.insets = new Insets(15, 0, 10, 10);
        contentPane.add(buttonPanel, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(addButton)) {
            Worker worker = CheckData.checkAndCreateWorker(surnameField.getText(), departmentField.getText(),
                    birthField.getText(), employmentField.getText(), positionField.getText(),
                    (String) degreeBox.getSelectedItem(), (String) rankBox.getSelectedItem());
            if (worker == null) {
                JOptionPane.showMessageDialog(new JPanel(), "Некоректні дані співробітника",
                        "Помилка", JOptionPane.WARNING_MESSAGE);
            } else controller.addWorker(worker);
            controller.launchMain();
            close();
        } else if (e.getSource().equals(backButton)) {
            controller.launchMain();
            close();
        } else {
            throw new IllegalStateException();
        }
    }
}
