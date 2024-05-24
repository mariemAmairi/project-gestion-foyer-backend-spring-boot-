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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Foyer")

public class Foyer {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long  id;
	@Column(name="NomFoyer" , length=255)
	private String nomFoyer;
	@Column(name="CapaciteFoyer" , length=255)
	private int capaciteFoyer;
	@OneToOne(mappedBy="foyer" , cascade = CascadeType.ALL)
	private Universite universite;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="foyer")
	private Set<Bloc> blocs;
	
	public Foyer() {
		super();
	}

	public Foyer(Long id, String nomFoyer, int capaciteFoyer, Universite universite, Set<Bloc> blocs) {
		super();
		this.id = id;
		this.nomFoyer = nomFoyer;
		this.capaciteFoyer = capaciteFoyer;
		this.universite = universite;
		this.blocs = blocs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomFoyer() {
		return nomFoyer;
	}

	public void setNomFoyer(String nomFoyer) {
		this.nomFoyer = nomFoyer;
	}

	public int getCapaciteFoyer() {
		return capaciteFoyer;
	}

	public void setCapaciteFoyer(int capaciteFoyer) {
		this.capaciteFoyer = capaciteFoyer;
	}

	public Universite getUniversite() {
		return universite;
	}

	public void setUniversite(Universite universite) {
		this.universite = universite;
	}

	public Set<Bloc> getBlocs() {
		return blocs;
	}

	public void setBlocs(Set<Bloc> blocs) {
		this.blocs = blocs;
	}
	
	
}