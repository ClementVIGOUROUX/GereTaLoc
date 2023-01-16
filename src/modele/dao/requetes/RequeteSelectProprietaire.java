package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Proprietaire;

public class RequeteSelectProprietaire implements Requete<Proprietaire> {

	@Override
	public String requete() {
		return "select * from SAE_PROPRIETAIRE";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametresT(PreparedStatement prSt, Proprietaire donnee) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		
	}

}
