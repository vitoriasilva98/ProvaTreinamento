package br.com.prova.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.prova.entity.Aluno;
import br.com.prova.entity.Questao;
import br.com.prova.persistence.AlunoDao;
import br.com.prova.persistence.AlunoProvaDao;
import br.com.prova.persistence.QuestaoDao;

@WebServlet("/ProvaController")
public class ProvaController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ProvaController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);

		try {

			AlunoDao aludao = new AlunoDao();

			String emailAluno = request.getParameter("email");
			Aluno busaId = aludao.findIdAluno(emailAluno);

			if (busaId != null) {

				Integer idAluno = busaId.getIdAluno();

				AlunoProvaDao aluprodao = new AlunoProvaDao();
				Integer idProva = Integer.valueOf(request.getParameter("idProva"));

				Boolean registroProva = aluprodao.createAlunoProvaDao(idAluno, idProva);

				if (idProva != null) {
					
					List<Questao> listaquestao = new QuestaoDao().findSelectAllQuestao(idProva);
					
					session.setAttribute("idAluno", idAluno);
					session.setAttribute("idProva", idProva);
					session.setAttribute("listaquestao", listaquestao);
					response.sendRedirect("prova.jsp");

				} else {
					session.setAttribute("invalido", "Prova inexistente");
					response.sendRedirect("usuarionaoexiste.jsp");
				}

			} else {
				session.setAttribute("invalido", "Usuário inválido, email incorreto");
				response.sendRedirect("usuarionaoexiste.jsp");
			}

		} catch (Exception ex) {

			request.setAttribute("msg", "Erro interno da Aplicação");
			request.getRequestDispatcher("saidaerro.jsp").forward(request, response);
		}

	}
	

}
