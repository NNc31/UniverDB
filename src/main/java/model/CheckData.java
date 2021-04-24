package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class CheckData {
    public static Worker checkAndCreateWorker(String surname, String department, String birthStr,
                                     String employmentStr, String position, String degree, String rank) {
        LocalDate birth, employment;
        try {
            birth = LocalDate.parse(birthStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            employment = LocalDate.parse(employmentStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (DateTimeParseException e) {
            return null;
        }

        int age = (int) ChronoUnit.YEARS.between(birth, LocalDate.now());
        if (degree.matches("Відсутній|Кандидат|Доктор_наук") &&
                rank.matches("Відсутнє|Доцент|Професор") &&
                age >= 18 && !employment.isAfter(LocalDate.now()) && !department.isEmpty() &&
                !position.isEmpty() && !surname.isEmpty()) {
            return new Worker(surname, age, department, birth, employment, position, degree, rank);
        }
        else return null;
    }

    public static boolean checkFilters(String minAge, String maxAge, String rank) {
        int min, max;
        try {
            if (minAge.isBlank()) min = 0;
            else min = Integer.parseInt(minAge);
            if (maxAge.isBlank()) max = Integer.MAX_VALUE;
            else max = Integer.parseInt(maxAge);
        } catch (NumberFormatException e) {
            return false;
        }
        return rank.matches("Відсутнє|Доцент|Професор|Неважливо") && min <= max && min >= 0;
    }
}
