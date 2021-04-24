package tests;

import model.CheckData;
import model.Worker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class CheckDataTest {
    private String surname;
    private String department;
    private String birthStr;
    private String employmentStr;
    private String position;
    private String degree;
    private String rank;

    @Before
    public void setUp(){
        surname = "Микола";
        department = "ТеСЕТ";
        birthStr = "21.03.1995";
        employmentStr = "12.05.2015";
        position = "Викладач";
        degree = "Кандидат";
        rank = "Доцент";
    }

    @Test
    public void checkAndCreateWorkerTest(){
        setUp();
        Worker worker = new Worker("Микола",26, "ТеСЕТ",
                LocalDate.parse("21.03.1995", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                LocalDate.parse("12.05.2015", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                "Викладач", "Кандидат", "Доцент");
        Assert.assertEquals("Неочікувані дані працівника", worker, CheckData.checkAndCreateWorker(surname, department, birthStr, employmentStr, position, degree, rank));
    }
}