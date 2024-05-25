import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CalculoRaices")
public class CalculoRaices extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los parámetros del formulario
        double a = Double.parseDouble(request.getParameter("coeficienteA"));
        double b = Double.parseDouble(request.getParameter("coeficienteB"));
        double c = Double.parseDouble(request.getParameter("coeficienteC"));

        // Configurar la respuestaaa
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

      
        double x1;
        double x2;

        //CALCULO DE LA RAIZ MÁS GRANDE
        double Dentro_Raiz = b * b - 4 * a * c;
        
        // Calcular las raíces
        out.println("<html>");
        out.println("<body>");
        out.println("<h2>Resultados de la Ecuación de Segundo Grado</h2>");
        //CASO REAL
        if (Dentro_Raiz > 0) {
            x1 = (-b + Math.sqrt(Dentro_Raiz)) / (2 * a);
            x2 = (-b - Math.sqrt(Dentro_Raiz)) / (2 * a);
            out.println("<p>Raices reales:</p>");
            out.println("<p>Primera Raíz: " + x1 + "</p>");
            out.println("<p>Segunda Raíz: " + x2 + "</p>");
        } /*Caso complejo*/else if (Dentro_Raiz < 0) {
            //para pa primera raiz
            x1 = -b/(2*a); 
            x2 = Math.sqrt(Math.abs(Dentro_Raiz)) / (2 * a);
            out.println("<p>Raices complejas:</p>");
            out.println("<p>Primera Raíz: " + x1 + " + " + x2 + "i</p>");
            out.println("<p>Segunda Raíz: " + x1 + " - " + x2 + "i</p>");
        } 

        out.println("</body>");
        out.println("</html>");
    }
}
