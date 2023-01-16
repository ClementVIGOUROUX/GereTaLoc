package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Paiement;

public class RequeteSelectPaiement implements Requete<Paiement>{

	@Override
	public String requete() {
		return "select * from SAE_PAIEMENT";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
	}


	@Override
	public void parametresT(PreparedStatement prSt, Paiement donnee) throws SQLException, ParseException {
		//rien
		
	}

}
