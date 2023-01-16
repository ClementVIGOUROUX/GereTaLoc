package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Facture;

public class RequeteSelectFactureById implements Requete<Facture> {

	@Override
	public String requete() {
		return "select * from SAE_FACTURE where N_FACTURE = ?";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	@Override
	public void parametresT(PreparedStatement prSt, Facture donnee) throws SQLException, ParseException {
		prSt.setString(1, donnee.getnFacture());
	}
	
}
