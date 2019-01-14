package videoClub.Jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "realisateur")
@SequenceGenerator(name = "seqRealisateur", sequenceName = "seq_realisateur", allocationSize = 1, initialValue = 100)
public class Realisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRealisateur")
	@Column(name = "id_real", length = 150, nullable = true)
	private Integer idReal;
	@Column(name = "first_real", length = 150, nullable = false)
	private String prenom;
	@Column(name = "last_real", length = 150, nullable = false)
	private String nom;
	
	
	public Realisateur() {
		super();
	}
		
	public Realisateur(Integer idReal, String prenom, String nom) {
		super();
		this.idReal = idReal;
		this.prenom = prenom;
		this.nom = nom;
	}
	public Integer getIdReal() {
		return idReal;
	}
	public void setIdReal(Integer idReal) {
		this.idReal = idReal;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Realisateur other = (Realisateur) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}
	
	
	
}
