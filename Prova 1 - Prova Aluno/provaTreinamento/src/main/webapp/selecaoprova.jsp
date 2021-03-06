<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.*, br.com.prova.entity.*, br.com.prova.controller.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Portal Faculdade SP</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

<style>
.input-group-text {
	height: 40px;
}
</style>
</head>
<body>
	<div class="bg-dark p-5 text-white text-center">
		<h1>Portal Faculdade SP</h1>
	</div>
	<div class="container">
		<h3 class="text-center pt-5">Fa?a a prova!</h3>

		<div class="row mt-5">
			<form method="post" action="ProvaController">
				<div class="col-md-5 container">
					<div class="card">
						<div class="card-body">
							<h4 class="card-title text-center">Selecione a prova</h4>

							<div class="input-group form-group pt-3">
								<div class="input-group-prepend">
									<span class="input-group-text"><i
										class="fas fa-envelope"></i></span>
								</div>
								<input type="text" name="email"
									placeholder="Digite o email cadastrado" class="form-control">
							</div>

							<div class="col-md-8 mt-4">
								<%
								List<Prova> listaprova = (List<Prova>) session.getAttribute("listaprova");
								%>
								<label>Selecione a prova que deseja realizar:</label> <select
									name="idProva" class="form-select form-control mt-3"
									aria-label="select prova">

									<option selected>Selecione a prova</option>

									<%
									for (int i = 0; i < listaprova.size(); i++) {
										out.print(
										"<option value=" + listaprova.get(i).getIdProva() + ">" + listaprova.get(i).getDisciplina() + "</option>");
									}
									%>
								</select>
							</div>
							<div class="col-md-3 mt-4">
								<button type="submit" class="btn btn-success" value="Enviar">Entrar</button>
							</div>

						</div>
					</div>
				</div>
			</form>
		</div>
	</div>

</body>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.0/js/bootstrap.min.js"></script>

</html>