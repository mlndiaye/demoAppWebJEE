package sn.ept.git.dic2.demoappwebjee;

import java.io.*;

import jakarta.ejb.EJB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sn.ept.git.dic2.demoappwebjee.entities.Departement;
import sn.ept.git.dic2.demoappwebjee.services.DepartementFacade;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    @EJB
    private DepartementFacade departementFacade;

    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

        Departement d1 = new Departement();
        d1.setCode("GIT");
        d1.setNom("Informatique");

        departementFacade.createDepartement(d1);
    }

    public void destroy() {
    }
}