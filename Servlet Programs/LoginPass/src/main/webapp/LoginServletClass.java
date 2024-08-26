import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
@WebServlet("/LoginServletClass")
public class LoginServletClass extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // doGet method to handle GET requests
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward GET requests to the login page
        request.getRequestDispatcher("index.html").forward(request, response);
    }

    // doPost method to handle POST requests
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Get parameters from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check if username and password are correct (just a dummy check)
        boolean isValidUser = validateUser(username, password);

        // Write the result to the response
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (isValidUser) {
            out.println("<h2>Hello, " + username + "!</h2>");
        } else {
            out.println("<h2>Login failed. Please check your username and password.</h2>");
        }
        out.println("</body></html>");
    }

    // Dummy method to validate username and password (replace with actual validation logic)
    private boolean validateUser(String username, String password) {
        // Dummy credentials
        String validUsername = "admin";
        String validPassword = "password";

        // Check if username and password match
        return username.equals(validUsername) && password.equals(validPassword);
    }
}
