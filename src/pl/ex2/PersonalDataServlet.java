package pl.ex2;

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
@WebServlet("/PersonalDataServlet")
public class PersonalDataServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String inputFirstName = request.getParameter("firstName");
        String inputLastName = request.getParameter("lastName");
        String inputAge = request.getParameter("age");
        String inputAddress = request.getParameter("addressURL");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<!DOCTYPE	html>");
        writer.print("<html><body>");
        writer.print("<h3>");
        if (inputFirstName.equals("") || inputLastName.equals("")) {
            writer.print("Pola Imię oraz Nazwisko są obowiązkowe. Wprowadź dane.");
            writer.print("<br>");
            writer.print("<br>");
            writer.print("<a href='/'>Powrót do formularza</a>");
        } else {
            writer.print("Następujące dane zostały odebrane:");
            writer.print("<br>");
            writer.print(inputFirstName);
            writer.print("<br>");
            writer.print(inputLastName);
            writer.print("<br>");
            writer.print(inputAge);
            writer.print("<br>");
            writer.print(inputAddress);
            writer.print("<br>");
        }
        writer.print("</h3>");
        writer.print("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
