package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Locataire;


public class RequeteSelectLocataireLogementImmeuble implements Requete<Locataire> {

	@Override
	public String requete() {
		return "SELECT lc.* FROM sae_locataire lc, sae_bail b,sae_signer s WHERE lc.id_loc = s.id_loc AND b.id_bail = s.id_bail AND b.numero_l = ? AND b.id_immeuble = ?";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		int id0 = Integer.parseInt(id[0]);
		int id1 = Integer.parseInt(id[1]);
		prSt.setInt(1, id0);
		prSt.setInt(2, id1);
	}

	@Override
	public void parametresT(PreparedStatement prSt, Locataire donnee) throws SQLException, ParseException {
		//rien
	}

}
