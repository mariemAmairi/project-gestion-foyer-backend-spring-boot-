package tp.spring.entities;
//import java.util.Date;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Chambre")

public class Chambre {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long  id;
	@Column(name="NumeroChambre" , length=255)
	private int numeroChambre;
	@Enumerated(EnumType.STRING)
	 private typeChambre typeChambre;
	@ManyToOne
	private Bloc blocs;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Reservation> reservations;
	
	public Chambre() {
		super();
	}

	public Chambre(Long id, int numeroChambre, tp.spring.entities.typeChambre typeChambre, Bloc blocs,
			Set<Reservation> reservations) {
		super();
		this.id = id;
		this.numeroChambre = numeroChambre;
		this.typeChambre = typeChambre;
		this.blocs = blocs;
		this.reservations = reservations;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumeroChambre() {
		return numeroChambre;
	}

	public void setNumeroChambre(int numeroChambre) {
		this.numeroChambre = numeroChambre;
	}

	public typeChambre getTypeChambre() {
		return typeChambre;
	}

	public void setTypeChambre(typeChambre typeChambre) {
		this.typeChambre = typeChambre;
	}

	public Bloc getBlocs() {
		return blocs;
	}

	public void setBlocs(Bloc blocs) {
		this.blocs = blocs;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}
	
}
