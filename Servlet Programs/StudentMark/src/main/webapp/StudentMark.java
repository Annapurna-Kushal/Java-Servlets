import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/StudentMark")
public class StudentMark extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.html").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //logic to find factorial
        // Set response content type
        response.setContentType("text/html");

        // Get parameters from the request
        int marks = Integer.parseInt(request.getParameter("marks"));

        // Write the result to the response
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if(marks>=50)
            out.println("<h4>Pass</h4>");
        else
            out.println("<h4>Fail</h4>");
        out.println("</body></html>");
    }
}
