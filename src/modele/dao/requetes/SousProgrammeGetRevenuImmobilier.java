package modele.dao.requetes;

import java.sql.CallableStatement;
import java.sql.SQLException;

import modele.Agence;

public class SousProgrammeGetRevenuImmobilier implements SousProgramme<Agence> {

	@Override
	public String appelSousProgramme() {
		return "{? = call MONTANT_REVENU}";
	}

	@Override
	public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
		
	}

}
