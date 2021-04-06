package view;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FilterMenu extends Menu {

    private JButton filterButton = new JButton("Фільтрувати");
    private JButton backButton = new JButton("Назад");
    private JButton unFilterButton = new JButton("Скинути фільтри");
    private JCheckBox rankBox = new JCheckBox("Вчене звання");
    private JLabel minAgeLabel = new JLabel("Мінімальний вік");
    private JLabel maxAgeLabel = new JLabel("Максимальний вік");
    private JTextField minAgeField = new JTextField();
    private JTextField maxAgeField = new JTextField();

    public FilterMenu(Controller controller) {
        super(controller);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(filterButton)) {

        } else if (e.getSource().equals(unFilterButton)) {

        } else if (e.getSource().equals(backButton)) {

        } else {
            throw new IllegalStateException();
        }
    }
}
