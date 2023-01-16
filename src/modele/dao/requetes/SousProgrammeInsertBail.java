package modele.dao.requetes;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;

import modele.Bail;

public class SousProgrammeInsertBail implements SousProgramme<Bail> {

	@Override
	public String appelSousProgramme() {
		return "call INSERER_BAIL(?, ?, ?, ?, ?, ?)";
	}

	@Override
	public void parametres(CallableStatement prSt, String... parametres) throws SQLException {
		prSt.setDate(1, Date.valueOf(parametres[0]));
		prSt.setString(2,  parametres[1]);
		prSt.setInt(3, Integer.valueOf( parametres[2]));
		prSt.setInt(4, Integer.valueOf( parametres[3]));
		prSt.setString(5, parametres[4]);
		prSt.setInt(6, Integer.valueOf( parametres[5]));
	}

}
