package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

public interface Requete<T> {
	public String requete();
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException;
	public void parametresT(PreparedStatement prSt, T donnee) throws SQLException, ParseException;

}
