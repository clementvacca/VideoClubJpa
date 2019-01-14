package videoClub.Jpa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")
public class BluRay extends Article {
	@Column(name="3d")
	private Boolean troisD;
	public BluRay(){
		
	}
	
	
	public BluRay(Boolean troisD) {
		super();
		this.troisD = troisD;
	}


	public Boolean getTroisD() {
		return troisD;
	}

	public void setTroisD(Boolean troisD) {
		this.troisD = troisD;
	}
	
}
