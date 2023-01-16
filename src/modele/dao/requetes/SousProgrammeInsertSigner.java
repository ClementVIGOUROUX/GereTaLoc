package modele.dao.requetes;

import java.sql.CallableStatement;
import java.sql.SQLException;

import modele.Bail;


public class SousProgrammeInsertSigner implements SousProgramme<Bail> {

	@Override
	public String appelSousProgramme() {
		return "call LIER_LOCATAIRE_AVEC_BAIL(?, ?)";
	}

	@Override
	public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
		prSt.setInt(1, Integer.valueOf(parametres[0]));
		prSt.setInt(2, Integer.valueOf(parametres[1]));
	}

}