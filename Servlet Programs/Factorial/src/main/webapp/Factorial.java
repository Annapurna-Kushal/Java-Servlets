import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/Factorial")
public class Factorial extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.html").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //logic to find factorial
        // Set response content type
        response.setContentType("text/html");

        // Get parameters from the request
        int number = Integer.parseInt(request.getParameter("num"));

        // Check if username and password are correct (just a dummy check)
        int factorial = factorial(number);

        // Write the result to the response
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Factorial of "+number+" is: "+factorial);
        out.println("</body></html>");
    }
    private int factorial(int number) {
        int res=1;
        for(int i=number; i>=2; i--) {
            res=res*i;
        }
        return res;
    }

}
