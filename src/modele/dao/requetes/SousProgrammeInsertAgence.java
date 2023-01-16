package modele.dao.requetes;

import java.sql.CallableStatement;
import java.sql.SQLException;

import modele.Agence;

public class SousProgrammeInsertAgence implements SousProgramme<Agence> {

	@Override
	public String appelSousProgramme() {
		return "call INSERER_AGENCE(?, ?, ?, ?, ?, ?, ?)";
	}

	@Override
	public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
		prSt.setString(1, parametres[0]);
		prSt.setString(2, parametres[1]);
		prSt.setString(3, parametres[2]);
		prSt.setString(4, parametres[3]);
		prSt.setString(5, parametres[4]);
		prSt.setString(6, parametres[5]);
		prSt.setString(7, parametres[6]);
	}

}
