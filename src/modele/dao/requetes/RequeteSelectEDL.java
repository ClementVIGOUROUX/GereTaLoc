package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.EtatdesLieux;

public class RequeteSelectEDL implements Requete<EtatdesLieux>{

	@Override
	public String requete() {
		return "select * from sae_etatdeslieux";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		
	}

	@Override
	public void parametresT(PreparedStatement prSt, EtatdesLieux donnee) throws SQLException, ParseException {
		
	}

}
