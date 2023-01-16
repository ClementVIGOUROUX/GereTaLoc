package modele.dao.requetes;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;

import modele.Paiement;

public class SousProgrammeInsertPaiement implements SousProgramme<Paiement> {

	@Override
	public String appelSousProgramme() {
		return "call INSERER_PAIEMENT(?, ?, ?, ?, ?)";
	}

	@Override
	public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
		prSt.setString(1, parametres[0]);
		prSt.setInt(2, Integer.valueOf(parametres[1]));
		prSt.setDate(3,  Date.valueOf(parametres[2]));
		prSt.setFloat(4, Float.valueOf(parametres[3]));
		prSt.setInt(5, Integer.valueOf(parametres[4]));
	}

}
