package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Locataire;

public class RequeteSelectLocataireByBail implements Requete<Locataire> {

	@Override
	public String requete() {
		return "SELECT l.* FROM sae_locataire l, sae_signer s WHERE l.id_loc = s.id_loc AND s.ID_BAIL = ?";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}


	@Override
	public void parametresT(PreparedStatement prSt, Locataire donnee) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		
	}

}
