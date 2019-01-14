package videoClub.Jpa.dao.Article;

public class DaoArticleFactory {
	private static DaoArticle singleton=null;
	public static DaoArticle getInstance() {
		if(singleton==null) {
			singleton=new DaoArticleJpaImpl();
		}
		return singleton;
	}
}
