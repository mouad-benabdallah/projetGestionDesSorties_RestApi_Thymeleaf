package com.exo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
public class Sortie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "le titre ne doit pas être vide")
	private String titre;
	@NotBlank(message = "la destination ne doit pas être vide")
	private String destination;
	@NotBlank(message = "le depart ne doit pas être vide")
	private String depart;
	@NotBlank(message = "le retour ne doit pas être vide")
	private String retour;
	@NotNull(message = "le prix ne doit pas être vide")
	private double prix;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="responsable",referencedColumnName = "nomComplet",unique = true)
	private Admin admin;
	@Lob
	private String description;
	
	@OneToMany(mappedBy = "sortie")
	private List<Participant> participants = new ArrayList<Participant>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getRetour() {
		return retour;
	}

	public void setRetour(String retour) {
		this.retour = retour;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}
	

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	
	

	

	

	public Sortie(@NotBlank(message = "le titre ne doit pas être vide") String titre,
			@NotBlank(message = "la destination ne doit pas être vide") String destination,
			@NotBlank(message = "le depart ne doit pas être vide") String depart,
			@NotBlank(message = "le retour ne doit pas être vide") String retour,
			@NotNull(message = "le prix ne doit pas être vide") double prix, 
			 Admin admin, String description,
			List<Participant> participants) {
		super();
		this.titre = titre;
		this.destination = destination;
		this.depart = depart;
		this.retour = retour;
		this.prix = prix;
		this.admin = admin;
		this.description = description;
		this.participants = participants;
	}

	public Sortie() {
		super();
	}
	
	

}
