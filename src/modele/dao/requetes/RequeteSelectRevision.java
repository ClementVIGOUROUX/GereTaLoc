package modele.dao.requetes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import modele.Revision;

public class RequeteSelectRevision implements Requete<Revision>{

	@Override
	public String requete() {
		return "select * from SAE_Revision";
	}

	@Override
	public void parametresID(PreparedStatement prSt, String... id) throws SQLException {
	}


	@Override
	public void parametresT(PreparedStatement prSt, Revision donnee) throws SQLException, ParseException {
		// TODO Auto-generated method stub
		
	}

}
