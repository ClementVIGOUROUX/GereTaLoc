package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Bail;

public class RequeteSelectBail implements Requete<Bail>{

	@Override
	public String requete() {
		return "select * from SAE_BAIL";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
	}

	@Override
	public void parametresT(PreparedStatement prSt, Bail donnee) throws SQLException, ParseException {
	}

}
