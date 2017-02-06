package pl.ex3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Rysiek on 2017-02-06.
 */
@WebServlet("/CalculateServlet")
public class CalculateServlet extends HttpServlet {

    private int outputResult;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<!DOCTYPE	html>");
        writer.print("<html><body>");
        writer.print("<h3>");
        if (checkResult(request)) {
            writer.print("Wynik działania jest poprawny");
        } else {
            writer.print("Wynika działanie jest niepoprawny. Poprawny wynik to:"+outputResult);
        }
        writer.print("<br>");
        writer.print("<br>");
        writer.print("<a href='/index1.html'>Powrót do formularza</a>");
        writer.print("</h3>");
        writer.print("</body></html>");

    }


    private boolean checkResult(HttpServletRequest request) {
        int nr1 = Integer.parseInt(request.getParameter("number1"));
        int nr2 = Integer.parseInt(request.getParameter("number2"));
        int result = Integer.parseInt(request.getParameter("result"));
        String option = request.getParameter("options");
        boolean check = false;
        if (option.equals("+")){
            check = (nr1+nr2)==result;
            outputResult = nr1+nr2;
        }
        if (option.equals("-")) {
            check = (nr1-nr2)==result;
            outputResult = nr1-nr2;
        }
        if (option.equals("*")) {
            check = (nr1*nr2)==result;
            outputResult = nr1*nr2;
        }
        if (option.equals("/")) {
            check = (nr1/nr2)==result;
            outputResult = nr1/nr2;
        }
        return check;

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
