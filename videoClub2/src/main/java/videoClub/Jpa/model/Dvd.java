package videoClub.Jpa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("D")
public class Dvd extends Article{
	@Column(name="Dvd")
	private Boolean bonus;
	public Dvd(){
		
	}
	public Boolean getBonus() {
		return bonus;
	}
	public void setBonus(Boolean bonus) {
		this.bonus = bonus;
	}
	
}
