package modele.dao.requetes;

import java.sql.CallableStatement;
import java.sql.SQLException;

import modele.Diagnostics;


public class SousProgrammeInsertDiagnostic implements SousProgramme<Diagnostics> {

	@Override
	public String appelSousProgramme() {
		return "call INSERER_DIAGNOSTIC(?,?,?,?)";
	}

	@Override
	public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
		prSt.setString(1, parametres[0]);
		prSt.setString(2, parametres[1]);
		prSt.setString(3, parametres[2]);
		prSt.setString(4, parametres[3]);
		
	}



}