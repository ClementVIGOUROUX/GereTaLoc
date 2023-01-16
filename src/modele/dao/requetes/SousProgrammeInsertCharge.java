package modele.dao.requetes;

import java.sql.CallableStatement;
import java.sql.SQLException;

import modele.Charge;


public class SousProgrammeInsertCharge implements SousProgramme<Charge> {

	@Override
	public String appelSousProgramme() {
		return "call INSERER_CHARGE(?, ?, ?, ?)";
	}

	@Override
	public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
		int i = Integer.parseInt(parametres[1]);
		int i2 = Integer.parseInt(parametres[2]);
		
		prSt.setString(1, parametres[0]);
		prSt.setInt(2, i);
		prSt.setInt(3, i2);
		prSt.setString(4, parametres[3]);
	}

}