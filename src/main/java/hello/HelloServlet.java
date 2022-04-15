package hello;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {

    private void responsePage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        String msg = "";
        String pronome = "";
        
        String lang = request.getParameter("lang");
        if(lang==null)
            lang = "pt";
        switch(lang){
            case "pt":
                msg = "Olá, ";
                switch(request.getParameter("pronome")){
                    case "sr":
                        pronome = "Sr.";
                        break;
                    case "sra":
                        pronome = "Sra.";
                        break;
                }
                break;
            case "en":
                msg = "Hello, ";
                switch(request.getParameter("pronome")){
                    case "sr":
                        pronome = "Mr.";
                        break;
                    case "sra":
                        pronome = "Ms.";
                        break;
                }
                break;
            case "fr":
                msg = "Bonjour, ";
                switch(request.getParameter("pronome")){
                    case "sr":
                        pronome = "M.";
                        break;
                    case "sra":
                        pronome = "Mme.";
                        break;
                }
                break;
            case "de":
                msg = "Hallo, ";
                switch(request.getParameter("pronome")){
                    case "sr":
                        pronome = "Herr";
                        break;
                    case "sra":
                        pronome = "Frau";
                        break;
                }
                break;
            case "jp":
                msg = "Kon'nichiwa, ";
                switch(request.getParameter("pronome")){
                    case "sr":
                        pronome = "Shi";
                        break;
                    case "sra":
                        pronome = "Fujin";
                        break;
                }
            case "su":
                msg = "Habari, ";
                switch(request.getParameter("pronome")){
                    case "sr":
                        pronome = "Bwana";
                        break;
                    case "sra":
                        pronome = "Bi";
                        break;
                }
        }
        
        String nome = request.getParameter("nome");

        if(nome == null)
            nome = "Fulano";
        
        msg = msg + pronome + nome + "!";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.responsePage(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.responsePage(request, response);
    }
}
