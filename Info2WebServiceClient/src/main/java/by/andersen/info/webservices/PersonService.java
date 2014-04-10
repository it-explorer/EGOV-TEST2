
package by.andersen.info.webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PersonService", targetNamespace = "http://webservices.info.andersen.by/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PersonService {


    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns by.andersen.info.webservices.Person
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPerson", targetNamespace = "http://webservices.info.andersen.by/", className = "by.andersen.info.webservices.GetPerson")
    @ResponseWrapper(localName = "getPersonResponse", targetNamespace = "http://webservices.info.andersen.by/", className = "by.andersen.info.webservices.GetPersonResponse")
    @Action(input = "http://webservices.info.andersen.by/PersonService/getPersonRequest", output = "http://webservices.info.andersen.by/PersonService/getPersonResponse")
    public Person getPerson(
            @WebParam(name = "arg0", targetNamespace = "")
            String arg0,
            @WebParam(name = "arg1", targetNamespace = "")
            String arg1,
            @WebParam(name = "arg2", targetNamespace = "")
            String arg2,
            @WebParam(name = "arg3", targetNamespace = "")
            XMLGregorianCalendar arg3);

}
