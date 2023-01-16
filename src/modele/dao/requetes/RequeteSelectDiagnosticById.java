package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Diagnostics;

public class RequeteSelectDiagnosticById implements Requete<Diagnostics> {

	@Override
	public String requete() {
		return "select * from SAE_DIAGNOSTICS where ID_DIAGNOSTICS = ?";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
		
	}

	@Override
	public void parametresT(PreparedStatement prSt, Diagnostics donnee) throws SQLException {
		prSt.setInt(1, donnee.getIdDiagnostic());
		
	}
	
	 
	
	
}
