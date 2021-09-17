package br.com.provaTreinamentoCrud.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pet {

//	private static SimpleDateFormat SDFD = new SimpleDateFormat("yyyy-MM-dd");
//	private static SimpleDateFormat SDFH = new SimpleDateFormat("HH:mm");
	private Integer idPet;
	private String tipoAnimal;
	private String nome;
	private String raca;
	private String porte;
	private String data;
	private String horario;

	public Pet() {

	}

	public Pet(String tipoAnimal, String nome, String raca, String porte, String data, String horario) {
		super();
		this.tipoAnimal = tipoAnimal;
		this.nome = nome;
		this.raca = raca;
		this.porte = porte;
		this.data = data;
		this.horario = horario;
	}

	@Override
	public String toString() {
		return "Pet [tipoAnimal=" + tipoAnimal + ", nome=" + nome + ", raca=" + raca + ", porte=" + porte + ", data="
				+ data + ", horario=" + horario + "]";
	}

	public Integer getIdPet() {
		return idPet;
	}

	public void setIdPet(Integer idPet) {
		this.idPet = idPet;
	}

	public String getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

}
