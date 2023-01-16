package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Locataire;

public class RequeteSelectLocataire implements Requete<Locataire> {

	@Override
	public String requete() {
		return "select * from SAE_LOCATAIRE";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void parametresT(PreparedStatement prSt, Locataire donnee) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		
	}

}
