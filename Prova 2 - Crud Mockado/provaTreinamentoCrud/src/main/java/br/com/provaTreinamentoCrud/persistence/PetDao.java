package br.com.provaTreinamentoCrud.persistence;

import java.util.ArrayList;
import java.util.List;

import br.com.provaTreinamentoCrud.entity.Pet;

public class PetDao extends Dao {

	public void cadastroPet(Pet pet) throws Exception {
		open();
		con.setAutoCommit(false);

		try {
			stmt = con.prepareStatement("insert into Pet values (null,?,?,?,?,?,?);");
			stmt.setString(1, pet.getNome());
			stmt.setString(2, pet.getTipoAnimal());
			stmt.setString(3, pet.getRaca());
			stmt.setString(4, pet.getPorte());
			stmt.setString(5, pet.getData());
			stmt.setString(6, pet.getHorario());
			stmt.executeUpdate();
			stmt.close();
			con.setAutoCommit(true);
		} catch (Exception ex) {
			con.rollback();
		} finally {
			close();
		}
	}

	public List<Pet> bucarReservas() throws Exception {
		open();
		stmt = con.prepareStatement("select * from Pet;");
		rs = stmt.executeQuery();
		List<Pet> pet = new ArrayList<>();
		while (rs.next()) {
			Pet p = new Pet();
			p.setIdPet(rs.getInt(1));
			p.setNome(rs.getString(2));
			p.setTipoAnimal(rs.getString(3));
			p.setRaca(rs.getString(4));
			p.setPorte(rs.getString(5));
			p.setData(rs.getString(6));
			p.setHorario(rs.getString(7));
			pet.add(p);
		}
		close();
		return pet;
	}

	public void cancelarReserva(Integer idPet) throws Exception {
		open();
		stmt = con.prepareStatement("delete from Pet where idPet=?;");
		stmt.setInt(1, idPet);
		stmt.executeUpdate();
		close();
	}

	public Pet bucarReservaId(Integer idPet) throws Exception {
		open();
		stmt = con.prepareStatement("select * from Pet where idPet=?;");
		stmt.setInt(1, idPet);
		rs = stmt.executeQuery();
		Pet p = null;
		while (rs.next()) {
			p = new Pet();
			p.setIdPet(rs.getInt(1));
			p.setNome(rs.getString(2));
			p.setTipoAnimal(rs.getString(3));
			p.setRaca(rs.getString(4));
			p.setPorte(rs.getString(5));
			p.setData(rs.getString(6));
			p.setHorario(rs.getString(7));
		}
		close();
		return p;
	}

	public void atualizarReserva(Pet pet) throws Exception {
		open();
		stmt = con.prepareStatement(
				"update Pet set nome=?, tipoAnimal=?, raca=?, porte=?, data=?, horario=? where idPet=?");
		stmt.setString(1, pet.getNome());
		stmt.setString(2, pet.getTipoAnimal());
		stmt.setString(3, pet.getRaca());
		stmt.setString(4, pet.getPorte());
		stmt.setString(5, pet.getData());
		stmt.setString(6, pet.getHorario());
		stmt.setInt(7, pet.getIdPet());
		stmt.executeUpdate();
		close();
	}
}
