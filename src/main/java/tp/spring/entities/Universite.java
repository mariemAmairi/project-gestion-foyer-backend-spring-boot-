package tp.spring.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.EnumType;
//import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Universite")


public class Universite {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long  id;
	@Column(name="NomUniversite" , length=255)
	private String nomUniversite;
	@Column(name="Adresse" , length=255)
	private String adresse;
	@OneToOne
	private Foyer foyer;
	
	public Universite() {
		super();
	}

	public Universite(Long id, String nomUniversite, String adresse, Foyer foyer) {
		super();
		this.id = id;
		this.nomUniversite = nomUniversite;
		this.adresse = adresse;
		this.foyer = foyer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomUniversite() {
		return nomUniversite;
	}

	public void setNomUniversite(String nomUniversite) {
		this.nomUniversite = nomUniversite;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Foyer getFoyer() {
		return foyer;
	}

	public void setFoyer(Foyer foyer) {
		this.foyer = foyer;
	}
	
	

}
