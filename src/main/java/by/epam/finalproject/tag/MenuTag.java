package by.epam.finalproject.tag;

import by.epam.finalproject.entity.ROLE;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class MenuTag extends TagSupport {

    private ROLE role;

    public void setRole(ROLE role) {
        this.role = role;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            String greeting = null;
            if (ROLE.ADMIN.equals(role)) {
                greeting = "Hello, " + role;
            } else {
                greeting = "Welcome, guest!";
            }
            JspWriter jspWriter = pageContext.getOut();
            jspWriter.write(("<hr/>" + greeting + "<hr/>"));
        } catch (IOException e) {
            throw new JspException("Menu tag failed.", e);
        }
        return SKIP_BODY;
    }
}
