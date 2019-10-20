package by.epam.finalproject.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormatterTag extends SimpleTagSupport {

    private String dateTime;

    public DateFormatterTag() {
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public void doTag() throws JspException, IOException {
        String date = dateTime;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);

        ZonedDateTime zdt = dateTime.atZone(ZoneId.systemDefault());
        Date currentDate = Date.from(zdt.toInstant());

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        getJspContext().getOut().write(dateFormat.format(currentDate));
    }
}
