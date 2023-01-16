package modele.dao.requetes;

import java.sql.PreparedStatement;

import modele.Diagnostics;

public class RequeteSelectDiagnostic implements Requete<Diagnostics> {

	@Override
	public String requete() {
		return "select * from SAE_DIAGNOSTICS";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametresT(PreparedStatement prSt, Diagnostics donnee) {
		// TODO Auto-generated method stub
		
	}
	
	 
	
	
}
