package controller;

import model.Worker;
import service.APIWord;
import service.WorkerDAO;
import view.AddMenu;
import view.EditMenu;
import view.FilterMenu;
import view.MainMenu;

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
        workerDAO.create(worker);
    }

    public void editWorker(String id, Worker worker){ //добавил параметр Worker
        workerDAO.update(id, worker);

    }
    public void deleteWorker(String id){
        workerDAO.delete(id);
    }

    public List<Worker> filter(int minAge, int maxAge, String rank){
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.rank = rank;
        return workerDAO.read(minAge, maxAge, rank);
    }
    public List<Worker> filter(){
        return workerDAO.read(minAge, maxAge, rank);
    }
    public void saveWorkers(){
        APIWord apiWord = new APIWord();
        apiWord.writeToFile(filter());
    }
    public Worker getWorker(String id){
        return workerDAO.getWorker(id);
    }



}
