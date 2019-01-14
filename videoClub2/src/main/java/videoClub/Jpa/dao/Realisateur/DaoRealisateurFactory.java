package videoClub.Jpa.dao.Realisateur;

public class DaoRealisateurFactory {
	private static DaoRealisateur singleton=null;
	public static DaoRealisateur getInstance() {
		if(singleton==null) {
			singleton=new DaoRealisateurJpaImpl();
		}
		return singleton;
	}
}
