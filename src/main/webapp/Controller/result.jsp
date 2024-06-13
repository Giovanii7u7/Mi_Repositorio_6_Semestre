<%--
  Created by IntelliJ IDEA.
  User: giova
  Date: 13/06/2024
  Time: 09:21 a. m.
  To change this template use File | Settings | File Templates.
--%><%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.model.BeanCiclico" %>
<%@ page import="java.util.Arrays" %>
<html>
<head>
    <title>Resultados</title>
</head>
<body>
<h1>Resultado</h1>

<%
    try {
        double cantidad = Double.parseDouble(request.getParameter("cantidad"));
        int plazo = Integer.parseInt(request.getParameter("plazo"));

        BeanCiclico bean = new BeanCiclico();
        bean.setCantidad(cantidad);
        bean.setPlazo(plazo);

        double[] pagos = bean.calcularPagosMensuales();
%>


<h2>Pagos Mensuales:</h2>
<ul>
    <% for (int i = 0; i < pagos.length; i++) { %>
    <li>Mes <%= i + 1 %>: <%= pagos[i] %></li>
    <% } %>
</ul>

<%
} catch (IllegalArgumentException e) {
%>
<h2>Error:</h2>
<p><%= e.getMessage() %></p>
<% } %>

</body>
</html>
