package view;

import controller.Controller;
import model.Worker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class MainMenu extends Menu {

    private JTextArea workers = new JTextArea(17, 30);
    private JTextField idField = new JTextField(2);
    private JLabel idLabel = new JLabel("ID");
    private JLabel titleLabel = new JLabel("Універ БД");
    private JButton addButton = new JButton("Додати");
    private JButton editButton = new JButton("Змінити");
    private JButton deleteButton = new JButton("Видалити");
    private JButton filterButton = new JButton("Фільтрувати");
    private JButton saveButton = new JButton("Зберегти");

    public MainMenu(Controller controller) {
        super(controller);
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 0, 0);
        contentPane.add(titleLabel, gbc);

        addButton.addActionListener(this);
        editButton.addActionListener(this);
        deleteButton.addActionListener(this);
        filterButton.addActionListener(this);
        saveButton.addActionListener(this);

        JScrollPane verticalScroll = new JScrollPane(workers);
        JScrollPane horizontalScroll = new JScrollPane(workers);
        verticalScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        horizontalScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        contentPane.add(verticalScroll);
        contentPane.add(horizontalScroll);
        workers.setEditable(false);
        List<Worker> workerList = controller.filter();
        //String workerStr = "ID\tПрізвище\tКафедра\tНародження\t" +
        //        "Працевлаштування\tПосада\tНауовий ступінь\tВчене звання  \n\n";
        String workerStr = "";
        for (Worker worker : workerList) {
            workerStr += worker.toString() + "\n";
        }
        workers.setText(workerStr);
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 7;
        gbc.insets = new Insets(20, 10, 20, 20);
        contentPane.add(horizontalScroll, gbc);

        JPanel idPanel = new JPanel();
        idPanel.add(idLabel);
        idPanel.add(idField);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(0, 0, 30, 15);
        contentPane.add(idPanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        contentPane.add(addButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        contentPane.add(editButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        contentPane.add(deleteButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        contentPane.add(filterButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.insets = new Insets(0, 0, 15, 15);
        contentPane.add(saveButton, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(addButton)) {
            controller.launchAdd();
            close();
        } else if (e.getSource().equals(editButton)) {
            controller.launchEdit(idField.getText());
            close();
        } else if (e.getSource().equals(deleteButton)) {
            controller.launchDelete(idField.getText());
            close();
        } else if (e.getSource().equals(filterButton)) {
            controller.launchFilter();
            close();
        } else if (e.getSource().equals(saveButton)) {
            controller.saveWorkers();
            controller.launchMain();
            close();
        } else {
            throw new IllegalStateException();
        }
    }
}
