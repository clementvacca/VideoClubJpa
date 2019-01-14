package videoClub.Jpa.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import videoClub.Jpa.dao.Adherent.Civilite;
import videoClub.Jpa.dao.Adresse.Adresse;

@Entity
@Table(name = "adherent")
@SequenceGenerator(name = "seqAdherent", sequenceName = "seq_adherent", allocationSize = 1, initialValue = 100)
public abstract class Adherent {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAdherent")
	@Column(name = "no_adherent", length = 150, nullable = true)
	private Integer id;
	@Column(name = "first", length = 150, nullable = false)
	private String prenom;
	@Column(name = "last", length = 150, nullable = false)
	private String nom;

	@Enumerated(EnumType.ORDINAL)
	@Column(name = "title", length = 5)
	private Civilite civilite;
	@Temporal(TemporalType.DATE)
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "number")),
		@AttributeOverride(name = "rue", column = @Column(name = "street", length = 150)),
		@AttributeOverride(name = "cp", column = @Column(name = "zip_code", length = 5)),
		@AttributeOverride(name = "ville", column = @Column(name = "city", length = 150)) })
	private Adresse adresse;

	public Adherent() {

	}

	public Adherent(String prenom, String nom) {
		this.prenom = prenom;
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((civilite == null) ? 0 : civilite.hashCode());
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
		Adherent other = (Adherent) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (civilite != other.civilite)
			return false;
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
