package mx.edu.unistmo;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.bson.Document;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import jakarta.servlet.http.Cookie;

@WebServlet("/login")
public class SessionServlet extends HttpServlet {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> usuariosCollection;
    private MongoCollection<Document> passwordsCollection;

    @Override
    public void init() throws ServletException {
        mongoClient = MongoClients.create(
                "mongodb+srv://giovanni:Giovani129se23nf@cluster0.qfbkqre.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0");
        database = mongoClient.getDatabase("miBaseDeDatos");
        usuariosCollection = database.getCollection("usuarios");
        passwordsCollection = database.getCollection("passwords");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String contraseña = request.getParameter("contraseña");

        boolean credencialesValidas = verificarCredenciales(usuario, contraseña);

        if (credencialesValidas) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);

            if (request.getParameter("recordar") != null) {
      
                HttpSession session = request.getSession(true);
                session.setAttribute("usuario", usuario);
                session.setMaxInactiveInterval(7 * 24 * 60 * 60); 

                Cookie usuarioCookie = new Cookie("usuario", usuario);
                Cookie contraseñaCookie = new Cookie("contraseña", contraseña);
                usuarioCookie.setMaxAge(7 * 24 * 60 * 60); 
                contraseñaCookie.setMaxAge(7 * 24 * 60 * 60);
                response.addCookie(usuarioCookie);
                response.addCookie(contraseñaCookie);
            }

            response.sendRedirect("bienvenida.jsp");
        } else {
            request.setAttribute("mensajeError", "Usuario o contraseña incorrectos");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private boolean verificarCredenciales(String usuario, String contraseña) {

        Document usuarioDocument = usuariosCollection.find(Filters.eq("usuario", usuario)).first();
        if (usuarioDocument == null) {
            return false; // Usuario no encontrado
        }

        Document contraseñaDocument = passwordsCollection
                .find(Filters.and(Filters.eq("usuario", usuario), Filters.eq("contraseña", contraseña))).first();
        return contraseñaDocument != null;
    }

    @Override
    public void destroy() {
        mongoClient.close();
    }
}