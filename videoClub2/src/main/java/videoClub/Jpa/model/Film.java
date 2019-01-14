package videoClub.Jpa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "film")
@SequenceGenerator(name = "seqfilm", sequenceName="seq_film",allocationSize = 1, initialValue = 100)
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqfilm")
	@Column(name = "id_film", length = 150, nullable = true)
	private Integer noFilm;
	@Column(name = "titre", length = 150, nullable = true)
	private String titre;
	@Column(name = "release", length = 150, nullable = true)
	private Date dateSortie;
	
	public Film() {
	}
	public Film(String titre,Date dateSortie) {
		super();
		this.titre=titre;
		this.dateSortie=dateSortie;
		
	}
	

	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Date getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noFilm == null) ? 0 : noFilm.hashCode());
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
		Film other = (Film) obj;
		if (noFilm == null) {
			if (other.noFilm != null)
				return false;
		} else if (!noFilm.equals(other.noFilm))
			return false;
		return true;
	}

}

