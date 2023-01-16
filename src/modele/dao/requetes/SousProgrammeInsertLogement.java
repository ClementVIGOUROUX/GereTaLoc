package modele.dao.requetes;

import java.sql.CallableStatement;
import java.sql.SQLException;

import modele.Logement;

public class SousProgrammeInsertLogement implements SousProgramme<Logement> {

	@Override
	public String appelSousProgramme() {
		return "call INSERER_LOGEMENT(?, ?, ?, ?, ?, ?, ?)";
	}

	@Override
	public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
		prSt.setString(1, parametres[0]);
		prSt.setString(2, parametres[1]);
		prSt.setString(3, parametres[2]);
		prSt.setString(4, parametres[3]);
		prSt.setString(5, parametres[4]);
		prSt.setString(6, parametres[5]);
		//On a qu'un seul proprietaire dans notre application
		prSt.setString(7, "1");
	}

}
