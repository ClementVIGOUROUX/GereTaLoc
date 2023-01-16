package modele.dao.requetes;

import java.sql.CallableStatement;
import java.sql.SQLException;

import modele.Caution;
import modele.Locataire;

public class SousProgrammeInsertCaution implements SousProgramme<Caution> {

	@Override
	public String appelSousProgramme() {
		return "call INSERER_CAUTION(?, ?, ?, ?)";
	}

	@Override
	public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
		prSt.setString(1, parametres[0]);
		prSt.setString(2, parametres[1]);
		prSt.setString(3, parametres[2]);
		prSt.setInt(4, Integer.valueOf(parametres[3]));
		
	}

}