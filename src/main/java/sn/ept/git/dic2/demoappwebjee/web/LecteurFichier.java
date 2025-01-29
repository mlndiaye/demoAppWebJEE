package sn.ept.git.dic2.demoappwebjee.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "lecteurfichier", urlPatterns ={"/telechargement/*","/document/*"})
public class LecteurFichier extends HttpServlet {
    private File document;
    private File telechargement ;


    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("initialisation du LecteurFichier");
        document = new File("C:\\Users\\DELL\\Documents");
        telechargement = new File("C:\\Users\\DELL\\Downloads");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>LecteurFichier</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>uri="+req.getRequestURI()+"</h1> <br>");
        out.println("<h1>context="+req.getContextPath()+"</h1> <br>");
        out.println("<h1>path="+req.getPathInfo()+"</h1> <br>");        out.println("<h1>path="+req.getPathInfo()+"</h1> <br>");
        out.println("<h1>querystring="+req.getQueryString()+"</h1> <br>");
        out.println("<h1>path="+req.getServletPath()+"</h1> <br>");
        String regrex = req.getContextPath()+"/(document|telechargement)[/]*(.*)";
        out.println("<h1>regrex="+regrex+"</h1> <br>");

        Pattern p = Pattern.compile(regrex);
        Matcher m = p.matcher(req.getRequestURI());
        if (m.matches()) {
            out.println("<h1>repertoire="+m.group(1)+"</h1> <br>");
            out.println("<h1>fichier="+m.group(2)+"</h1> <br>");
            File filedir ;
            if (m.group(1).equals("document")) {
                filedir = document;

            }else {
                filedir = telechargement;

            }
            File fichier = new File(filedir,m.group(2));
            if (fichier.exists()) {
                out.println("<h1>fichier="+fichier+"</h1>");
                if (fichier.isDirectory()){
                    File[] files = fichier.listFiles();
                    for (File file : files) {
                        out.println("<h1>fichier="+file.getName()+"</h1>");
                    }
                } else if (fichier.isFile()) {
                    

                }
            }else {
                out.println("<h1>fichier néxiste pas"+fichier+"</h1>");
            }

        }else
            out.println("<h1>regrex non valider !</h1> <br>");





        out.println("<h1>url="+req.getRequestURL()+"</h1>");
        out.println("</body>");
        out.println("</html>");


    }

    @Override
    public void destroy() {
        System.out.println("destroy du LecteurFichier");
        super.destroy();

    }

}
