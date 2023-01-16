package modele.dao.requetes;

import java.sql.CallableStatement;
import java.sql.SQLException;

import modele.Revision;

public class SousProgrammeInsertRevision implements SousProgramme<Revision> {

	@Override
	public String appelSousProgramme() {
		return "call INSERER_REVISION(?, ?)";
	}

	@Override
	public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
		prSt.setFloat(1, Float.valueOf(parametres[0]) );
		prSt.setString(2,parametres[1]);
	}

}