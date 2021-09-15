package br.com.prova.persistence;

import java.sql.PreparedStatement;

import br.com.prova.entity.AlunoProva;

public class AlunoProvaDao extends Dao{

	public Boolean createAlunoProvaDao(Integer idAluno, Integer idProva) throws Exception {
		open();
		con.setAutoCommit(false);

		try {
			stmt = con.prepareStatement("insert into AlunoProva values(?, ?, null);",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, idAluno);
			stmt.setInt(2, idProva);
			stmt.executeUpdate();
			stmt.close();
			con.setAutoCommit(true);
			return true;
		} catch (Exception ex) {
			con.rollback();
			return false;
		} finally {
			close();
		}
	}
	
	public void updateNotaObtida(Integer idAluno, Integer idProva, Integer notaObtida) throws Exception {
		open();
		con.setAutoCommit(false);

		try {
			stmt = con.prepareStatement("update AlunoProva set notaObtida = ? where fkAluno =? and fkProva=?;");
			
			stmt.setInt(1, notaObtida);
			stmt.setInt(2, idAluno);
			stmt.setInt(3, idProva);
			stmt.executeUpdate();
			stmt.close();
			con.setAutoCommit(true);
		} catch (Exception ex) {
			con.rollback();
		} finally {
			close();
		}
	}
	
	public AlunoProva findNota(Integer idAluno, Integer idProva) throws Exception {

		open();
		stmt = con.prepareStatement("select notaObtida from AlunoProva where fkAluno=? and fkProva=?;");
		stmt.setInt(1, idAluno);
		stmt.setInt(2, idProva);
		rs = stmt.executeQuery();
		AlunoProva ap = null;
		if (rs.next()) {
			ap = new AlunoProva();
			ap.setNotaObtida(rs.getDouble(1));
		}
		close();
		return ap;
	}
}
