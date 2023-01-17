package modele.dao.requetes;

import java.sql.CallableStatement;
import java.sql.SQLException;

import modele.Agence;

public class SousProgrammeGetNbBauxParMois implements SousProgramme<Agence> {

	@Override
	public String appelSousProgramme() {
		return "{? = call NB_BAUX_PAR_MOIS}";
	}

	@Override
	public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
		
	}

}
