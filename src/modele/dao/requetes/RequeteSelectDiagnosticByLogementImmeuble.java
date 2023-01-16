package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modele.Diagnostics;

public class RequeteSelectDiagnosticByLogementImmeuble implements Requete<Diagnostics> {

	@Override
	public String requete() {
		return "select * from SAE_DIAGNOSTICS where ID_IMMEUBLE = ? AND NUMERO = ?";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		prSt.setString(1, id[0]);
		prSt.setString(2, id[1]);
		
	}

	@Override
	public void parametresT(PreparedStatement prSt, Diagnostics donnee) throws SQLException {
		prSt.setInt(1, donnee.getLogement().getImmeuble().getIdImmeuble());
		prSt.setString(2, donnee.getLogement().getNumero() );
		
	}
	
	 
	
	
}
