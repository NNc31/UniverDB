package view;

import controller.Controller;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class Menu extends JFrame implements ActionListener {
    protected Controller controller;
    protected JPanel contentPane = new JPanel();

    protected void showContent() {
        this.pack();
        this.setVisible(true);
    }

    protected void close() {
        dispose();
    }
}
