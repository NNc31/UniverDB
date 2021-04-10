package controller;

import model.Worker;
import service.APIWord;
import service.WorkerDAO;
import view.AddMenu;
import view.EditMenu;
import view.FilterMenu;
import view.MainMenu;

import javax.swing.*;
import java.util.List;

public class Controller {
    private WorkerDAO workerDAO = new WorkerDAO();
    private int minAge;
    private int maxAge;
    private String rank;

    public void launchMain(){
        MainMenu mainMenu = new MainMenu(this);
        mainMenu.showContent();
    }
  
    public void launchAdd(){
        AddMenu addMenu = new AddMenu(this);
        addMenu.showContent();
    }
  
public void launchEdit(String id){
        EditMenu editMenu = new EditMenu(this, id);
        editMenu.showContent();
    }
  
    public void launchDelete(){

    }
  
    public void launchFilter(){
        FilterMenu filterMenu = new FilterMenu(this);
        filterMenu.showContent();
    }

    public void addWorker(Worker worker){
        try {
            workerDAO.create(worker);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JPanel(), "Помилка при створенні", "Помилка",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void editWorker(String id, Worker worker) {
        try {
            workerDAO.update(id, worker);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JPanel(), "Помилка при зміні", "Помилка",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    public void deleteWorker(String id) {
        try {
            workerDAO.delete(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JPanel(), "Помилка при видаленні", "Помилка",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<Worker> filter(int minAge, int maxAge, String rank){
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.rank = rank;
        try {
            return workerDAO.read(minAge, maxAge, rank);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JPanel(), "Помилка при зчитуванні", "Помилка",
                    JOptionPane.ERROR_MESSAGE);
        }
        System.exit(0);
        return null;
    }

    public List<Worker> filter() {
        try {
            return workerDAO.read(minAge, maxAge, rank);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JPanel(), "Помилка при зчитуванні", "Помилка",
                    JOptionPane.ERROR_MESSAGE);
        }
        try {
            return workerDAO.read(minAge, maxAge, rank);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JPanel(), "Помилка при зчитуванні", "Помилка",
                    JOptionPane.ERROR_MESSAGE);
        }
        System.exit(0);
        return null;
    }
    public void saveWorkers(){
        APIWord apiWord = new APIWord();
        apiWord.writeToFile(filter());
    }
    public Worker getWorker(String id) {
        try {
            return workerDAO.getWorker(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JPanel(), "Помилка при зчитуванні", "Помилка",
                    JOptionPane.ERROR_MESSAGE);
        }
        System.exit(0);
        return null;
    }



}
