package tp.spring.entities;
//import java.util.Date;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="Bloc")


public class Bloc {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long  id;
	@Column(name="NomBloc" , length=255)
	private String nomBloc;
	@Column(name="CapaciteBloc" , length=255)
	private int CapaciteBloc;
	@ManyToOne
	private Foyer foyer;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="blocs")
	private Set<Chambre> chambres;
	
	public Bloc() {
		super();
	}

	public Bloc(Long id, String nomBloc, int capaciteBloc, Foyer foyer, Set<Chambre> chambres) {
		super();
		this.id = id;
		this.nomBloc = nomBloc;
		CapaciteBloc = capaciteBloc;
		this.foyer = foyer;
		this.chambres = chambres;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomBloc() {
		return nomBloc;
	}

	public void setNomBloc(String nomBloc) {
		this.nomBloc = nomBloc;
	}

	public int getCapaciteBloc() {
		return CapaciteBloc;
	}

	public void setCapaciteBloc(int capaciteBloc) {
		CapaciteBloc = capaciteBloc;
	}

	public Foyer getFoyer() {
		return foyer;
	}

	public void setFoyer(Foyer foyer) {
		this.foyer = foyer;
	}

	public Set<Chambre> getChambres() {
		return chambres;
	}

	public void setChambres(Set<Chambre> chambres) {
		this.chambres = chambres;
	}
	
	


}
