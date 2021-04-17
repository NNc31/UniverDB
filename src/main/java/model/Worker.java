package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Worker {
    private String id;
    private String surname;
    private int age;
    private String department;
    private LocalDate birthDate;
    private LocalDate employmentDate;
    private String position;
    private String degree;
    private String rank;

    public Worker() {
    }

    public Worker(String surname, int age, String department, LocalDate birthDate,
                  LocalDate employmentDate, String position, String degree, String rank) {
        this.surname = surname;
        this.age = age;
        this.department = department;
        this.birthDate = birthDate;
        this.employmentDate = employmentDate;
        this.position = position;
        this.degree = degree;
        this.rank = rank;
    }

    public Worker(String id, String surname, int age, String department, LocalDate birthDate,
                  LocalDate employmentDate, String position, String degree, String rank) {
        this.id = id;
        this.surname = surname;
        this.age = age;
        this.department = department;
        this.birthDate = birthDate;
        this.employmentDate = employmentDate;
        this.position = position;
        this.degree = degree;
        this.rank = rank;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return id +
                " " + surname +
                "\t" + department +
                "\t" + birthDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) +
                "\t" + employmentDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) +
                "\t" + position +
                "\t" + degree +
                "\t" + rank;
    }
}
