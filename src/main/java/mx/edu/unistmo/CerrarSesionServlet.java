package mx.edu.unistmo;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.http.Cookie;

@WebServlet("/CerrarSesionServlet")

public class CerrarSesionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Destruir las cookies de usuario
        Cookie usuarioCookie = new Cookie("usuario", "");
        usuarioCookie.setMaxAge(0); // Establecer la duración de la cookie a cero para eliminarla
        response.addCookie(usuarioCookie);

        // Redirigir a la página de inicio
        response.sendRedirect("index.jsp");
    }
}
