package view;

import controller.Controller;

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
    private JTextField degreeField = new JTextField(6);
    private JTextField rankField = new JTextField(6);

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

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.insets = new Insets(10, 5, 5, 15);
        gbc.anchor = GridBagConstraints.WEST;
        contentPane.add(degreeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.insets = new Insets(10, 15, 5, 5);
        gbc.anchor = GridBagConstraints.EAST;
        contentPane.add(rankLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.insets = new Insets(10, 5, 5, 15);
        gbc.anchor = GridBagConstraints.WEST;
        contentPane.add(rankField, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(backButton);
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.insets = new Insets(5, 0, 15, 15);
        contentPane.add(buttonPanel, gbc);
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
