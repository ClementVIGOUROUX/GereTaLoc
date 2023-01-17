package modele.dao.requetes;

import java.sql.CallableStatement;
import java.sql.SQLException;

import modele.Agence;

public class SousProgrammeGetTaxeFonctiere implements SousProgramme<Agence> {

	@Override
	public String appelSousProgramme() {
		return "{? = call TAXES_FONCIERES}";
	}

	@Override
	public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
		
	}

}
