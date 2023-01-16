package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Locataire;

public class RequeteSelectFactureImmeuble implements Requete<Locataire> {

	@Override
	public String requete() {
		return "SELECT f.* FROM SAE_FACTURE f, SAE_LOGEMENT l WHERE f.numero = l.numero_l AND l.id_immeuble = ? AND f.Immeuble = 1";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		int id0 = Integer.parseInt(id[0]);
		prSt.setInt(1, id0);
	}

	@Override
	public void parametresT(PreparedStatement prSt, Locataire donnee) throws SQLException, ParseException {
		//rien
	}

}
