package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.EtatdesLieux;

public class RequeteSelectEDLLogementImmeuble implements Requete<EtatdesLieux>{

	@Override
	public String requete() {
		return "SELECT e.* FROM  sae_bail b,sae_etatdeslieux e WHERE b.id_bail = e.id_bail AND b.numero_l = ? AND b.id_immeuble = ?";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		int id0 = Integer.parseInt(id[0]);
		int id1 = Integer.parseInt(id[1]);
		prSt.setInt(1, id0);
		prSt.setInt(2, id1);
	}

	@Override
	public void parametresT(PreparedStatement prSt, EtatdesLieux donnee) throws SQLException, ParseException {
		//rien
	}

}
