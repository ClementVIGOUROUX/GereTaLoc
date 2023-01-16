package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Diagnostics;

public class RequeteUpdateDiagnosticRepertoireDate implements Requete<Diagnostics> {

	@Override
	public String requete() {
		return "update SAE_DIAGNOSTICS set REPERTOIRE = ? , DATE_D = CURRENT_DATE where ID_DIAGNOSTICS = ?  ";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametresT(PreparedStatement prSt, Diagnostics donnee) throws SQLException, ParseException {
		prSt.setString(1, donnee.getRepertoire());
		prSt.setInt(2, donnee.getIdDiagnostic());
		
	}

}
