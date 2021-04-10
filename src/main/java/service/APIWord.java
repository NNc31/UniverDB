package service;

import model.Worker;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import javax.swing.*;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class APIWord {
    public void createFile(){

    }
    private void saveFile(){}
    public void writeToFile(List<Worker> workerList){
        XWPFDocument document = new XWPFDocument();
        List<XWPFParagraph> paragraphList = new LinkedList<>();
        for (Worker w : workerList) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Прізвище: ").append(w.getSurname()).append("\tдата народження: ").append(w.getBirthDate());
            stringBuilder.append("\tназва кафедри: ").append(w.getDepartment()).append("\tпосада: ").append(w.getPosition());
            stringBuilder.append("\tнауковий ступінь: ").append(w.getDegree()).append("\tвчене звання: ").append(w.getRank());
            stringBuilder.append("\tдата працевлаштування: ").append(w.getEmploymentDate());
            String info = stringBuilder.toString();
            document.createParagraph().createRun().setText(info);
        }
        JFileChooser fileChooser = new JFileChooser();
        if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            try (FileOutputStream fos = new FileOutputStream(fileChooser.getSelectedFile())) {
                document.write(fos);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
