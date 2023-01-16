package modele.dao.requetes;

import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.text.ParseException;

import modele.Paiement;

public class RequeteSelectPaiementByBail implements Requete<Paiement>{

	@Override
	public String requete() {
		return "select * from SAE_PAIEMENT where ID_BAIL = ?";
		
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
		
	}


	@Override
	public void parametresT(PreparedStatement prSt, Paiement donnee) throws SQLException, ParseException {
		
	}

}
