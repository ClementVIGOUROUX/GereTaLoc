package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Entreprise;

public class RequeteSelectEntreprise implements Requete<Entreprise> {

	@Override
	public String requete() {
		return "select * from SAE_Entreprise";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametresT(PreparedStatement prSt, Entreprise donnee) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		
	}
	
	 
	
	
}
