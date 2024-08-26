import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/DateAndTime")

public class DateAndTime extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Index.html").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //logic to find factorial
        // Set response content type
        response.setContentType("text/html");

        //get current date and time
        LocalDateTime currentDate = LocalDateTime.now();

        // Format date as "dd-MM-yyyy"
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = currentDate.format(dateFormatter); //current date in the format needed

        // Format time as "HH:mm:ss" (24-hour format)
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentDate.format(timeFormatter); //current time in the format needed

        // Write the result to the response
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Current date: "+formattedDate);
        out.println("<h3>Current time: "+formattedTime);
        out.println("</body></html>");
    }

}
