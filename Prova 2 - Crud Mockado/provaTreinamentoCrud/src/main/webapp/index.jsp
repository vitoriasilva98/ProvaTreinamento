<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import = "java.util.List" %>
	<%@ page import = "br.com.provaTreinamentoCrud.entity.*" %>
	<%@ page import = "br.com.provaTreinamentoCrud.persistence.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PetShop SP</title>

<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<style>
.form {
	display: inline;
}
</style>
</head>
<body>
	<h1 class="bg-dark text-warning text-center p-5">
		PetShop: Reserva do Pet <i class="fas fa-paw"></i>
	</h1>

	<div class="container">
		<form class="form" method="post" action="PetController">

			<div class="col-md-6 offset-md-3 mt-5">
				<div class="card mt-3">
					<div class="card-header">
						<div class="text-header">
							<h5 class="text-center mt-2">Dados do Pet</h5>
						</div>
					</div>
					<div class="card-body">

						<label for="nome">Nome do Pet: </label> <input type="text"
							name="nome" title="Digite o nome do seu pet"
							placeholder="Digite nome do seu pet" class="form-control form-control-sm"> 
							
							<label for="tipoAnimal" class="mt-3">Animal: </label> 
							
							<select name="tipoAnimal" class="form-control form-control-sm">
								<option value="" selected>Escolha o tipo do animal:</option>
  								<option value="Cachorro">Cachorro</option>
  								<option value="Gato">Gato</option>
  								<option value="Passaro">Passáro</option>
  								<option value="Reptil">Reptil</option>
							</select>
							
							<label for="raca" class="mt-3">Raça: </label> <input type="text"
							name="raca" title="Digite a raça do animal"
							placeholder="Digite a raça do animal" class="form-control form-control-sm"> 
							 
							<label for="porte" class="mt-3">Porte: </label> 
							<select name="porte" class="form-control form-control-sm">
								<option value="" selected>Escolha o porte do animal:</option>
  								<option value="Pequeno">Pequeno</option>
  								<option value="Médio">Médio</option>
  								<option value="Grande">Grande</option>
							</select>
							
							<label for="data" class="mt-3">Data da reserva: </label> <input type="date"
							name="data" title="Digite a data da reserva" min="2021-09-15" max="2021-12-20"
							placeholder="Digite a data da reserva" class="form-control form-control-sm">
							
							<label for="horario" class="mt-3">Horário da reserva: </label> <input type="time"
							name="horario" title="Digite o horário da reserva" min="09:00" max="18:00"
							placeholder="Digite o horário da reserva" class="form-control form-control-sm">  

						<input type="hidden" value="reservar" name="administracao">
						<button type="submit" class="btn btn-success btn-sm mt-4">
							Reservar <i class="fas fa-save"></i>
						</button>

					</div>
				</div>
			</div>
		</form>
		
		<div class="container mt-5">
			<table class="table table-striped table-bordered table-houver">
				<thead class="text-center bg-dark text-warning">
					<tr>
						<th>Número da reserva</th>
						<th>Nome</th>
						<th>Tipo do Animal</th>
						<th>Raça</th>
						<th>Porte</th>
						<th>Data Reservada</th>
						<th>Horário Reservado</th>
						<th>Administração</th>
					</tr>
				</thead>
				<tbody class="text-center">
				
				<%
				PetDao petDao = new PetDao();
				List<Pet> pets = petDao.bucarReservas();
				
				for(Integer i = 0; i < pets.size(); i++){
				%>
				
				<tr>
					<td><%out.print(pets.get(i).getIdPet()); %></td>
					<td><%out.print(pets.get(i).getNome()); %></td>
					<td><%out.print(pets.get(i).getTipoAnimal()); %></td>
					<td><%out.print(pets.get(i).getRaca()); %></td>
					<td><%out.print(pets.get(i).getPorte()); %></td>
					<td><%out.print(pets.get(i).getData()); %></td>
					<td><%out.print(pets.get(i).getHorario()); %></td>
					<td>
						
						<form class="form" method="post" action="PetController">
						<input type="hidden" value="remarcar" name="administracao">
						<input type="hidden" value="<%out.print(pets.get(i).getIdPet()); %>" name="id">
						<button type="submit" class="btn btn-secondary text-light" 
						title="Editar reserva"><i class="fas fa-user-edit"></i></button>
						</form>
							
						<form class="form" method="post" action="PetController">
						<input type="hidden" value="cancelar" name="administracao">
						<input type="hidden" value="<%out.print(pets.get(i).getIdPet()); %>" name="id">
						<button type="submit" class="btn btn-warning text-light" 
						title="Cancelar reserva"><i
							class="fas fa-trash-alt"></i></button>
						</form>
					</td>
				</tr>
				<%} %>
				
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>