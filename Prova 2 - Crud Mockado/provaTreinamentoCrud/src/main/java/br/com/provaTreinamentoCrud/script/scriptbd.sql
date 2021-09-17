create database bdprovacrud;

use bdprovacrud;

create table Pet(
	idPet int primary key auto_increment,
	nome varchar(20),
	tipoAnimal varchar(10),
	raca varchar(25),
	porte varchar(10),
	data varchar(10),
	horario varchar(5))
	auto_increment = 35;
	
insert into Pet values (35, 'Baby Love', 'cachorro', 'Viralata', 'Médio', '16-10-2021', '09:30');