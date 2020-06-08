<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="/RecuperacionExamenGuzman/CSS/css/bootstrap.css">
<link rel="stylesheet"
	href="/RecuperacionExamenGuzman/CSS/css/font-awesome.min.css">
<link rel="stylesheet"
	href="/RecuperacionExamenGuzman/CSS/Styles/style.css">
<link rel="stylesheet"
	href="/RecuperacionExamenGuzman/CSS/Styles/InicioSesion.css">
<link rel="stylesheet" type="text/css"
	href="/RecuperacionExamenGuzman/CSS/util.css">
<link rel="stylesheet" type="text/css"
	href="/RecuperacionExamenGuzman/CSS/css/main.css">
<title>ListarTickets</title>

</head>

<body>
	<header>
	<a href="/RecuperacionExamenGuzman/index.html" >Inicio</a>
	</header>
	<section class="our_skill">
		<div class="container">
			<div class="limiter">
				<div class="container-table100">

					<form action="/RecuperacionExamenGuzman/ControladorBuscarTicket"
						method="post" style="margin-top: 12px; margin-bottom: 12px;">

						<label for="cars" style="font-size: x-large;">Buscar por:</label>
						<select id="cars" name="opcion">
							<option value="PlacaVehiculo">PlacaVehiculo</option>
							<option value="CedulaCliente">CedulaCliente</option>

						</select> <input type="text" name="parametro" placeholder="Ingrese dato"
							id="login-name" value="" style="margin-top: 6px;"><input
							class="boton" type="submit" name="Ingresar" value="Buscar" />


					</form>
					<C:set var="cliente" value="${requestScope['cliente']}" />



					<div class="wrap-table100">
						<div class="table100 ver1">


							<div class="wrap-table100-nextcols js-pscroll">
								<div class="table100-nextcols">

									<table>
										<p><pre><b>Cedula: </b>${cliente.cedula}	 <b> Nombre: </b>${cliente.nombre}		<b> Direccion: </b>${cliente.direccion} 		<b>Telefono: </b>${cliente.cedula}
										</pre><p>
										<thead>
											<tr class="row100 head">
												<th class="cell100 column2">Placa</th>
												<th class="cell100 column3">Marca</th>
												<th class="cell100 column4">Modelo</th>
												<th class="cell100 column5">FechaIngreso</th>
												<th class="cell100 column6">HoraIngreso</th>
												<th class="cell100 column7">FechaSalida</th>
												<th class="cell100 column8">HoraSalida</th>


											</tr>
										</thead>

										<tbody>

											<C:forEach var="vehiculo" items="${cliente.vehiculos}">
												<C:forEach var="ticket" items="${vehiculo.tickets}">
													<tr class="row100 body">
														<td class="cell100 column2">${vehiculo.placa}</td>

														<td class="cell100 column3">${vehiculo.marca}</td>
														<td class="cell100 column4">${vehiculo.modelo}</td>

														<td class="cell100 column5"><fmt:formatDate
																value="${ticket.fechaDeIngreso}" pattern="dd/MM/yyyy" /></td>
														<td class="cell100 column6"><fmt:formatDate
																value="${ticket.horaDeIngreso.time}" dateStyle="short"
																type="time" /></td>

														<td class="cell100 column7"><fmt:formatDate
																value="${ticket.fechaDeSalida}" pattern="dd/MM/yyyy" /></td>
														<td class="cell100 column8"><fmt:formatDate
																value="${ticket.horaDeSalida.time}" dateStyle="short"
																type="time" /></td>



													</tr>
												</C:forEach>
											</C:forEach>

										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</section>
</body>
</html>