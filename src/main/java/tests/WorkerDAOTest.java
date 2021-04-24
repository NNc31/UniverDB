package tests;

import model.Worker;
import org.junit.Assert;
import org.junit.Test;
import service.WorkerDAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class WorkerDAOTest {

    @Test
    public void readTest() {
        List<Worker> workerList = new LinkedList<Worker>();
        workerList.add(new Worker("0", "Alex", 21, "ІТП",
                LocalDate.parse("20.08.1999", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                LocalDate.parse("28.08.2020", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                "Викладач", "Доктор_наук", "Професор"));
        workerList.add(new Worker("1", "Віталій", 25, "ФФТ",
                        LocalDate.parse("20.08.1995", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                        LocalDate.parse("28.03.2021", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                        "Охоронець", "Відсутній", "Відсутнє"));
        workerList.add(new Worker("2","Іван", 26, "КНТ",
                LocalDate.parse("20.03.1995", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                LocalDate.parse("02.03.2015", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                "секретар", "Кандидат", "Доцент"));
        try {
            Assert.assertEquals("Дані не співпадають", workerList, new WorkerDAO().read(0, 100, null));
        } catch (Exception e) {
            Assert.fail("Збій при роботі з БД");
        }
    }

    @Test
    public void createAndDeleteTest(){
        try {
            WorkerDAO workerDAO = new WorkerDAO();
            List<Worker> beforeOperation = workerDAO.read(0, 100, null);
            workerDAO.create(new Worker("Егор", 30, "АМФ",
                    LocalDate.parse("20.06.1991", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    LocalDate.parse("15.02.2021", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    "Секретар", "Доктор_наук", "Професор"));
            workerDAO.delete(String.valueOf(beforeOperation.size()));
            List<Worker> afterOperation = workerDAO.read(0, 100, null);
            Assert.assertEquals("Дані некоректні", beforeOperation, afterOperation);
        } catch (Exception e) {
            Assert.fail("Помилка операції");
        }
    }
}