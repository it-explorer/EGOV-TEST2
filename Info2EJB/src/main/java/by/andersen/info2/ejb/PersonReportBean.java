package by.andersen.info2.ejb;

import by.andersen.info.webservices.Person;
import by.andersen.info.webservices.PersonService;
import by.andersen.info.webservices.PersonServiceService;
import by.andersen.info2.ejbapi.PersonReport;

import javax.ejb.Stateless;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.InputStream;
import java.util.Date;
import java.util.GregorianCalendar;

@Stateless
public class PersonReportBean implements PersonReport {

    /*private static Collection findReportData()
    {
        //declare a list of object
        List<Person> data = new LinkedList<Person>();
        Person p1 = new Person();
        p1.setFirstName("John");
        p1.setSurname("Smith");
        p1.setAge(Integer.valueOf(5));
        data.add(p1);
        return data;
    }*/

    @Override
    public void getPersonReport(Person person) {
        /*
        try
        {
            InputStream resourceAsStream = Thread.currentThread().getContextClassLoader()
                    .getResourceAsStream(reportTemplateUrl);
            //get report file and then load into jasperDesign
            jasperDesign = JRXmlLoader.load(resourceAsStream);
            //compile the jasperDesign
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            //fill the ready report with data and parameter
            jasperPrint = JasperFillManager.fillReport(jasperReport, null,
                    new JRBeanCollectionDataSource(
                            findReportData()));
            //view the report using JasperViewer
            JasperViewer.viewReport(jasperPrint);
        }
        catch (JRException e)
        {
            e.printStackTrace();
        }

         */
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
