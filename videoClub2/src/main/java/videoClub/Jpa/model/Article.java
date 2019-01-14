package videoClub.Jpa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "article")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",length=1)
public abstract class Article {
	@Id
	@Column(name = "no_article", length = 150, nullable = true)
	private Integer noArticle;
	@Column(name = "nbDisques", length = 150, nullable = true)
	private Integer nbDisques;
	
	private Integer noAdherent;
	private Integer noFilm;
	
	public Article() {
	}
	
	public Integer getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

	public Integer getNbDisques() {
		return nbDisques;
	}

	public void setNbDisques(Integer nbDisques) {
		this.nbDisques = nbDisques;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((noArticle == null) ? 0 : noArticle.hashCode());
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
		Article other = (Article) obj;
		if (noArticle == null) {
			if (other.noArticle != null)
				return false;
		} else if (!noArticle.equals(other.noArticle))
			return false;
		return true;
	}

}
