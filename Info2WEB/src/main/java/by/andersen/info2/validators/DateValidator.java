package by.andersen.info2.validators;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        FacesMessage facesMessage;
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            Date date = dateFormat.parse((String) o);

            if (date.after(new Date(System.currentTimeMillis()))) {
                facesMessage = new FacesMessage("date after current date");
                throw new ValidatorException(facesMessage);
            }
        } catch (ParseException e) {
            facesMessage = new FacesMessage("incorrect date. must be yyyy-mm-dd");
            throw new ValidatorException(facesMessage);
        }
    }
}
