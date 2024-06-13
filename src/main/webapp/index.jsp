<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<form action="Controller/result.jsp" method="post">
    <label for="cantidad">Cantidad a prestar:</label>
    <input type="text" id="cantidad" name="cantidad" required><br><br>

    <label for="plazo">Plazo (hasta 12 meses):</label>
    <input type="number" id="plazo" name="plazo" required><br><br>

    <input type="submit" value="Calcular pagos mensuales">
</form>
</body>
</html>
