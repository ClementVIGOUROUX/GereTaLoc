package modele.dao.requetes;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;

import modele.Facture;


public class SousProgrammeInsertFacture implements SousProgramme<Facture> {

	@Override
	public String appelSousProgramme() {
		return "call INSERER_FACTURE(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	}

	@Override
	public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
		prSt.setString(1, parametres[0]);
		prSt.setString(2, parametres[1]);
		prSt.setDate(3, Date.valueOf(parametres[2]));
		prSt.setFloat(4, Float.valueOf(parametres[3]));
		prSt.setFloat(5, Float.valueOf(parametres[4]));
		prSt.setString(6, parametres[5]);
		prSt.setString(7, parametres[6]);
		prSt.setString(8,parametres[7]);
		prSt.setString(9, parametres[8]);
		
	}

}