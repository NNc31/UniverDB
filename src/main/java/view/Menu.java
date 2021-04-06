package view;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class Menu extends JFrame implements ActionListener {
    protected Controller controller;
    protected JPanel contentPane = new JPanel();

    Menu(Controller controller) {
        this.controller = controller;
        setTitle("Універ БД");
        setContentPane(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showContent() {
        this.pack();
        this.setVisible(true);
    }

    public void close() {
        dispose();
    }
}
