package mx.edu.unistmo;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebFilter("/login")
public class CookieFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Verificar si hay una cookie de usuario almacenada
        Cookie[] cookies = httpRequest.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("usuario")) {
                    // Si se encuentra una cookie de usuario, redirigir a la página de bienvenida
                    httpResponse.sendRedirect("bienvenida.jsp");
                    return; // Terminar la ejecución del filtro
                }
            }
        }

        // Si no hay cookie de usuario, continuar con la solicitud normal
        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {
        // Método de inicialización del filtro (no se necesita en este caso)
    }

    public void destroy() {
        // Método de destrucción del filtro (no se necesita en este caso)
    }
}