package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Immeuble;

public class RequeteSelectImmeuble implements Requete<Immeuble> {

	@Override
	public String requete() {
		return "select * from SAE_IMMEUBLE";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametresT(PreparedStatement prSt, Immeuble donnee) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		
	}

}
