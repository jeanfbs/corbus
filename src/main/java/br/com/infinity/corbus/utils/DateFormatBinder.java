package br.com.infinity.corbus.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class DateFormatBinder {

    @Value("${date.format}")
    private String dateFormat;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat df = new SimpleDateFormat(dateFormat);
        df.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(df, true));
    }
}
