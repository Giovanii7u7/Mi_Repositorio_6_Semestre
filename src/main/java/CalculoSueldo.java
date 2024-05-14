import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CalculoSueldo")
public class CalculoSueldo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double sueldoDiario = Double.parseDouble(request.getParameter("sueldoDiario"));
        int diasTrabajados = Integer.parseInt(request.getParameter("diasTrabajados"));

        //Calculo del sueldo total
        double sueldoTotal = sueldoDiario * diasTrabajados;


        //configuracion salida
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (diasTrabajados < 1 || diasTrabajados > 15) {
            out.println("<html>");
            out.println("<body>");
            out.println("<h2>Los dias no corresponden con el rango establecido</h2>");
            out.println("</body>");
            out.println("</html>");
        } else {
            out.println("<html>");
            out.println("<body>");
            out.println("<h2>Sueldo total:</h2>");
            out.println("<p>Sueldo Total: " + sueldoTotal + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
