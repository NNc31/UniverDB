package service;

import model.Worker;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WorkerDAO {

    private File source;
    private String sourceStr = "DataBase.txt";

    private FileReader connectToRead() throws Exception {
        source = new File(sourceStr);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(source);
        } catch (FileNotFoundException e) {
            throw new Exception("Database file was not found");
        }
        return fileReader;
    }
    private FileWriter connectToWrite(boolean append) throws Exception {
        source = new File(sourceStr);
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(source, append);
        } catch (IOException e) {
            throw new Exception("Database file was not found");
        }
        return fileWriter;

    }

    private void disconnect(Reader reader) throws Exception {
        try {
            reader.close();
        } catch (IOException e) {
            throw new Exception("Database file was not closed");
        }
    }
    private void disconnect(Writer writer) throws Exception {
        try {
            writer.close();
        }  catch (IOException e) {
            throw new Exception("Database file was not closed");
        }
    }

    public void create(Worker worker) throws Exception {
        FileReader fileReader = connectToRead();
        Scanner scanner = new Scanner(fileReader);
        int count = 0;
        while(scanner.hasNextLine()){
            scanner.nextLine();
            count++;
        }
        disconnect(fileReader);
        worker.setId(String.valueOf(count));
        FileWriter fileWriter = connectToWrite(true);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(worker.getId()).append(" ").append(worker.getSurname()).append(" ").append(worker.getAge());
        stringBuilder.append(" ").append(worker.getDepartment()).append(" ").append(worker.getBirthDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        stringBuilder.append(" ").append(worker.getEmploymentDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))).append(" ").append(worker.getPosition());
        stringBuilder.append(" ").append(worker.getDegree()).append(" ").append(worker.getRank());
        try {
            fileWriter.write(stringBuilder.toString());
            fileWriter.append(System.getProperty("line.separator"));
        } catch (IOException e) {
            throw new Exception("Data was not written to database");
        }
        disconnect(fileWriter);
    }

    public List<Worker> read(int minAge, int maxAge, String rank) throws Exception {
        List<Worker> list = new LinkedList<>();
        FileReader fileReader = connectToRead();
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String []info = line.split(" ");
            int workerAge = Integer.parseInt(info[2]);
            String workerRank = info[8];
            if(workerAge >= minAge && workerAge <= maxAge && (workerRank.equals(rank) || rank == null)){
                LocalDate birthDate = LocalDate.parse(info[4], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                LocalDate employmentDate = LocalDate.parse(info[5], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                list.add(new Worker(info[0], info[1], Integer.parseInt(info[2]), info[3],
                        birthDate, employmentDate, info[6], info[7], info[8]));
            }
        }
        disconnect(fileReader);
        return list;
    }

    public void update(String id, Worker worker) throws Exception {
        worker.setId(id);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(worker.getId()).append(" ").append(worker.getSurname()).append(" ").append(worker.getAge());
        stringBuilder.append(" ").append(worker.getDepartment()).append(" ")
                .append(worker.getBirthDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        stringBuilder.append(" ").append(worker.getEmploymentDate()
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))).append(" ").append(worker.getPosition());
        stringBuilder.append(" ").append(worker.getDegree()).append(" ").append(worker.getRank());
        String newWorkerInfo = stringBuilder.toString();

        FileReader fileReader = connectToRead();
        Scanner scanner = new Scanner(fileReader);
        LinkedList<String> workerList = new LinkedList<>();
        boolean validId = false;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line.startsWith(id + " ")){
                line = newWorkerInfo;
                validId = true;
            }
            workerList.add(line);
        }
        if(!validId) throw new Exception("Not valid ID");
        disconnect(fileReader);

        FileWriter fileWriter = connectToWrite(false);
        try {
            for (String s: workerList) {
                 fileWriter.write(s);
                fileWriter.append(System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        disconnect(fileWriter);
    }

    public void delete(String id) throws Exception {
        FileReader fileReader = connectToRead();
        Scanner scanner = new Scanner(fileReader);
        LinkedList<String> workerList = new LinkedList<>();
        int count = 0;
        boolean validId = false;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(! line.startsWith(id + " ")){
                line = count + line.substring(line.indexOf(" "));
                workerList.add(line);
                count++;
            }
            else{
                validId = true;
            }

        }
        if(!validId) throw new Exception("Not valid ID");
        disconnect(fileReader);

        FileWriter fileWriter = connectToWrite(false);
        try {
            for (String s: workerList) {
                fileWriter.write(s);
                fileWriter.append(System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        disconnect(fileWriter);
    }

    public Worker getWorker(String id) throws Exception {
        FileReader fileReader = connectToRead();
        Scanner scanner = new Scanner(fileReader);
        Worker worker = null;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line.startsWith(id + " ")){
                String [] info = line.split(" ");
                LocalDate birthDate = LocalDate.parse(info[4], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                LocalDate employmentDate = LocalDate.parse(info[5], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                worker = new Worker(info[0], info[1], Integer.parseInt(info[2]), info[3],
                        birthDate, employmentDate, info[6], info[7], info[8]);
            }
        }
        if(worker != null) return worker;
        else throw new Exception("Not valid ID");
    }

    public void setSourceStr(String sourceStr) {
        this.sourceStr = sourceStr;
    }
}
