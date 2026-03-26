<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AeroFly - Reserva de Vuelo</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>
<body class="bg-light">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">AeroFly</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">Inicio</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/flights">Vuelos</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container my-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow">
                <div class="card-header bg-primary text-white text-center py-3">
                    <h3 class="mb-0">Reserva de Vuelo</h3>
                </div>
                <div class="card-body p-4">
                    <c:if test="${not empty error}">
                        <div class="alert alert-danger" role="alert">
                            ${error}
                        </div>
                    </c:if>

                    <div class="alert alert-info py-3" role="alert">
                        <div class="d-flex align-items-center mb-2">
                            <i class="bi bi-airplane-fill me-2 fs-4"></i>
                            <h5 class="mb-0">Información del Vuelo</h5>
                        </div>
                        <c:choose>
                            <c:when test="${not empty flight}">
                                <div class="row small">
                                    <div class="col-6 mb-1">
                                        <span class="text-muted d-block">Número de Vuelo:</span>
                                        <strong>${flight.flightNumber}</strong>
                                    </div>
                                    <div class="col-6 mb-1">
                                        <span class="text-muted d-block">Horario:</span>
                                        <strong>${flight.departureTime}</strong>
                                    </div>
                                    <div class="col-6">
                                        <span class="text-muted d-block">Origen:</span>
                                        <strong>${flight.origin}</strong>
                                    </div>
                                    <div class="col-6">
                                        <span class="text-muted d-block">Destino:</span>
                                        <strong>${flight.destination}</strong>
                                    </div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <p class="mb-0">Vuelo ID: <strong>${flightId}</strong></p>
                            </c:otherwise>
                        </c:choose>
                    </div>

                    <form action="${pageContext.request.contextPath}/booking" method="post">
                        <input type="hidden" name="flightId" value="${flightId}">

                        <div class="mb-3">
                            <label for="passengerName" class="form-label">Nombre del Pasajero:</label>
                            <input type="text" class="form-control" id="passengerName" name="passengerName" placeholder="Nombre completo" required>
                        </div>

                        <div class="mb-4">
                            <label for="email" class="form-label">Correo Electrónico:</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="ejemplo@mail.com" required>
                            <div id="emailHelp" class="form-text text-muted small">Te enviaremos los detalles de tu reserva por este medio.</div>
                        </div>

                        <div class="d-grid gap-2">
                            <button type="submit" class="btn btn-primary btn-lg">Confirmar Reserva</button>
                            <a href="${pageContext.request.contextPath}/flights" class="btn btn-outline-secondary">Volver al Listado</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<footer class="bg-white py-4 border-top mt-auto">
    <div class="container text-center text-muted">
        <p class="mb-0">&copy; 2026 AeroFly. Todos los derechos reservados.</p>
    </div>
</footer>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
