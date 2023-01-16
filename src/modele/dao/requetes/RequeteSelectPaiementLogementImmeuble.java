package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Paiement;

public class RequeteSelectPaiementLogementImmeuble implements Requete<Paiement> {

	@Override
	public String requete() {
		return "SELECT p.* FROM sae_paiement p, sae_bail b WHERE p.id_bail = b.id_bail AND b.numero_l = ? AND b.id_immeuble = ?";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		int id0 = Integer.parseInt(id[0]);
		int id1 = Integer.parseInt(id[1]);
		prSt.setInt(1, id0);
		prSt.setInt(2, id1);
	}

	@Override
	public void parametresT(PreparedStatement prSt, Paiement donnee) throws SQLException, ParseException {
		//rien
	}

}
