<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Formulario de Trabajo</title>
</head>
<body>
    <h2>Ejercicio 1</h2>
    <form action="CalculoSueldo" method="post">
        Nombre: <input type="text" name="nombre" ><br><br>
        Sueldo diario: <input type="number" name="sueldoDiario" ><br><br>
        Cantidad de días Trabajados: <input type="number" name="diasTrabajados" ><br><br>
        <button type="submit">Enviar</button>
    </form>

    <a href="calculos.jsp">Ir a Cálculos</a>
</body>
</html>
