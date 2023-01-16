package modele.dao.requetes;

import java.sql.PreparedStatement;

import modele.Agence;

public class RequeteSelectAgence implements Requete<Agence> {

	@Override
	public String requete() {
		return "select * from SAE_AGENCE";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametresT(PreparedStatement prSt, Agence donnee) {
		// TODO Auto-generated method stub
		
	}
	
	 
	
	
}
