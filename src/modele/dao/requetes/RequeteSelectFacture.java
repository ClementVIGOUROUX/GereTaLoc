package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Facture;

public class RequeteSelectFacture implements Requete<Facture>{

	@Override
	public String requete() {
		return "select * from SAE_FACTURE";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
	}

	@Override
	public void parametresT(PreparedStatement prSt, Facture donnee) throws SQLException, ParseException {
	}

}
