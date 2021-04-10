package service;

import model.Worker;

import java.io.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WorkerDAO {

    private File source;

    private FileReader connectToRead() {
        source = new File("DataBase.txt");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(source);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fileReader;
    }
    private FileWriter connectToWrite(boolean append){
        source = new File("DataBase.txt");
        FileWriter fileWriter = null;
        try{
            fileWriter = new FileWriter(source, append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileWriter;

    }

    private void disconnect(Reader reader) {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void disconnect(Writer writer){
        try {
            writer.close();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void create(Worker worker) {
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
        stringBuilder.append(worker.getId());
        stringBuilder.append(" ");
        stringBuilder.append(worker.getSurname());
        stringBuilder.append(" ");
        stringBuilder.append(worker.getAge());
        stringBuilder.append(" ");
        stringBuilder.append(worker.getDepartment());
        stringBuilder.append(" ");
        stringBuilder.append(worker.getBirthDate());
        stringBuilder.append(" ");
        stringBuilder.append(worker.getEmploymentDate());
        stringBuilder.append(" ");
        stringBuilder.append(worker.getPosition());
        stringBuilder.append(" ");
        stringBuilder.append(worker.getDegree());
        stringBuilder.append(" ");
        stringBuilder.append(worker.getRank());
        try {
            fileWriter.write(stringBuilder.toString());
            fileWriter.append(System.getProperty("line.separator"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        disconnect(fileWriter);
    }

    public List<Worker> read(int minAge, int maxAge, String rank) {
        List<Worker> list = new LinkedList<>();
        FileReader fileReader = connectToRead();
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String []info = line.split(" ");
            int workerAge = Integer.parseInt(info[1]);
            String workerRank = info[7];
            if(workerAge >= minAge && workerAge <= maxAge && (rank == null || workerRank.equals(rank))){
                LocalDate birthDate = LocalDate.parse(info[4]);
                LocalDate employmentDate = LocalDate.parse(info[5]);
                list.add(new Worker(info[0], info[1], Integer.parseInt(info[2]), info[3],
                        birthDate, employmentDate, info[6], info[7], info[8]));
            }
        }
        disconnect(fileReader);
        return list;
    }

    public void update(String id, Worker worker) {
        worker.setId(id);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(worker.getId());
        stringBuilder.append(" ");
        stringBuilder.append(worker.getSurname());
        stringBuilder.append(" ");
        stringBuilder.append(worker.getAge());
        stringBuilder.append(" ");
        stringBuilder.append(worker.getDepartment());
        stringBuilder.append(" ");
        stringBuilder.append(worker.getBirthDate());
        stringBuilder.append(" ");
        stringBuilder.append(worker.getEmploymentDate());
        stringBuilder.append(" ");
        stringBuilder.append(worker.getPosition());
        stringBuilder.append(" ");
        stringBuilder.append(worker.getDegree());
        stringBuilder.append(" ");
        stringBuilder.append(worker.getRank());
        String newWorkerInfo = stringBuilder.toString();

        FileReader fileReader = connectToRead();
        Scanner scanner = new Scanner(fileReader);
        LinkedList<String> workerList = new LinkedList<>();
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line.startsWith(id + " ")){
                line = newWorkerInfo;
            }
            workerList.add(line);
        }
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

    public void delete(String id) {
        FileReader fileReader = connectToRead();
        Scanner scanner = new Scanner(fileReader);
        LinkedList<String> workerList = new LinkedList<>();
        int count = 0;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(! line.startsWith(id + " ")){
                line = count + line.substring(line.indexOf(" "));
                workerList.add(line);
                count++;
            }
        }
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
}