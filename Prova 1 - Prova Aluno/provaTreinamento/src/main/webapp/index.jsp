<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
			<form method="post" action="ValidaoCadastroController">
				<div class="col-md-5 container">
					<div class="card">
						<div class="card-body">
							<h4 class="card-title text-center">Entre para realizar a
								prova</h4>

							<div class="input-group form-group pt-3">
								<div class="input-group-prepend">
									<span class="input-group-text"><i
										class="fas fa-envelope"></i></span>
								</div>
								<input type="text" name="email"
									placeholder="Digite o email cadastrado" class="form-control">
							</div>
							<div class="col-md-3 mt-4">
								<button type="submit" class="btn btn-success" value="Enviar">Entrar</button>
							</div>

						</div>
					</div>
				</div>
			</form>

			<form method="post"
				action="http://localhost:8083/provaTreinamento/CadastroController">
				<div class="col-md-5 container mt-3">
					<div class="card">
						<div class="card-body">
							<h4 class="card-title text-center">Se cadastre para fazer a
								prova</h4>

							<div class="input-group form-group pt-4">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-user">
									</i></span>
								</div>
								<input type="text" name="nomeAluno"
									placeholder="Digite o seu nome" class="form-control">
							</div>
							<div class="input-group form-group pt-3">
								<div class="input-group-prepend">
									<span class="input-group-text"><i
										class="fas fa-envelope"></i></span>
								</div>
								<input type="text" name="email"
									placeholder="Digite o email cadstrado" class="form-control">
							</div>
							<div class="col-md-3 mt-4">
								<button type="submit" class="btn btn-warning float-right">Cadastrar</button>
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