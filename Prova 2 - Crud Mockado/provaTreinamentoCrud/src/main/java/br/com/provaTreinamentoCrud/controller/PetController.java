package br.com.provaTreinamentoCrud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.provaTreinamentoCrud.entity.Pet;
import br.com.provaTreinamentoCrud.persistence.PetDao;

@WebServlet("/PetController")
public class PetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Integer idPet;   

    public PetController() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String administracao = request.getParameter("administracao");
		
		switch (administracao) {
		case "reservar":
			reserva(request, response);
			break;
			
		case "cancelar":
			cancelar(request, response);
			break;
			
		case "remarcar":
			remarcar(request, response);
			break;
			
		case "update":
			update(request, response);
			break;
			
		default:
			break;
		}
		
	}
	
	protected void reserva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Pet pet = new Pet(request.getParameter("tipoAnimal"), request.getParameter("nome"),
				request.getParameter("raca"), request.getParameter("porte"),
				request.getParameter("data"), request.getParameter("horario"));
		
		PetDao petDao = new PetDao();
		
		try {
			petDao.cadastroPet(pet);
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	protected void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		idPet = Integer.valueOf(request.getParameter("id"));
		
		PetDao petDao = new PetDao();
		try {
			petDao.cancelarReserva(idPet);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void remarcar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		idPet = Integer.valueOf(request.getParameter("id"));
		Pet pet = new Pet();
		PetDao petDao = new PetDao();
		
		try {
			pet = petDao.bucarReservaId(idPet);
			request.getRequestDispatcher("/update.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Pet pet = new Pet();
		PetDao petDao = new PetDao();
		
		try {			
			pet.setIdPet(idPet);
			pet.setNome(request.getParameter("nome"));
			pet.setTipoAnimal(request.getParameter("tipoAnimal"));
			pet.setRaca(request.getParameter("raca"));
			pet.setPorte(request.getParameter("porte"));
			pet.setData(request.getParameter("data"));
			pet.setHorario(request.getParameter("horario"));
			petDao.atualizarReserva(pet);
					
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}
}
