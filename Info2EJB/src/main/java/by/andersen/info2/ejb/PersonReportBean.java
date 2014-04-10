package by.andersen.info2.ejb;

import by.andersen.info.webservices.Person;
import by.andersen.info.webservices.PersonService;
import by.andersen.info.webservices.PersonServiceService;
import by.andersen.info2.ejbapi.PersonReport;

import javax.ejb.Stateless;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Stateless
public class PersonReportBean implements PersonReport {
    @Override
    public void getPersonReport() {
        System.out.println("personBean");
    }

    @Override
    public Person jaxwsFindPerson(String firstName, String lastName, String patronymic, Date birthdayDate) {
        PersonServiceService personService = new PersonServiceService();
        PersonService service = personService.getPersonServicePort();
        Person person = service.getPerson(firstName, lastName, patronymic, toXMLGregorianCalendar(birthdayDate));
        return person;
    }

    private XMLGregorianCalendar toXMLGregorianCalendar(Date date) {
        GregorianCalendar gCalendar = new GregorianCalendar();
        gCalendar.setTime(date);
        XMLGregorianCalendar xmlCalendar = null;
        try {
            xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
        } catch (DatatypeConfigurationException ex) {
            ex.printStackTrace();
        }
        return xmlCalendar;
    }
}
