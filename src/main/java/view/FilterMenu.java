package view;

import controller.Controller;
import model.CheckData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FilterMenu extends Menu {

    private JButton filterButton = new JButton("Фільтрувати");
    private JButton backButton = new JButton("Назад");
    private JComboBox rankBox;
    private JLabel rankLabel = new JLabel("Вчене звання");
    private JLabel minAgeLabel = new JLabel("Мінімальний вік");
    private JLabel maxAgeLabel = new JLabel("Максимальний вік");
    private JTextField minAgeField = new JTextField(3);
    private JTextField maxAgeField = new JTextField(3);

    public FilterMenu(Controller controller) {
        super(controller);
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 5, 5, 5);
        contentPane.add(minAgeLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 5, 5, 5);
        contentPane.add(minAgeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 5, 5, 5);
        contentPane.add(maxAgeLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        contentPane.add(maxAgeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(5, 5, 5, 5);
        contentPane.add(rankLabel, gbc);

        String[] ranks = {"Неважливо", "Відсутнє", "Доцент", "Професор"};
        rankBox = new JComboBox<>(ranks);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        contentPane.add(rankBox, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        filterButton.addActionListener(this);
        backButton.addActionListener(this);
        buttonPanel.add(filterButton);
        buttonPanel.add(backButton);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 0, 15, 15);
        contentPane.add(buttonPanel, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(filterButton)) {
            String rank = (String) rankBox.getSelectedItem();
            if (CheckData.checkFilters(minAgeField.getText(), maxAgeField.getText(),
                    (String) rankBox.getSelectedItem())) {

                int minAge, maxAge;
                if (minAgeField.getText().isBlank()) minAge = 0;
                else minAge = Integer.parseInt(minAgeField.getText());
                if (maxAgeField.getText().isBlank()) maxAge = Integer.MAX_VALUE;
                else maxAge = Integer.parseInt(maxAgeField.getText());
                if (rank.equals("Неважливо")) rank = null;
                controller.filter(minAge, maxAge, rank);
            } else JOptionPane.showMessageDialog(new JPanel(), "Некоректні дані фільтрування",
                    "Помилка", JOptionPane.WARNING_MESSAGE);

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
