package videoClub.Jpa.dao.Adherent;

public class DaoAdherentFactory {
	private static DaoAdherent singleton = null;

	public static DaoAdherent getInstance() {
		if (singleton == null) {
			singleton = new DaoAdherentJpaImpl();
		}
		return singleton;
	}
}
