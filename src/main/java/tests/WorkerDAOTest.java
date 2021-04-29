package tests;

import model.Worker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.WorkerDAO;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class WorkerDAOTest {

    private WorkerDAO dao = new WorkerDAO();

    @Before
    public void setUp() {
        dao.setSourceStr("TestDB.txt");
    }

    @Test
    public void readTest() {
        List<Worker> workerList = new LinkedList<Worker>();

        workerList.add(new Worker("0", "TestName1", 21, "TTT",
                LocalDate.parse("20.08.1999", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                LocalDate.parse("28.08.2020", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                "Job1", "Доктор_наук", "Професор"));
        workerList.add(new Worker("1", "TestName2", 25, "NNN",
                        LocalDate.parse("20.08.1995", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                        LocalDate.parse("28.03.2021", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                        "Job2", "Відсутній", "Відсутнє"));
        workerList.add(new Worker("2","TestName3", 26, "DDD",
                LocalDate.parse("20.03.1995", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                LocalDate.parse("02.03.2015", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                "Job3", "Кандидат", "Доцент"));
        try {
            Assert.assertEquals("Дані не співпадають", workerList, dao.read(0, 100, null));
        } catch (Exception e) {
            Assert.fail("Збій при роботі з БД");
        }
    }

    @Test
    public void createAndDeleteTest(){
        try {
            List<Worker> beforeOperation = dao.read(0, 100, null);
            dao.create(new Worker("Егор", 30, "АМФ",
                    LocalDate.parse("20.06.1991", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    LocalDate.parse("15.02.2021", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                    "Секретар", "Доктор_наук", "Професор"));
            dao.delete(String.valueOf(beforeOperation.size()));
            List<Worker> afterOperation = dao.read(0, 100, null);
            Assert.assertEquals("Дані некоректні", beforeOperation, afterOperation);
        } catch (Exception e) {
            Assert.fail("Помилка операції");
        }
    }
}