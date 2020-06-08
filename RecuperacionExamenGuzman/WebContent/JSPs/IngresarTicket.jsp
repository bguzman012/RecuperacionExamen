<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="/RecuperacionExamenGuzman/CSS/formulario.css">
<title>Registrar Ticket</title>
</head>
<body>
	<header>
		<a href="/RecuperacionExamenGuzman/index.html">Inicio</a>
	</header>
	<section class="our_skill">
		<div class="container">
			<div class="limiter">

				<form action="/RecuperacionExamenGuzman/ControladorIngresarTicket"
					target="" method="get" name="formDatosPersonales">

					<label for="nombre">Vehiculo</label> <input type="text"
						name="vehiculo" id="nombre" placeholder="Ingrese placa vehiculo" />

					<label for="date_in">Fecha de Entrada</label> <input type="date"
						id="date_in" name="date_in" value="2019-01-01" min="2019-01-01"
						max="2050-12-31"><label for="hora_in" />Hora de Entrada</label> <input
						type="time" id="hora_in" name="hora_in" min="07:00" max="21:00"
						step="1" /> <label for="date_out">Fecha de Salida</label> <input
						type="date" id="date_out" name="date_out" value="2019-01-01"
						min="2019-01-01" max="2050-12-31"><label for="hora_out" />Hora
					de Salida</label> <input type="time" id="hora_out" name="hora_out"
						min="07:00" max="21:00" step="1" /> <input type="submit"
						name="enviar" value="Registrar" />
				</form>
			</div>
		</div>

	</section>


</body>
</html>