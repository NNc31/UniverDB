package service;

import model.Worker;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import javax.swing.*;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class APIWord {
    public void createFile(){ // xз шо тут писать
    }
    private void saveFile(XWPFDocument document) throws Exception {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File("EmployeesInfo.docx"));
        if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            try (FileOutputStream fos = new FileOutputStream(fileChooser.getSelectedFile())) {
                document.write(fos);
            } catch (IOException e) {
                throw new Exception("Data could not be written to file");
            }
        }
    }
    public void writeToFile(List<Worker> workerList) throws Exception {
        XWPFDocument document = new XWPFDocument();
        for (Worker w : workerList) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Прізвище: ").append(w.getSurname()).append("    Дата народження: ")
                    .append(w.getBirthDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")))
                    .append("    Назва кафедри: ").append(w.getDepartment()).append("    Посада: ")
                    .append(w.getPosition()).append("    Науковий ступінь: ").append(w.getDegree())
                    .append("    Вчене звання: ").append(w.getRank()).append("    Дата працевлаштування: ")
                    .append(w.getEmploymentDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
            String info = stringBuilder.toString();
            document.createParagraph().createRun().setText(info);
            document.createParagraph().createRun();
        }
        saveFile(document);

    }
}
