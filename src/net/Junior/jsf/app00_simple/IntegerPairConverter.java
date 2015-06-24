package net.Junior.jsf.app00_simple;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by root on 24.06.2015.
 */
@FacesConverter("IntegerPairConverter")
public class IntegerPairConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String str) {
        String[] strTokens = str.split(".");
        if (strTokens.length > 1) {
            try {
                int num1 = Integer.valueOf(strTokens[0]);
                int num2 = Integer.valueOf(strTokens[1]);
                return new IntegerPair(num1, num2);
            } catch (RuntimeException ex) {
                /*Something wrong*/
            }
        }
        //so throw error message
        FacesMessage facesMessage = new FacesMessage(
                "Bad integer pair",
                "Integer pair must have format '123.456'");
        facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
        throw new ConverterException(facesMessage);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        IntegerPair integerPair = (IntegerPair) o;
        return integerPair.toString();
    }
}
