package by.andersen.info2.ejbapi;

import by.andersen.info.webservices.Person;

import javax.ejb.Local;
import java.util.Date;

@Local
public interface PersonReport {
    void getPersonReport(Person person);

    Person jaxwsFindPerson(String firstName, String lastName, String patronymic, Date birthdayDate);
}
