package modele.dao.requetes;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;

import modele.EtatdesLieux;


public class SousProgrammeInsertEDL implements SousProgramme<EtatdesLieux> {

	@Override
	public String appelSousProgramme() {
		return "call INSERER_ETATDESLIEUX(?,?)";
	}

	@Override
	public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
		prSt.setDate(1, Date.valueOf(parametres[0]));
		prSt.setInt(2, Integer.valueOf(parametres[1]));
		
	}



}