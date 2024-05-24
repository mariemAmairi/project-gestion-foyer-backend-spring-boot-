package tp.spring.entities;
import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Reservation")

public class Reservation {


	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private String  id;
	@Column(name="annee universitaire" , length=255)
	private Date anneeUniversitaire;
	@Column(name="est valide" , length=255)
	private boolean estValide;
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Etudiant> etudiants;
	
	public Reservation() {
		super();
	}

	public Reservation(String id, Date anneeUniversitaire, boolean estValide, Set<Etudiant> etudiants) {
		super();
		this.id = id;
		this.anneeUniversitaire = anneeUniversitaire;
		this.estValide = estValide;
		this.etudiants = etudiants;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getAnneeUniversitaire() {
		return anneeUniversitaire;
	}

	public void setAnneeUniversitaire(Date anneeUniversitaire) {
		this.anneeUniversitaire = anneeUniversitaire;
	}

	public boolean isEstValide() {
		return estValide;
	}

	public void setEstValide(boolean estValide) {
		this.estValide = estValide;
	}

	public Set<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Set<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	
	
}

