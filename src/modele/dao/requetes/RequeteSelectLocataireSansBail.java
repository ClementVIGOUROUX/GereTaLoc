package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Locataire;

public class RequeteSelectLocataireSansBail implements Requete<Locataire> {

	@Override
	public String requete() {
		return "select * from vgc4458a.SAE_LOCATAIRE l where not exists (select s.id_loc " + 
	                                                      				"from vgc4458a.SAE_SIGNER s " +
	                                                      				"where l.id_loc = s.id_loc)";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void parametresT(PreparedStatement prSt, Locataire donnee) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		
	}

}
