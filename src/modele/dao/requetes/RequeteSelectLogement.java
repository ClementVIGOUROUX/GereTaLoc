package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Logement;

public class RequeteSelectLogement implements Requete<Logement> {

	@Override
	public String requete() {
		return "select * from SAE_LOGEMENT";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametresT(PreparedStatement prSt, Logement donnee) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		
	}

}
