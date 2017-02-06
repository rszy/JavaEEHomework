package pl.ex1;

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
@WebServlet("/SumServlet")
public class SumServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String	inputNumber = request.getParameter("liczbaN");
        int number = Integer.parseInt(inputNumber);
        int sum = 0;
        for (int i = 0; i <= number; i++) {
            sum = sum + i;
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.print("<!DOCTYPE	html>");
        writer.print("<html><body>");
        writer.print("<h1>");
        if (number == 0) {
            writer.print(number);
        } else if (number <= 4) {
            for (int i = 0; i < number; i++) {
                writer.print(i + " + ");
            }
            writer.print(number);
        } else if (number > 4){
            writer.print("0 + 1 + 2 + 3 + ... + "+number);
        }
        writer.print(" = "+sum);

        writer.print("</h1>");
        writer.print("</body></html>");
    }
}
