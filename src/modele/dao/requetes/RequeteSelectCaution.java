package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Caution;

public class RequeteSelectCaution implements Requete<Caution> {

	@Override
	public String requete() {
		return "select * from SAE_Caution";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parametresT(PreparedStatement prSt, Caution donnee) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		
	}
	
	 
	
	
}
