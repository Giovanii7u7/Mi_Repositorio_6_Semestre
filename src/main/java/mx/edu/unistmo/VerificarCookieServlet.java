package mx.edu.unistmo;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;

@WebServlet("/verificarCookie")
public class VerificarCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Verificar si hay una cookie de usuario almacenada
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("usuario")) {
                    // Si se encuentra una cookie de usuario, redirigir a la página de bienvenida
                    response.sendRedirect("bienvenida.jsp");
                    return; // Terminar la ejecución del servlet
                }
            }
        }

        // Si no hay cookie de usuario, redirigir a index.jsp
        response.sendRedirect("index.jsp");
    }
}