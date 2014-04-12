package by.andersen.info2.controllers;


import by.andersen.info.webservices.Person;
import by.andersen.info2.ejbapi.PersonReport;

import javax.ejb.EJB;
import java.util.Date;

public class PersonReportController {
    @EJB
    private PersonReport personReport;

    private Person person;

    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public PersonReport getPersonReport() {
        return personReport;
    }

    public void setPersonReport(PersonReport personReport) {
        this.personReport = personReport;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public PersonReportController() {
    }

    public String findPerson(String firstName, String lastName, String patronymic, Date birthdayDate) {
        Person p = personReport.jaxwsFindPerson(firstName, lastName, patronymic, birthdayDate);
        this.person = p;
        return "result";
    }
}
