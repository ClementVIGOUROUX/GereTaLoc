package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Entreprise;

public class RequeteSelectEntrepriseByNom implements Requete<Entreprise>{

	@Override
	public String requete() {
		return "select * from SAE_Entreprise where NOM_ENTREPRISE = ?";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
	}

	@Override
	public void parametresT(PreparedStatement prSt, Entreprise donnee) throws SQLException, ParseException {
		prSt.setString(1, donnee.getnSiret());
	}

}
