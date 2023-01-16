package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Bail;

public class RequeteSelectBailLocataire implements Requete<Bail>{

	@Override
	public String requete() {
		return "SELECT b.* FROM sae_bail b, sae_locataire l, sae_signer s WHERE b.id_bail = s.id_bail AND l.id_loc = s.id_loc AND l.id_loc = ?";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	@Override
	public void parametresT(PreparedStatement prSt, Bail donnee) throws SQLException, ParseException {
		//rien
	}

}
