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
@Table(name="Etudiant")

public class Etudiant {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long  id;
	@Column(name="Name" , length=255)
	private String name;
	@Column(name="Prenom" , length=255)
	private String prenom;
	@Column(name="CIN" , length=255)
	private int cin;
	@Column(name="Ecole" , length=255)
	private String ecole;
	@Column(name="Date de naissance" , length=255)
	private Date dateNaissance;
	@ManyToMany(mappedBy="etudiants", cascade = CascadeType.ALL)
	private Set<Reservation> reservations;
	
	public Etudiant() {
		super();
	}

	public Etudiant(Long id, String name, String prenom, int cin, String ecole, Date dateNaissance,
			Set<Reservation> reservations) {
		super();
		this.id = id;
		this.name = name;
		this.prenom = prenom;
		this.cin = cin;
		this.ecole = ecole;
		this.dateNaissance = dateNaissance;
		this.reservations = reservations;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public String getEcole() {
		return ecole;
	}

	public void setEcole(String ecole) {
		this.ecole = ecole;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	
	
	

}
