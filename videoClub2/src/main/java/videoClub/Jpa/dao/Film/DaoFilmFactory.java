package videoClub.Jpa.dao.Film;

public class DaoFilmFactory {
	private static DaoFilm singleton=null;
	public static DaoFilm getInstance() {
		if(singleton==null) {
			singleton=new DaoFilmJpaImpl();
		}
		return singleton;
	}
}
